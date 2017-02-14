

insert into User (usr_login, usr_first_name, usr_last_name, usr_role)
select	'GAMST', 'Anton', 'Bessmeltsev', 'U';

insert into Account (acc_user_id, acc_okv)
select	1, 100.00;

insert into Kind_Sport (ksp_sport)
select	'Футбол';

insert into Tournament (trn_tournament, trn_sp_id)
select	'Чемпионат Украины 2016/2017', 1;

insert into Team (tms_team, tms_city, tms_country, tms_sp_id, tms_sex)
select	'Днепр', 'Днепропетровск', 'Украина', 1, 'М';
insert into Team (tms_team, tms_city, tms_country, tms_sp_id, tms_sex)
select	'Динамо', 'Киев', 'Украина', 1, 'М';

insert into Event (evn_event, evn_event_opis)
select	'П1', 'Победа первой команды';

insert into Item (itm_dat, itm_tourn_id, itm_team_id_home, itm_team_id_away)
select	'2016-01-25', 1, 1, 2;

insert into Rate (rts_item_id, rts_event_id, rts_rate)
select	1, 1, 2.80;

insert into Item_Result (irs_item_id, irs_score_home, irs_score_away)
select	1, 2, 1;

insert into Bet (bts_item_id, bts_user_id, bts_event_id, bts_sum)
select	1, 1, 1, 100.00;


