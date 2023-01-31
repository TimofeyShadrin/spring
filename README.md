### Создаем базу данных postgreSQL в докере командой:
```shell
docker run --name courses-db -p 5434:5432 -e POSTGRES_USER=courses -e POSTGRES_PASSWORD=password123 postgres
```
### Создаем схему courses
```sql
create schema courses;
alter schema courses owner to courses;
```
### Добавляем класс-прокси для DataSource, который будет перехватывать и логировать все выполняемые SQL-запросы
```xml
<dependency>
    <groupId>com.github.gavlyukovskiy</groupId>
    <artifactId>datasource-proxy-spring-boot-starter</artifactId>
    <version>1.8.1</version>
</dependency>
```