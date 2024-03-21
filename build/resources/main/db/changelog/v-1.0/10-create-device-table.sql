create table device_entity (
                               divided boolean,
                               inv_number integer,
                               united boolean,
                               id bigserial not null,
                               kit bigint,
                               mac bigint,
                               serial_number bigint,
                               user_id bigint,
                               brand varchar(255),
                               extra varchar(255),
                               manager varchar(255),
                               model varchar(255),
                               primary key (id)
)
;
alter table if exists device_entity
    add constraint FKqgx2q05mio3d8xa8kp9q6cd6h
        foreign key (user_id)
            references user_entity
;