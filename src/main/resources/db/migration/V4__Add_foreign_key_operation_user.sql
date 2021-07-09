alter table public.operation
    add column user_id bigint
        constraint user_operation_fk
            references public.pg_user (id);