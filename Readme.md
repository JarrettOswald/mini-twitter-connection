# Тестирование


Для локального запуска необходима база данных
### docker-compose.yaml
```yaml 
version: "3.9"
services:
  database:
    image: postgres
    container_name: connections-db
    environment:
      POSTGRES_PASSWORD: postgres
      POSTGRES_USER: postgres
    ports:
      - 5432:5432
    volumes:
      - ./init-database.sh:/docker-entrypoint-initdb.d/init-database.sh
```


### init-database.sh

```shell
#!/bin/bash
psql -U postgres <<-EOSQL
   CREATE SCHEMA IF NOT EXISTS liquibase;
EOSQL
```