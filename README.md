# Projeto Hearthstone

Projeto desenvolvido para Avaliação A - Desenvolvedor Java

## Para rodar a aplicação em modo de desenvolvimento

Primeiro suba o container Docker com o banco de dados PostgreSQL, execute:
```shell script
docker-compose up -d
```

Para rodar a aplicação execute:
```shell script
./mvnw compile quarkus:dev
```

## Gerando uber-jar

Para gera um uber-jar execute
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

## Documentação
```shell script
http://localhost:8080/swagger-ui/
```