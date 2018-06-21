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


create table t_order.item(
itemId integer not null auto_increment,
itemName varchar(40) not null,
itemDetail varchar(300),
price integer not null,
stock integer not null,
itemImage varchar(50),
showId integer not null,
categoryId integer not null,
itemFlag integer not null,
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
showImage varchar(50) not null,
 primary key(showId));

create table t_order.ticket_Purchaser(
reserveNo integer not null,
telNo varchar(15) not null,
showDay date not null,
PRIMARY KEY(reserveNo,telNo));

insert into t_order.buy_Detail(
reserveNo,itemId,count,subTotal)
values
('5465756','1','2','6600'),
('5465756','3','1','800'),
('5465756','6','1','720'),
('5465756','7','1','160'),
('3332221','5','2','2000'),
('4445556','11','1','1500'),
('5556667','8','2','320'),
('5556667','10','1','3100'),
('6667778','3','1','1500');

insert into t_order.category(categoryId,
categoryName)
values
('1','組トップグッズ'),
('2','公演グッズ'),
('3','雑誌'),
('4','写真'),
('5','雑貨');

insert into t_order.item(
itemId,itemName,itemDetail,price,stock,itemImage,showId,categoryId,itemFlag)
values
('1','ブレスレット','望海風斗デザイン監修グッズより、ブレスレットが登場！
“幸運を受けとめる”形をしている、といわれる馬蹄チャームが使われたアイテム！
どんなシーンでも合わせられるようにと、シンプルかつ上品に仕上がりました。
ブレスレットは、ゴム仕様なのでつけ外しはとっても便利☆','3300','100','1_bracelet.png','1','1','1'),

('2','オードトワレ','望海風斗デザイン監修グッズより、オードトワレが登場！
みずみずしいシトラスと豊かなマリン系の香りから、
ジャスミン、イランイランへと変化し、ムスクやバニラなど、オリエンタルで上品な香りを奏でます。
','4600','50','1_eaudetoilette.png','1','1','1'),

('3','チャーム','雪組「凱旋門」「Gato Bonito!!」公演より、チャームが登場！
凱旋門がデザインされた硬貨のようなフォルムに、エッフェル塔とカットガラスがついたチャームは、
手作業で磨きをかけているので色味も一つ一つ違うのもポイント♪
','1080','65','2_charm.png','1','2','1'),

('4','観劇バッグ','雪組「凱旋門」「Gato Bonito!!」公演より、観劇バッグが登場！
公演名にもなっている凱旋門がデザインとフランス語で、バッグにデザインされレトロな雰囲気に。
プログラムがすっぽり入る大きさなので、観劇用のサブバッグとしてお使い頂けるアイテムです。
','1080','78','2_bag.png','1','2','1'),

('5','宝塚大劇場公演プログラム','「凱旋門」「Gato Bonito!!」の公演プログラムです','1000','500','3_program.png3_magazine.png','1','3','1'),

('6','歌劇6月号','歌劇6月号です','720','100','3_magazine.png','1','3','1'),

('7','ポストカード(轟悠)／雪組「凱旋門」','雪組「凱旋門」「Gato Bonito!!」轟悠のポストカードです。','160','100','4_nozomi.png','1','4','1'),

('8','ポストカード(望海風斗)／雪組「凱旋門」','雪組「凱旋門」「Gato Bonito!!」望海風斗のポストカードです。','160','100','4_todoroki.png','1','4','1'),

('9','巾着バッグ','オフィシャルグッズより、リニューアルされた組柄から新たに日用雑貨品が登場！
さりげなくデザインに入っている組柄、男女問わず使えるシルクハットと女性らしいドレス柄の
2種類がラインアップ！
今注目のスマホリングや組柄がモチーフになったチャームなど、
見逃せないアイテムが盛りだくさん！！
ご家族や友人とお揃いにしてみたり、観劇のお土産にもピッタリなアイテムです♪
','1500','100','5_kinchaku.png','1','5','1'),

('10','晴雨兼用折り畳み傘','オフィシャルグッズより、晴雨兼用折り畳み傘が登場！
組カラーのストライプがデザインされており、シンプルで使いやすいデザインに！
ストライプ部分以外、黒なので男女どちらでも使えます。
雨の日も晴れの日もこれ1本あればとっても便利！
サイズ
収納された状態：約24(cm)
親骨の長さ：55（cm）
※ＵＶカット加工
','3100','100','5_umbrella.png','1','5','1'),

('11','巾着バッグ','オフィシャルグッズより、リニューアルされた組柄から新たに日用雑貨品が登場！
さりげなくデザインに入っている組柄、男女問わず使えるシルクハットと女性らしいドレス柄の
2種類がラインアップ！
今注目のスマホリングや組柄がモチーフになったチャームなど、
見逃せないアイテムが盛りだくさん！！
ご家族や友人とお揃いにしてみたり、観劇のお土産にもピッタリなアイテムです♪
','1500','100','5_kinchaku.png','2','5','1'),

('12','晴雨兼用折り畳み傘','オフィシャルグッズより、晴雨兼用折り畳み傘が登場！
組カラーのストライプがデザインされており、シンプルで使いやすいデザインに！
ストライプ部分以外、黒なので男女どちらでも使えます。
雨の日も晴れの日もこれ1本あればとっても便利！
サイズ
収納された状態：約24(cm)
親骨の長さ：55（cm）
※ＵＶカット加工
','3100','100','5_umbrella.png','2','5','1'),

('13','巾着バッグ','オフィシャルグッズより、リニューアルされた組柄から新たに日用雑貨品が登場！
さりげなくデザインに入っている組柄、男女問わず使えるシルクハットと女性らしいドレス柄の
2種類がラインアップ！
今注目のスマホリングや組柄がモチーフになったチャームなど、
見逃せないアイテムが盛りだくさん！！
ご家族や友人とお揃いにしてみたり、観劇のお土産にもピッタリなアイテムです♪
','1500','100','5_kinchaku.png','2','5','0'),

('14','晴雨兼用折り畳み傘','オフィシャルグッズより、晴雨兼用折り畳み傘が登場！
組カラーのストライプがデザインされており、シンプルで使いやすいデザインに！
ストライプ部分以外、黒なので男女どちらでも使えます。
雨の日も晴れの日もこれ1本あればとっても便利！
サイズ
収納された状態：約24(cm)
親骨の長さ：55（cm）
※ＵＶカット加工
','3100','100','5_umbrella.png','2','5','0');

insert into t_order.item_reserver(
reserveNo,totalCount,totalPrice,deliveryFlag)
values
('3332221','2','2000','1'),
('4445556','1','1500','0'),
('5465756','5','8280','0'),
('5556667','3','3420','0'),
('5522333','2','2000','1'),
('6667778','3','1500','0');

insert into t_order.manager(managerId,password)
values
('12345678','mana123'),
('98765432','mana987'),
('55555555','mana555');

insert into t_order.showd(
showId,showName,showStartDay,showEndDay,showFlag,showImage)
values
('1','凱旋門','20180601','20180701','0','gaisenmon.jpg'),
('2','MESSIAH','20180702','20180802','1','messiah.jpg'),
('3','ANOTHER WORLD','20180401','20180501','0','anotherworld.jpg'),
('4','Killer Rauge','20180901','20181001','0','killerrauge.jpg');

insert into t_order.ticket_Purchaser(
reserveNo,telNo,showDay)
values
('3332221','090-6655-1234','20180608'),
('4445556','090-0011-2233','20180705'),
('5465756','080-4444-6666','20180605'),
('5522333','090-4444-3321','20180428'),
('5556667','090-5555-6666','20180628'),
('6667778','090-0012-3366','20180615');


