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
package com.aionemu.gameserver.model.stats.calc.functions;

import com.aionemu.gameserver.model.gameobjects.Creature;
import com.aionemu.gameserver.model.stats.calc.Stat2;
import com.aionemu.gameserver.model.stats.container.CreatureGameStats;
import com.aionemu.gameserver.model.stats.container.StatEnum;

class MaxMpFunction extends StatFunction {

  MaxMpFunction() {
    this.stat = StatEnum.MAXMP;
  }
  
  public void apply(Stat2 stat) {
    float will = stat.getOwner().getGameStats().getWill().getCurrent();
    stat.setBase(Math.round(stat.getBase() * will / 100.0F));
  }

  public int getPriority() {
    return 30;
  }
}
