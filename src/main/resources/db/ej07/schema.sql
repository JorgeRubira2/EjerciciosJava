CREATE TABLE Cliente (
    id                  INTEGER PRIMARY KEY AUTO_INCREMENT,
    first_name          VARCHAR(200),
    last_name           VARCHAR(200),
    title               VARCHAR(200),
    email               VARCHAR(200),
    phone               VARCHAR(200),
    primary_account     VARCHAR(200),
    description         VARCHAR(200),
    calle               VARCHAR(200),
    ciudad              VARCHAR(200),
    estado              VARCHAR(200),
    pais                VARCHAR(200),
    cp                  INTEGER(5)
);

