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


package quest.reshanta;

import com.aionemu.gameserver.model.gameobjects.player.Player;
import com.aionemu.gameserver.questEngine.handlers.QuestHandler;
import com.aionemu.gameserver.model.DialogAction;
import com.aionemu.gameserver.questEngine.model.QuestEnv;
import com.aionemu.gameserver.questEngine.model.QuestState;
import com.aionemu.gameserver.questEngine.model.QuestStatus;

/**
 * @author Cheatkiller
 *
 */
public class _3711ToKillACaptain extends QuestHandler {

    private final static int questId = 3711;

    public _3711ToKillACaptain() {
        super(questId);
    }

<<<<<<< .mine
    public void register() {
        qe.registerQuestNpc(278501).addOnQuestStart(questId);
        qe.registerQuestNpc(278501).addOnTalkEvent(questId);
        qe.registerQuestNpc(279045).addOnTalkEvent(questId);
        qe.registerQuestNpc(730196).addOnTalkEvent(questId);
        qe.registerQuestNpc(214823).addOnKillEvent(questId);
    }
=======
	@Override
	public void register() {
		qe.registerQuestNpc(278501).addOnQuestStart(questId);
		qe.registerQuestNpc(278501).addOnTalkEvent(questId);
		qe.registerQuestNpc(279045).addOnTalkEvent(questId);
		qe.registerQuestNpc(730196).addOnTalkEvent(questId);
		qe.registerQuestNpc(214823).addOnKillEvent(questId);
	}
>>>>>>> .r274

    @Override
    public boolean onDialogEvent(QuestEnv env) {
        Player player = env.getPlayer();
        QuestState qs = player.getQuestStateList().getQuestState(questId);
        DialogAction dialog = env.getDialog();
        int targetId = env.getTargetId();

        if (qs == null || qs.getStatus() == QuestStatus.NONE) {
            if (targetId == 278501) {
                if (dialog == DialogAction.QUEST_SELECT) {
                    return sendQuestDialog(env, 4762);
                } else {
                    return sendQuestStartDialog(env);
                }
            }
        } else if (qs.getStatus() == QuestStatus.START) {
            if (targetId == 279045) {
                if (dialog == DialogAction.QUEST_SELECT) {
                    if (qs.getQuestVarById(0) == 0) {
                        return sendQuestDialog(env, 1011);
                    }
                } else if (dialog == DialogAction.SETPRO1) {
                    return defaultCloseDialog(env, 0, 1);
                }
            } else if (targetId == 730196) {
                if (dialog == DialogAction.QUEST_SELECT) {
                    if (qs.getQuestVarById(0) == 1) {
                        return sendQuestDialog(env, 1352);
                    }
                } else if (dialog == DialogAction.SETPRO2) {
                    return defaultCloseDialog(env, 1, 2);
                }
            }
        } else if (qs.getStatus() == QuestStatus.REWARD) {
            if (targetId == 278501) {
                if (dialog == DialogAction.USE_OBJECT) {
                    return sendQuestDialog(env, 1693);
                }
                return sendQuestEndDialog(env);
            }
        }
        return false;
    }

    @Override
    public boolean onKillEvent(QuestEnv env) {
        return defaultOnKillEvent(env, 214823, 2, true);
    }
}
