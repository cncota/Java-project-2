
/*
CrapsGame has the boolean playGame() method that contains the algorithm for a single craps game. It uses the CrapsMetricsMonitor
class to update the statistics at the end of each game. It returns true if its a win and false if its a lose.*/

import java.util.Random;

public class CrapsGame{
	private int numOfRolls = 0;
	private CrapsMetricsMonitor MetricsMonitor;
	
	public CrapsGame(CrapsMetricsMonitor monitor){
		this.MetricsMonitor = monitor;
	}
	
	public boolean playGame(){
		MetricsMonitor.incrNumOfGamesPlayed();
		boolean gameOver = false;
		Random generator = new Random();
		int roll = 0;
		roll =  (generator.nextInt(6) + 1) + (generator.nextInt(6) + 1);
		this.numOfRolls =0;
		this.numOfRolls++;
		System.out.print("Rolled a " + roll+"\n");
		if (roll == 7 || roll == 11){
			gameOver = true;
			MetricsMonitor.incrNumOfGamesWon();
			if (MetricsMonitor.getMaxNumOfRolls() < numOfRolls){
				MetricsMonitor.setMaxNumOfRolls(numOfRolls);
			}
			MetricsMonitor.incrNaturalRollCount();
			System.out.print("*****Natural! You win!*****"+"\n");
			return true;
		}
		if (roll == 2 || roll == 3 || roll ==12){
			gameOver = true;
			MetricsMonitor.incrNumOfGamesLost();
			if (MetricsMonitor.getMaxNumOfRolls() < numOfRolls){
				MetricsMonitor.setMaxNumOfRolls(numOfRolls);
			}
			MetricsMonitor.incrCrapsRollCount();
			System.out.print("*****Craps! You loose.*****"+"\n");
			return false;
		}
		
		else{
			while (gameOver == false){
				int roll2 = 0;
				roll2 = (generator.nextInt(6) + 1) + (generator.nextInt(6) + 1);
				this.numOfRolls++;
				System.out.print("Rolled a " + roll2 +"\n");
				if (roll2 ==7){
					gameOver = true;
					MetricsMonitor.incrNumOfGamesLost();
					if (MetricsMonitor.getMaxNumOfRolls() < numOfRolls){
						MetricsMonitor.setMaxNumOfRolls(numOfRolls);
					}
					System.out.print("*****Crap out! You loose.*****"+"\n");
					return false;
				}
				if (roll2 == roll){
					gameOver = true;
					MetricsMonitor.incrNumOfGamesWon();
					if (MetricsMonitor.getMaxNumOfRolls() < numOfRolls){
						MetricsMonitor.setMaxNumOfRolls(numOfRolls);
					}
					System.out.print("*****Rolled the point! You win!*****"+"\n");
					return true;
				}
			}		
		}
		
		return gameOver;
	
	}

	
}
