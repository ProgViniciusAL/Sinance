CREATE TABLE account
(
    id      UUID NOT NULL,
    user_id UUID,
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

ALTER TABLE account
    ADD CONSTRAINT FK_ACCOUNT_ON_USER FOREIGN KEY (user_id) REFERENCES user_entity (id);

ALTER TABLE transaction
    ADD CONSTRAINT FK_TRANSACTION_ON_ACCOUNT FOREIGN KEY (account_id) REFERENCES account (id);