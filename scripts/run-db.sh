#!/bin/bash

echo "Starting the database"

pushd `dirname $0`
  SCRIPT_DIR=$(pwd)
popd

if [ $(docker ps -a | grep "nhlxstats-postgres" | wc -l) -gt 0 ]
then
	echo "nhlxstats-postgres containers present -> removing old ones before starting new"
	$SCRIPT_DIR/stop-db.sh
fi

docker run -d -p 5432:5432 --name nhlxstats-postgres -e POSTGRES_PASSWORD=nhlxstats -e POSTGRES_USER=nhlxstats -e POSTGRES_DB=nhlxstats -e POSTGRES_DB_SCHEMA=nhlxstats nhlxstats-postgres
