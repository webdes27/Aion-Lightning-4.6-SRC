/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 */


package com.aionemu.gameserver.configs.administration;

import com.aionemu.commons.configuration.Property;

/**
 * @author vlog TEMPORARY fix
 */
public class CommandsConfig {

<<<<<<< .mine
    @Property(key = "add", defaultValue = "1")
    public static int ADD;
    @Property(key = "adddrop", defaultValue = "1")
    public static int ADDDROP;
    @Property(key = "addexp", defaultValue = "1")
    public static int ADDEXP;
    @Property(key = "addset", defaultValue = "3")
    public static int ADDSET;
    @Property(key = "addskill", defaultValue = "3")
    public static int ADDSKILL;
    @Property(key = "addtitle", defaultValue = "3")
    public static int ADDTITLE;
    @Property(key = "addtoll", defaultValue = "6")
    public static int ADDTOLL;
    @Property(key = "admin", defaultValue = "1")
    public static int ADMIN;
    @Property(key = "ai2", defaultValue = "4")
    public static int AI2;
    @Property(key = "announce", defaultValue = "1")
    public static int ANNONCE;
    @Property(key = "announcements", defaultValue = "1")
    public static int ANNONCEMENTS;
    @Property(key = "announcefaction", defaultValue = "3")
    public static int ANNONCEFACTION;
    @Property(key = "appearance", defaultValue = "3")
    public static int APPEARANCE;
    @Property(key = "attrbonus", defaultValue = "3")
    public static int ATTRBONUS;
    @Property(key = "ban", defaultValue = "3")
    public static int BAN;
    @Property(key = "banchar", defaultValue = "3")
    public static int BANCHAR;
    @Property(key = "banip", defaultValue = "3")
    public static int BANIP;
    @Property(key = "banmac", defaultValue = "3")
    public static int BANMAC;
    @Property(key = "base", defaultValue = "3")
    public static int BASE;
    @Property(key = "bk", defaultValue = "3")
    public static int BK;
    @Property(key = "channel", defaultValue = "3")
    public static int CHANNEL;
    @Property(key = "collide", defaultValue = "3")
    public static int COLLIDE;
    @Property(key = "configure", defaultValue = "3")
    public static int CONFIGURE;
    @Property(key = "cooldown", defaultValue = "3")
    public static int COOLDOWN;
    @Property(key = "damage", defaultValue = "3")
    public static int DAMAGE;
    @Property(key = "delete", defaultValue = "3")
    public static int DELETE;
    @Property(key = "delskill", defaultValue = "3")
    public static int DELSKILL;
    @Property(key = "dispel", defaultValue = "3")
    public static int DISPELL;
    @Property(key = "enemy", defaultValue = "3")
    public static int ENEMY;
    @Property(key = "equip", defaultValue = "3")
    public static int EQUIP;
    @Property(key = "fixpath", defaultValue = "3")
    public static int FIXPATH;
    @Property(key = "fsc", defaultValue = "3")
    public static int FSC;
    @Property(key = "gag", defaultValue = "3")
    public static int GAG;
    @Property(key = "gameshop", defaultValue = "3")
    public static int GAMESHOP;
    @Property(key = "gm", defaultValue = "1")
    public static int GM;
    @Property(key = "goto", defaultValue = "3")
    public static int GOTO;
    @Property(key = "gps", defaultValue = "0")
    public static int GPS;
    @Property(key = "grouptome", defaultValue = "3")
    public static int GROUPTOME;
    @Property(key = "heal", defaultValue = "3")
    public static int HEAL;
    @Property(key = "html", defaultValue = "3")
    public static int HTML;
    @Property(key = "info", defaultValue = "3")
    public static int INFO;
    @Property(key = "invis", defaultValue = "3")
    public static int INVIS;
    @Property(key = "invul", defaultValue = "3")
    public static int INVUL;
    @Property(key = "kamarbattle", defaultValue = "3")
    public static int KAMARBATTLE;
    @Property(key = "kick", defaultValue = "3")
    public static int KICK;
    @Property(key = "kill", defaultValue = "3")
    public static int KILL;
    @Property(key = "kinah", defaultValue = "3")
    public static int KINAH;
    @Property(key = "legion", defaultValue = "3")
    public static int LEGION;
    @Property(key = "map", defaultValue = "3")
    public static int MAP;
    @Property(key = "morph", defaultValue = "3")
    public static int MORPH;
    @Property(key = "motion", defaultValue = "3")
    public static int MOTION;
    @Property(key = "moveto", defaultValue = "3")
    public static int MOVETO;
    @Property(key = "moveplayertoplayer", defaultValue = "1")
    public static int MOVEPLAYERTOPLAYER;
    @Property(key = "movetome", defaultValue = "3")
    public static int MOVETOME;
    @Property(key = "movetomeall", defaultValue = "1")
    public static int MOVETOMEALL;
    @Property(key = "movetonpc", defaultValue = "3")
    public static int MOVETONPC;
    @Property(key = "movetoobject", defaultValue = "1")
    public static int MOVETOOBJECT;
    @Property(key = "movetoplayer", defaultValue = "1")
    public static int MOVETOPLAYER;
    @Property(key = "movie", defaultValue = "1")
    public static int MOVIE;
    @Property(key = "neutral", defaultValue = "1")
    public static int NEUTRAL;
    @Property(key = "notice", defaultValue = "1")
    public static int NOTICE;
    @Property(key = "npcskill", defaultValue = "1")
    public static int NPCSKILL;
    @Property(key = "passkeyreset", defaultValue = "4")
    public static int PASSKEYRESET;
    @Property(key = "petition", defaultValue = "1")
    public static int PETITION;
    @Property(key = "playerinfo", defaultValue = "1")
    public static int PLAYERINFO;
    @Property(key = "playerlist", defaultValue = "1")
    public static int PLAYERLIST;
    @Property(key = "powerup", defaultValue = "1")
    public static int POWERUP;
    @Property(key = "promote", defaultValue = "6")
    public static int PROMOTE;
    @Property(key = "quest", defaultValue = "2")
    public static int QUEST;
    @Property(key = "raw", defaultValue = "6")
    public static int RAW;
    @Property(key = "reload", defaultValue = "3")
    public static int RELOAD;
    @Property(key = "reload_spawn", defaultValue = "4")
    public static int RELOADSPAWN;
    @Property(key = "remove", defaultValue = "1")
    public static int REMOVE;
    @Property(key = "rename", defaultValue = "3")
    public static int RENAME;
    @Property(key = "res", defaultValue = "1")
    public static int RES;
    @Property(key = "revoke", defaultValue = "6")
    public static int REVOKE;
    @Property(key = "removecd", defaultValue = "4")
    public static int REMOVECD;
    @Property(key = "ring", defaultValue = "1")
    public static int RING;
    @Property(key = "rprison", defaultValue = "1")
    public static int RPRISON;
    @Property(key = "say", defaultValue = "1")
    public static int SAY;
    @Property(key = "see", defaultValue = "1")
    public static int SEE;
    @Property(key = "send", defaultValue = "4")
    public static int SEND;
    @Property(key = "set", defaultValue = "1")
    public static int SET;
    @Property(key = "setrace", defaultValue = "1")
    public static int SETRACE;
    @Property(key = "siege", defaultValue = "1")
    public static int SIEGE;
    @Property(key = "spawn", defaultValue = "1")
    public static int SPAWN;
    @Property(key = "spawnu", defaultValue = "1")
    public static int SPAWNU;
    @Property(key = "speed", defaultValue = "1")
    public static int SPEED;
    @Property(key = "state", defaultValue = "3")
    public static int STATE;
    @Property(key = "startevent", defaultValue = "3")
    public static int STARTEVENT;
    @Property(key = "stoken", defaultValue = "3")
    public static int STOKEN;
    @Property(key = "sprison", defaultValue = "1")
    public static int SPRISON;
    @Property(key = "sys", defaultValue = "4")
    public static int SYS;
    @Property(key = "sysmail", defaultValue = "1")
    public static int SYSMAIL;
    @Property(key = "teleportation", defaultValue = "1")
    public static int TELEPORTATION;
    @Property(key = "time", defaultValue = "1")
    public static int TIME;
    @Property(key = "tvt2", defaultValue = "1")
    public static int TVT2;
    @Property(key = "unban", defaultValue = "4")
    public static int UNBAN;
    @Property(key = "unbanchar", defaultValue = "4")
    public static int UNBANCHAR;
    @Property(key = "unbanip", defaultValue = "4")
    public static int UNBANIP;
    @Property(key = "ungag", defaultValue = "1")
    public static int UNGAG;
    @Property(key = "useskill", defaultValue = "3")
    public static int USESKILL;
    @Property(key = "warp", defaultValue = "1")
    public static int WARP;
    @Property(key = "wc", defaultValue = "1")
    public static int WC;
    @Property(key = "weather", defaultValue = "1")
    public static int WEATHER;
    @Property(key = "whisper", defaultValue = "1")
    public static int WHISPER;
    @Property(key = "who", defaultValue = "1")
    public static int WHO;
    @Property(key = "zone", defaultValue = "1")
    public static int ZONE;




