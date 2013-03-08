// MazeGeneratorListener.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #1: Dark at the End of the Tunnel


// The MazeGeneratorListener defines a set of notification methods that
// are to be called while a maze is being generated.  As your generator
// creates a maze, you'll call these methods as you make changes to it,
// which will cause the animation to be updated.

public interface MazeGeneratorListener
{
	// startingMazeGeneration() should be called when the maze generation
	// process has just begun, after the maze has been created, but before
	// it has been modified.  The Maze that's being generated should be
	// passed as a parameter.
	public void startingMazeGeneration(Maze maze);

	// mazeModified() should be called every time a modification is made
	// to the maze.  The Maze that's being generated should be passed as
	// a parameter.
	public void mazeModified(Maze maze);
}
