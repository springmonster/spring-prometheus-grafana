FROM gradle:7.4-jdk17-jammy
ADD --chown=gradle . /code
WORKDIR /code
COPY build/libs/spring-prometheus-grafana-0.0.1-SNAPSHOT.jar /code
CMD java -jar spring-prometheus-grafana-0.0.1-SNAPSHOT.jar
