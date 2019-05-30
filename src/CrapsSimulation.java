

CrapsSimulation is the class that stores all the information needed for the user by requesting it directly to the user. It also 
has the CrapsSimulation() method that runs the simulation of a game and the start() method that begins the game. It uses the 
CrapsGame and CrapsMetricsMonitor classes to run a complete craps game simulation and update the statistics to print them out at 
the end of each game. It also asks the user if they want to keep playing and keeps running the simulation if they do so.*/

import java.util.Scanner;

public class CrapsSimulation{

	private CrapsGame crapsGame;
	private CrapsMetricsMonitor crapsMetricsMonitor;
	private String name;
	private double balance;
	private double bet;
	private int winStreak;
	private int loseStreak;
	
	public CrapsSimulation(){
		crapsMetricsMonitor = new CrapsMetricsMonitor();
		crapsGame = new CrapsGame(crapsMetricsMonitor);
		name = "";
		balance = 0;
		bet = 0;
		winStreak = 0;
		loseStreak = 0;
	}
	
	public void start(){
		boolean play = true;
		String playS;
		do{
			Scanner in = new Scanner(System.in);
			System.out.print("Welcome to SimCraps! Enter your user name: ");
			name = in.nextLine();
			System.out.print("Hello " + name+ "!\n");
			System.out.print("Enter the amount of money you will bring to the table: ");
			balance = in.nextDouble();
			System.out.print("Enter the bet amount between $1 and $" + balance + ": ");
			this.bet = in.nextDouble();
			System.out.print("\n");
			while(bet < 1 || bet > balance){
				System.out.print("Invalid bet! Please enter a bet between $1 and $" + balance + ": "+"\n");
				this.bet = in.nextDouble();
			}
			while (balance > 0){
				if (balance > crapsMetricsMonitor.getMaxBalance()){
					crapsMetricsMonitor.setMaxBalance(balance);
					crapsMetricsMonitor.setGameNumOfMaxBalance(crapsMetricsMonitor.getNumOfGamesPlayed());
				}
				System.out.print(name+"'s balance: $" + balance+ ". Playing a new game...\n");
				if (bet < balance){
					System.out.print(name+ " bets $" + bet +"\n");
					boolean gameWinLose = crapsGame.playGame();
					if (gameWinLose == true){
						this.balance += bet;
						this.winStreak ++;
						this.loseStreak = 0;
						if(crapsMetricsMonitor.getMaxWinStreak() < winStreak){
							crapsMetricsMonitor.setMaxWinStreak(winStreak);
						}
						if (balance > crapsMetricsMonitor.getMaxBalance()){
							crapsMetricsMonitor.setMaxBalance(balance);
							crapsMetricsMonitor.setGameNumOfMaxBalance(crapsMetricsMonitor.getNumOfGamesPlayed());
						}
					}
					if (gameWinLose == false){
						this.balance -= bet;
						this.winStreak = 0;
						this.loseStreak ++;
						if(crapsMetricsMonitor.getMaxLoseStreak() < loseStreak){
							crapsMetricsMonitor.setMaxLoseStreak(loseStreak);
						}
					}
					
				}
				else{
					System.out.print(name+ " bets $" + bet+"\n");
					boolean gameWinLose = crapsGame.playGame();
					if (gameWinLose == true){
						
						this.balance += balance;
						this.winStreak ++;
						this.loseStreak = 0;
						if(crapsMetricsMonitor.getMaxWinStreak() < winStreak){
							crapsMetricsMonitor.setMaxWinStreak(winStreak);
						}
						if (balance > crapsMetricsMonitor.getMaxBalance()){
							crapsMetricsMonitor.setMaxBalance(balance);
							crapsMetricsMonitor.setGameNumOfMaxBalance(crapsMetricsMonitor.getNumOfGamesPlayed());
						}
					}
					if (gameWinLose == false){
						
						this.balance = 0;
						this.winStreak = 0;
						this.loseStreak ++;
						if(crapsMetricsMonitor.getMaxLoseStreak() < loseStreak){
							crapsMetricsMonitor.setMaxLoseStreak(loseStreak);
						}
					}
				}	
			}
			
			System.out.print(name+"'s balance: $" + balance + "\n");
			System.out.print("\n");
			crapsMetricsMonitor.printStatistics();
			System.out.print("\n");
			System.out.print("Replay? Enter 'y' or 'n': ");
			playS = in.next();
			System.out.print("\n");
			if (playS.equals("y") || playS.equals("Y")|| playS.equals("Yes")|| playS.equals("yes")){
				crapsMetricsMonitor.reset();
			}
			else{
				play = false;
			}
		}while (play == true);
	}
}
