import java.util.UUID;


public class GameState {
	
	private char[] board;
	private int turnCount;
	private char turn;
	public GameState()
	{
		turnCount = 0;
		turn = 'x';
		board = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
	}
	
	public boolean move(int move, char player)
	{
		boolean validMove = false;
		if(move<9 && board[move]==' ' && player==turn)
		{
			board[move]=turn;
			turnCount++;
			if(turn=='x')
				turn='o';
			else if(turn=='o')
				turn='x';
			validMove = true;
		}
		printBoard();
		return validMove;
	}
	public char winner()
	{
		boolean result = false;
		char winner = '?';
		
		//vertical
		for(int i=0;i<3;i++){
			if(board[i] != ' ' && board[i]==board[i+3] && board[i]==board[i+6]){
				result=true;
				winner = board[i];
			}
		}
		
		//horizontal
		for(int i=0;i<=6;i+=3){
			if(board[i] != ' ' && board[i]==board[i+1] && board[i]==board[i+2]){
				result=true;
				winner = board[i];
			}
		}
		
		//diagonal
		if(board[0] != ' ' && board[0]==board[4] && board[0] == board[8]){
			result = true;
			winner = board[4];
		}
		if(board[2] != ' ' && board[2]==board[4] && board[2] == board[6]){
			result = true;
			winner = board[4];
		}
		
		if(result==false && turnCount==9){
			winner = 'c';
			result = true;
		}
		
		return winner;
	}
	public void printBoard(){
		for(int i=0;i<9;i++){
			System.out.print(board[i]);
			if(i==2 || i==5 || i==8){
				System.out.println();
			}
			else{
				System.out.print(" | ");
			}
		}
	}
	
}
