FROM openjdk:8-jdk-alpine

RUN mkdir /opt/application

COPY ./scholarWeb-0.0.1-SNAPSHOT.jar /opt/application/scholarWeb-0.0.1-SNAPSHOT.jar
COPY ./horario.pdf /opt/application/horario.pdf
COPY ./comedor.pdf /opt/application/comedor.pdf
COPY ./deportes.pdf /opt/application/deportes.pdf

WORKDIR /opt/application

CMD ["java", "-jar", "/opt/application/scholarWeb-0.0.1-SNAPSHOT.jar"]
