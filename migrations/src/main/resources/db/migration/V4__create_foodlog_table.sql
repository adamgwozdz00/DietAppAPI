CREATE TABLE FoodLog
(
    logId      int8 PRIMARY KEY NOT NULL,
    foodId     VARCHAR(255)     NOT NULL,
    foodWeight NUMERIC(19, 2),
    table_id   VARCHAR(255)
);


