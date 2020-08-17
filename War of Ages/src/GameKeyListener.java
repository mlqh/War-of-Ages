/**
 * GameKeyListener.java
 * Listens to keyboard input
 * Matthew Hao
 * Jan 20, 2020
 */

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener, GameConstants, EntityConstants {
    
    private Player playerOne, playerTwo;
    private PlayPanel playPanel;
    
    GameKeyListener(Player p1, Player p2,PlayPanel pp) {
        playerOne = p1;
        playerTwo = p2;
        playPanel = pp;
    }
    
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        int cost;
        
        // Pause Game
        if(keyCode == KeyEvent.VK_SPACE){
            if(playPanel.getGamePaused())
                playPanel.setGamePaused(false);
            else
                playPanel.setGamePaused(true);
        }
        
        // Volume on/off
        if(keyCode == KeyEvent.VK_T){
            if(playPanel.getPlayingMusic()){
                playPanel.setPlayingMusic(false);
                playPanel.stopPlayingMusic();
            }
            else{
                playPanel.setPlayingMusic(true);
                playPanel.playMusic();
            }
        }
        // player one
        // creatures
        if (keyCode == KeyEvent.VK_1) {
            cost = FIRST_COST  + (playerOne.getCurrentEvolution() * FIRST_MULTIPLIER);
            if(playerOne.getGold() >= cost) {
                playerOne.queueCreature(cost, FIRST_TYPE);
            }
        } else if(keyCode == KeyEvent.VK_2) {
            cost = SECOND_COST  + (playerOne.getCurrentEvolution() * SECOND_MULTIPLIER);
            if(playerOne.getGold() >= cost) {
                playerOne.queueCreature(cost, SECOND_TYPE);
            }
        } else if(keyCode == KeyEvent.VK_3) {
            cost = THIRD_COST  + (playerOne.getCurrentEvolution() * THIRD_MULTIPLIER);
            if(playerOne.getGold() >= cost) {
                playerOne.queueCreature(cost, THIRD_TYPE);
            }
        } else if(keyCode == KeyEvent.VK_4) {
            cost = FOURTH_COST  + (playerOne.getCurrentEvolution() * FOURTH_MULTIPLIER);
            if(playerOne.getGold() >= cost) {
                playerOne.queueCreature(cost, FOURTH_TYPE);
            }  
            
        // turrets
        } else if(keyCode == KeyEvent.VK_Z) {
            Turret turret = playerOne.getTower().getTurrets().get(FIRST_TURRET);
            if(turret == null) {
                cost = BASE_GOLD_BUY  + (playerOne.getCurrentEvolution() * TURRET_MULTIPLIER);
                if(playerOne.getGold() >= cost) {
                    playerOne.buyTurret(cost, FIRST_TURRET);
                }
            } else {
                playerOne.sellTurret(turret.getGoldFromSell(), FIRST_TURRET);
            }
            
        } else if(keyCode == KeyEvent.VK_X) {
            Turret turret = playerOne.getTower().getTurrets().get(SECOND_TURRET);
            if(turret == null) {
                cost = BASE_GOLD_BUY  + (playerOne.getCurrentEvolution() * TURRET_MULTIPLIER);
                if(playerOne.getGold() >= cost) {
                    playerOne.buyTurret(cost, SECOND_TURRET);
                }
            } else {
                playerOne.sellTurret(turret.getGoldFromSell(), SECOND_TURRET);
            }
            
        } else if(keyCode == KeyEvent.VK_C) {
            Turret turret = playerOne.getTower().getTurrets().get(THIRD_TURRET);
            if(turret == null) {
                cost = BASE_GOLD_BUY  + (playerOne.getCurrentEvolution() * TURRET_MULTIPLIER);
                if(playerOne.getGold() >= cost) {
                    playerOne.buyTurret(cost, THIRD_TURRET);
                }
            } else {
                playerOne.sellTurret(turret.getGoldFromSell(), THIRD_TURRET);
            }
            
        // evolve
        } else if(keyCode == KeyEvent.VK_A) {
            if(playerOne.getGold() >= playerOne.getEvolutionCost()) {
                playerOne.evolve();
            }
            
            //------------------------------------
            // player two
        } else if (keyCode == KeyEvent.VK_7) {
            cost = FIRST_COST  + (playerTwo.getCurrentEvolution() * FIRST_MULTIPLIER);
            if(playerTwo.getGold() >= cost) {
                playerTwo.queueCreature(cost, FIRST_TYPE);
            }
        } else if(keyCode == KeyEvent.VK_8) {
            cost = SECOND_COST  + (playerTwo.getCurrentEvolution() * SECOND_MULTIPLIER);
            if(playerTwo.getGold() >= cost) {
                playerTwo.queueCreature(cost, SECOND_TYPE);
            }
        } else if(keyCode == KeyEvent.VK_9) {
            cost = THIRD_COST  + (playerTwo.getCurrentEvolution() * THIRD_MULTIPLIER);
            if(playerTwo.getGold() >= cost) {
                playerTwo.queueCreature(cost, THIRD_TYPE);
            }
        } else if(keyCode == KeyEvent.VK_0) {
            cost = FOURTH_COST  + (playerTwo.getCurrentEvolution() * FOURTH_MULTIPLIER);
            if(playerTwo.getGold() >= cost) {
                playerTwo.queueCreature(cost, FOURTH_TYPE);
            }  
            
            // turrets
        } else if(keyCode == KeyEvent.VK_B) {
            Turret turret = playerTwo.getTower().getTurrets().get(THIRD_TURRET);
            if(turret == null) {
                cost = BASE_GOLD_BUY  + (playerTwo.getCurrentEvolution() * TURRET_MULTIPLIER);
                if(playerTwo.getGold() >= cost) {
                    playerTwo.buyTurret(cost, THIRD_TURRET);
                }
            } else {
                playerTwo.sellTurret(turret.getGoldFromSell(), THIRD_TURRET);
            }
            
        } else if(keyCode == KeyEvent.VK_N) {
            Turret turret = playerTwo.getTower().getTurrets().get(SECOND_TURRET);
            if(turret == null) {
                cost = BASE_GOLD_BUY  + (playerTwo.getCurrentEvolution() * TURRET_MULTIPLIER);
                if(playerTwo.getGold() >= cost) {
                    playerTwo.buyTurret(cost, SECOND_TURRET);
                }
            } else {
                playerTwo.sellTurret(turret.getGoldFromSell(), SECOND_TURRET);
            }
            
        } else if(keyCode == KeyEvent.VK_M) {
            Turret turret = playerTwo.getTower().getTurrets().get(FIRST_TURRET);
            if(turret == null) {
                cost = BASE_GOLD_BUY  + (playerTwo.getCurrentEvolution() * TURRET_MULTIPLIER);
                if(playerTwo.getGold() >= cost) {
                    playerTwo.buyTurret(cost, FIRST_TURRET);
                }
            } else {
                playerTwo.sellTurret(turret.getGoldFromSell(), FIRST_TURRET);
            }
            
            // evolve
        } else if(keyCode == KeyEvent.VK_L) {
            if(playerTwo.getGold() >= playerTwo.getEvolutionCost()) {
                playerTwo.evolve();
            }   
        }
    }
    
    public void keyTyped(KeyEvent e) {  
    }
    
    public void keyReleased(KeyEvent e) {
    }
    
}



