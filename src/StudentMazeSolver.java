import java.util.ArrayList;

// StudentMazeSolver.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #1: Dark at the End of the Tunnel


// The StudentMazeSolver class is where you will implement your maze
// solving algorithm.  Presently, it returns a newly-created solution,
// which contains only the starting position and nothing else.

public class StudentMazeSolver implements MazeSolver
{
	Maze tempMaze;
	boolean [][] visit;
	MazeSolution tempSol;
	MazeSolverListener listener1;


	public MazeSolution solveMaze(Maze maze, MazeSolverListener listener)
	{

		int xstart;
		int ystart;

		this.tempMaze = maze;
		this.listener1 = listener;
		
		//New solution is created
		tempSol = MazeSolutionFactory.createMazeSolution(
				maze.getWidth(), maze.getHeight(),
				maze.getStartXPosition(), maze.getStartYPosition(),
				maze.getEndXPosition(), maze.getEndYPosition());

		visit = new boolean[maze.getHeight()][maze.getWidth()];

		xstart = tempMaze.getStartXPosition();
		ystart = tempMaze.getStartYPosition();

		listener1.startingMazeSolution(tempSol);

		//starting locations (0,0) are sent
		calc(xstart,ystart);

		listener1.solutionChanged(tempSol);
		
		return tempSol;
	}


	public MazeSolution calc(int width, int height)
	{

		//Marks current location as true, random starting location
		if(width < tempMaze.getWidth() && height<tempMaze.getHeight())
			visit[height][width] = true;


		width = tempSol.getLastXPosition();
		height = tempSol.getLastYPosition();


		boolean moveUp = false;
		boolean moveLeft = false;
		boolean moveDown = false;
		boolean moveRight = false;

		//This if-else statement checks which direction is permitted
		if(height >= 0 && tempMaze.canMoveSouthFrom(width, height) && !(visit[height+1][width] == true))
		{
			moveDown = true;			
		}

		if(tempMaze.canMoveEastFrom(width, height) && !(visit[height][width+1] == true) && width < tempMaze.getWidth()-1)
		{ 
			moveRight = true;			
		}

		if(tempMaze.canMoveNorthFrom(width, height) && !(visit[height-1][width] == true))
		{
			moveUp = true;		
		}

		if(tempMaze.canMoveWestFrom(width, height) && !(visit[height][width-1] == true))
		{
			moveLeft = true;
		}


		//Depending on which direction is permitted, the solution finds a way
		if(moveLeft)
		{
			tempSol.moveWest();

			listener1.solutionChanged(tempSol);

			if(width>0)
				width = width - 1;

			if(tempSol.solutionComplete())
				return tempSol;
			
			calc(width,height);
		}

		//If the last coordinates in the sequence match the end coordinates then the program ends
		if(tempSol.solutionComplete())
			return tempSol;
		
		if(moveRight)
		{
			tempSol.moveEast();

			listener1.solutionChanged(tempSol);

			if(width <= tempMaze.getWidth())
				width = width + 1;

			if(tempSol.solutionComplete())
				return tempSol;
			
			if(width<tempMaze.getWidth())
				calc(width,height);

		}

		if(tempSol.solutionComplete())
			return tempSol;
		
		if(moveUp)
		{
			tempSol.moveNorth();

			if(height < tempMaze.getHeight())
				height = height -1;

			if(tempSol.solutionComplete())
				return tempSol;
			
			listener1.solutionChanged(tempSol);

			if(height < tempMaze.getHeight())
				calc(width,height);

		}
		
		if(tempSol.solutionComplete())
			return tempSol;

		if(moveDown)
		{
			tempSol.moveSouth();

			if(height >= 0)
				height = height + 1;

			if(tempSol.solutionComplete())
				return tempSol;
			
			listener1.solutionChanged(tempSol);

			if(height < tempMaze.getHeight())
				calc(width,height);
		}

		if(tempSol.solutionComplete())
			return tempSol;
		
		//If the solution gets stuck in a corner, then it backs up and recurses again
		if(tempSol.getXPositions().length > 1 && tempSol.getYPositions().length > 1)
		{
			tempSol.backUp();
			listener1.solutionChanged(tempSol);
			calc(width,height);
		}
		
		width = tempSol.getLastXPosition();
		height = tempSol.getLastYPosition();

		return tempSol;


	}




}
