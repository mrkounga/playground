CREATE TABLE IF NOT EXISTS `ARTICLES`(
    `id`          INTEGER PRIMARY KEY,
    `title`       VARCHAR(100) NOT NULL,
    `author`      VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS `COUNTRY`(
    `id`          INTEGER PRIMARY KEY,
    `title`       VARCHAR(100) NOT NULL,
    `author`      VARCHAR(100) NOT NULL
);