    // Player Commands
    @Property(key = "bet", defaultValue = "0")
    public static int BET;
    @Property(key = "cube", defaultValue = "0")
    public static int CUBE;
    @Property(key = "divorce", defaultValue = "0")
    public static int DIVORCE;
    @Property(key = "drop", defaultValue = "0")
    public static int DROP;
    @Property(key = "dye", defaultValue = "1")
    public static int DYE;
    @Property(key = "enchant", defaultValue = "1")
    public static int ENCHANT;
    @Property(key = "exchange", defaultValue = "0")
    public static int EXCHANGE;
    @Property(key = "eye", defaultValue = "1")
    public static int EYE;
    @Property(key = "ffa", defaultValue = "1")
    public static int FFA;
    @Property(key = "goevent", defaultValue = "0")
    public static int GOEVENT;
    @Property(key = "gmlist", defaultValue = "0")
    public static int GMLIST;
    @Property(key = "help", defaultValue = "0")
    public static int HELP;
    @Property(key = "honoritems", defaultValue = "1")
    public static int HONORITEMS;
    @Property(key = "job", defaultValue = "1")
    public static int JOB;
    @Property(key = "marry", defaultValue = "0")
    public static int MARRY;
    @Property(key = "mcheck", defaultValue = "0")
    public static int MCHECK;
    @Property(key = "medal", defaultValue = "1")
    public static int MEDAL;
    @Property(key = "noexp", defaultValue = "0")
    public static int NOEXP;
    @Property(key = "preview", defaultValue = "0")
    public static int PREVIEW;
    @Property(key = "questauto", defaultValue = "1")
    public static int QUESTAUTO;
    @Property(key = "questrestart", defaultValue = "0")
    public static int QUESTRESTART;
    @Property(key = "revenge", defaultValue = "0")
    public static int REVENGE;
    @Property(key = "rp", defaultValue = "0")
    public static int RP;
    @Property(key = "shop", defaultValue = "0")
    public static int SHOP;
    @Property(key = "skills", defaultValue = "0")
    public static int SKILLS;
    @Property(key = "start", defaultValue = "0")
    public static int START;
    @Property(key = "toll", defaultValue = "0")
    public static int TOLL;
    @Property(key = "transfer", defaultValue = "0")
    public static int TRANSFER;
    @Property(key = "tvt", defaultValue = "0")
    public static int TVT;
    @Property(key = "userinfo", defaultValue = "0")
    public static int USERINFO;
    @Property(key = "unstuck", defaultValue = "0")
    public static int UNSTUCK;

