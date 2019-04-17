FROM java:8

VOLUME /tmp

ADD scholarweb-0.0.1.jar app.jar
ADD wait-for -it.sh
RUN bash -c 'touch /app.jar

EXPOSE 8444

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
