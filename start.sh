#!/bin/bash

cd backend && mvn clean install && cd ..

docker-compose down
docker-compose build
docker-compose up
