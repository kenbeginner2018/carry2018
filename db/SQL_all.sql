DROP DATABASE IF EXISTS t_order;

CREATE DATABASE t_order DEFAULT CHARACTER SET utf8;

create table t_order.buy_detail(
reserveNo integer not null,
itemId integer not null,
count integer not null,
subTotal integer not null);

create table t_order.category(
categoryId integer not null auto_increment,
categoryName varchar(40) not null,
primary key(categoryId));

create table t_order.credit(
creditNo integer(16) not null,
Name varchar(30) not null,
securityCode integer(3) not null,
primary key(creditNo));

create table t_order.item(
itemId integer(3) not null auto_increment,
itemName varchar(40) not null,
itemDetail varchar(300),
price integer(6) not null,
stock integer(5) not null,
itemImage varchar(50),
showId integer(2) not null,
categoryId integer(1) not null,
primary key(itemId));

create table t_order.item_Reserver(
reserveNo integer not null,
totalCount integer not null,
totalPrice integer not null,
deliveryFlag integer not null,
primary key(reserveNo));

create table t_order.manager(
managerId integer not null,
password varchar(16) not null,
primary key(managerId));

create table t_order.showd(
showId integer not null auto_increment,
showName varchar(40) not null,
showStartDay date not null,
showEndDay date not null,
showFlag integer not null,
primary key(showId));

create table t_order.ticket_Purchaser(
reserveNo integer not null,
telNo varchar(15) not null,
showDay date not null,
PRIMARY KEY(reserveNo,telNo));

insert into t_order.buy_Detail(
reserveNo,itemId,count,subTotal)
values
('5465756','1','2','6600'),('5465756','3','1','800'),('5465756','6','1','720'),
('5465756','7','1','160');

insert into t_order.category(categoryId,
categoryName)
values
('1','組トップグッズ'),
('2','公演グッズ'),
('3','雑誌'),
('4','写真'),
('5','雑貨');

insert into t_order.item(
itemId,itemName,itemDetail,price,stock,itemImage,showId,categoryId)
values
('1','ブレスレット','望海風斗デザイン監修グッズより、ブレスレットが登場！
“幸運を受けとめる”形をしている、といわれる馬蹄チャームが使われたアイテム！
どんなシーンでも合わせられるようにと、シンプルかつ上品に仕上がりました。
ブレスレットは、ゴム仕様なのでつけ外しはとっても便利☆','3300','100','1_bracelet.png','1','1'),

('2','オードトワレ','望海風斗デザイン監修グッズより、オードトワレが登場！
みずみずしいシトラスと豊かなマリン系の香りから、
ジャスミン、イランイランへと変化し、ムスクやバニラなど、オリエンタルで上品な香りを奏でます。
','4600','50','1_eaudetoilette.png','1','1'),

('3','チャーム','雪組「凱旋門」「Gato Bonito!!」公演より、チャームが登場！
凱旋門がデザインされた硬貨のようなフォルムに、エッフェル塔とカットガラスがついたチャームは、
手作業で磨きをかけているので色味も一つ一つ違うのもポイント♪
','1080','65','2_bag.png','1','2'),

('4','観劇バッグ','雪組「凱旋門」「Gato Bonito!!」公演より、観劇バッグが登場！
公演名にもなっている凱旋門がデザインとフランス語で、バッグにデザインされレトロな雰囲気に。
プログラムがすっぽり入る大きさなので、観劇用のサブバッグとしてお使い頂けるアイテムです。
','1080','78','2_charm.png','1','2'),

('5','宝塚大劇場公演プログラム','「凱旋門」「Gato Bonito!!」の公演プログラムです','1000','500','3_program.png3_magazine.png','1','3'),

('6','歌劇6月号','歌劇6月号です','720','100','3_magazine.png','1','3'),

('7','ポストカード／雪組「凱旋門」「Gato Bonito!!」','雪組「凱旋門」「Gato Bonito!!」轟悠のポストカードです。','160','100','4_nozomi.png','1','4'),

('8','ポストカード／雪組「凱旋門」「Gato Bonito!!」','雪組「凱旋門」「Gato Bonito!!」望海風斗のポストカードです。','160','100','4_todoroki.png','1','4'),

('9','巾着バッグ','オフィシャルグッズより、リニューアルされた組柄から新たに日用雑貨品が登場！
さりげなくデザインに入っている組柄、男女問わず使えるシルクハットと女性らしいドレス柄の
2種類がラインアップ！
今注目のスマホリングや組柄がモチーフになったチャームなど、
見逃せないアイテムが盛りだくさん！！
ご家族や友人とお揃いにしてみたり、観劇のお土産にもピッタリなアイテムです♪
','1500','100','5_kinchaku.png','1','5'),

('10','晴雨兼用折り畳み傘','オフィシャルグッズより、晴雨兼用折り畳み傘が登場！
組カラーのストライプがデザインされており、シンプルで使いやすいデザインに！
ストライプ部分以外、黒なので男女どちらでも使えます。
雨の日も晴れの日もこれ1本あればとっても便利！
サイズ
収納された状態：約24(cm)
親骨の長さ：55（cm）
※ＵＶカット加工
','3100','100','umbrella.png','1','5'),

('11','巾着バッグ','オフィシャルグッズより、リニューアルされた組柄から新たに日用雑貨品が登場！
さりげなくデザインに入っている組柄、男女問わず使えるシルクハットと女性らしいドレス柄の
2種類がラインアップ！
今注目のスマホリングや組柄がモチーフになったチャームなど、
見逃せないアイテムが盛りだくさん！！
ご家族や友人とお揃いにしてみたり、観劇のお土産にもピッタリなアイテムです♪
','1500','100','5_kinchaku.png','2','5'),

('12','晴雨兼用折り畳み傘','オフィシャルグッズより、晴雨兼用折り畳み傘が登場！
組カラーのストライプがデザインされており、シンプルで使いやすいデザインに！
ストライプ部分以外、黒なので男女どちらでも使えます。
雨の日も晴れの日もこれ1本あればとっても便利！
サイズ
収納された状態：約24(cm)
親骨の長さ：55（cm）
※ＵＶカット加工
','3100','100','umbrella.png','2','5');

insert into t_order.item_Reserver(
reserveNo,totalCount,totalPrice,deliveryFlag)
values
('5465756','5','3900','0'),
('4525687','15','15000','1'),
('4568958','7','8500','1');

insert into t_order.manager(managerId,password)
values
('12345678','mana123'),
('98765432','mana987'),
('55555555','mana555');

insert into t_order.showd(
showId,showName,showStartDay,showEndDay,showFlag)
values
('1','凱旋門','20180601','20180701','0'),
('2','MESSIAH','20180702','20180802','1');

insert into t_order.ticket_Purchaser(
reserveNo,telNo,showDay)
values
('5465756','080-4444-6666','20180605'),
('4525687','090-1234-9875','20180610'),
('4568958','080-5523-6658','20180620');


alter table t_order.showd add showimage varchar(50);

update t_order.showd set showimage = 'gaisenmon.jpg' where showId = 1;

update t_order.showd set showimage = 'messiah.jpg' where showId = 2;
