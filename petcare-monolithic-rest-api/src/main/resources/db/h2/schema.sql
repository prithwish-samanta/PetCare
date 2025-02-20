DROP TABLE IF EXISTS tb_owners CASCADE;
DROP TABLE IF EXISTS tb_pet_types CASCADE;
DROP TABLE IF EXISTS tb_pets CASCADE;
DROP TABLE IF EXISTS tb_specialties CASCADE;
DROP TABLE IF EXISTS tb_vets CASCADE;
DROP TABLE IF EXISTS tb_vistis CASCADE;
DROP TABLE IF EXISTS vet_specialties CASCADE;

CREATE TABLE tb_owners
(
    id         INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    address    VARCHAR(255),
    city       VARCHAR(80),
    telephone  VARCHAR(20)
);
CREATE INDEX owners_last_name ON tb_owners (last_name);

CREATE TABLE tb_pet_types
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(80)
);
CREATE INDEX types_name ON tb_pet_types (name);

CREATE TABLE tb_pets
(
    id         INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name       VARCHAR(30),
    birth_date DATE,
    type_id    INTEGER,
    owner_id   INTEGER
);
ALTER TABLE tb_pets
    ADD CONSTRAINT fk_pets_owners FOREIGN KEY (owner_id) REFERENCES tb_owners (id);
ALTER TABLE tb_pets
    ADD CONSTRAINT fk_pets_types FOREIGN KEY (type_id) REFERENCES tb_pet_types (id) ON DELETE SET NULL;
CREATE INDEX pets_name ON tb_pets (name);

CREATE TABLE tb_specialties
(
    id   INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name VARCHAR(80)
);
CREATE INDEX specialties_name ON tb_specialties (name);

CREATE TABLE tb_vets
(
    id         INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30)
);
CREATE INDEX vets_last_name ON tb_vets (last_name);

CREATE TABLE tb_visits
(
    id          INTEGER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    pet_id      INTEGER NOT NULL,
    visit_date  DATE,
    description VARCHAR(255)
);
ALTER TABLE tb_visits
    ADD CONSTRAINT fk_visits_pets FOREIGN KEY (pet_id) REFERENCES tb_pets (id);
CREATE INDEX visits_pet_id ON tb_visits (pet_id);

CREATE TABLE tb_vet_specialties
(
    vet_id       INTEGER NOT NULL,
    specialty_id INTEGER NOT NULL,
    primary key (specialty_id, vet_id)
);
ALTER TABLE tb_vet_specialties
    ADD CONSTRAINT fk_vet_specialties_vets FOREIGN KEY (vet_id) REFERENCES tb_vets (id);
ALTER TABLE tb_vet_specialties
    ADD CONSTRAINT fk_vet_specialties_specialties FOREIGN KEY (specialty_id) REFERENCES tb_specialties (id);
