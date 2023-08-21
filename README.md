# Catalog API

## Description

This API is used to manage the products catalog of the application. This project is intended to practice Spring Boot concepts.

The spring cli was used to create the project using the following command:

```shell
spring init --dependencies=web,data-jpa --build=maven catalog-api
```

## Dependencies

- java: 17.0.8-tem
- maven: 3.9.4
- springboot: 3.1.2

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

## Init compose services

To run the compose services, run the following command:

```shell
docker-compose up -d
```

