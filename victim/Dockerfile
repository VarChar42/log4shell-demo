FROM maven:3.9.12-eclipse-temurin-11 AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY ./src ./src
RUN mvn package

FROM eclipse-temurin:11-jre

WORKDIR /app

COPY --from=build /app/target/demo-1.0.jar demo.jar


COPY secret.txt secret.txt

EXPOSE 8080

CMD ["java", "-Dcom.sun.jndi.ldap.object.trustURLCodebase=true", "-jar", "demo.jar"]
