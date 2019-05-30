/*Claudia Cota ID:60341850

CrapsMetricsMonitor stores all the statistics information as the game is being played. It has all the methods needed to update,
get, increment, or reset the statistic objects. It also has a public method that prints the statistic information in a readable
format.*/

public class CrapsMetricsMonitor{
	
	private int numOfGamesPlayed;
	private int numOfGamesWon;
	private int numOfGamesLost;
	private int maxNumOfRolls;
	private int naturalRollCount;
	private int crapsRollCount;
	private int maxWinStreak;
	private int maxLoseStreak;
	private double maxBalance;
	private int gameNumOfMaxBalance;
	
	public int getNumOfGamesPlayed(){
		return numOfGamesPlayed;
	}
	
	public int getNumOfGamesWon(){
		return numOfGamesWon;
	}
	
	public int getNumOfGamesLost(){
		return numOfGamesLost;
	}
	
	public int getMaxNumOfRolls(){
		return maxNumOfRolls;
	}
	
	public int getNaturalRollCount(){
		return naturalRollCount;
	}
	
	public int getCrapsRollCount(){
		return crapsRollCount;
	}
	
	public int getMaxWinStreak(){
		return maxWinStreak;
	}
	
	public int getMaxLoseStreak(){
		return maxLoseStreak;
	}
	
	public double getMaxBalance(){
		return maxBalance;
	}
	
	public int getGameNumOfMaxBalance(){
		return gameNumOfMaxBalance;
	}
	
	public void incrNumOfGamesPlayed(){
		this.numOfGamesPlayed++;
	}
	
	public void incrNumOfGamesWon(){
		this.numOfGamesWon++;
	}
	
	public void incrNumOfGamesLost(){
		this.numOfGamesLost++;
	}
	
	public void setMaxNumOfRolls(int num){
		this.maxNumOfRolls = num;
	}
	
	public void incrNaturalRollCount(){
		this.naturalRollCount++;
	}
	
	public void incrCrapsRollCount(){
		this.crapsRollCount++;
	}
	
	public void setMaxWinStreak(int num){
		this.maxWinStreak = num;
	}
	
	public void setMaxLoseStreak(int num){
		this.maxLoseStreak = num;
	}
	
	public void setMaxBalance(double num){
		this.maxBalance = num;
	}
	
	public void setGameNumOfMaxBalance(int num){
		this.gameNumOfMaxBalance = num;
	}
	
	public void printStatistics(){
		System.out.print("*****************************\n");
		System.out.print("*** SIMULATION STATISTICS ***\n");
		System.out.print("*****************************\n");
		System.out.print("Games played: "+ numOfGamesPlayed + "\n");
		System.out.print("Games won: " + numOfGamesWon+ "\n");
		System.out.print("Games lost: " + numOfGamesLost+ "\n");
		System.out.print("Maximum Rolls in a single game: " + maxNumOfRolls+ "\n");
		System.out.print("Natural Count: " + naturalRollCount+ "\n");
		System.out.print("Craps Count: " + crapsRollCount+ "\n");
		System.out.print("Maximum Winning Streak: " + maxWinStreak+ "\n");
		System.out.print("Maximum Loosing Streak: " + maxLoseStreak+ "\n");
		System.out.print("Maximum balance: $" + maxBalance + " during game " + gameNumOfMaxBalance+ "\n");
	}
	
	public void reset(){
		this.numOfGamesPlayed = 0;
		this.numOfGamesWon = 0;
		this.numOfGamesLost = 0;
		this.maxNumOfRolls = 0;
		this.naturalRollCount = 0;
		this.crapsRollCount = 0;
		this.maxWinStreak = 0;
		this.maxLoseStreak = 0;
		this.maxBalance = 0;
		this.gameNumOfMaxBalance = 0;
	}

}
