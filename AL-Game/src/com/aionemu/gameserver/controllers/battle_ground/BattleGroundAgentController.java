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


package com.aionemu.gameserver.controllers.battle_ground;

import com.aionemu.gameserver.controllers.NpcController;
import com.aionemu.gameserver.model.gameobjects.battle_ground.BattleGroundAgent;
import com.aionemu.gameserver.model.gameobjects.Creature;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.model.gameobjects.player.RequestResponseHandler;
import com.aionemu.gameserver.network.aion.serverpackets.SM_QUESTION_WINDOW;
import com.aionemu.gameserver.services.ecfunctions.battle_ground.battleground.BattleGroundManager;
import com.aionemu.gameserver.utils.PacketSendUtility;

/**
 * @author Eloann
 */
public class BattleGroundAgentController extends NpcController {

    @Override
    public void onDialogRequest(final Player player) {
        if (player.getCommonData().getRace() != getOwner().getObjectTemplate().getRace()) {
            return;
        }
        if (player.battlegroundWaiting) {
            PacketSendUtility.sendMessage(player, "You are already registered in a battleground.");
        } else {
            String message = "Do you want to register in a battleground ?";
            RequestResponseHandler responseHandler = new RequestResponseHandler(player) {
                @Override
                public void acceptRequest(Creature requester, Player responder) {
                    BattleGroundManager.sendRegistrationForm(player);
                }

                @Override
                public void denyRequest(Creature requester, Player responder) {
                }
            };
            boolean requested = player.getResponseRequester().putRequest(902247, responseHandler);
            if (requested) {
                PacketSendUtility.sendPacket(player, new SM_QUESTION_WINDOW(902247, 1, 1, message));
            }
        }
    }

    @Override
    public BattleGroundAgent getOwner() {
        return (BattleGroundAgent) super.getOwner();
    }
}
