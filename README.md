# Getting Started

> requirements:
> 1. Docker
> 2. Docker Compose

1. Build jar

```
./gradlew clean build
```

2. Build Docker image

```
docker build -t spring-prometheus-grafana .
```

3. Modify `email` related configurations of alertmanager.yml in docker folder
4. Use Docker Compose to start services

```
docker-compose up -d
```

5. Check Prometheus server

- Open http://localhost:9090
- Access status -> Targets, both endpoints must be "UP"

6. Config grafana

- Open http://localhost:3000, user name and password are all `admin`
- Configure integration with Prometheus
    - Access configuration
    - Add data source
    - Select Prometheus
    - Use url "http://host.docker.internal:9090" and access with value "Server(default)"
- Configure dashboard
    - Access "home"
    - Dashboard Import
    - Import via grafana.com: https://grafana.com/grafana/dashboards/4701
