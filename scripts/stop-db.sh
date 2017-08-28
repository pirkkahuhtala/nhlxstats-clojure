#!/bin/bash

echo "Stopping database"

docker stop nhlxstats-postgres | xargs docker rm -v
