create view userfood as
select log.logid,
       log.foodweight,
       ft.userid,
       ft.date,
       f.name,
       f.weight,
       f.calories,
       f.protein,
       f.fat,
       f.carbohydrates
from foodtable ft
         join foodlog log on log.table_id = ft.id
         join food f on f.id = log.foodid
