FROM maven:3.8.1-openjdk-11-slim AS build
WORKDIR /build

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn package --batch-mode --fail-fast

FROM adoptopenjdk/openjdk11:jre-11.0.11_9-alpine AS release
WORKDIR /app

COPY --from=build /build/target/*.jar app.jar

CMD java -jar app.jar