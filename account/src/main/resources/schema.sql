CREATE TABLE IF NOT EXISTS accounts (
    id BIGINT AUTO_INCREMENT,
    account_holder_name VARCHAR(255) NOT NULL,
    account_type VARCHAR(255) NOT NULL,
    account_number VARCHAR(255) NOT NULL,
    balance DECIMAL(38, 2) NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT pk_accounts PRIMARY KEY (id),
    CONSTRAINT uc_accounts_account_number UNIQUE (account_number)
);