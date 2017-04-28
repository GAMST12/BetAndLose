

insert into User (usr_login, usr_first_name, usr_last_name, usr_role, usr_email, usr_password, usr_okv, usr_login_dte)
select	'GAMST', 'Anton', 'Bessmeltsev', 'U', 'gamst9@gmail.com', 'qwerty', 1000.00, '2017-01-01';


insert into User (usr_login, usr_first_name, usr_last_name, usr_role, usr_email, usr_password, usr_okv, usr_login_dte)
select	'admin', 'admin', 'admin', 'A', 'admin@betandlose.com', 'admin', 0.00, '2017-03-31';


insert into Kind_Sport (ksp_sport)
select	'Football';

insert into Tournament (trn_tournament, trn_sp_id)
select	'Ukrainian Premier League 2016/2017', 1;

insert into Team (tms_team, tms_city, tms_country, tms_sex, tms_sp_id)
select	'Dnipro', 'Dnipro', 'Ukraine', 'Man', 1;
insert into Team (tms_team, tms_city, tms_country, tms_sex, tms_sp_id)
select	'Dynamo', 'Kiyv', 'Ukraine', 'Man', 1;


insert into Item (itm_dat, itm_tourn_id, itm_team_id_home, itm_team_id_away, itm_koef_w1, itm_koef_x, itm_koef_w2)
select	'2017-01-25', 1, 1, 2, 2.80, 2.70, 2.50;
insert into Item (itm_dat, itm_tourn_id, itm_team_id_home, itm_team_id_away, itm_koef_w1, itm_koef_x, itm_koef_w2)
select	'2017-04-30', 1, 2, 1, 1.80, 2.70, 3.80;


insert into Bet (bts_item_id, bts_user_id, bts_bet_dat, bts_event, bts_sum)
select	1, 1, '2017-01-01', 'WIN1', 100.00;
insert into Bet (bts_item_id, bts_user_id, bts_bet_dat, bts_event, bts_sum)
select	2, 1, '2017-02-20', 'DRAW', 100.00;


/*
insert into Bet (bts_item_id, bts_user_id, bts_bet_dat, bts_event, bts_sum)
select	2, 2, '2017-02-20', 'DRAW', 100.00;
*/


