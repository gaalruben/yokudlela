FROM openjdk:11

RUN mkdir -p /opt
WORKDIR /recipes/build/libs
ADD recipes-1.0-SNAPSHOT.jar /opt/recipes-1.0-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT java -jar /opt/recipes-1.0-SNAPSHOT.jar -Djava.net.preferIPv4Stack=true
