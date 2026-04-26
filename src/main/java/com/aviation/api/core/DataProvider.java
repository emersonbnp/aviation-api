package com.aviation.api.core;

import java.util.List;
import java.util.Map;
import tools.jackson.databind.JsonNode;

public interface DataProvider {

  List<JsonNode> getStationInfo(Map<String, Object> params);

  List<JsonNode> getAirport(Map<String, Object> params);

  List<JsonNode> getNavaid(Map<String, Object> params);

  List<JsonNode> getFix(Map<String, Object> params);

  List<JsonNode> getFeature(Map<String, Object> params);

  List<JsonNode> getObstacle(Map<String, Object> params);
}
