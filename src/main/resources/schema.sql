
DROP TABLE IF EXISTS User;
DROP TABLE IF EXISTS Account;
DROP TABLE IF EXISTS Kind_Sport;
DROP TABLE IF EXISTS Tournament;
DROP TABLE IF EXISTS Team;
DROP TABLE IF EXISTS Event;
DROP TABLE IF EXISTS Item;
DROP TABLE IF EXISTS Rate;
DROP TABLE IF EXISTS Item_Result;
DROP TABLE IF EXISTS Bet;


CREATE TABLE IF NOT EXISTS User (
	usr_user_id INT NOT NULL AUTO_INCREMENT,
	usr_login VARCHAR(50) NOT NULL, 
	usr_first_name VARCHAR(256) NOT NULL,
	usr_last_name VARCHAR(256) NOT NULL,
  usr_role VARCHAR(1) NOT NULL default 'U',
	PRIMARY KEY (usr_user_id),
    UNIQUE UQ_USR_LOGIN (usr_login) 
);


CREATE TABLE IF NOT EXISTS Account (
	acc_user_id INT NOT NULL, 
	acc_okv NUMERIC(15,2) NOT NULL DEFAULT 0.0,
	PRIMARY KEY (acc_user_id),
    CONSTRAINT FK_ACCOUNT_USER FOREIGN KEY (acc_user_id) REFERENCES User(usr_user_id)
);


CREATE TABLE IF NOT EXISTS Kind_Sport (
	ksp_sp_id INT NOT NULL AUTO_INCREMENT, 
	ksp_sport VARCHAR(128) NOT NULL,
	PRIMARY KEY (ksp_sp_id),
    UNIQUE UQ_KSP_SPORT (ksp_sport)
);

CREATE TABLE IF NOT EXISTS Tournament (
	trn_tourn_id INT NOT NULL AUTO_INCREMENT, 
	trn_tournament VARCHAR(256) NOT NULL, 
    trn_sp_id INT NOT NULL,
	PRIMARY KEY (trn_tourn_id),
	CONSTRAINT FK_TOURNAMENT_KIND_SPORT FOREIGN KEY (trn_sp_id) REFERENCES Kind_Sport(ksp_sp_id)
);

CREATE TABLE IF NOT EXISTS Team (
	tms_team_id INT NOT NULL AUTO_INCREMENT, 
	tms_team VARCHAR(128) NOT NULL, 
    tms_city VARCHAR(128) NOT NULL, 
    tms_country VARCHAR(128) NOT NULL, 
    tms_sp_id INT NOT NULL,
    tms_sex VARCHAR(1) NOT NULL, 
	PRIMARY KEY (tms_team_id),
	CONSTRAINT FK_TEAM_KIND_SPORT FOREIGN KEY (tms_sp_id) REFERENCES Kind_Sport(ksp_sp_id)
);

CREATE TABLE IF NOT EXISTS Event (
	evn_event_id INT NOT NULL AUTO_INCREMENT,
	evn_event VARCHAR(8) NOT NULL, 
	evn_event_opis VARCHAR(256) NOT NULL,
	PRIMARY KEY (evn_event_id),
    UNIQUE UQ_EVN_SPORT (evn_event)
);

CREATE TABLE IF NOT EXISTS Item (
	itm_item_id INT NOT NULL AUTO_INCREMENT, 
	itm_dat DATETIME NOT NULL,
    itm_tourn_id INT NOT NULL,
    itm_team_id_home INT NOT NULL, 
    itm_team_id_away INT NOT NULL, 
	PRIMARY KEY (itm_item_id),
    CONSTRAINT FK_ITEM_TOURNAMENT FOREIGN KEY (itm_tourn_id) REFERENCES Tournament(trn_tourn_id),
    CONSTRAINT FK_ITEM_TEAM_HOME FOREIGN KEY (itm_team_id_home) REFERENCES Team(tms_team_id),
    CONSTRAINT FK_ITEM_TEAM_AWAY FOREIGN KEY (itm_team_id_away) REFERENCES Team(tms_team_id)
);

CREATE TABLE IF NOT EXISTS Rate (
	rts_item_id INT NOT NULL, 
    rts_event_id INT NOT NULL,
	rts_rate NUMERIC(10,2) NOT NULL,
    PRIMARY KEY (rts_item_id, rts_event_id),
    CONSTRAINT FK_RATE_ITEM FOREIGN KEY (rts_item_id) REFERENCES Item(itm_item_id),
    CONSTRAINT FK_RATE_EVENT FOREIGN KEY (rts_event_id) REFERENCES Event(evn_event_id)
);

CREATE TABLE IF NOT EXISTS Item_Result (
	irs_item_id INT NOT NULL, 
    irs_score_home INT NOT NULL,
	irs_score_away INT NOT NULL,
    PRIMARY KEY (irs_item_id),
    CONSTRAINT FK_ITEM_RESULT_ITEM FOREIGN KEY (irs_item_id) REFERENCES Item(itm_item_id)
);

CREATE TABLE IF NOT EXISTS Bet (
	bts_bet_id INT NOT NULL AUTO_INCREMENT, 
    bts_item_id INT NOT NULL, 
    bts_user_id INT NOT NULL,
    bts_event_id INT NOT NULL,
    bts_sum NUMERIC(15,2) NOT NULL,
    bts_total NUMERIC(15,2) NOT NULL DEFAULT 0.0,
    bts_isFinished VARCHAR(8) NOT NULL DEFAULT 'N',
    PRIMARY KEY (bts_bet_id),
    CONSTRAINT FK_BET_ITEM FOREIGN KEY (bts_item_id) REFERENCES Item(itm_item_id),
    CONSTRAINT FK_BET_ACCOUNT FOREIGN KEY (bts_user_id) REFERENCES Account(acc_user_id),
    CONSTRAINT FK_BET_EVENT FOREIGN KEY (bts_event_id) REFERENCES Event(evn_event_id)
);

    
