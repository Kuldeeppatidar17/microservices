CREATE TABLE IF NOT EXISTS cards (
    id BIGINT AUTO_INCREMENT,
    card_number VARCHAR(255) NOT NULL,
    card_type VARCHAR(255) NOT NULL,
    credit_limit DOUBLE NOT NULL,
    available_amount DOUBLE NOT NULL,
    mobile_number BIGINT NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP,
    created_by VARCHAR(255),
    updated_by VARCHAR(255),
    CONSTRAINT pk_cards PRIMARY KEY (id),
    CONSTRAINT uc_cards_card_number UNIQUE (card_number)
);