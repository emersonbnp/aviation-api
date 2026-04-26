# Aviation-API
This API is a wrapper for ICAO API, providing endpoints to fetch airport details.

## API Specification
The endpoints supported by aviation-api are available in the openapi.yaml file.

## Architecture
The application is designed to scale and be resilient, while integrating with downstream services that require throttling.
In order to respect rate limits without impacting scalability, the application uses distributed cache.

![architecture.png](docs/images/architecture.png "Aviation API Architecture")