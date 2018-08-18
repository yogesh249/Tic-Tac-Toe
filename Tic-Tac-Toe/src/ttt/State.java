package ttt;

import java.util.List;

public abstract class State {
	public abstract List<State> getChildren();
	public abstract String[][] getState();
	public abstract String getTurn();
	public abstract void setTurn(String turn);
	public abstract String getWinner();
	public abstract boolean isGameOver();
	public int minimax()
	{
		
		if(!getWinner().equals(""))
		{
			if("X".equalsIgnoreCase(getWinner()))
			{
				return 1;
			}
			if("O".equalsIgnoreCase(getWinner()))
			{
				return -1;
			}
			if("draw".equalsIgnoreCase(getWinner()))
			{
				return 0;
			}
		}
		List<State> children = getChildren();
		if(getTurn().equals("X"))
		{
			int maxScore = -100;
			for(State child : children)
			{
				int childScore = child.minimax();
				if(childScore > maxScore)
				{
					maxScore = childScore;
				}
			}
			return maxScore;
		}
		else
		{
			int minScore = 100;
			for(State child : children)
			{
				int childScore = child.minimax();
				if(childScore < minScore)
				{
					minScore = childScore;
				}
			}
			return minScore;			
		}

	}

}
