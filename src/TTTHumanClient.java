import java.util.Scanner;


public class TTTHumanClient implements TTTClient {

	private Scanner in;
	public TTTHumanClient(){
		in = new Scanner(System.in);
	}
	@Override
	public int turn() {
		int move = 0;
		System.out.println();
		System.out.print("Enter your move: ");
		move = in.nextInt();
		while(move < 0 || move > 8){
			System.out.println();
			System.out.print("Invalid Move. Try again: ");
			move = in.nextInt();
		}
		return move;
	}

	@Override
	public void opponentTurn(int move) {
		// TODO Auto-generated method stub

	}

}
