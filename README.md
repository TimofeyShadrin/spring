### Создаем базу данных postgreSQL в докере командой:
```shell
docker run --name courses-db -p 5434:5432 -e POSTGRES_USER=courses -e POSTGRES_PASSWORD=password123 postgres
```
### Создаем схему courses
```sql
create schema courses;
alter schema courses owner to courses;
```