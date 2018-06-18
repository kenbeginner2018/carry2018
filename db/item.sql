create table item(
itemId integer(3) not null auto_increment,
itemName varchar(40) not null,
itemDetail varchar(300),
price integer(6) not null,
stock integer(5) not null,
itemImage varchar(50),
showId integer(2) not null,
categoryId integer(1) not null,
 primary key(itemId));
