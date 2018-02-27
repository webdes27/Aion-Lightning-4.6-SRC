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


package com.aionemu.gameserver.model;

import java.util.NoSuchElementException;

/**
 * @author synchro2
 */
public enum SellLimit {

<<<<<<< .mine
    LIMIT_1_30(1, 30, 5300047),
    LIMIT_31_40(31, 40, 7100047),
    LIMIT_41_55(41, 55, 12050047),
    LIMIT_56_60(56, 60, 14600047),
    LIMIT_61_65(61, 65, 17150047);
    private int playerMinLevel;
    private int playerMaxLevel;
    private long limit;
=======
	LIMIT_1_30(1, 30, 5300047), 
	LIMIT_31_40(31, 40, 7100047), 
	LIMIT_41_55(41, 55, 12050047), 
	LIMIT_56_60(56, 60, 14600047), 
	LIMIT_61_65(61, 65, 17150047);
	
	private int playerMinLevel;
	private int playerMaxLevel;
	private long limit;
>>>>>>> .r274

    private SellLimit(int playerMinLevel, int playerMaxLevel, long limit) {
        this.playerMinLevel = playerMinLevel;
        this.playerMaxLevel = playerMaxLevel;
        this.limit = limit;
    }

    public static long getSellLimit(int playerLevel) {
        for (SellLimit sellLimit : values()) {
            if (sellLimit.playerMinLevel <= playerLevel && sellLimit.playerMaxLevel >= playerLevel) {
                return sellLimit.limit;
            }
        }
        throw new NoSuchElementException("Sell limit for player level: " + playerLevel + " was not found");
    }
}
