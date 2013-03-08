// MazeGenerator.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #1: Dark at the End of the Tunnel


// The MazeGenerator interface defines what it means to be a maze generator.
// A maze generator creates a two-dimensional maze of a particular width
// and height.  As the generation process progresses, a MazeGeneratorListener
// object is notified, so that the changes can be animated one at a time.

public interface MazeGenerator
{
	// generateMaze() generates and returns a new Maze of the given width
	// and height.  Each time the maze is modified as it is being generated,
	// the given MazeGeneratorListener object should be notified.  This
	// allows the generation process to be animated.
	public Maze generateMaze(
		int width, int height,
		MazeGeneratorListener listener);
}
