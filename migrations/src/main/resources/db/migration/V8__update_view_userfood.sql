DROP VIEW IF EXISTS foodsum;
DROP VIEW IF EXISTS userfood;
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
