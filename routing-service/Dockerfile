# you have to add each sub project at the first to `cache` the jar files

#COPY ./common/pom.xml /build/common/pom.xml
#WORKDIR /build/common
#RUN mvn dependency:go-offline -B install

#COPY ./pom.xml /build/pom.xml
#COPY ./routing-service/pom.xml /build/routing-service/pom.xml
#COPY ./rec-service/pom.xml /build/rec-service/pom.xml
#WORKDIR /build/
#RUN mvn dependency:go-offline -B

#COPY ./ /build
#WORKDIR /build
#RUN mvn package -pl routing-service -am

FROM openjdk:8-jre-alpine
WORKDIR /app
COPY ./routing-service/target/routing-service-0.0.1.jar /app/
ENTRYPOINT ["java", "-jar", "routing-service-0.0.1.jar"]