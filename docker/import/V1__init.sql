-- CREATE
-- USER diet_admin with password 'admin1';
-- GRANT ALL PRIVILEGES ON DATABASE
-- diet TO diet_admin;

CREATE TABLE FOOD
(
    id            VARCHAR(255) PRIMARY KEY,
    name          VARCHAR(255),
    weight        DECIMAL,
    calories      DECIMAL,
    protein       DECIMAL,
    fat           DECIMAL,
    carbohydrates DECIMAL
);

CREATE TABLE FoodTable
(
    id     VARCHAR(255) PRIMARY KEY NOT NULL,
    date   DATE,
    userId INT8                     NOT NULL
);

CREATE TABLE FoodLog
(
    logId      int8 PRIMARY KEY NOT NULL,
    foodId     VARCHAR(255)     NOT NULL,
    foodWeight NUMERIC(19, 2),
    table_id   VARCHAR(255)
);

CREATE VIEW userfood AS
SELECT f.id,
       log.logid,
       log.foodweight,
       ft.userid,
       ft.date,
       f.name,
       ROUND(f.calories * 1.0 / f.weight * log.foodweight, 2)      AS calories,
       ROUND(f.protein * 1.0 / f.weight * log.foodweight, 2)       AS protein,
       ROUND(f.fat * 1.0 / f.weight * log.foodweight, 2)           AS fat,
       ROUND(f.carbohydrates * 1.0 / f.weight * log.foodweight, 2) AS carbohydrates
FROM foodtable ft
         JOIN foodlog log ON log.table_id = ft.id
         JOIN food f ON f.id = log.foodid;

CREATE VIEW FOODSUM AS
SELECT userid,
        date,
        SUM (calories) AS calories,
        SUM (protein) AS protein,
        SUM (fat) AS fat,
        SUM (carbohydrates) AS carbohydrates
        from userfood
        GROUP BY userid, date;


