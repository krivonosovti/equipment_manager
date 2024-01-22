create table device_type_entity (
                                    type integer,
                                    id bigint not null,
                                    extra varchar(255),
                                    primary key (id)
)
;
alter table if exists device_type_entity
    add constraint FKb81sy00eseckf6vr6k17g256b
        foreign key (id)
            references device_entity
;
