create table t_order.showd(
showId integer not null auto_increment,
showName varchar(40) not null,
showStartDay date not null,
showEndDay date not null,
showFlag integer not null,
showPast date not null,
showFuture date not null,
 primary key(showId));
