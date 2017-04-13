
DROP TABLE IF EXISTS User;
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
  usr_email VARCHAR(256) NOT NULL,
  usr_password VARCHAR(256) NOT NULL,
  usr_okv NUMERIC(15,2) NOT NULL DEFAULT 0.0,
  usr_login_dte DATETIME NOT NULL,
  	PRIMARY KEY (usr_user_id),
    UNIQUE UQ_USR_LOGIN (usr_login)
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
	  UNIQUE UQ_TRN_TOURNAMENT (trn_tournament),
	  CONSTRAINT FK_TOURNAMENT_KIND_SPORT FOREIGN KEY (trn_sp_id) REFERENCES Kind_Sport(ksp_sp_id)
);

CREATE TABLE IF NOT EXISTS Team (
	tms_team_id INT NOT NULL AUTO_INCREMENT, 
	tms_team VARCHAR(128) NOT NULL,
	tms_city VARCHAR(128) NOT NULL,
	tms_country VARCHAR(128) NOT NULL,
	tms_sex VARCHAR(8) NOT NULL,
	tms_sp_id INT NOT NULL,
	  PRIMARY KEY (tms_team_id),
	  UNIQUE UQ_TMS_TEAM_CITY_COUNTRY_SEX (tms_team, tms_city, tms_country, tms_sex),
	  CONSTRAINT FK_TEAM_KIND_SPORT FOREIGN KEY (tms_sp_id) REFERENCES Kind_Sport(ksp_sp_id)
);


CREATE TABLE IF NOT EXISTS Item (
	itm_item_id INT NOT NULL AUTO_INCREMENT, 
	itm_dat DATETIME NOT NULL,
  itm_tourn_id INT NOT NULL,
  itm_team_id_home INT NOT NULL,
  itm_team_id_away INT NOT NULL,
  itm_koef_w1 NUMERIC(15,2) NOT NULL DEFAULT 1.0,
  itm_koef_x NUMERIC(15,2) NOT NULL DEFAULT 1.0,
  itm_koef_w2 NUMERIC(15,2) NOT NULL DEFAULT 1.0,
  itm_score_home INT NOT NULL DEFAULT 0,
  itm_score_away INT NOT NULL DEFAULT 0,
  itm_fl_finished BIT(1) NOT NULL DEFAULT 0,
	  PRIMARY KEY (itm_item_id),
    CONSTRAINT FK_ITEM_TOURNAMENT FOREIGN KEY (itm_tourn_id) REFERENCES Tournament(trn_tourn_id),
    CONSTRAINT FK_ITEM_TEAM_HOME FOREIGN KEY (itm_team_id_home) REFERENCES Team(tms_team_id),
    CONSTRAINT FK_ITEM_TEAM_AWAY FOREIGN KEY (itm_team_id_away) REFERENCES Team(tms_team_id)
);



CREATE TABLE IF NOT EXISTS Bet (
	bts_bet_id INT NOT NULL AUTO_INCREMENT, 
  bts_item_id INT NOT NULL,
  bts_user_id INT NOT NULL,
  bts_bet_dat DATETIME NOT NULL,
  bts_event VARCHAR(8) NOT NULL,
  bts_sum NUMERIC(15,2) NOT NULL,
  bts_total NUMERIC(15,2) NOT NULL DEFAULT 0.0,
  bts_fl_finished BIT(1) NOT NULL DEFAULT 0,
    PRIMARY KEY (bts_bet_id),
    --UNIQUE UQ_BTS_ITEM_USER (bts_item_id, bts_user_id),
    CONSTRAINT FK_BET_ITEM FOREIGN KEY (bts_item_id) REFERENCES Item(itm_item_id),
    CONSTRAINT FK_BET_USER FOREIGN KEY (bts_user_id) REFERENCES User(usr_user_id)
);

    
