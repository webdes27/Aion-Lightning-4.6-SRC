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


package instance;

import java.util.*;
import javolution.util.FastMap;
import java.util.concurrent.Future;

import com.aionemu.commons.utils.Rnd;
import com.aionemu.commons.network.util.ThreadPoolManager;

import com.aionemu.gameserver.ai2.*;
import com.aionemu.gameserver.ai2.manager.WalkManager;
import com.aionemu.gameserver.controllers.effect.PlayerEffectController;
import com.aionemu.gameserver.instance.handlers.GeneralInstanceHandler;
import com.aionemu.gameserver.instance.handlers.InstanceID;
import com.aionemu.gameserver.model.*;
import com.aionemu.gameserver.model.drop.DropItem;
import com.aionemu.gameserver.model.gameobjects.Npc;
import com.aionemu.gameserver.model.gameobjects.Creature;
import com.aionemu.gameserver.model.gameobjects.StaticDoor;
import com.aionemu.gameserver.model.gameobjects.VisibleObject;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.items.storage.Storage;
<<<<<<< .mine
import com.aionemu.gameserver.network.aion.serverpackets.*;
import com.aionemu.gameserver.services.item.ItemService;
import com.aionemu.gameserver.services.drop.DropRegistrationService;
=======
import com.aionemu.gameserver.network.aion.serverpackets.*;
>>>>>>> .r274
import com.aionemu.gameserver.services.player.PlayerReviveService;
import com.aionemu.gameserver.services.teleport.TeleportService2;
import com.aionemu.gameserver.skillengine.SkillEngine;
import com.aionemu.gameserver.utils.*;
import com.aionemu.gameserver.world.WorldMapInstance;
import com.aionemu.gameserver.world.knownlist.Visitor;
import com.aionemu.gameserver.world.zone.ZoneInstance;
import com.aionemu.gameserver.world.zone.ZoneName;

<<<<<<< .mine
/*
Author Waii (Dev team)
*/
=======
/**
 * @author Alcapwnd
 * @rework Blackfire
 */
>>>>>>> .r274
<<<<<<< .mine

/**
You start at the top of the instance so you need to move down as fast as you can.
If you die inside you will restart at the entrance of the instance.  
The tower has two floors, bridges on east and west are connected to the second floor and north and south bridges are connected to the first floor.  
An elevator in the center connects both floors.  
Four Shield Units must be defended from monsters, and each shield needs to charge 3 phases, when all shields are at third phase the final boss will spawn.  
Cannons are located around the shield units, enter them with the right item and make wide area damage to the monsters.

=======
>>>>>>> .r274
<<<<<<< .mine
Special Features:
Successfully defend the towers and the final boss will appear.
You will need to collect the items, defend the towers and then the "Boss" will appear.
Updrafts are placed around the map so you can travel faster between floors and bridges, if you fall outside the updraft it will instant kill you.
The rolls of the party members is important, designate a person to collect the items, another for the cannons, and to defend the shield units.
=======
@InstanceID(301230000)
public class IlluminaryObeliskInstance extends GeneralInstanceHandler {
    @SuppressWarnings("unused")
    private long startTime;
    @SuppressWarnings("unused")
	private int beritraKilled;
	private boolean isStop;
	private boolean isStop1;
	private boolean isEnd;
	private Future<?> TWDTask;
	@SuppressWarnings("unused")
	private Future<?> TWD1Task;
	@SuppressWarnings("unused")
	private Future<?> TWD2Task;
	private Future<?> GENTask;
	private Future<?> CNT1Task;
	private Future<?> CNT2Task;
	private Future<?> CNT3Task;
	private Future<?> CNT4Task;
	private Future<?> CNT5Task;
	private Future<?> CNT6Task;
	private Future<?> CNT7Task;
	private Future<?> SP1Task;
	private Future<?> SP2Task;
	private Future<?> SP3Task;
	private Future<?> SP4Task;
	private Future<?> CHKTask;
    private Future<?> instanceTimer;
    private Map<Integer, StaticDoor> doors;
    protected boolean isInstanceDestroyed = false;
    private List<Integer> movies = new ArrayList<Integer>();
>>>>>>> .r274

<<<<<<< .mine
Starting Point:
You will start at the top of the instance.
At the starting point you can obtain quests from the NPC.
A timer of 30 minutes will start once you glide down.
If you die inside the instance, you will resurrect at the entrance.
=======
    @Override
    public void onInstanceCreate(WorldMapInstance instance) {
        super.onInstanceCreate(instance);
        doors = instance.getDoors();
    }
>>>>>>> .r274

<<<<<<< .mine
Shield Units:
Its a good idea to start powering the shields once you have 6 ide shield items.
Help collect the remaining pieces together in the other bridges.
Once you charge a shield with one of the items, a wave of monster will appear, help that person and kill the mobs.
Protect the shield units from monsters while you charge them up to the 3rd phase.
Once all shields are at the 3rd phase no more monsters will spawn.
=======
    @Override
    public void onEnterInstance(final Player player) {
        super.onInstanceCreate(instance);
        if (instanceTimer == null) {
            startTime = System.currentTimeMillis();
            instanceTimer = ThreadPoolManager.getInstance().schedule(new Runnable() {
                @Override
                public void run() {
                    sendMsg(1402193);
                    openFirstDoors();
                }
            }, 60000);
        }
        switch (player.getRace()) {
            case ELYOS:
                sendMovie(player, 894);
                break;
            case ASMODIANS:
                sendMovie(player, 895);
                break;
            default:
                break;
        }
    }
>>>>>>> .r274

<<<<<<< .mine
Activate The Seal:
When all shield units have been charged up to the 3rd phase, you can activate the passage to the final boss.
When you activate the seal the final boss will appear and the fight will begin.
**/
=======
    /**
     * Defense Cannons:
     * Each Shield Unit has a defense cannon that can be used.
     * This cannons do powerful wide area damage attacks.
     * In order to use them you need to have Bomb items.
     * When a shield is charged completely a cannon will spawn to help in the defense of the area.
     * Determining a person to use the cannon and positioning before the mobs come is a recommended.
     * Bombs to use the cannons appear in chests around the instance in a different place every time, collect them too.
     */
    @Override
    public void handleUseItemFinish(Player player, Npc npc) {
        switch (npc.getNpcId()) {
            case 702009: // Danuar Cannon.
            case 702021: // Danuar Cannon.
            case 702022: // Danuar Cannon.
            case 702023: // Danuar Cannon.
                despawnNpc(npc);
                SkillEngine.getInstance().getSkill(npc, 21511, 60, player).useNoAnimationSkill();
                break;
        }
    }
