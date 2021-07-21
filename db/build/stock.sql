create table stock
(
    stockName      varchar(30)  not null
        primary key,
    stockRoom      varchar(20)  null,
    stockType      varchar(20)  null,
    stockDetailLoc varchar(20)  null,
    stockContainer varchar(20)  null,
    orgName        varchar(50)  null,
    companyName    varchar(50)  null,
    country        varchar(20)  null,
    province       varchar(20)  null,
    city           varchar(20)  null,
    district       varchar(30)  null,
    street         varchar(30)  null,
    streetNumber   int          null,
    state          varchar(10)  null,
    executorId     bigint       null,
    executor       varchar(255) null
)
    charset = utf8;

