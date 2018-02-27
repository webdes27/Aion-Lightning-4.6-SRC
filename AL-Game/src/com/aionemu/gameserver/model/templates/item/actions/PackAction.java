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


package com.aionemu.gameserver.model.templates.item.actions;

import com.aionemu.commons.network.util.ThreadPoolManager;
import com.aionemu.gameserver.controllers.observer.ItemUseObserver;
import com.aionemu.gameserver.model.DescriptionId;
import com.aionemu.gameserver.model.TaskId;
import com.aionemu.gameserver.model.gameobjects.Item;
import com.aionemu.gameserver.model.gameobjects.PersistentState;
import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.network.aion.serverpackets.SM_INVENTORY_UPDATE_ITEM;
import com.aionemu.gameserver.network.aion.serverpackets.SM_ITEM_USAGE_ANIMATION;
import com.aionemu.gameserver.network.aion.serverpackets.SM_SYSTEM_MESSAGE;
import com.aionemu.gameserver.utils.PacketSendUtility;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Ever'
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PackAction")
public class PackAction extends AbstractItemAction {

    @XmlAttribute
    protected UseTarget target;

    @Override
    public boolean canAct(Player player, Item parentItem, Item targetItem) {
        if (target.equals(UseTarget.WEAPON) && !targetItem.getItemTemplate().isWeapon()) {
            return false;
        }
        if (target.equals(UseTarget.ARMOR) && !targetItem.getItemTemplate().isArmor()) {
            return false;
        }
        return targetItem.getPackCount() < targetItem.getItemTemplate().getPackCount() && !targetItem.isEquipped();
    }

    public UseTarget getTarget() {
        return target;
    }

<<<<<<< .mine
    @Override
    public void act(final Player player, final Item parentItem, final Item targetItem) {
        final int parentItemId = parentItem.getItemId();
        final int parntObjectId = parentItem.getObjectId().intValue();
        final int parentNameId = parentItem.getNameId();
        PacketSendUtility.broadcastPacket(player, new SM_ITEM_USAGE_ANIMATION(player.getObjectId().intValue(), parentItem.getObjectId().intValue(), parentItemId, 5000, 0, 0), true);
=======
	@Override
	public void act(final Player player, final Item parentItem, final Item targetItem) {
		final int parentItemId = parentItem.getItemId();
		final int parentObjectId = parentItem.getObjectId().intValue();
		final int parentNameId = parentItem.getNameId();
		PacketSendUtility.broadcastPacket(player, new SM_ITEM_USAGE_ANIMATION(player.getObjectId().intValue(), parentItem.getObjectId().intValue(), parentItemId, 5000, 0, 0), true);
>>>>>>> .r274

<<<<<<< .mine
        final ItemUseObserver observer = new ItemUseObserver() {
            @Override
            public void abort() {
                player.getController().cancelTask(TaskId.ITEM_USE);
                player.removeItemCoolDown(parentItem.getItemTemplate().getUseLimits().getDelayId());
                PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402015, new Object[]{new DescriptionId(parentNameId)})); // You cannot wrap %0
                PacketSendUtility.broadcastPacket(player, new SM_ITEM_USAGE_ANIMATION(player.getObjectId().intValue(), parntObjectId, parentItemId, 0, 2, 0), true);
=======
		final ItemUseObserver observer = new ItemUseObserver() {
			@Override
			public void abort() {
				player.getController().cancelTask(TaskId.ITEM_USE);
				player.removeItemCoolDown(parentItem.getItemTemplate().getUseLimits().getDelayId());
				PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402015, new Object[] { new DescriptionId(parentNameId) })); // You cannot wrap %0
				PacketSendUtility.broadcastPacket(player, new SM_ITEM_USAGE_ANIMATION(player.getObjectId().intValue(), parentObjectId, parentItemId, 0, 2, 0), true);
>>>>>>> .r274

                player.getObserveController().removeObserver(this);
            }
        };
        player.getObserveController().attach(observer);

<<<<<<< .mine
        player.getController().addTask(TaskId.ITEM_USE, ThreadPoolManager.getInstance().schedule(new Runnable() {
            @Override
            public void run() {
                player.getObserveController().removeObserver(observer);
                PacketSendUtility.broadcastPacket(player, new SM_ITEM_USAGE_ANIMATION(player.getObjectId().intValue(), parntObjectId, parentItemId, 0, 1, 1), true);
                if (!player.getInventory().decreaseByObjectId(parntObjectId, 1)) {
                    return;
                }
                int _packCount = targetItem.getPackCount();
                if (_packCount >= targetItem.getItemTemplate().getPackCount()) {
                    return;
                }
                if (targetItem.isEquipped()) {
                    PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402020)); // You cannot wrap equipped items
                    return;
                }
                if (targetItem.isTradeable(player)) {
                    PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402022)); // A tradeable item cannot be wrapped
                    return;
                }
                if (parentItem.getItemTemplate().getItemQuality() != targetItem.getItemTemplate().getItemQuality()) {
                    PacketSendUtility.sendPacket(player, SM_SYSTEM_MESSAGE.STR_MSG_PACK_ITEM_WRONG_TARGET_ITEM_CATEGORY(parentNameId, targetItem.getNameId())); // %1 cannot be wrapped with %0
                    return;
                }
                if (targetItem.getPackCount() > targetItem.getItemTemplate().getPackCount()) {
                    PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402015, new Object[]{new DescriptionId(targetItem.getNameId())}));
                    return;
                }
                targetItem.setPacked(true);
                targetItem.setPackCount(++_packCount);
                targetItem.setPersistentState(PersistentState.UPDATE_REQUIRED);
                PacketSendUtility.sendPacket(player, new SM_INVENTORY_UPDATE_ITEM(player, targetItem));
                PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402031, new Object[]{new DescriptionId(targetItem.getNameId())})); // Wrapping of %0 is complete
            }
        }, 5000));
    }
