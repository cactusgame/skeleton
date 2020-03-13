FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD

COPY ./ /build
WORKDIR /build
RUN mvn clean package -pl routing-service -am

FROM openjdk:8-jre-alpine
WORKDIR /app
#COPY --from=MAVEN_BUILD /build/target/routing-service-0.0.1.jar /app/
COPY --from=MAVEN_BUILD /build/routing-service/target/routing-service-0.0.1.jar /app/
ENTRYPOINT ["java", "-jar", "routing-service-0.0.1.jar"]