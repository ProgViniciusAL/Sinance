CREATE TABLE user_entity
(
    id            UUID NOT NULL,
    user_name     VARCHAR(255),
    user_email    VARCHAR(255),
    password_hash VARCHAR(255),
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_user_entity PRIMARY KEY (id)
);