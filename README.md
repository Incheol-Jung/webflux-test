## webflux test

### mysql 실행
```
sudo docker run -d -p 3306:3306 -e MYSQL_ROOT_PASSWORD=password mysql:5.6
```

### schema 생성
```
create table employee
(
    id           int NOT NULL AUTO_INCREMENT,
    email        varchar(255),
    name         varchar(255),
    phone_number varchar(255),
    primary key (id)
)
```
