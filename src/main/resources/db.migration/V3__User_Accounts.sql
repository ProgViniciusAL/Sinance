ALTER TABLE user_entity
    ADD user_accounts UUID;

ALTER TABLE user_entity
    ADD CONSTRAINT FK_USER_ENTITY_ON_USER_ACCOUNTS FOREIGN KEY (user_accounts) REFERENCES account (id);