CREATE TABLE food (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    quantidade INT NOT NULL,
    validade DATE NOT NULL
);
