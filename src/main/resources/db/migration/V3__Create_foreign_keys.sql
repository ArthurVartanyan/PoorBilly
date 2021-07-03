alter table public.pg_user
    alter column id type bigint using id::bigint;
alter table income
    alter column id type bigint using id::bigint;
alter table spending
    alter column id type bigint using id::bigint;
alter table operation
    alter column id type bigint using id::bigint;

alter table income
    add column operation_id bigint
        constraint income_operation_fk
            references operation (id);

alter table spending
    add column operation_id bigint
        constraint spending_operation_fk
            references spending (id);