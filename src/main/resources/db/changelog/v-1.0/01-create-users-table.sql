create table user_entity (
     id bigserial not null,
     sub_id bigint,
     organization varchar(255),
     patronymic varchar(255),
     position varchar(255),
     subdivision varchar(255),
     surname varchar(255),
     username varchar(255),
     primary key (id)
)

;

alter table if exists user_entity
    add constraint FKk9mxikny0qk17weha6lhgs3v2
        foreign key (sub_id)
            references subdivision_enity
;