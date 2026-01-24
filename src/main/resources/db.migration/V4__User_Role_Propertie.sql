CREATE TABLE user_entity_accounts
(
    user_entity_id UUID NOT NULL,
    accounts_id    UUID NOT NULL,
    CONSTRAINT pk_user_entity_accounts PRIMARY KEY (user_entity_id, accounts_id)
);

ALTER TABLE user_entity
    ADD user_role SMALLINT;

ALTER TABLE user_entity_accounts
    ADD CONSTRAINT uc_user_entity_accounts_accounts UNIQUE (accounts_id);

ALTER TABLE user_entity_accounts
    ADD CONSTRAINT fk_useentacc_on_account_entity FOREIGN KEY (accounts_id) REFERENCES account (id);

ALTER TABLE user_entity_accounts
    ADD CONSTRAINT fk_useentacc_on_user_entity FOREIGN KEY (user_entity_id) REFERENCES user_entity (id);