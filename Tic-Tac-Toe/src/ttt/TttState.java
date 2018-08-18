package ttt;

import java.util.ArrayList;
import java.util.List;

public class TttState extends State {
	private String state[][] = null ;
	private String turn = "";
	public TttState(State x)
	{
		state = new String[3][3];
		for(int i=0;i<=2; i++)
		{
			for(int j=0; j<=2;j++)
			{
				this.state[i][j]=x.getState()[i][j];
			}
		}
		this.turn = x.getTurn();
	}
	public TttState() {
		state = new String[3][3];
		for(int i=0;i<=2; i++)
		{
			for(int j=0; j<=2;j++)
			{
				this.state[i][j]="";
			}
		}
		this.turn = "X";
	}
	public String toString()
	{
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<=2; i++)
		{
			for(int j=0; j<=2;j++)
			{
				if(state[i][j].equals(""))
				{
					sb.append("-");
				}
				else
				{
					sb.append(state[i][j]);
				}
				sb.append("\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	public String getWinner()
	{
		/* ROW CHECK BEGINS */
		if(state[0][0].equalsIgnoreCase("X") && state[0][1].equalsIgnoreCase("X") && state[0][2].equalsIgnoreCase("X"))
		{
			return "X";
		}
		if(state[0][0].equalsIgnoreCase("O") && state[0][1].equalsIgnoreCase("O") && state[0][2].equalsIgnoreCase("O"))
		{
			return "O";
		}
		if(state[1][0].equalsIgnoreCase("X") && state[1][1].equalsIgnoreCase("X") && state[1][2].equalsIgnoreCase("X"))
		{
			return "X";
		}
		if(state[1][0].equalsIgnoreCase("O") && state[1][1].equalsIgnoreCase("O") && state[1][2].equalsIgnoreCase("O"))
		{
			return "O";
		}
		if(state[2][0].equalsIgnoreCase("X") && state[2][1].equalsIgnoreCase("X") && state[2][2].equalsIgnoreCase("X"))
		{
			return "X";
		}
		if(state[2][0].equalsIgnoreCase("O") && state[2][1].equalsIgnoreCase("O") && state[2][2].equalsIgnoreCase("O"))
		{
			return "O";
		}
		
		/* COLUMN CHECK BEGINS */
		if(state[0][0].equalsIgnoreCase("X") && state[1][0].equalsIgnoreCase("X") && state[2][0].equalsIgnoreCase("X"))
		{
			return "X";
		}
		if(state[0][0].equalsIgnoreCase("O") && state[1][0].equalsIgnoreCase("O") && state[2][0].equalsIgnoreCase("O"))
		{
			return "O";
		}
		if(state[0][1].equalsIgnoreCase("X") && state[1][1].equalsIgnoreCase("X") && state[2][1].equalsIgnoreCase("X"))
		{
			return "X";
		}
		if(state[0][1].equalsIgnoreCase("O") && state[1][1].equalsIgnoreCase("O") && state[2][1].equalsIgnoreCase("O"))
		{
			return "O";
		}
		if(state[0][2].equalsIgnoreCase("X") && state[1][2].equalsIgnoreCase("X") && state[2][2].equalsIgnoreCase("X"))
		{
			return "X";
		}
		if(state[0][2].equalsIgnoreCase("O") && state[1][2].equalsIgnoreCase("O") && state[2][2].equalsIgnoreCase("O"))
		{
			return "O";
		}
		/* DIAGNONAL CHECKS */
		if(state[0][0].equalsIgnoreCase("X") && state[1][1].equalsIgnoreCase("X") && state[2][2].equalsIgnoreCase("X"))
		{
			return "X";
		}
		if(state[0][0].equalsIgnoreCase("O") && state[1][1].equalsIgnoreCase("O") && state[2][2].equalsIgnoreCase("O"))
		{
			return "O";
		}
		
		if(state[0][2].equalsIgnoreCase("X") && state[1][1].equalsIgnoreCase("X") && state[2][0].equalsIgnoreCase("X"))
		{
			return "X";
		}
		if(state[0][2].equalsIgnoreCase("O") && state[1][1].equalsIgnoreCase("O") && state[2][0].equalsIgnoreCase("O"))
		{
			return "O";
		}		
		int nonBlank = 0;
		for(int i=0;i<=2;i++)
		{
			for(int j=0;j<=2;j++)
			{
				if(!state[i][j].equals(""))
				{
					nonBlank++;
				}
			}
		}
		if(nonBlank==9)
		{
			return "draw";
		}
		
		return "";
	}
	public boolean isGameOver()
	{
		if(!getWinner().equals("") && !getWinner().equals("draw"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	@Override
	public List<State> getChildren() {
		List<State> children = new ArrayList<State>();
		if(turn.equals("X"))
		{
			for(int i=0;i<=2; i++)
			{
				for(int j=0; j<=2;j++)
				{
					if(state[i][j].equals(""))
					{
						State child = new TttState(this);
						child.getState()[i][j]="X";
						String newTurn = "O";
						child.setTurn(newTurn);
						children.add(child);
					}
				}
			}
		}
		else
		{
			for(int i=0;i<=2; i++)
			{
				for(int j=0; j<=2;j++)
				{
					if(state[i][j].equals(""))
					{
						State child = new TttState(this);
						child.getState()[i][j]="O";
						String newTurn = "X";
						child.setTurn(newTurn);
						children.add(child);
					}
				}
			}
		}
		return children;
	}

	public String[][] getState() {
		return state;
	}

	public void setState(String[][] state) {
		this.state = state;
	}

	public String getTurn() {
		return turn;
	}

	public void setTurn(String turn) {
		this.turn = turn;
	}

}
