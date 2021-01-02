package solution2;

import java.util.ArrayList;

/*GameState object is part of the Node Object
 * It holds our grid numbers for our 8-piece puzzle
 * it holds methods relevant to the grid itself
 */

public class GameState {
    public char[][] grid; 	//grid represents the state space
    static final char[][] INITIAL_GRID = {{'8', '7', '6'}, {'5', '4', '3'}, {'2', '1', ' '}};
    static final char[][] GOAL_GRID = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', ' '}};
    final int xGrid = 3; 	//grid length
    final int yGrid = 3; 	//grid height

    public GameState(char[][] grid) {
        this.grid = grid;
    }
	
    // Duplicate/Save Current GameState
    public GameState clone() {
        char[][] clonedGrid = new char[xGrid][yGrid];
        
        for(int i = 0; i < (this.grid).length; i++) {
        	  for(int j = 0; j < (this.grid[i]).length; j++) {
        	    clonedGrid[i][j] = this.grid[i][j];
        }}
        
        return new GameState(clonedGrid);
    }

    // PrintFunctionality
    @Override
    public String toString() {
    	String output = "Grid( ";
    	
		for (int i = 0; i < this.xGrid; i++) {
			for (int j = 0; j < this.yGrid; j++) {
				output += "("+this.grid[i][j]+"), ";
			}}
		output += ")";
		return output;

    }
    
    // Check if we've reached Goal state
    public boolean isGoal() {
    	for(int i = 0; i < (this.grid).length; i++) {
      	  for(int j = 0; j < (this.grid[i]).length; j++) {
            if (this.grid[i][j] != GOAL_GRID[i][j]) return false;
        }}
        return true;
    }
    
    // Check for duplicates
    public boolean isSame(GameState other) {
    	for(int i = 0; i < (this.grid).length; i++) {
      	  for(int j = 0; j < (this.grid[i]).length; j++) {
            if (this.grid[i][j] != other.grid[i][j]) return false;
        }}
        return true;
    }
    
    // change grid values: for traversing the grid
    public void replace(int x, int y, int movex, int movey) {
		// move to a new GameState by switching variables in iterator
    	char oldx = this.grid[x][y];
    	char oldy = this.grid[movex][movey];
    	   	
    	this.grid[x][y] = oldy;
    	this.grid[movex][movey] = oldx;

	}
    
	// possibleMoves returns a list of all GameStates that can
    // be reached in a single move from the current GameState.
    // this is done by comparing width(i) and height(j) values
    // with the grids size to find out if it's a legal move 
	public ArrayList<GameState> possibleMoves() {

	    ArrayList<GameState> moves = new ArrayList<GameState>();
	  
	    for(int i = 0; i < xGrid; i++) {
	      	  for(int j = 0; j < yGrid; j++) {
	 
		        if (this.grid[i][j] == ' ') {
		        	
		        	// can we move east? --> add this state
		        	if ((i+1)<xGrid) {
		        		GameState eastState = this.clone();
		        		eastState.replace(i, j, (i+1), j);
		        		moves.add(eastState);
		        	}
		        	
		        	// can we move west? --> add this state
		        	if (i>0) {
						GameState westState = this.clone();
		        		westState.replace(i, j, (i-1), j);
		        		moves.add(westState);
		        		}
					
		        	// can we move south? --> add this state
					if ((j+1)<yGrid) {
						GameState southState = this.clone();
		        		southState.replace(i, j, i, (j+1));
		        		moves.add(southState);
					}
					
					// can we move north? --> add this state
					if (j>0) {
						GameState northState = this.clone();
		        		northState.replace(i, j, i, (j-1));
		        		moves.add(northState);
					}
	      
		        }
	      	  }
	    }
	    return moves;
	}
    
    
}
