create table mission_template(
                                 id bigint auto_increment,
                                 tempid int not null,
                                 itemid int not null,
                                 iscomplete boolean,
                                 name varchar(50),
                                 primary key (id)
)