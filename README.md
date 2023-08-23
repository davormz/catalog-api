# Catalog API

## Description

This API is used to manage the products catalog of the application. This project is intended to practice Spring Boot concepts.

The spring cli was used to bootstrap the project using the following command:

```shell
spring init --dependencies=web,data-jpa --build=maven catalog-api
```

## Dependencies

- java: 17.0.8-tem
- maven: 3.9.4
- springboot: 3.1.2
- docker: 20.10.8 (optional)

I Strongly recommend using [sdkman](https://sdkman.io/) to manage your java and maven versions. The project includes a `.sdkmanrc` file to set the java and maven versions.

To set the environment, run the following command:

```shell
sdk env install
```

## How to run the project

Run the project using the following command:

```shell
./mvnw spring-boot:run
```

## How to check the health of the application (actuator)

To check the health of the application, run the following command:

```shell
curl http://localhost:8080/actuator/health
```

And you should see the following response:

```json
{"status":"UP"}
```

It can include extra information like the following:

```json
{
  "status": "UP",
  "components": {
    "db": {
      "status": "UP",
      "details": {
        "database": "PostgreSQL",
        "validationQuery": "isValid()"
      }
    },
    "diskSpace": {
      "status": "UP",
      "details": {
        "total": 499963174912,
        "free": 443893903616,
        "threshold": 10485760
      }
    },
    "ping": {
      "status": "UP"
    }
  }
}
```

## Init compose services

To run the compose services, run the following command:

```shell
docker-compose up -d
```

## Project structure

### Entity domain

The entity domain is located in the `com.davo.catalogapi.domain` package.