	// Created Player Commands
	//@Property(key = "check", defaultValue = "0")
    //public static int CHECK;
	//@Property(key = "exchange", defaultValue = "0")
    //public static int EXCHANGE;
	//@Property(key = "freezer", defaultValue = "0")
   // public static int FREEZER;
	//@Property(key = "instances", defaultValue = "0")
    //public static int INSTANCES;
	@Property(key = "go", defaultValue = "0")
    public static int GO;
    @Property(key = "skin", defaultValue = "0")
    public static int SKIN;
	@Property(key = "givestigma", defaultValue = "0")
    public static int GIVESTIGMA;
    @Property(key = "showgp", defaultValue = "0")
    public static int SHOWGP;
    @Property(key = "augmentme", defaultValue = "0")
    public static int AUGMENTME;
	@Property(key = "checkpoint", defaultValue = "0")
    public static int CHECKPOINT;
	@Property(key = "queue", defaultValue = "0")
    public static int QUEUE;
	@Property(key = "levelme", defaultValue = "0")
    public static int LEVELME;
    @Property(key = "1v1", defaultValue = "0")
    public static int ONEVSONE;
    @Property(key = "event", defaultValue = "0")
    public static int EVENT;
    @Property(key = "bg", defaultValue = "0")
    public static int BG;
    @Property(key = "kor", defaultValue = "0")
    public static int KOR;

	

	//@Property(key = "enchantme", defaultValue = "0")
    //public static int ENCHANTME;
	//@Property(key = "unlockcube", defaultValue = "0")
    //public static int UNLOCKCUBE;
	//@Property(key = "test", defaultValue = "0")
    //public static int TEST;

