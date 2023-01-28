### Создаем базу данных postgreSQL в докере командой:
```shell
docker run --name products-db -p 5434:5432 -e POSTGRES_USER=products -e POSTGRES_PASSWORD=password123 postgres
```
### Создаем схему products
```sql
create schema products;
alter schema products owner to products;
```