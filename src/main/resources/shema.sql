DROP TABLE IF EXISTS computer;

CREATE TABLE computer
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    serialNumber BIGINT             NOT NULL,
    producerType      VARCHAR_IGNORECASE NOT NULL,
    formComputer          VARCHAR_IGNORECASE NOT NULL,
    price         BIGINT             NOT NULL,
    balance       BIGINT             NOT NULL
);