=======
		player.getController().addTask(TaskId.ITEM_USE, ThreadPoolManager.getInstance().schedule(new Runnable() {
			@Override
			public void run() {
				player.getObserveController().removeObserver(observer);
				PacketSendUtility.broadcastPacket(player, new SM_ITEM_USAGE_ANIMATION(player.getObjectId().intValue(), parentObjectId, parentItemId, 0, 1, 1), true);
				if (!player.getInventory().decreaseByObjectId(parentObjectId, 1)) {
					return;
				}
				int _packCount = targetItem.getPackCount();
				if (_packCount >= targetItem.getItemTemplate().getPackCount()) {
					return;
				}
				if (targetItem.isEquipped()) {
					PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402020)); // You cannot wrap equipped items
					return;
				}
				if (targetItem.isTradeable(player)) {
					PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402022)); // A tradeable item cannot be wrapped
					return;
				}
				if (parentItem.getItemTemplate().getItemQuality() != targetItem.getItemTemplate().getItemQuality()) {
					PacketSendUtility.sendPacket(player, SM_SYSTEM_MESSAGE.STR_MSG_PACK_ITEM_WRONG_TARGET_ITEM_CATEGORY(parentNameId, targetItem.getNameId())); // %1 cannot be wrapped with %0
					return;
				}
				if (targetItem.getPackCount() > targetItem.getItemTemplate().getPackCount()) {
					PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402015, new Object[] { new DescriptionId(targetItem.getNameId()) }));
					return;
				}
				targetItem.setPacked(true);
				targetItem.setPackCount(++_packCount);
				targetItem.setPersistentState(PersistentState.UPDATE_REQUIRED);
				PacketSendUtility.sendPacket(player, new SM_INVENTORY_UPDATE_ITEM(player, targetItem));
				PacketSendUtility.sendPacket(player, new SM_SYSTEM_MESSAGE(1402031, new Object[] { new DescriptionId(targetItem.getNameId()) })); // Wrapping of %0 is complete
			}
		}, 5000));
	}
>>>>>>> .r274
}
