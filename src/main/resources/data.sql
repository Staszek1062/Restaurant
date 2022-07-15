insert into dish_type (id, type)
values
    (1, 'MEAT'),
    (2, 'VEGETABLES'),
    (3, 'SEA_FOOD'),
    (4, 'FRUITS');

insert into dish(id,name,vegetarian,calories,type)
values (1, 'spaghetti bolognese',true,300,2),
        (2,'pork', false, 800, 1),
		(3,'chicken', false, 400, 1),
		(4,'salmon', false, 300,3),
		(5,'shrimps', false, 300, 3),
		(6,'french fries', true, 530, 2),
		(7,'sauerkraut', true, 100, 2);