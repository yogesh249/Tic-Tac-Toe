package ttt;

import java.util.List;
import java.util.Scanner;

public class MainApp {
	public static void main(String args[])
	{
		TttState x = new TttState();
		System.out.println("WINNER : " + x.getWinner());
		x.setTurn("X");
		Scanner sc = new Scanner(System.in);
		while(!x.isGameOver())
		{
			String xIndex = sc.nextLine();
			String yIndex = sc.nextLine();
			int xint = Integer.parseInt(xIndex);
			int yint = Integer.parseInt(yIndex);
			x.getState()[xint][yint]="X";
			x.setTurn("O");
			int minScore = 100;
			List<State> children = x.getChildren();
			TttState bestMove = new TttState(x);
			for(State child : children)
			{
				int childScore = child.minimax();
				if(childScore < minScore)
				{
					minScore = childScore;
					bestMove = (TttState) child;
					bestMove.setTurn("X");
				}
			}
			System.out.print(bestMove);
			x = bestMove;
		}
		System.out.println("GAME OVER...");

	}
	
}
