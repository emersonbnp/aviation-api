package com.aviation.api.application.provider.navigationaldata;

import static java.util.Optional.ofNullable;
import static java.util.concurrent.TimeUnit.SECONDS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RateLimiter {

  private final RedisTemplate<String, String> redisTemplate;
  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  public RateLimiter(RedisTemplate<String, String> redisTemplate) {
    this.redisTemplate = redisTemplate;
  }

  public boolean allowRequest(String clientId, int maxRequests, int windowSeconds) {
    final var key = "rate-limit:" + clientId;
    final var operations = redisTemplate.opsForValue();
    final long currentCount = ofNullable(operations.get(key)).map(Long::valueOf).orElse(0L);

    if (currentCount < maxRequests) {
      operations.set(key, String.valueOf(currentCount + 1L), windowSeconds, SECONDS);
      return true;
    }

    logger.warn(
        "Rate limit exceeded for client '{}': {} requests in {} seconds",
        clientId,
        maxRequests,
        windowSeconds);
    return false;
  }
}