	// Created Admin Commands
	//@Property(key = "showtoll", defaultValue = "2")
    //public static int SHOWTOLL;
	//@Property(key = "rewardall", defaultValue = "2")
    //public static int REWARDALL;
    @Property(key = "gp", defaultValue = "2")
    public static int GP;
    @Property(key = "outlaw", defaultValue = "3")
    public static int OUTLAW;
    @Property(key = "eventai", defaultValue = "2")
    public static int EVENTAI;
	@Property(key = "moveplayerto", defaultValue = "2")
    public static int MOVEPLAYERTO;
	@Property(key = "eventcaller", defaultValue = "2")
    public static int EVENTCALLER;
	@Property(key = "recharger", defaultValue = "2")
    public static int RECHARGER;	
	@Property(key = "misc", defaultValue = "2")
    public static int MISC;
	@Property(key = "urllink", defaultValue = "2")
    public static int URLLINK;
	@Property(key = "switchchannel", defaultValue = "2")
    public static int SWITCHCHANNEL;
	@Property(key = "check", defaultValue = "2")
    public static int CHECK;
    @Property(key = "emanager", defaultValue = "2")
    public static int EVENTUTIL;

    // Chat Command
    @Property(key = "asmo", defaultValue = "1")
    public static int ASMO;
    @Property(key = "ely", defaultValue = "1")
    public static int ELY;
    @Property(key = "faction", defaultValue = "1")
    public static int FACTION;
    @Property(key = "world", defaultValue = "1")
    public static int WORLD;
=======
	@Property(key = "add", defaultValue = "1")
	public static int ADD;
	@Property(key = "adddrop", defaultValue = "1")
	public static int ADDDROP;
	@Property(key = "addexp", defaultValue = "1")
	public static int ADDEXP;
	@Property(key = "addset", defaultValue = "3")
	public static int ADDSET;
	@Property(key = "addskill", defaultValue = "3")
	public static int ADDSKILL;
	@Property(key = "addtitle", defaultValue = "3")
	public static int ADDTITLE;
	@Property(key = "addtoll", defaultValue = "6")
	public static int ADDTOLL;
	@Property(key = "admin", defaultValue = "1")
	public static int ADMIN;
	@Property(key = "ai2", defaultValue = "6")
	public static int AI2;
	@Property(key = "announce", defaultValue = "1")
	public static int ANNONCE;
	@Property(key = "announcements", defaultValue = "1")
	public static int ANNONCEMENTS;
	@Property(key = "announcefaction", defaultValue = "3")
	public static int ANNONCEFACTION;
	@Property(key = "appearance", defaultValue = "3")
	public static int APPEARANCE;
	@Property(key = "attrbonus", defaultValue = "3")
	public static int ATTRBONUS;
	@Property(key = "ban", defaultValue = "3")
	public static int BAN;
	@Property(key = "banchar", defaultValue = "3")
	public static int BANCHAR;
	@Property(key = "banip", defaultValue = "3")
	public static int BANIP;
	@Property(key = "banmac", defaultValue = "3")
	public static int BANMAC;
	@Property(key = "base", defaultValue = "3")
	public static int BASE;
	@Property(key = "bk", defaultValue = "3")
	public static int BK;
	@Property(key = "channel", defaultValue = "3")
	public static int CHANNEL;
	@Property(key = "collide", defaultValue = "3")
	public static int COLLIDE;
	@Property(key = "configure", defaultValue = "3")
	public static int CONFIGURE;
	@Property(key = "cooldown", defaultValue = "3")
	public static int COOLDOWN;
	@Property(key = "damage", defaultValue = "3")
	public static int DAMAGE;
	@Property(key = "delete", defaultValue = "3")
	public static int DELETE;
	@Property(key = "delskill", defaultValue = "3")
	public static int DELSKILL;
	@Property(key = "dispel", defaultValue = "3")
	public static int DROPINFO;
	@Property(key = "dropinfo", defaultValue = "3")
	public static int DISPELL;
	@Property(key = "enemy", defaultValue = "3")
	public static int ENEMY;
	@Property(key = "equip", defaultValue = "3")
	public static int EQUIP;
	@Property(key = "fixpath", defaultValue = "3")
	public static int FIXPATH;
	@Property(key = "fsc", defaultValue = "3")
	public static int FSC;
	@Property(key = "gp", defaultValue = "3")
	public static int Gp;
	@Property(key = "gag", defaultValue = "3")
	public static int GAG;
	@Property(key = "gameshop", defaultValue = "3")
	public static int GAMESHOP;
	@Property(key = "gm", defaultValue = "1")
	public static int GM;
	@Property(key = "goto", defaultValue = "3")
	public static int GOTO;
	@Property(key = "gps", defaultValue = "0")
	public static int GPS;
	@Property(key = "grouptome", defaultValue = "3")
	public static int GROUPTOME;
	@Property(key = "heal", defaultValue = "3")
	public static int HEAL;
	@Property(key = "html", defaultValue = "3")
	public static int HTML;
	@Property(key = "info", defaultValue = "3")
	public static int INFO;
	@Property(key = "invis", defaultValue = "3")
	public static int INVIS;
	@Property(key = "invul", defaultValue = "3")
	public static int INVUL;
	@Property(key = "kamarbattle", defaultValue = "3")
	public static int KAMARBATTLE;
	@Property(key = "kick", defaultValue = "3")
	public static int KICK;
	@Property(key = "kill", defaultValue = "3")
	public static int KILL;
	@Property(key = "kinah", defaultValue = "3")
	public static int KINAH;
	@Property(key = "legion", defaultValue = "3")
	public static int LEGION;
	@Property(key = "map", defaultValue = "3")
	public static int MAP;
	@Property(key = "morph", defaultValue = "3")
	public static int MORPH;
	@Property(key = "motion", defaultValue = "3")
	public static int MOTION;
	@Property(key = "moveto", defaultValue = "3")
	public static int MOVETO;
	@Property(key = "moveplayertoplayer", defaultValue = "1")
	public static int MOVEPLAYERTOPLAYER;
	@Property(key = "movetome", defaultValue = "3")
	public static int MOVETOME;
	@Property(key = "movetomeall", defaultValue = "1")
	public static int MOVETOMEALL;
	@Property(key = "movetonpc", defaultValue = "3")
	public static int MOVETONPC;
	@Property(key = "movetoobject", defaultValue = "1")
	public static int MOVETOOBJECT;
	@Property(key = "movetoplayer", defaultValue = "1")
	public static int MOVETOPLAYER;
	@Property(key = "movie", defaultValue = "1")
	public static int MOVIE;
	@Property(key = "neutral", defaultValue = "1")
	public static int NEUTRAL;
	@Property(key = "notice", defaultValue = "1")
	public static int NOTICE;
	@Property(key = "npcskill", defaultValue = "1")
	public static int NPCSKILL;
	@Property(key = "passkeyreset", defaultValue = "4")
	public static int PASSKEYRESET;
	@Property(key = "petition", defaultValue = "1")
	public static int PETITION;
	@Property(key = "playerinfo", defaultValue = "1")
	public static int PLAYERINFO;
	@Property(key = "playerlist", defaultValue = "1")
	public static int PLAYERLIST;
	@Property(key = "powerup", defaultValue = "1")
	public static int POWERUP;
	@Property(key = "promote", defaultValue = "6")
	public static int PROMOTE;
	@Property(key = "quest", defaultValue = "2")
	public static int QUEST;
	@Property(key = "raw", defaultValue = "6")
	public static int RAW;
	@Property(key = "reload", defaultValue = "3")
	public static int RELOAD;
	@Property(key = "reload_spawn", defaultValue = "4")
	public static int RELOADSPAWN;
	@Property(key = "remove", defaultValue = "1")
	public static int REMOVE;
	@Property(key = "rename", defaultValue = "3")
	public static int RENAME;
	@Property(key = "res", defaultValue = "1")
	public static int RES;
	@Property(key = "revoke", defaultValue = "6")
	public static int REVOKE;
	@Property(key = "removecd", defaultValue = "4")
	public static int REMOVECD;
	@Property(key = "ring", defaultValue = "1")
	public static int RING;
	@Property(key = "rprison", defaultValue = "1")
	public static int RPRISON;
	@Property(key = "say", defaultValue = "1")
	public static int SAY;
	@Property(key = "see", defaultValue = "1")
	public static int SEE;
	@Property(key = "send", defaultValue = "6")
	public static int SEND;
	@Property(key = "set", defaultValue = "1")
	public static int SET;
	@Property(key = "setrace", defaultValue = "1")
	public static int SETRACE;
	@Property(key = "siege", defaultValue = "1")
	public static int SIEGE;
	@Property(key = "spawn", defaultValue = "1")
	public static int SPAWN;
	@Property(key = "spawnu", defaultValue = "1")
	public static int SPAWNU;
	@Property(key = "speed", defaultValue = "1")
	public static int SPEED;
	@Property(key = "state", defaultValue = "3")
	public static int STATE;
	@Property(key = "startevent", defaultValue = "3")
	public static int STARTEVENT;
	@Property(key = "stoken", defaultValue = "3")
	public static int STOKEN;
	@Property(key = "sprison", defaultValue = "1")
	public static int SPRISON;
	@Property(key = "sys", defaultValue = "4")
	public static int SYS;
	@Property(key = "sysmail", defaultValue = "1")
	public static int SYSMAIL;
	@Property(key = "teleportation", defaultValue = "1")
	public static int TELEPORTATION;
	@Property(key = "time", defaultValue = "1")
	public static int TIME;
	@Property(key = "tvt2", defaultValue = "1")
	public static int TVT2;
	@Property(key = "unban", defaultValue = "4")
	public static int UNBAN;
	@Property(key = "unbanchar", defaultValue = "4")
	public static int UNBANCHAR;
	@Property(key = "unbanip", defaultValue = "4")
	public static int UNBANIP;
	@Property(key = "ungag", defaultValue = "1")
	public static int UNGAG;
	@Property(key = "useskill", defaultValue = "3")
	public static int USESKILL;
	@Property(key = "warp", defaultValue = "1")
	public static int WARP;
	@Property(key = "wc", defaultValue = "1")
	public static int WC;
	@Property(key = "weather", defaultValue = "1")
	public static int WEATHER;
	@Property(key = "whisper", defaultValue = "1")
	public static int WHISPER;
	@Property(key = "who", defaultValue = "1")
	public static int WHO;
	@Property(key = "zone", defaultValue = "1")
	public static int ZONE;
	@Property(key = "moveplayerto", defaultValue = "1")
	public static int MOVEPLAYERTO;
	// Player Commands
	@Property(key = "bet", defaultValue = "0")
	public static int BET;
	@Property(key = "bg", defaultValue = "0")
	public static int BG;
	@Property(key = "cube", defaultValue = "1")
	public static int CUBE;
	@Property(key = "divorce", defaultValue = "0")
	public static int DIVORCE;
	@Property(key = "dye", defaultValue = "1")
	public static int DYE;
	@Property(key = "enchant", defaultValue = "1")
	public static int ENCHANT;
	@Property(key = "exchange", defaultValue = "0")
	public static int EXCHANGE;
	@Property(key = "eye", defaultValue = "1")
	public static int EYE;
	@Property(key = "goevent", defaultValue = "0")
	public static int GOEVENT;
	@Property(key = "gmlist", defaultValue = "0")
	public static int GMLIST;
	@Property(key = "help", defaultValue = "0")
	public static int HELP;
	@Property(key = "honoritems", defaultValue = "1")
	public static int HONORITEMS;
	@Property(key = "job", defaultValue = "1")
	public static int JOB;
	@Property(key = "marry", defaultValue = "0")
	public static int MARRY;
	@Property(key = "mcheck", defaultValue = "0")
	public static int MCHECK;
	@Property(key = "medal", defaultValue = "1")
	public static int MEDAL;
	@Property(key = "noexp", defaultValue = "0")
	public static int NOEXP;
	@Property(key = "preview", defaultValue = "0")
	public static int PREVIEW;
	@Property(key = "questauto", defaultValue = "1")
	public static int QUESTAUTO;
	@Property(key = "questrestart", defaultValue = "0")
	public static int QUESTRESTART;
	@Property(key = "revenge", defaultValue = "0")
	public static int REVENGE;
	@Property(key = "rp", defaultValue = "0")
	public static int RP;
	@Property(key = "shop", defaultValue = "0")
	public static int SHOP;
	@Property(key = "skills", defaultValue = "0")
	public static int SKILLS;
	@Property(key = "start", defaultValue = "0")
	public static int START;
	@Property(key = "toll", defaultValue = "0")
	public static int TOLL;
	@Property(key = "transfer", defaultValue = "0")
	public static int TRANSFER;
	@Property(key = "tvt", defaultValue = "0")
	public static int TVT;
	@Property(key = "userinfo", defaultValue = "0")
	public static int USERINFO;
	@Property(key = "unstuck", defaultValue = "0")
	public static int UNSTUCK;
	// Chat Command
	@Property(key = "asmo", defaultValue = "1")
	public static int ASMO;
	@Property(key = "ely", defaultValue = "1")
	public static int ELY;
	@Property(key = "faction", defaultValue = "1")
	public static int FACTION;
	@Property(key = "world", defaultValue = "1")
	public static int WORLD;
>>>>>>> .r274
}