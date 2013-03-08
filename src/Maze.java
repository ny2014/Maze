// Maze.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #1: Dark at the End of the Tunnel


// The Maze interface defines the behavior of a maze object.  A maze is a
// two-dimensional grid of "positions", each with an (x,y) coordinate.
// The top left corner of the maze will be considered to be (0,0).
// Between each adjacent pair of positions, there may or may not be a wall.
//
// You can create a Maze by calling this static method:
//
//     Maze MazeFactory.createMaze(int width, int height)
//
// The starting position of the new maze will always be (0,0) and the
// ending position will always be (width-1, height-1).
//
// NOTE: You may not need to use all of the methods in this interface.

public interface Maze
{
	// getWidth() returns the width of this maze.
	public int getWidth();

	// getHeight() returns the height of this maze.
	public int getHeight();

	// getStartXPosition() returns the x-coordinate of the starting
	// position of this maze.
	public int getStartXPosition();

	// getStartYPosition() returns the y-coordinate of the starting
	// position of this maze.
	public int getStartYPosition();

	// getEndXPosition() returns the x-coordinate of the ending position
	// of this maze.
	public int getEndXPosition();

	// getEndYPosition() returns the y-coordinate of the ending position
	// of this maze.
	public int getEndYPosition();


	// All of the methods below -- canMoveXXXFrom(), addWallXXXOf(), and
	// removeWallXXXOf() -- throw an IllegalArgumentException if the
	// parameters indicate an invalid (x,y) coordinate for this maze (i.e.
	// x is negative or >= the width, y is negative or >= the height).
	// IllegalArgumentException is a standard Java class, and is an
	// unchecked exception (which is why it does not appear in a
	// "throws" clause).

	// canMoveNorthFrom() returns true if it is legal, in this maze, to
	// move north from the position (x,y).
	public boolean canMoveNorthFrom(int x, int y);

	// canMoveSouthFrom() returns true if it is legal, in this maze, to
	// move south from the position (x,y).
	public boolean canMoveSouthFrom(int x, int y);

	// canMoveEastFrom() returns true if it is legal, in this maze, to
	// move east from the position (x,y).
	public boolean canMoveEastFrom(int x, int y);

	// canMoveWestFrom() returns true if it is legal, in this maze, to
	// move west from the position (x,y).
	public boolean canMoveWestFrom(int x, int y);

	// addWallNorthOf() adds a new wall to the north of position (x,y).
	// If there is already a wall there, this method has no effect.
	public void addWallNorthOf(int x, int y);

	// addWallSouthOf() adds a new wall to the south of position (x,y).
	// If there is already a wall there, this method has no effect.
	public void addWallSouthOf(int x, int y);

	// addWallEastOf() adds a new wall to the east of position (x,y).
	// If there is already a wall there, this method has no effect.
	public void addWallEastOf(int x, int y);

	// addWallWestOf() adds a new wall to the west of position (x,y).
	// If there is already a wall there, this method has no effect.
	public void addWallWestOf(int x, int y);

	// removeWallNorthOf() removes the wall to the north of position (x,y).
	// If there is no wall there, this method has no effect.
	public void removeWallNorthOf(int x, int y);

	// removeWallSouthOf() removes the wall to the south of position (x,y).
	// If there is no wall there, this method has no effect.
	public void removeWallSouthOf(int x, int y);

	// removeWallEastOf() removes the wall to the east of position (x,y).
	// If there is no wall there, this method has no effect.
	public void removeWallEastOf(int x, int y);

	// removeWallWestOf() removes the wall to the west of position (x,y).
	// If there is no wall there, this method has no effect.
	public void removeWallWestOf(int x, int y);
}
