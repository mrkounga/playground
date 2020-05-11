DROP TABLE IF EXISTS `ROTATEK_USERS`;

CREATE TABLE IF NOT EXISTS `ROTATEK_USERS`(
    `id`          INTEGER AUTO_INCREMENT PRIMARY KEY,
    `email`       VARCHAR(100) NOT NULL UNIQUE,
    `firstname`      VARCHAR(100) NOT NULL,
    `username`     VARCHAR(100) NOT NULL,
    `surname`     VARCHAR(100) NOT NULL
);