DROP TABLE IF EXISTS messages;

CREATE TABLE messages (
	id IDENTITY NOT NULL PRIMARY KEY,
    content VARCHAR(2048),
    login VARCHAR(255),
    date TIMESTAMP NOT NULL DEFAULT(current_timestamp)
);

INSERT INTO messages(login, content) VALUES ( 'Adi', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur nibh nulla, dapibus sed felis nec, aliquam dignissim nunc. Aliquam vel felis mi. Mauris vel nisl eget metus ornare dictum. In sit amet purus risus. Mauris aliquam pulvinar sapien, a velit.');
INSERT INTO messages(login, content) VALUES ( 'xxx222', 'asd');
INSERT INTO messages(login, content) VALUES ( 'xxx333', 'asd');
INSERT INTO messages(login, content) VALUES ( 'yyyyy', 'yyyyyyyyyyyyyyyyyyyyy');