>>>>>>> .r274

<<<<<<< .mine
@InstanceID(301230000)
public class IlluminaryObeliskInstance extends GeneralInstanceHandler
{
    private long startTime;
    private int beritraKilled;
    private Future<?> TWDTask;
    private Future<?> instanceTimer;
    private Map<Integer, StaticDoor> doors;
    protected boolean isInstanceDestroyed = false;
    private List<Integer> movies = new ArrayList<Integer>();
    
    @Override
    public void onInstanceCreate(WorldMapInstance instance) {
        super.onInstanceCreate(instance);
        doors = instance.getDoors();
    }
    
   /**
    * Reward:
    * After a successful capture of the boss you will get a small chance of obtaining mythical wings, and a variety of items.
    * Boxes are for all the members and the wings only for one person in the group.
    */
/*    public void onDropRegistered(Npc npc) {
        Set<DropItem> dropItems = DropRegistrationService.getInstance().getCurrentDropMap().get(npc.getObjectId());
        int npcId = npc.getNpcId();
        int index = dropItems.size() + 1;
        switch (npcId) {
            case 233740: //Test Weapon Dynatoum.
                for (Player player: instance.getPlayersInside()) {
                    if (player.isOnline()) {
                      //dropItems.add(DropRegistrationService.getInstance().regDropItem(index++, player.getObjectId(), npcId, 188052830, 1)); //Dynatoum's Brazen Weapon Box.
                      //dropItems.add(DropRegistrationService.getInstance().regDropItem(index++, player.getObjectId(), npcId, 188052831, 1)); //Dynatoum's Brazen Armor Box.
                        dropItems.add(DropRegistrationService.getInstance().regDropItem(index++, player.getObjectId(), npcId, 188052827, 1)); //Dynatoum's Equipment Chest.   
                        dropItems.add(DropRegistrationService.getInstance().regDropItem(index++, player.getObjectId(), npcId, 188052823, 1)); //Illuminary Obelisk Supply Chest.  
                        dropItems.add(DropRegistrationService.getInstance().regDropItem(index++, player.getObjectId(), npcId, 188053295, 1)); //Empyrean Plume Chest.                 
                        dropItems.add(DropRegistrationService.getInstance().regDropItem(index++, player.getObjectId(), npcId, 188053083, 1)); //Tempering Solution Chest.
                        }
            }
            break;
           /**
            * Collect Items:
            * Each "Shield Generator" unit needs 3 ide items, 12 items in total, you can find them all around the instance.
            * Bombs to use the cannons appear in chests around the instance in a different place every time, collect them too.
            */
/*            case 730884: //Flourishing Idium.
                dropItems.add(DropRegistrationService.getInstance().regDropItem(1, 0, npcId, 164000289, 3));
            break;
            case 730885: //Danuar Cannonballs.
                dropItems.add(DropRegistrationService.getInstance().regDropItem(1, 0, npcId, 164000290, 3));
            break;
        }
    } */
    
    @Override
    public void onEnterInstance(final Player player) {
        super.onInstanceCreate(instance);
        if (instanceTimer == null) {
            startTime = System.currentTimeMillis();
            instanceTimer = ThreadPoolManager.getInstance().schedule(new Runnable() {
                @Override
                public void run() {
                    sendMsg(1402193);
                    openFirstDoors();
                }
            }, 60000);
        } switch (player.getRace()) {
            case ELYOS:
                sendMovie(player, 894);
            break;
            case ASMODIANS:
                sendMovie(player, 895);
            break;
        }
    }
    
   /**
    * Defense Cannons:
    * Each Shield Unit has a defense cannon that can be used.
    * This cannons do powerful wide area damage attacks.
    * In order to use them you need to have Bomb items.
    * When a shield is charged completely a cannon will spawn to help in the defense of the area.
    * Determining a person to use the cannon and positioning before the mobs come is a recommended.
    * Bombs to use the cannons appear in chests around the instance in a different place every time, collect them too.
    */
    @Override
    public void handleUseItemFinish(Player player, Npc npc) {
        switch (npc.getNpcId()) {
            case 702009: //Danuar Cannon.
            case 702021: //Danuar Cannon.
            case 702022: //Danuar Cannon.
            case 702023: //Danuar Cannon.
                despawnNpc(npc);
                SkillEngine.getInstance().getSkill(npc, 21511, 60, player).useNoAnimationSkill();
            break;
        }
    }
    
