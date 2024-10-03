docker build -t keycloakcloud .

docker-compose up -d

# Array con las rutas de los proyectos
$projects = @("config-server", "eureka_server", "gateway_server", "microservicio_proveedores", "microservicio_usuarios")

# Iterar sobre cada proyecto y ejecutarlo
foreach ($project in $projects) {
    Write-Host "Ejecutando $project..."
    Set-Location $project
    # mvn clean install
    Start-Process "mvn" "spring-boot:run"
    Set-Location ..
    Start-Sleep -Seconds 2
}

Write-Host "Todos los proyectos se han ejecutado."
