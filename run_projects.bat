@echo off
setlocal

set projects=config-server eureka_server gateway_server microservicio_proveedor microservicio_usuarios

for %%p in (%projects%) do (
    echo Ejecutando %%p...
    cd %%p
    mvn clean install
    start mvn spring-boot:run
    cd ..
)

echo Todos los proyectos se han ejecutado.
