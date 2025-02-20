@echo off
REM Create a Docker network
docker network create maybank-network

REM Add containers to the network
docker network connect maybank-network eureka-server
docker network connect maybank-network user-management
docker network connect maybank-network book-management
docker network connect maybank-network kafka-ui
docker network connect maybank-network kafka
docker network connect maybank-network mysql-db
docker network connect maybank-network zookeeper
echo Docker network 'maybank-network' created and containers added.
pause
