CREATE TABLE IF NOT EXISTS tb_owners
(
    id         INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    address    VARCHAR(255),
    city       VARCHAR(80),
    telephone  VARCHAR(20),
    INDEX (last_name)
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS tb_pet_types
(
    id   INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80),
    INDEX (name)
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS tb_pets
(
    id         INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(30),
    birth_date DATE,
    type_id    INT(4) UNSIGNED NOT NULL,
    owner_id   INT(4) UNSIGNED,
    INDEX (name),
    FOREIGN KEY (owner_id) REFERENCES tb_owners (id),
    FOREIGN KEY (type_id) REFERENCES tb_pet_types (id)
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS tb_specialties
(
    id   INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80),
    INDEX (name)
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS tb_vets
(
    id         INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    INDEX (last_name)
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS tb_visits
(
    id          INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pet_id      INT(4) UNSIGNED,
    visit_date  DATE,
    description VARCHAR(255),
    FOREIGN KEY (pet_id) REFERENCES tb_pets (id)
) engine = InnoDB;

CREATE TABLE IF NOT EXISTS tb_vet_specialties
(
    vet_id       INT(4) UNSIGNED NOT NULL,
    specialty_id INT(4) UNSIGNED NOT NULL,
    FOREIGN KEY (vet_id) REFERENCES tb_vets (id),
    FOREIGN KEY (specialty_id) REFERENCES tb_specialties (id),
    UNIQUE (vet_id, specialty_id)
) engine = InnoDB;


