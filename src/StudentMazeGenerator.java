import java.util.ArrayList;
import java.util.Random;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;

// StudentMazeGenerator.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #1: Dark at the End of the Tunnel


// The StudentMazeGenerator class is where you should implement your maze
// generation algorithm.  Presently, it returns a newly-created maze, in which
// every wall exists.

//
//Mark the current cell as "visited."
//While the current cell has any adjacent cells that have not yet been visited...
//	Choose one of the unvisited adjacent cells at random. Randomness is important here, or your algorithm will always generate the same maze.
//	Remove the wall between the current cell and the cell you just chose.
//	Recursively call the algorithm, with the chosen cell becoming the current cell.

public class StudentMazeGenerator implements MazeGenerator
{

	Maze tempMaze;
	boolean [][] visit;
	MazeGeneratorListener listener1;

	Random ranW = new Random();
	Random ranH = new Random();



	public Maze generateMaze(int width, int height, MazeGeneratorListener listener) //parameters = size of maze
	{
		int startW = ranW.nextInt(width);
		int startH = ranH.nextInt(height);
		this.listener1 = listener;


		tempMaze = MazeFactory.createMaze(width, height);
		visit = new boolean[height][width];
		listener1.startingMazeGeneration(tempMaze);	
		calc(0,0); //Starts the generation process at 0,0
		listener1.mazeModified(tempMaze);
		return tempMaze;
	}

	public Maze calc(int width, int height)//parameters = locations
	{


		//Marks current location as true, random starting location
		if(width < tempMaze.getWidth() && height<tempMaze.getHeight())
			visit[height][width] = true;


		boolean moveUp = false;
		boolean moveLeft = false;
		boolean moveDown = false;
		boolean moveRight = false;

		ArrayList<String> choices = new ArrayList<String>();

		
		//This if-else statement checks which direction is permitted
		if((height >= 0) && (height<tempMaze.getHeight()-1) && !(visit[height+1][width] == true) )
		{
			moveDown = true;
			choices.add("moveDown");
		}

		if((width > 0) && !(visit[height][width-1] == true))
		{ 
			moveLeft = true;
			choices.add("moveLeft");
		}

		if( (height > 0 ) && !(visit[height-1][width] == true) )
		{
			moveUp = true;
			choices.add("moveUp");
		}

		if( (width < tempMaze.getWidth()-1) && !(visit[height][width+1] == true))
		{
			moveRight = true;
			choices.add("moveRight");
		}

		
		Random ran = new Random();
		int num = 0;

		//Once the permitted directions are determined, the directions go into an ArrayList where they are chosen randomly
		if(choices.size()>0)
		{
			num = ran.nextInt(choices.size());
		}
		else {
			return tempMaze;
		}
			

		String choice = choices.get(num);

		//Depending on the which direction to go, the walls are removed
		if(choice.equals("moveRight"))
		{
			tempMaze.removeWallEastOf(width, height);
			if(width <= tempMaze.getWidth())
				width = width + 1;
			listener1.mazeModified(tempMaze);
			if(width < tempMaze.getWidth())
				calc(width,height);

		}

		if(choice.equals("moveLeft"))
		{
			tempMaze.removeWallWestOf(width, height);

			if(width >= 0)
				width = width - 1;

			listener1.mazeModified(tempMaze);
			if(width >= 0)
				calc(width,height);

		}
		
		if(choice.equals("moveUp"))
		{
			tempMaze.removeWallNorthOf(width, height);
			if(height<tempMaze.getHeight())
				height = height - 1;
			listener1.mazeModified(tempMaze);
			if(height < tempMaze.getHeight())
				calc(width,height);

		}
		
		if(choice.equals("moveDown"))
		{
			tempMaze.removeWallSouthOf(width, height);

			if(height >= 0)
				height = height + 1;
			listener1.mazeModified(tempMaze);
			if(height < tempMaze.getHeight()-1)
				calc(width,height);

		}
		
		//If the maze is stuck in a corner, then recursion helps take alternative routes via this method
		if(moveDown || moveUp|| moveLeft|| moveRight)
			{
			calc(width,height);
			}

		return tempMaze;
			
		

	}

}
