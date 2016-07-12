#!/usr/bin/env bash
set -e

mvn clean test -Davro.version=1.5.0
mvn clean test -Davro.version=1.5.1
mvn clean test -Davro.version=1.5.2
mvn clean test -Davro.version=1.5.3
mvn clean test -Davro.version=1.5.4
mvn clean test -Davro.version=1.6.0
mvn clean test -Davro.version=1.6.1
mvn clean test -Davro.version=1.6.2
mvn clean test -Davro.version=1.6.3
mvn clean test -Davro.version=1.7.0
mvn clean test -Davro.version=1.7.1
mvn clean test -Davro.version=1.7.2
mvn clean test -Davro.version=1.7.3
mvn clean test -Davro.version=1.7.4
mvn clean test -Davro.version=1.7.5
mvn clean test -Davro.version=1.7.6
mvn clean test -Davro.version=1.7.7
mvn clean test -Davro.version=1.8.0


