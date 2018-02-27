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



package com.aionemu.gameserver.services.reward;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aionemu.gameserver.configs.main.MembershipConfig;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.services.abyss.AbyssPointsService;
import com.aionemu.gameserver.utils.ThreadPoolManager;
import com.aionemu.gameserver.utils.PacketSendUtility;
import com.aionemu.gameserver.world.World;
import com.aionemu.gameserver.world.knownlist.Visitor;

/**
 * @author Eloann
 */
public class APOnlineBonus {

    private static final Logger log = LoggerFactory.getLogger(APOnlineBonus.class);

    private APOnlineBonus() {
        ThreadPoolManager.getInstance().scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                World.getInstance().doOnAllPlayers(new Visitor<Player>() {
                    @Override
                    public void visit(Player object) {
                        int count = MembershipConfig.AP_ONLINE_BONUS_COUNT;
                        int time = MembershipConfig.AP_ONLINE_BONUS_TIME;
                        try {
                            AbyssPointsService.addAp(object, count);
                            AbyssPointsService.addGp(object, 50);
                            PacketSendUtility.sendMessage(object, "[Online Bonus Service]: You earn " + count + " Abyss Points and 50 Glory Points as Online Reward!!");
                        } catch (Exception ex) {
                            log.error("Exception during event rewarding of player " + object.getName(), ex);
                        }
                    }
                });
            }
        }, MembershipConfig.AP_ONLINE_BONUS_TIME * 60000, MembershipConfig.AP_ONLINE_BONUS_TIME * 60000);
    }

    public void playerLoggedIn(Player player) {
        if (MembershipConfig.AP_ONLINE_BONUS_ENABLE) {
            player.setOnlineBonusTime(System.currentTimeMillis());
        }
    }

    public void playerLoggedOut(Player player) {
    }

    public static APOnlineBonus getInstance() {
        return SingletonHolder.instance;
    }

    @SuppressWarnings("synthetic-access")
    private static class SingletonHolder {

        protected static final APOnlineBonus instance = new APOnlineBonus();
    }
}
