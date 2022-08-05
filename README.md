# 医疗路径管理系统

后端Java实现

一个单病种的医疗路径管理系统
# 项目地址
- 后端：https://github.com/ZCXu1/Path-Management
- 前端：https://github.com/AKACiven/Clinical_Pathway_Tracking

# 环境

- jdk11
- IDE:IntelliJ IDEA
- mybatis
- mysql 8.0.23
- sa-token

# 数据库

database：pathmanagement

建表语句：

```SQL
create table admin
(
    username varchar(255) default '' not null
        primary key,
    password varchar(255)            null
);

create table inpath
(
    id     varchar(255) default '' not null
        primary key,
    name   varchar(50)             null,
    bed    int                     null,
    status int                     null,
    date   date                    null,
    time   time                    null
);

create table overall
(
    patient_id  varchar(255) null,
    stage_one   int          null,
    stage_two   int          null,
    stage_three int          null,
    stage_four  int          null
);

create table patient
(
    id     int auto_increment
        primary key,
    name   varchar(50) null,
    bed    int         null,
    status int         null
);

create table stage1
(
    patient_id     varchar(255) default '' not null
        primary key,
    checked_cities longtext                null,
    cities         longtext                null,
    detail_cities  longtext                null,
    begin_date     date                    null,
    begin_time     time                    null,
    end_date       date                    null,
    end_time       time                    null
);

create table stage2
(
    patient_id     varchar(255) not null,
    checked_cities longtext     null,
    cities         longtext     null,
    detail_cities  longtext     null,
    begin_date     date         null,
    begin_time     time         null,
    end_date       date         null,
    end_time       time         null
);

create table stage3
(
    patient_id     varchar(255) not null,
    checked_cities longtext     null,
    cities         longtext     null,
    detail_cities  longtext     null,
    begin_date     date         null,
    begin_time     time         null,
    end_date       date         null,
    end_time       time         null
);

create table stage4
(
    patient_id     varchar(255) null,
    checked_cities longtext     null,
    cities         longtext     null,
    detail_cities  longtext     null,
    begin_date     date         null,
    begin_time     time         null,
    end_date       date         null,
    end_time       time         null
);

create table variation
(
    id   varchar(255) not null,
    info longtext     null
);


```


需要在`mybatis-config.xml`以及`application.yml`两处更改数据库连接
