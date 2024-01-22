create table subdivision_enity (
                                   id bigserial not null,
                                   kpp bigint,
                                   org_id bigint,
                                   adress varchar(255),
                                   name varchar(255),
                                   organisation varchar(255),
                                   primary key (id)
)
;
alter table if exists subdivision_enity
    add constraint FK6jl7kcbtqyd2e74styia012yk
        foreign key (org_id)
            references organization_entity
;

