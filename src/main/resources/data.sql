INSERT INTO "users" ("name", "cpf", "email", "password")
VALUES
    ('Maysun', '12345678910', 'guilherme@mail.com', '1234'),
    ('Pet', '10987654321', 'preveda@mail.com', '4321');

INSERT INTO "accounts" ("type", "balance", "user_id")
VALUES
    ('CC', 200.35, '2'),
    ('CP', 150, '1');

INSERT INTO "transactions" ("payer_id", "amount", "payee_id")
VALUES
    ('2', 150, '1');