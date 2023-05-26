FROM openjdk:11

RUN mkdir -p /opt
#ARG JARPATH=./build/libs
ADD /build/libs/market-1.0-SNAPSHOT.jar /opt/market-1.0-SNAPSHOT.jar

EXPOSE 8060

ENTRYPOINT java -jar /opt/market-1.0-SNAPSHOT.jar -Djava.net.preferIPv4Stack=true