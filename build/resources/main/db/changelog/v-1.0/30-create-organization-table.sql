create table organization_entity (
     id bigserial not null,
     inn bigint,
     ogrn bigint,
     adress varchar(255),
     name varchar(255),
     shortname varchar(255),
     primary key (id)
)
;
