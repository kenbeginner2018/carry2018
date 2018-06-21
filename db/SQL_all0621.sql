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
('1','�g�g�b�v�O�b�Y'),
('2','�����O�b�Y'),
('3','�G��'),
('4','�ʐ^'),
('5','�G��');

insert into t_order.item(
itemId,itemName,itemDetail,price,stock,itemImage,showId,categoryId,itemFlag)
values
('1','�u���X���b�g','�]�C���l�f�U�C���ďC�O�b�Y���A�u���X���b�g���o��I
�g�K�^���󂯂Ƃ߂�h�`�����Ă���A�Ƃ�����n���`���[�����g��ꂽ�A�C�e���I
�ǂ�ȃV�[���ł����킹����悤�ɂƁA�V���v������i�Ɏd�オ��܂����B
�u���X���b�g�́A�S���d�l�Ȃ̂ł��O���͂Ƃ��Ă��֗���','3300','100','1_bracelet.png','1','1','1'),

('2','�I�[�h�g����','�]�C���l�f�U�C���ďC�O�b�Y���A�I�[�h�g�������o��I
�݂��݂������V�g���X�ƖL���ȃ}�����n�̍��肩��A
�W���X�~���A�C�����C�����ւƕω����A���X�N��o�j���ȂǁA�I���G���^���ŏ�i�ȍ����t�ł܂��B
','4600','50','1_eaudetoilette.png','1','1','1'),

('3','�`���[��','��g�u�M����v�uGato Bonito!!�v�������A�`���[�����o��I
�M���傪�f�U�C�����ꂽ�d�݂̂悤�ȃt�H�����ɁA�G�b�t�F�����ƃJ�b�g�K���X�������`���[���́A
���ƂŖ����������Ă���̂ŐF�������Ⴄ�̂��|�C���g��
','1080','65','2_charm.png','1','2','1'),

('4','�ό��o�b�O','��g�u�M����v�uGato Bonito!!�v�������A�ό��o�b�O���o��I
�������ɂ��Ȃ��Ă���M���傪�f�U�C���ƃt�����X��ŁA�o�b�O�Ƀf�U�C�����ꃌ�g���ȕ��͋C�ɁB
�v���O�����������ۂ����傫���Ȃ̂ŁA�ό��p�̃T�u�o�b�O�Ƃ��Ă��g��������A�C�e���ł��B
','1080','78','2_bag.png','1','2','1'),

('5','��ˑ匀������v���O����','�u�M����v�uGato Bonito!!�v�̌����v���O�����ł�','1000','500','3_program.png3_magazine.png','1','3','1'),

('6','�̌�6����','�̌�6�����ł�','720','100','3_magazine.png','1','3','1'),

('7','�|�X�g�J�[�h(���I)�^��g�u�M����v','��g�u�M����v�uGato Bonito!!�v���I�̃|�X�g�J�[�h�ł��B','160','100','4_nozomi.png','1','4','1'),

('8','�|�X�g�J�[�h(�]�C���l)�^��g�u�M����v','��g�u�M����v�uGato Bonito!!�v�]�C���l�̃|�X�g�J�[�h�ł��B','160','100','4_todoroki.png','1','4','1'),

('9','�В��o�b�O','�I�t�B�V�����O�b�Y���A���j���[�A�����ꂽ�g������V���ɓ��p�G�ݕi���o��I
���肰�Ȃ��f�U�C���ɓ����Ă���g���A�j����킸�g����V���N�n�b�g�Ə����炵���h���X����
2��ނ����C���A�b�v�I
�����ڂ̃X�}�z�����O��g�������`�[�t�ɂȂ����`���[���ȂǁA
�������Ȃ��A�C�e�������肾������I�I
���Ƒ���F�l�Ƃ������ɂ��Ă݂���A�ό��̂��y�Y�ɂ��s�b�^���ȃA�C�e���ł���
','1500','100','5_kinchaku.png','1','5','1'),

('10','���J���p�܂��ݎP','�I�t�B�V�����O�b�Y���A���J���p�܂��ݎP���o��I
�g�J���[�̃X�g���C�v���f�U�C������Ă���A�V���v���Ŏg���₷���f�U�C���ɁI
�X�g���C�v�����ȊO�A���Ȃ̂Œj���ǂ���ł��g���܂��B
�J�̓�������̓�������1�{����΂Ƃ��Ă��֗��I
�T�C�Y
���[���ꂽ��ԁF��24(cm)
�e���̒����F55�icm�j
���t�u�J�b�g���H
','3100','100','5_umbrella.png','1','5','1'),

('11','�В��o�b�O','�I�t�B�V�����O�b�Y���A���j���[�A�����ꂽ�g������V���ɓ��p�G�ݕi���o��I
���肰�Ȃ��f�U�C���ɓ����Ă���g���A�j����킸�g����V���N�n�b�g�Ə����炵���h���X����
2��ނ����C���A�b�v�I
�����ڂ̃X�}�z�����O��g�������`�[�t�ɂȂ����`���[���ȂǁA
�������Ȃ��A�C�e�������肾������I�I
���Ƒ���F�l�Ƃ������ɂ��Ă݂���A�ό��̂��y�Y�ɂ��s�b�^���ȃA�C�e���ł���
','1500','100','5_kinchaku.png','2','5','1'),

('12','���J���p�܂��ݎP','�I�t�B�V�����O�b�Y���A���J���p�܂��ݎP���o��I
�g�J���[�̃X�g���C�v���f�U�C������Ă���A�V���v���Ŏg���₷���f�U�C���ɁI
�X�g���C�v�����ȊO�A���Ȃ̂Œj���ǂ���ł��g���܂��B
�J�̓�������̓�������1�{����΂Ƃ��Ă��֗��I
�T�C�Y
���[���ꂽ��ԁF��24(cm)
�e���̒����F55�icm�j
���t�u�J�b�g���H
','3100','100','5_umbrella.png','2','5','1'),

('13','�В��o�b�O','�I�t�B�V�����O�b�Y���A���j���[�A�����ꂽ�g������V���ɓ��p�G�ݕi���o��I
���肰�Ȃ��f�U�C���ɓ����Ă���g���A�j����킸�g����V���N�n�b�g�Ə����炵���h���X����
2��ނ����C���A�b�v�I
�����ڂ̃X�}�z�����O��g�������`�[�t�ɂȂ����`���[���ȂǁA
�������Ȃ��A�C�e�������肾������I�I
���Ƒ���F�l�Ƃ������ɂ��Ă݂���A�ό��̂��y�Y�ɂ��s�b�^���ȃA�C�e���ł���
','1500','100','5_kinchaku.png','2','5','0'),

('14','���J���p�܂��ݎP','�I�t�B�V�����O�b�Y���A���J���p�܂��ݎP���o��I
�g�J���[�̃X�g���C�v���f�U�C������Ă���A�V���v���Ŏg���₷���f�U�C���ɁI
�X�g���C�v�����ȊO�A���Ȃ̂Œj���ǂ���ł��g���܂��B
�J�̓�������̓�������1�{����΂Ƃ��Ă��֗��I
�T�C�Y
���[���ꂽ��ԁF��24(cm)
�e���̒����F55�icm�j
���t�u�J�b�g���H
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
('1','�M����','20180601','20180701','0','gaisenmon.jpg'),
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


