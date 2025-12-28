CREATE TABLE account
(
    id              UUID NOT NULL,
    name            VARCHAR(255),
    user_id         UUID,
    current_balance DECIMAL,
    account_type    VARCHAR(255),
    is_active       BOOLEAN,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

CREATE TABLE transaction
(
    id          UUID NOT NULL,
    account_id  UUID,
    amount      DECIMAL,
    type        VARCHAR(255),
    description VARCHAR(255),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_transaction PRIMARY KEY (id)
);

CREATE TABLE user_entity
(
    id            UUID NOT NULL,
    user_name     VARCHAR(255),
    user_email    VARCHAR(255),
    password_hash VARCHAR(255),
    created_at    TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_user_entity PRIMARY KEY (id)
);

ALTER TABLE account
    ADD CONSTRAINT FK_ACCOUNT_ON_USER FOREIGN KEY (user_id) REFERENCES user_entity (id);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES account (id);