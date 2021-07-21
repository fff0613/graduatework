create table maintain_device(
                                id bigint auto_increment,
                                proid int not null,
                                deviceid int not null,
                                iscomplete boolean,
                                primary key (id)
)