   /**
    * If a "Shield" is destroyed, you must start again from the 1st phase
    * You can heal the shield with a restoration skill.
    */
    @Override
    public void onDie(Npc npc) {
        Player player = npc.getAggroList().getMostPlayerDamage();
        switch (npc.getObjectTemplate().getTemplateId()) {
            case 284851: //Beritra Ranger.
            case 284853: //Beritra Songweaver.
            case 284855: //Beritra Immobilizer.
            case 284857: //Beritra Healer.
                beritraKilled ++;
                if (beritraKilled == 1) {
                } else if (beritraKilled == 2) {
                } else if (beritraKilled == 3) {
                } else if (beritraKilled == 4) {
                    spawnShieldControlRoomTeleporter();
                }
                despawnNpc(npc);
            break;
            case 702010: //Eastern Shield Generator.
                despawnNpc(npc);
                deleteNpc(233723);
                deleteNpc(233724);
                deleteNpc(233725);
                deleteNpc(233734);
                deleteNpc(233735);
                deleteNpc(233857);
                deleteNpc(284841);
                deleteNpc(284842);
                deleteNpc(284843);
                deleteNpc(284850);
                deleteNpc(284851);
                deleteNpc(702218);
                deleteNpc(702219);
                deleteNpc(702220);
                instance.doOnAllPlayers(new Visitor<Player>() {
                    @Override
                    public void visit(Player player) {
                        PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402139));
                    }
                });
                ThreadPoolManager.getInstance().schedule(new Runnable() {
                    @Override
                    public void run() {
                        spawn(702010, 255.47392f, 293.56177f, 321.18497f, (byte) 89); //Eastern Shield Generator.
                    }
                }, 10000);
            break;
            case 702011: //Western Shield Generator.
                despawnNpc(npc);
                deleteNpc(233726);
                deleteNpc(233727);
                deleteNpc(233728);
                deleteNpc(233736);
                deleteNpc(233737);
                deleteNpc(233858);
                deleteNpc(284844);
                deleteNpc(284845);
                deleteNpc(284846);
                deleteNpc(284852);
                deleteNpc(284853);
                deleteNpc(702221);
                deleteNpc(702222);
                deleteNpc(702223);
                instance.doOnAllPlayers(new Visitor<Player>() {
                    @Override
                    public void visit(Player player) {
                        PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402140));
                    }
                });
                ThreadPoolManager.getInstance().schedule(new Runnable() {
                    @Override
                    public void run() {
                        spawn(702011, 255.55742f, 216.03549f, 321.21344f, (byte) 30); //Western Shield Generator.
                    }
                }, 10000);
            break;
            case 702012: //Southern Shield Generator.
                despawnNpc(npc);
                deleteNpc(233729);
                deleteNpc(233730);
                deleteNpc(233731);
                deleteNpc(233738);
                deleteNpc(233739);
                deleteNpc(233880);
                deleteNpc(284847);
                deleteNpc(284848);
                deleteNpc(284849);
                deleteNpc(284854);
                deleteNpc(284855);
                deleteNpc(702224);
                deleteNpc(702225);
                deleteNpc(702226);
                instance.doOnAllPlayers(new Visitor<Player>() {
                    @Override
                    public void visit(Player player) {
                        PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402141));
                    }
                });
                ThreadPoolManager.getInstance().schedule(new Runnable() {
                    @Override
                    public void run() {
                        spawn(702012, 294.20718f, 254.60352f, 295.7729f, (byte) 60); //Southern Shield Generator.
                    }
                }, 10000);
            break;
            case 702013: //Northern Shield Generator.
                despawnNpc(npc);
                deleteNpc(233720);
                deleteNpc(233721);
                deleteNpc(233722);
                deleteNpc(233732);
                deleteNpc(233733);
                deleteNpc(233881);
                deleteNpc(284838);
                deleteNpc(284839);
                deleteNpc(284840);
                deleteNpc(284856);
                deleteNpc(284857);
                deleteNpc(702227);
                deleteNpc(702228);
                deleteNpc(702229);
                instance.doOnAllPlayers(new Visitor<Player>() {
                    @Override
                    public void visit(Player player) {
                        PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402142));
                    }
                });
                ThreadPoolManager.getInstance().schedule(new Runnable() {
                    @Override
                    public void run() {
                        spawn(702013, 216.97739f, 254.4616f, 295.77353f, (byte) 0); //Northern Shield Generator.
                    }
                }, 10000);
            break;
           /****************************
            * Eastern Shield Generator *
            ****************************/
            case 233723:
            case 233724:
            case 233725:
                despawnNpc(npc);
                if (getNpcs(233723).isEmpty() &&
                    getNpcs(233724).isEmpty() &&
                    getNpcs(233725).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402194);
                            spawn(702218, 255.56438f, 297.59488f, 321.39154f, (byte) 29);
                        }
                    }, 2000);
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            startWaveEasternShieldGenerator2();
                        }
                    }, 8000);
                }
            break;
            case 284841:
            case 284842:
            case 284843:
                despawnNpc(npc);
                if (getNpcs(284841).isEmpty() &&
                    getNpcs(284842).isEmpty() &&
                    getNpcs(284843).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402194);
                            sendMsg(1402198);
                            spawn(702219, 255.56438f, 297.59488f, 321.39154f, (byte) 29);
                        }
                    }, 2000);
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            startWaveEasternShieldGenerator3();
                        }
                    }, 8000);
                }
            break;
            case 233734:
            case 233735:
            case 233857:
            case 284850:
                despawnNpc(npc);
                if (getNpcs(233734).isEmpty() &&
                    getNpcs(233735).isEmpty() &&
                    getNpcs(233857).isEmpty() &&
                    getNpcs(284850).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402194);
                            spawn(702220, 255.56438f, 297.59488f, 321.39154f, (byte) 29);
                        }
                    }, 2000);
                }
            break;
           /****************************
            * Western Shield Generator *
            ****************************/
            case 233726:
            case 233727:
            case 233728:
                despawnNpc(npc);
                if (getNpcs(233726).isEmpty() &&
                    getNpcs(233727).isEmpty() &&
                    getNpcs(233728).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402195);
                            spawn(702221, 255.38777f, 212.00926f, 321.37292f, (byte) 90);
                        }
                    }, 2000);
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            startWaveWesternShieldGenerator2();
                        }
                    }, 8000);
                }
            break;
            case 284844:
            case 284845:
            case 284846:
                despawnNpc(npc);
                if (getNpcs(284844).isEmpty() &&
                    getNpcs(284845).isEmpty() &&
                    getNpcs(284846).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402195);
                            sendMsg(1402199);
                            spawn(702222, 255.38777f, 212.00926f, 321.37292f, (byte) 90);
                        }
                    }, 2000);
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            startWaveWesternShieldGenerator3();
                        }
                    }, 8000);
                }
            break;
            case 233736:
            case 233737:
            case 233858:
            case 284852:
                despawnNpc(npc);
                if (getNpcs(233736).isEmpty() &&
                    getNpcs(233737).isEmpty() &&
                    getNpcs(233858).isEmpty() &&
                    getNpcs(284852).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402195);
                            spawn(702223, 255.38777f, 212.00926f, 321.37292f, (byte) 90);
                        }
                    }, 2000);
                }
            break;
           /*****************************
            * Southern Shield Generator *
            *****************************/
            case 233729:
            case 233730:
            case 233731:
                despawnNpc(npc);
                if (getNpcs(233729).isEmpty() &&
                    getNpcs(233730).isEmpty() &&
                    getNpcs(233731).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402197);
                            spawn(702224, 298.13452f, 254.48087f, 295.93027f, (byte) 119);
                        }
                    }, 2000);
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            startWaveSouthernShieldGenerator2();
                        }
                    }, 8000);
                }
            break;
            case 284847:
            case 284848:
            case 284849:
                despawnNpc(npc);
                if (getNpcs(284847).isEmpty() &&
                    getNpcs(284848).isEmpty() &&
                    getNpcs(284849).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402196);
                            sendMsg(1402200);
                            spawn(702225, 298.13452f, 254.48087f, 295.93027f, (byte) 119);
                        }
                    }, 2000);
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            startWaveSouthernShieldGenerator3();
                        }
                    }, 8000);
                }
            break;
            case 233738:
            case 233739:
            case 233880:
            case 284854:
                despawnNpc(npc);
                if (getNpcs(233738).isEmpty() &&
                    getNpcs(233739).isEmpty() &&
                    getNpcs(233880).isEmpty() &&
                    getNpcs(284854).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402196);
                            spawn(702226, 298.13452f, 254.48087f, 295.93027f, (byte) 119);
                        }
                    }, 2000);
                }
            break;
           /*****************************
            * Northern Shield Generator *
            *****************************/
            case 233720:
            case 233721:
            case 233722:
                despawnNpc(npc);
                if (getNpcs(233720).isEmpty() &&
                    getNpcs(233721).isEmpty() &&
                    getNpcs(233722).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402197);
                            spawn(702227, 212.96484f, 254.4526f, 295.90784f, (byte) 60);
                        }
                    }, 2000);
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            startWaveNorthernShieldGenerator2();
                        }
                    }, 8000);
                }
            break;
            case 284838:
            case 284839:
            case 284840:
                despawnNpc(npc);
                if (getNpcs(284838).isEmpty() &&
                    getNpcs(284839).isEmpty() &&
                    getNpcs(284840).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402197);
                            sendMsg(1402201);
                            spawn(702228, 212.96484f, 254.4526f, 295.90784f, (byte) 60);
                        }
                    }, 2000);
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            startWaveNorthernShieldGenerator3();
                        }
                    }, 8000);
                }
            break;
            case 233732:
            case 233733:
            case 233881:
            case 284856:
                despawnNpc(npc);
                if (getNpcs(233732).isEmpty() &&
                    getNpcs(233733).isEmpty() &&
                    getNpcs(233881).isEmpty() &&
                    getNpcs(284856).isEmpty()) {
                    ThreadPoolManager.getInstance().schedule(new Runnable() {
                        @Override
                        public void run() {
                            sendMsg(1402197);
                            spawn(702229, 212.96484f, 254.4526f, 295.90784f, (byte) 60);
                        }
                    }, 2000);
                }
            break;
           /**
            * Final Boss.
            */
            case 233740: //Test Weapon Dynatoum.
                TWDTask.cancel(true);
                sendMsg("[Congratulation]: you finish <ILLUMINARY OBELISK>");
                spawn(730905, 241.23743f, 254.4286f, 455.12573f, (byte) 0); //Illuminary Obelisk Exit.
            break;
        }
    }
    
   /**
    * You have about 6 minutes to finish the boss, so all party members must be ready before activating the seal.
    */
    @Override
    public void onEnterZone(Player player, ZoneInstance zone) {
        if (zone.getAreaTemplate().getZoneName() == ZoneName.get("SHIELD_GENERATION_HUB_301230000")) {
            instance.doOnAllPlayers(new Visitor<Player>() {
                @Override
                public void visit(Player player) {
                    if (player.isOnline()) {
                        PacketSendUtility.sendPacket(player, new SM_QUEST_ACTION(0, 360)); //6 Minutes.
                        TWDTask = ThreadPoolManager.getInstance().schedule(new Runnable() {
                            @Override
                            public void run() {
                                instance.doOnAllPlayers(new Visitor<Player>() {
                                    @Override
                                    public void visit(Player player) {
                                        onExitInstance(player);
                                    }
                                });
                                onInstanceDestroy();
                            }
                        }, 360000); //6 Minutes.
                    }
                }
            });
        }
    }
    
    private void removeEffects(Player player) {
        PlayerEffectController effectController = player.getEffectController();
        effectController.removeEffect(0);
    }
    
    public void removeItems(Player player) {
        Storage storage = player.getInventory();
        storage.decreaseByItemId(164000289, storage.getItemCountByItemId(164000289));
        storage.decreaseByItemId(164000290, storage.getItemCountByItemId(164000290));
    }
    
   /**
    * The higher the phase of the charge will spawn more difficult monsters, in the 3rd phase elite monsters will spawn.
    * Charging a shield to the 3rd phase continuously can be hard because of all the mobs you will have to handle.
    * A few easy monsters will spawn after a certain time if you leave the shield unit alone.
    * After all units have been charged to the 3rd phase, defeat the remaining monsters.
    ****************************
    * Eastern Shield Generator *
    ****************************/
    private void startWaveEasternShieldGenerator2() {
        sp(284842, 252.68709f, 333.483f, 325.59268f, (byte) 90, 1000, "EasternShieldGenerator1");
        sp(284841, 255.74022f, 333.2762f, 325.49332f, (byte) 90, 1000, "EasternShieldGenerator2");
        sp(284843, 258.72256f, 333.27713f, 325.58722f, (byte) 90, 1000, "EasternShieldGenerator3");
    }
    private void startWaveEasternShieldGenerator3() {
        sp(233734, 252.68709f, 333.483f, 325.59268f, (byte) 90, 6000, "EasternShieldGenerator1");
        sp(233735, 255.74022f, 333.2762f, 325.49332f, (byte) 90, 6000, "EasternShieldGenerator2");
        sp(284850, 258.72256f, 333.27713f, 325.58722f, (byte) 90, 6000, "EasternShieldGenerator3");
        sp(233857, 252.68709f, 333.483f, 325.59268f, (byte) 90, 23000, "EasternShieldGenerator1");
        sp(284851, 255.74022f, 333.2762f, 325.49332f, (byte) 90, 23000, "EasternShieldGenerator2");
        sp(233857, 258.72256f, 333.27713f, 325.58722f, (byte) 90, 23000, "EasternShieldGenerator3");
    }
   /****************************
    * Western Shield Generator *
    ****************************/
    private void startWaveWesternShieldGenerator2() {
        sp(284844, 258.37912f, 176.03621f, 325.59268f, (byte) 30, 1000, "WesternShieldGenerator1");
        sp(284845, 255.55922f, 176.17963f, 325.49332f, (byte) 29, 1000, "WesternShieldGenerator2");
        sp(284846, 252.49738f, 176.27466f, 325.52942f, (byte) 29, 1000, "WesternShieldGenerator3");
    }
    private void startWaveWesternShieldGenerator3() {
        sp(233736, 258.37912f, 176.03621f, 325.59268f, (byte) 30, 6000, "WesternShieldGenerator1");
        sp(233737, 255.55922f, 176.17963f, 325.49332f, (byte) 29, 6000, "WesternShieldGenerator2");
        sp(284852, 252.49738f, 176.27466f, 325.52942f, (byte) 29, 6000, "WesternShieldGenerator3");
        sp(233858, 258.37912f, 176.03621f, 325.59268f, (byte) 30, 23000, "WesternShieldGenerator1");
        sp(284853, 255.55922f, 176.17963f, 325.49332f, (byte) 29, 23000, "WesternShieldGenerator2");
        sp(233858, 252.49738f, 176.27466f, 325.52942f, (byte) 29, 23000, "WesternShieldGenerator3");
    }
   /*****************************
    * Southern Shield Generator *
    *****************************/
    private void startWaveSouthernShieldGenerator2() {
        sp(284847, 337.93338f, 257.88702f, 292.43845f, (byte) 60, 1000, "SouthernShieldGenerator1");
        sp(284848, 338.05304f, 254.6424f, 292.3325f, (byte) 60, 1000, "SouthernShieldGenerator2");
        sp(284849, 338.13315f, 251.34738f, 292.48932f, (byte) 59, 1000, "SouthernShieldGenerator3");
    }
    private void startWaveSouthernShieldGenerator3() {
        sp(233738, 337.93338f, 257.88702f, 292.43845f, (byte) 60, 6000, "SouthernShieldGenerator1");
        sp(233739, 338.05304f, 254.6424f, 292.3325f, (byte) 60, 6000, "SouthernShieldGenerator2");
        sp(284854, 338.13315f, 251.34738f, 292.48932f, (byte) 59, 6000, "SouthernShieldGenerator3");
        sp(233880, 337.93338f, 257.88702f, 292.43845f, (byte) 60, 23000, "SouthernShieldGenerator1");
        sp(284855, 338.05304f, 254.6424f, 292.3325f, (byte) 60, 23000, "SouthernShieldGenerator2");
        sp(233880, 338.13315f, 251.34738f, 292.48932f, (byte) 59, 23000, "SouthernShieldGenerator3");
    }
   /*****************************
    * Northern Shield Generator *
    *****************************/
    private void startWaveNorthernShieldGenerator2() {
        sp(284838, 174.50981f, 251.38982f, 292.43088f, (byte) 0, 1000, "NorthernShieldGenerator1");
        sp(284839, 174.9973f, 254.4739f, 292.3325f, (byte) 0, 1000, "NorthernShieldGenerator2");
        sp(284840, 174.84029f, 257.80832f, 292.4389f, (byte) 0, 1000, "NorthernShieldGenerator3");
    }
    private void startWaveNorthernShieldGenerator3() {
        sp(233732, 174.50981f, 251.38982f, 292.43088f, (byte) 0, 6000, "NorthernShieldGenerator1");
        sp(233733, 174.9973f, 254.4739f, 292.3325f, (byte) 0, 6000, "NorthernShieldGenerator2");
        sp(284856, 174.84029f, 257.80832f, 292.4389f, (byte) 0, 6000, "NorthernShieldGenerator3");
        sp(233881, 174.50981f, 251.38982f, 292.43088f, (byte) 0, 23000, "NorthernShieldGenerator1");
        sp(284857, 174.9973f, 254.4739f, 292.3325f, (byte) 0, 23000, "NorthernShieldGenerator2");
        sp(233881, 174.84029f, 257.80832f, 292.4389f, (byte) 0, 23000, "NorthernShieldGenerator3");
    }
   /**********************************
    * Shield Control Room Teleporter *
    **********************************/
    private void spawnShieldControlRoomTeleporter() {
        deleteNpc(702010);
        deleteNpc(702011);
        deleteNpc(702012);
        deleteNpc(702013);
        spawn(730886, 255.47392f, 293.56177f, 321.18497f, (byte) 89);
        spawn(730886, 255.55742f, 216.03549f, 321.21344f, (byte) 30);
        spawn(730886, 294.20718f, 254.60352f, 295.7729f, (byte) 60);
        spawn(730886, 216.97739f, 254.4616f, 295.77353f, (byte) 0);
    }
    
    protected void sp(final int npcId, final float x, final float y, final float z, final byte h, final int time, final String walkerId) {
        ThreadPoolManager.getInstance().schedule(new Runnable() {
            @Override
            public void run() {
                if (!isInstanceDestroyed) {
                    Npc npc = (Npc)spawn(npcId, x, y, z, h);
                    npc.getSpawn().setWalkerId(walkerId);
                    WalkManager.startWalking((NpcAI2) npc.getAi2());
                }
            }
        }, time);
    }
    
    protected void openFirstDoors() {
        openDoor(129);
    }
    
    protected void openDoor(int doorId) {
        StaticDoor door = doors.get(doorId);
        if (door != null) {
            door.setOpen(true);
        }
    }
    
    private void sendMsg(final String str) {
        instance.doOnAllPlayers(new Visitor<Player>() {
            @Override
            public void visit(Player player) {
                PacketSendUtility.sendMessage(player, str);
            }
        });
    }
    
    private void sendMovie(Player player, int movie) {
        if (!movies.contains(movie)) {
             movies.add(movie);
             PacketSendUtility.sendPacket(player, new SM_PLAY_MOVIE(0, movie));
        }
    }
    
    @Override
    public void onPlayerLogOut(Player player) {
        removeItems(player);
        removeEffects(player);
    }
    
    @Override
    public void onLeaveInstance(Player player) {
        removeItems(player);
        removeEffects(player);
    }
    
    @Override
    public void onInstanceDestroy() {
        if (instanceTimer != null) {
            instanceTimer.cancel(false);
        
        }
        isInstanceDestroyed = true;
        doors.clear();
        movies.clear();
    }
     
    public void onExitInstance(Player player) {
        TeleportService2.moveToInstanceExit(player, mapId, player.getRace());
    }
    
    private void deleteNpc(int npcId) {
        if (getNpc(npcId) != null) {
            getNpc(npcId).getController().onDelete();
        }
    }
    
    protected void despawnNpc(Npc npc) {
        if (npc != null) {
            npc.getController().onDelete();
        }
    }
    
    protected void despawnNpcs(List<Npc> npcs) {
        for (Npc npc: npcs) {
            npc.getController().onDelete();
        }
    }
    
    protected Npc getNpc(int npcId) {
        if (!isInstanceDestroyed) {
            return instance.getNpc(npcId);
        }
        return null;
    }
    
    protected List<Npc> getNpcs(int npcId) {
        if (!isInstanceDestroyed) {
            return instance.getNpcs(npcId);
        }
        return null;
    }
    
    @Override
    public boolean onReviveEvent(Player player) {
        PacketSendUtility.sendPacket(player, SM_SYSTEM_MESSAGE.STR_REBIRTH_MASSAGE_ME);
        PlayerReviveService.revive(player, 100, 100, false, 0);
        player.getGameStats().updateStatsAndSpeedVisually();
        return TeleportService2.teleportTo(player, mapId, instanceId, 321.6408f, 323.9414f, 405.50763f, (byte) 75);
    }
    
    @Override
    public boolean onDie(final Player player, Creature lastAttacker) {
        PacketSendUtility.broadcastPacket(player, new SM_EMOTION(player, EmotionType.DIE, 0, player.equals(lastAttacker) ? 0 : lastAttacker.getObjectId()), true);
        PacketSendUtility.sendPacket(player, new SM_DIE(player.haveSelfRezEffect(), player.haveSelfRezItem(), 0, 8));
        return true;
    }
}=======
    /**
     * If a "Shield" is destroyed, you must start again from the 1st phase
     * You can heal the shield with a restoration skill.
     */
    @Override
    public void onDie(Npc npc) {
        //Player player = npc.getAggroList().getMostPlayerDamage();
        switch (npc.getObjectTemplate().getTemplateId()) {
            case 702010: // Eastern Shield Generator.
                despawnNpc(npc);
				deleteNpc(233720);
				deleteNpc(233721);
				deleteNpc(233728);
                deleteNpc(233729);
                deleteNpc(233730);
                deleteNpc(233732);
                deleteNpc(233733);
                deleteNpc(233734);
                deleteNpc(233735);
                deleteNpc(233736);
                deleteNpc(233737);
                deleteNpc(233738);
				deleteNpc(233739);
				deleteNpc(702014);
				deleteNpc(702218);
				deleteNpc(702219);
				deleteNpc(702220);
				isEnd = true;
				SP1Task.cancel(true);
				instance.doOnAllPlayers(new Visitor<Player>() {
                    @Override
                    public void visit(Player player) {
                        PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402139));
					}
                });
                ThreadPoolManager.getInstance().schedule(new Runnable() {
                    @Override
                    public void run() {
                        spawn(702010, 255.47392f, 293.56177f, 321.18497f, (byte) 89); //Eastern Shield Generator.
						isEnd = false;
                    }
                }, 10000);
                break;
            case 702011: // Western Shield Generator.
                despawnNpc(npc);
				deleteNpc(233722);
				deleteNpc(233723);
				deleteNpc(233728);
                deleteNpc(233729);
                deleteNpc(233730);
                deleteNpc(233732);
                deleteNpc(233733);
                deleteNpc(233734);
                deleteNpc(233735);
                deleteNpc(233736);
                deleteNpc(233737);
                deleteNpc(233738);
				deleteNpc(233739);
				deleteNpc(702015);
				deleteNpc(702221);
				deleteNpc(702222);
				deleteNpc(702223);
				SP2Task.cancel(true);
				isEnd = true;
                instance.doOnAllPlayers(new Visitor<Player>() {
                    @Override
                    public void visit(Player player) {
                        PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402140));
					}
                });
                ThreadPoolManager.getInstance().schedule(new Runnable() {
                    @Override
                    public void run() {
                        spawn(702011, 255.55742f, 216.03549f, 321.21344f, (byte) 30); //Western Shield Generator.
						isEnd = false;
                    }
                }, 10000);
                break;
            case 702012: // Southern Shield Generator.
                despawnNpc(npc);
				deleteNpc(233724);
                deleteNpc(233725);
                deleteNpc(233728);
                deleteNpc(233729);
                deleteNpc(233730);
                deleteNpc(233732);
                deleteNpc(233733);
                deleteNpc(233734);
                deleteNpc(233735);
                deleteNpc(233736);
                deleteNpc(233737);
                deleteNpc(233738);
				deleteNpc(233739);
				deleteNpc(702016);
				deleteNpc(702224);
				deleteNpc(702225);
				deleteNpc(702226);
				SP3Task.cancel(true);
				isEnd = true;
                instance.doOnAllPlayers(new Visitor<Player>() {
                    @Override
                    public void visit(Player player) {
                        PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402141));
					}
                });
                ThreadPoolManager.getInstance().schedule(new Runnable() {
                    @Override
                    public void run() {
                        spawn(702012, 294.20718f, 254.60352f, 295.7729f, (byte) 60); //Southern Shield Generator.
						isEnd = false;
                    }
                }, 10000);
                break;
            case 702013: // Northern Shield Generator.
                despawnNpc(npc);
				deleteNpc(233726);
                deleteNpc(233727);
                deleteNpc(233728);
                deleteNpc(233729);
                deleteNpc(233730);
                deleteNpc(233732);
                deleteNpc(233733);
                deleteNpc(233734);
                deleteNpc(233735);
                deleteNpc(233736);
                deleteNpc(233737);
                deleteNpc(233738);
				deleteNpc(233739);
				deleteNpc(702016);
				deleteNpc(702227);
				deleteNpc(702228);
				deleteNpc(702229);
				SP4Task.cancel(true);
				isEnd = true;
                instance.doOnAllPlayers(new Visitor<Player>() {
                    @Override
                    public void visit(Player player) {
                        PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402142));
					}
                });
                ThreadPoolManager.getInstance().schedule(new Runnable() {
                    @Override
                    public void run() {
                        spawn(702013, 216.97739f, 254.4616f, 295.77353f, (byte) 0); //Northern Shield Generator.
						isEnd = false;
                    }
                }, 10000);
                break;
            /****************************
             * Eastern Shield Generator *
             ****************************/
            case 233720:
            case 233721:
			case 233881:
                despawnNpc(npc);
				if (getNpcs(233720).isEmpty() && getNpcs(233721).isEmpty() && getNpcs(233881).isEmpty()) {
						spawncheckE();
                    }
                break;
           	case 233728:
			case 233729:
			case 233730:
			case 233731:
			case 233732:
			case 233733:
			case 233734:
			case 233735:
			case 233736:
			case 233737:
			case 233738:
			case 233739:
            	despawnNpc(npc);
                break;
            /****************************
             * Western Shield Generator *
             ****************************/
            case 233722:
            case 233723:
			case 233882:
                despawnNpc(npc);
                if (getNpcs(233722).isEmpty() && getNpcs(233723).isEmpty() && getNpcs(233882).isEmpty()) {
						spawncheckW();
                    }
                break;
            
            /*****************************
             * Southern Shield Generator *
             *****************************/
            case 233724:
			case 233725:
			case 233883:
				despawnNpc(npc);
               if (getNpcs(233724).isEmpty() && getNpcs(233725).isEmpty() && getNpcs(233883).isEmpty()) {
						spawncheckS();
                    }
                break;
           
            /*****************************
             * Northern Shield Generator *
             *****************************/
            case 233726:
            case 233727:
			case 233857:
               despawnNpc(npc);
                if (getNpcs(233726).isEmpty() && getNpcs(233727).isEmpty() && getNpcs(233857).isEmpty()) {
						spawncheckN();
                    }
                break;
            
            /**
             * Final Boss.
             */
            case 233740: // Test Weapon Dynatoum.
                TWDTask.cancel(true);
                spawn(730905, 255.5597f, 254.49713f, 455.12012f, (byte) 104); //Illuminary Obelisk Exit.
                break;
        }
    }

    /**
     * You have about 6 minutes to finish the boss, so all party members must be ready before activating the seal.
     */
    @Override
    public void onEnterZone(Player player, ZoneInstance zone) {
		if (zone.getAreaTemplate().getZoneName() == ZoneName.get("SHIELD_GENERATION_HUB_301230000")) {
			if (!isStop) {
				isStop = true;
				instance.doOnAllPlayers(new Visitor<Player>() {
					@Override
					public void visit(Player player) {
						if (player.isOnline()) {
							sendMsg(1402143);
							PacketSendUtility.sendPacket(player, new SM_QUEST_ACTION(0, 360)); //6 Minutes.
							TWDTask = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402146);
											onExitInstance(player);
										}
									});
									onInstanceDestroy();
								}
							}, 360000); // 6 Minutes.
							
							TWD1Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402144);
										}
									});
								}
							}, 60000); // 1 Minutes.
							
							TWD2Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402145);
										}
									});
								}
							}, 300000); // 5 Minutes.
						}
					}
				});
			}
		} else {
			if (zone.getAreaTemplate().getZoneName() == ZoneName.get("SZ_SECTOR_A_301230000") || zone.getAreaTemplate().getZoneName() == ZoneName.get("SZ_SECTOR_B_301230000") || zone.getAreaTemplate().getZoneName() == ZoneName.get("SZ_SECTOR_C_301230000")
				|| zone.getAreaTemplate().getZoneName() == ZoneName.get("SZ_SECTOR_D_301230000")) {
				if (!isStop1) {
					chargecheck();
					instance.doOnAllPlayers(new Visitor<Player>() {
						@Override
						public void visit(Player player) {
							if (player.isOnline()) {
								isStop1 = true;
								sendMsg(1402129); //30 msg.
								countdownmsg();
								spawncheckE();
								GENTask = ThreadPoolManager.getInstance().schedule(new Runnable() {
									@Override
									public void run() {
										instance.doOnAllPlayers(new Visitor<Player>() {
											@Override
											public void visit(Player player) {
												onExitInstance(player);
											}
										});
										onInstanceDestroy();
									}
								}, 1830000); // 30 Minutes and 30 second.
							}
						}
					});
				}
			}
		}
    }
	
	/**
	 * ***************************
     * Eastern Shield Generator Periodic Spawn *
     * **************************
     */
	 private void startWaveEasternShieldGenerator1() {
        sp(233720, 252.68709f, 333.483f, 325.59268f, (byte) 90, 1000, "EasternShieldGenerator1");
		sp(233721, 255.74022f, 333.2762f, 325.49332f, (byte) 90, 1000, "EasternShieldGenerator2");
		sp(233881, 258.72256f, 333.27713f, 325.58722f, (byte) 90, 6000, "EasternShieldGenerator3");
    }
	
	/**
	 * ***************************
     * Western Shield Generator Periodic Spawn *
     * **************************
     */
	 private void startWaveWesternShieldGenerator1() {
        sp(233722, 258.37912f, 176.03621f, 325.59268f, (byte) 30, 1000, "WesternShieldGenerator1");
		sp(233723, 255.55922f, 176.17963f, 325.49332f, (byte) 29, 1000, "WesternShieldGenerator2");
		sp(233882, 252.49738f, 176.27466f, 325.52942f, (byte) 29, 1000, "WesternShieldGenerator3");
	}
	
	/**
	 * ***************************
     * Southern Shield Generator Periodic Spawn *
     * **************************
     */
	 private void startWaveSouthernShieldGenerator1() {
		sp(233724, 337.93338f, 257.88702f, 292.43845f, (byte) 60, 1000, "SouthernShieldGenerator1");
		sp(233725, 338.05304f, 254.6424f, 292.3325f, (byte) 60, 1000, "SouthernShieldGenerator2");
		sp(233883, 338.13315f, 251.34738f, 292.48932f, (byte) 59, 1000, "SouthernShieldGenerator3");
	}
	
	/**
	 * ***************************
     * Northern Shield Generator Periodic Spawn *
     * **************************
     */
	 
	 private void startWaveNorthernShieldGenerator1() {
		sp(233726, 174.50981f, 251.38982f, 292.43088f, (byte) 0, 1000, "NorthernShieldGenerator1");
		sp(233727, 174.9973f, 254.4739f, 292.3325f, (byte) 0, 1000, "NorthernShieldGenerator2");
		sp(233857, 174.84029f, 257.80832f, 292.4389f, (byte) 0, 1000, "NorthernShieldGenerator3");
	}	
	
	/**
     * Starting periodic enemy spawn until all generator is fully charged East.
     */
	public void spawncheckE() {
				if (!isEnd) {
						SP1Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
							@Override
							public void run() {
								startWaveEasternShieldGenerator1();
							}
						}, 30000 * 3); // spawn every 1 and a half minutes.
					} 
	}
	
	/**
     * Starting periodic enemy spawn until all generator is fully charged Western.
     */
	public void spawncheckW() {
				if (!isEnd) {
						SP2Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
							@Override
							public void run() {
								startWaveWesternShieldGenerator1();
							}
						}, 30000 * 3); // spawn every 1 and a half minutes.
					} 
	}
	
	/**
     * Starting periodic enemy spawn until all generator is fully charged South.
     */
	public void spawncheckS() {
				if (!isEnd) {
						SP3Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
							@Override
							public void run() {
								startWaveSouthernShieldGenerator1();
							}
						}, 30000 * 3); // spawn every 1 and a half minutes.
					} 
    }
	
	/**
     * Starting periodic enemy spawn until all generator is fully charged North.
     */
	public void spawncheckN() {
				if (!isEnd) {
						SP4Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
							@Override
							public void run() {
								startWaveNorthernShieldGenerator1();
							}
						}, 30000 * 3); //spawn every 1 and a half minutes.
					} 
    }
	
	/**
     * Starting periodic enemy spawn until all generator is fully charged.
     */
	public void chargecheck() {
			if (!getNpcs(702220).isEmpty() && !getNpcs(702223).isEmpty() && !getNpcs(702226).isEmpty() &&  !getNpcs(702229).isEmpty()) {
				spawnShieldControlRoomTeleporter();
			} else {
					CHKTask = ThreadPoolManager.getInstance().schedule(new Runnable() {
							@Override
							public void run() {
								chargecheck();
							}
						}, 60000);
					} 
	
	}
		
	public void countdownmsg() {
				instance.doOnAllPlayers(new Visitor<Player>() {
					@Override
					public void visit(Player player) {
						if (player.isOnline()) {
							CNT1Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402130);
										}
									});
								}
							}, 60000 * 5); // 25 Minutes.
							
							CNT2Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402131);
										}
									});
								}
							}, 60000 * 10); // 20 Minutes.
							
							CNT3Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402132);
										}
									});
								}
							}, 60000 * 15); // 15 Minutes.
							
							CNT4Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402133);
										}
									});
								}
							}, 60000 * 20); // 10 Minutes.
							
							CNT5Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402134);
										}
									});
								}
							}, 60000 * 25); // 5 Minutes.
							
							CNT6Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402235);
										}
									});
								}
							}, 60000 * 29); // 4 Minutes.
							
							CNT7Task = ThreadPoolManager.getInstance().schedule(new Runnable() {
								@Override
								public void run() {
									instance.doOnAllPlayers(new Visitor<Player>() {
										@Override
										public void visit(Player player) {
											sendMsg(1402236);
										}
									});
								}
							}, 60000 * 30); // 5 Minutes.
					}
				}
			});
	}
	
	private void removeEffects(Player player) {
        PlayerEffectController effectController = player.getEffectController();
        effectController.removeEffect(0);
    }

    public void removeItems(Player player) {
        Storage storage = player.getInventory();
        storage.decreaseByItemId(164000289, storage.getItemCountByItemId(164000289));
        storage.decreaseByItemId(164000290, storage.getItemCountByItemId(164000290));
    }
	
	private void stopInstanceTask() {
		if (instanceTimer != null) {
			instanceTimer.cancel(true);
		}
	}

    /**
     * *******************************
     * Shield Control Room Teleporter *
     * ********************************
     */
    private void spawnShieldControlRoomTeleporter() {
		sendMsg(1402202);
		GENTask.cancel(true);
		CNT1Task.cancel(true);
		CNT2Task.cancel(true);
		CNT3Task.cancel(true);
		CNT4Task.cancel(true);
		CNT5Task.cancel(true);
		CNT6Task.cancel(true);
		CNT7Task.cancel(true);
		SP1Task.cancel(true);
		SP2Task.cancel(true);
		SP3Task.cancel(true);
		SP4Task.cancel(true);
		CHKTask.cancel(true);
		isEnd = true;
        deleteNpc(702010);
        deleteNpc(702011);
        deleteNpc(702012);
        deleteNpc(702013);
		spawn(730886, 255.47392f, 293.56177f, 321.18497f, (byte) 89);
        spawn(730886, 255.55742f, 216.03549f, 321.21344f, (byte) 30);
        spawn(730886, 294.20718f, 254.60352f, 295.7729f, (byte) 60);
        spawn(730886, 216.97739f, 254.4616f, 295.77353f, (byte) 0);
    }

    protected void sp(final int npcId, final float x, final float y, final float z, final byte h, final int time, final String walkerId) {
        ThreadPoolManager.getInstance().schedule(new Runnable() {
            @Override
            public void run() {
                if (!isInstanceDestroyed) {
                    Npc npc = (Npc) spawn(npcId, x, y, z, h);
                    npc.getSpawn().setWalkerId(walkerId);
                    WalkManager.startWalking((NpcAI2) npc.getAi2());
                }
            }
        }, time);
    }

    protected void openFirstDoors() {
        openDoor(129);
    }

    protected void openDoor(int doorId) {
        StaticDoor door = doors.get(doorId);
        if (door != null) {
            door.setOpen(true);
        }
    }

    //private void sendMsg(final String str) {
    //    instance.doOnAllPlayers(new Visitor<Player>() {
    //        @Override
    //        public void visit(Player player) {
    //            PacketSendUtility.sendMessage(player, str);
    //        }
    //    });
    //}

    private void sendMovie(Player player, int movie) {
        if (!movies.contains(movie)) {
            movies.add(movie);
            PacketSendUtility.sendPacket(player, new SM_PLAY_MOVIE(0, movie));
        }
    }

    @Override
    public void onPlayerLogOut(Player player) {
        removeItems(player);
        removeEffects(player);
		TeleportService2.teleportTo(player, 600060000, 1050, 1842, 366);
    }

    @Override
    public void onLeaveInstance(Player player) {
        removeItems(player);
        removeEffects(player);
		stopInstanceTask();
		PacketSendUtility.sendPacket(player, new SM_QUEST_ACTION(0, 0)); //cancel timer
	}

    @Override
    public void onInstanceDestroy() {
        isInstanceDestroyed = true;
        doors.clear();
        movies.clear();
		stopInstanceTask();
    }

    public void onExitInstance(Player player) {
        TeleportService2.moveToInstanceExit(player, mapId, player.getRace());
    }

    private void deleteNpc(int npcId) {
        if (getNpc(npcId) != null) {
            getNpc(npcId).getController().onDelete();
        }
    }

    protected void despawnNpc(Npc npc) {
        if (npc != null) {
            npc.getController().onDelete();
        }
    }

    protected void despawnNpcs(List<Npc> npcs) {
        for (Npc npc : npcs) {
            npc.getController().onDelete();
        }
    }

    protected Npc getNpc(int npcId) {
        if (!isInstanceDestroyed) {
            return instance.getNpc(npcId);
        }
        return null;
    }

    protected List<Npc> getNpcs(int npcId) {
        if (!isInstanceDestroyed) {
            return instance.getNpcs(npcId);
        }
        return null;
    }

    @Override
    public boolean onReviveEvent(Player player) {
        PacketSendUtility.sendPacket(player, SM_SYSTEM_MESSAGE.STR_REBIRTH_MASSAGE_ME);
        PlayerReviveService.revive(player, 100, 100, false, 0);
        player.getGameStats().updateStatsAndSpeedVisually();
        return TeleportService2.teleportTo(player, mapId, instanceId, 321.6408f, 323.9414f, 405.50763f, (byte) 75);
    }

    @Override
    public boolean onDie(final Player player, Creature lastAttacker) {
        PacketSendUtility.broadcastPacket(player, new SM_EMOTION(player, EmotionType.DIE, 0, player.equals(lastAttacker) ? 0 : lastAttacker.getObjectId()), true);
        PacketSendUtility.sendPacket(player, new SM_DIE(player.haveSelfRezEffect(), player.haveSelfRezItem(), 0, 8));
        return true;
    }
}
>>>>>>> .r274
