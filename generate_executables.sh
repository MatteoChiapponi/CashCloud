#!/bin/bash

eureka_server_path="C:\\Users\\matteo\\Desktop\\CashCloud\\components\\eureka-server\\"
configuration_server_path="C:\\Users\\matteo\\Desktop\\CashCloud\\components\\configuration-server\\"

mvn -f "${eureka_server_path}pom.xml" package && {
  java -jar "${eureka_server_path}target\\eureka-server.jar" &
  eureka_pid=$!
}

mvn -f "${configuration_server_path}pom.xml" package && {
 java -jar "${configuration_server_path}target\\configuration-server.jar" &
 configuration_server_pid=$!
}

sleep 50

paths_pom=(
    "C:\\Users\\matteo\\Desktop\\CashCloud\\components\\gateway\\pom.xml"
    "C:\\Users\\matteo\\Desktop\\CashCloud\\microservices\\accounts-ms\\pom.xml"
    "C:\\Users\\matteo\\Desktop\\CashCloud\\microservices\\keycloak-manager-ms\\pom.xml"
    "C:\\Users\\matteo\\Desktop\\CashCloud\\microservices\\notifications-ms\\pom.xml"
    "C:\\Users\\matteo\\Desktop\\CashCloud\\microservices\\users-ms\\pom.xml"
)

  for pom in "${paths_pom[@]}"; do
       mvn -f "$pom" package || { echo "Error al compilar $pom"; exit 1; }
  done

kill $configuration_server_pid
kill $eureka_pid
