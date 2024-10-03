#!/bin/bash

docker build -t keycloakcloud .

docker-compose up -d

# Array con las rutas de los proyectos
projects=("config-server" "eureka_server" "gateway_server" "microservicio_proveedores" "microservicio_usuarios")

# Iterar sobre cada proyecto y ejecutarlo
for project in "${projects[@]}"
do
  echo "Ejecutando $project..."
  cd $project
#   mvn clean install
  mvn spring-boot:run &
  cd ..
  sleep 2
done

# Esperar a que todos los procesos terminen
wait
echo "Todos los proyectos se han ejecutado."
