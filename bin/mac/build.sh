#!/bin/bash
parent_path=$( cd "$(dirname "${BASH_SOURCE[0]}")" ; pwd -P )

cd "$parent_path"

if [ -z "$1" ]; then
  mvn -f ../../pom.xml clean install -DskipTests --settings
else
  mvn -f ../../$1/pom.xml clean install -DskipTests --settings
fi