package Core;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entities.Player;
import Entities.Turret;
import Panels.PlayPanel;

public class GameKeyListener implements KeyListener, GameConstants, EntityConstants {

	private Player playerOne, playerTwo;
	private PlayPanel playPanel;

	public GameKeyListener(Player p1, Player p2, PlayPanel pp) {
		playerOne = p1;
		playerTwo = p2;
		playPanel = pp;
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		int cost;
		Turret turret;

		switch (keyCode) {
			// Pause Game
			case KeyEvent.VK_SPACE:
				if (playPanel.getGamePaused()) {
					playPanel.setGamePaused(false);
				} else {
					playPanel.setGamePaused(true);
				}
				break;

			// Volume on/off
			case KeyEvent.VK_G:
				if (playPanel.getPlayingMusic()) {
					playPanel.setPlayingMusic(false);
					playPanel.stopPlayingMusic();
				} else {
					playPanel.setPlayingMusic(true);
					playPanel.playMusic();
				}
				break;

			// player one
			// creatures
			case KeyEvent.VK_1:
				cost = FIRST_COST + (playerOne.getCurrentEvolution() * FIRST_MULTIPLIER);
				if (playerOne.getGold() >= cost) {
					playerOne.queueCreature(cost, FIRST_TYPE);
				}
				break;

			case KeyEvent.VK_2:
				cost = SECOND_COST + (playerOne.getCurrentEvolution() * SECOND_MULTIPLIER);
				if (playerOne.getGold() >= cost) {
					playerOne.queueCreature(cost, SECOND_TYPE);
				}
				break;

			case KeyEvent.VK_3:
				cost = THIRD_COST + (playerOne.getCurrentEvolution() * THIRD_MULTIPLIER);
				if (playerOne.getGold() >= cost) {
					playerOne.queueCreature(cost, THIRD_TYPE);
				}
				break;

			case KeyEvent.VK_4:
				cost = FOURTH_COST + (playerOne.getCurrentEvolution() * FOURTH_MULTIPLIER);
				if (playerOne.getGold() >= cost) {
					playerOne.queueCreature(cost, FOURTH_TYPE);
				}
				break;

			// turrets
			case KeyEvent.VK_Z:
				turret = playerOne.getTower().getTurrets().get(FIRST_TURRET);
				if (turret == null) {
					cost = BASE_GOLD_BUY + (playerOne.getCurrentEvolution() * TURRET_MULTIPLIER);
					if (playerOne.getGold() >= cost) {
						playerOne.buyTurret(cost, FIRST_TURRET);
					}
				} else {
					playerOne.sellTurret(turret.getGoldFromSell(), FIRST_TURRET);
				}
				break;

			case KeyEvent.VK_X:
				turret = playerOne.getTower().getTurrets().get(SECOND_TURRET);
				if (turret == null) {
					cost = BASE_GOLD_BUY + (playerOne.getCurrentEvolution() * TURRET_MULTIPLIER);
					if (playerOne.getGold() >= cost) {
						playerOne.buyTurret(cost, SECOND_TURRET);
					}
				} else {
					playerOne.sellTurret(turret.getGoldFromSell(), SECOND_TURRET);
				}
				break;

			case KeyEvent.VK_C:
				turret = playerOne.getTower().getTurrets().get(THIRD_TURRET);
				if (turret == null) {
					cost = BASE_GOLD_BUY + (playerOne.getCurrentEvolution() * TURRET_MULTIPLIER);
					if (playerOne.getGold() >= cost) {
						playerOne.buyTurret(cost, THIRD_TURRET);
					}
				} else {
					playerOne.sellTurret(turret.getGoldFromSell(), THIRD_TURRET);
				}
				break;

			// evolve
			case KeyEvent.VK_A:
				if (playerOne.getGold() >= playerOne.getEvolutionCost()) {
					playerOne.evolve();
				}
				break;

			// ------------------------------------
			// player two
			case KeyEvent.VK_7:
				cost = FIRST_COST + (playerTwo.getCurrentEvolution() * FIRST_MULTIPLIER);
				if (playerTwo.getGold() >= cost) {
					playerTwo.queueCreature(cost, FIRST_TYPE);
				}
				break;

			case KeyEvent.VK_8:
				cost = SECOND_COST + (playerTwo.getCurrentEvolution() * SECOND_MULTIPLIER);
				if (playerTwo.getGold() >= cost) {
					playerTwo.queueCreature(cost, SECOND_TYPE);
				}
				break;

			case KeyEvent.VK_9:
				cost = THIRD_COST + (playerTwo.getCurrentEvolution() * THIRD_MULTIPLIER);
				if (playerTwo.getGold() >= cost) {
					playerTwo.queueCreature(cost, THIRD_TYPE);
				}
				break;

			case KeyEvent.VK_0:
				cost = FOURTH_COST + (playerTwo.getCurrentEvolution() * FOURTH_MULTIPLIER);
				if (playerTwo.getGold() >= cost) {
					playerTwo.queueCreature(cost, FOURTH_TYPE);
				}
				break;

			// turrets
			case KeyEvent.VK_B:
				turret = playerTwo.getTower().getTurrets().get(THIRD_TURRET);
				if (turret == null) {
					cost = BASE_GOLD_BUY + (playerTwo.getCurrentEvolution() * TURRET_MULTIPLIER);
					if (playerTwo.getGold() >= cost) {
						playerTwo.buyTurret(cost, THIRD_TURRET);
					}
				} else {
					playerTwo.sellTurret(turret.getGoldFromSell(), THIRD_TURRET);
				}
				break;

			case KeyEvent.VK_N:
				turret = playerTwo.getTower().getTurrets().get(SECOND_TURRET);
				if (turret == null) {
					cost = BASE_GOLD_BUY + (playerTwo.getCurrentEvolution() * TURRET_MULTIPLIER);
					if (playerTwo.getGold() >= cost) {
						playerTwo.buyTurret(cost, SECOND_TURRET);
					}
				} else {
					playerTwo.sellTurret(turret.getGoldFromSell(), SECOND_TURRET);
				}
				break;

			case KeyEvent.VK_M:
				turret = playerTwo.getTower().getTurrets().get(FIRST_TURRET);
				if (turret == null) {
					cost = BASE_GOLD_BUY + (playerTwo.getCurrentEvolution() * TURRET_MULTIPLIER);
					if (playerTwo.getGold() >= cost) {
						playerTwo.buyTurret(cost, FIRST_TURRET);
					}
				} else {
					playerTwo.sellTurret(turret.getGoldFromSell(), FIRST_TURRET);
				}
				break;

			// evolve
			case KeyEvent.VK_L:
				if (playerTwo.getGold() >= playerTwo.getEvolutionCost()) {
					playerTwo.evolve();
				}
				break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {
	}

}
