
public class TicTacToeServer {

	public static void main(String[] args) {
		TTTClient playerX = new  TTTHumanClient();
		TTTClient playerO = new TTTHumanClient();
		GameState game = new GameState();
		int NumberOfRounds = 1;//Integer.parseInt(args[0]);
		
		int nextMove;
		printMoves();
		for(int i=0;i<NumberOfRounds;i++){
			while(game.winner()=='?'){
				nextMove = playerX.turn();
				if(game.move(nextMove, 'x'))
					playerO.opponentTurn(nextMove);
				
				if(game.winner()=='?'){
					nextMove = playerO.turn();
					if(game.move(nextMove, 'o'))
						playerX.opponentTurn(nextMove);
				}
			}
			System.out.print("Winner: "+game.winner());
		}
	}
	public static void printMoves(){
		for(int i=0;i<9;i++){
			System.out.print(i);
			if(i==2 || i==5 || i==8){
				System.out.println();
			}
			else{
				System.out.print(" | ");
			}
		}
	}
}
