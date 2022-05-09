DROP TABLE IF EXISTS messages;

CREATE TABLE messages (
	id IDENTITY NOT NULL PRIMARY KEY,
    content VARCHAR(2048),
    login VARCHAR(255),
    date TIMESTAMP NOT NULL DEFAULT(current_timestamp)
);

