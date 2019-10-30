#! /bin/sh

# clean artifact and rebuild maven application
cd ./backend/ && mvn clean install && cd ..

## stop and remove containers created by 'docker-compose up'
docker-compose down

# build services
docker-compose build

# create and run containers for services
docker-compose up