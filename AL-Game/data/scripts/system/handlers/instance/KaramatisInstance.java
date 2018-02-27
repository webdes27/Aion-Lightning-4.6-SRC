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

import com.aionemu.gameserver.dataholders.DataManager;
import com.aionemu.gameserver.instance.handlers.GeneralInstanceHandler;
import com.aionemu.gameserver.instance.handlers.InstanceID;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.skillengine.model.Effect;
import com.aionemu.gameserver.skillengine.model.SkillTemplate;
import com.aionemu.gameserver.world.zone.ZoneInstance;
import com.aionemu.gameserver.world.zone.ZoneName;

/**
 * @author Eloann
 */
@InstanceID(310010000)
public class KaramatisInstance extends GeneralInstanceHandler {

    @Override
    public void onEnterZone(Player player, ZoneInstance zone) {
        if (zone.getAreaTemplate().getZoneName() == ZoneName.get("AFIRA_OBELISK_310010000")) {
            belpartanBlessing();
        }
    }

<<<<<<< .mine
    private void belpartanBlessing() {
        for (Player p : instance.getPlayersInside()) {
            SkillTemplate st = DataManager.SKILL_DATA.getSkillTemplate(1910); //Belpartan's Blessing.
            Effect e = new Effect(p, p, st, 1, st.getEffectsDuration(9));
            e.initialize();
            e.applyEffect();
        }
    }
=======
	private void belpartanBlessing() {
		for (Player p : instance.getPlayersInside()) {
			SkillTemplate st = DataManager.SKILL_DATA.getSkillTemplate(1910); // Belpartan's Blessing.
			Effect e = new Effect(p, p, st, 1, st.getEffectsDuration(9));
			e.initialize();
			e.applyEffect();
		}
	}
>>>>>>> .r274
<<<<<<< .mine

    @Override
    public void onPlayerLogOut(Player player) {
        TeleportService2.moveToInstanceExit(player, mapId, player.getRace());
    }
=======
>>>>>>> .r274
}
