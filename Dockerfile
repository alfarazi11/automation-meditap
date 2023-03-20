FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/udemy

# ADD .jar under target from host
# into this image
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs

# in case of any other dependency like .csv / .json / .xls
# please ADD any files required here

# ADD suite files
ADD seleniumSuite.xml seleniumSuite.xml

# ADD health check script
RUN healthcheck.sh healthcheck.sh

# BROWSER
# HUB_HOST
# MODULE
ENTRYPOINT sh healthcheck.sh