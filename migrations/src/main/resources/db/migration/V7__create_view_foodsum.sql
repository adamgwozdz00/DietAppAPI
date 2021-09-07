CREATE VIEW FOODSUM AS
SELECT userid,
        date,
        SUM (calories) AS calories,
        SUM (protein) AS protein,
        SUM (fat) AS fat,
        SUM (carbohydrates) AS carbohydrates
        from userfood
        GROUP BY userid, date
