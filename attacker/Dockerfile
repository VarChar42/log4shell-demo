FROM maven:3.9.12-eclipse-temurin-11 AS build

RUN git clone https://github.com/mbechler/marshalsec.git

RUN cd marshalsec && mvn clean package -DskipTests

FROM eclipse-temurin:11-jdk

RUN apt-get update && apt-get install -y python3

COPY --from=build marshalsec/target/marshalsec-*-all.jar marshalsec/

COPY Payload.java .
COPY start.sh .

RUN javac Payload.java
RUN chmod +x start.sh

EXPOSE 1389
EXPOSE 8000

CMD ["./start.sh"]
