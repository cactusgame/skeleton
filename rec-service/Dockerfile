#FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
#COPY ./ /build
#WORKDIR /build
#RUN mvn clean package -pl rec-service -am
#
#FROM openjdk:8-jre-alpine
#WORKDIR /app
#COPY --from=MAVEN_BUILD /build/rec-service/target/rec-service-0.0.1.jar /app/
#ENTRYPOINT ["java", "-jar", "routing-service-0.0.1.jar"]


FROM openjdk:8-jre-alpine
WORKDIR /app
COPY ./rec-service/target/rec-service-0.0.1.jar /app/
ENTRYPOINT ["java", "-jar", "rec-service-0.0.1.jar"]