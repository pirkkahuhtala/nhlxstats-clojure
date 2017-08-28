#!/bin/bash

echo "Building db Docker image"
pushd `dirname $0`

cd ../docker

cp ../initdb.sql .
docker build -f Dockerfile.postgres -t nhlxstats-postgres .
rm initdb.sql

popd
