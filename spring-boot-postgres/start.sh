#! /bin/sh

# clean artifact and rebuild maven application
mvn clean install

## stop and remove containers created by 'docker-compose up'
docker-compose build

# create and run containers for services
docker-compose up