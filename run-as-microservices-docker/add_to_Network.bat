@echo off
REM Create a Docker network

REM Add containers to the network
docker network connect maybank-network eureka-server
docker network connect maybank-network user-management
docker network connect maybank-network book-management
docker network connect maybank-network mysql-db
echo Docker network 'maybank-network' created and containers added.
pause
