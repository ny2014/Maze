// MazeSolution.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #1: Dark at the End of the Tunnel


// The MazeSolution interface defines the behavior of a maze solution.
// A maze solution is a sequence of positions (i.e. (x,y) coordinates in the
// maze grid, where (0,0) is the top left corner of the maze).  A newly-created
// maze solution will be a sequence with exactly one position in it, namely
// the start position.  Positions can be added to the sequence by "moving" the
// solution, which adds a position to the end of the solution; they can be
// removed by "backing it up," which removes the last position from the
// solution.
//
// Several of these methods can throw a MazeSolutionException.  This type of
// exception is unchecked, which is why it is not listed in a "throws" clause.
//
// You can create a MazeSolution by calling this static method:
//
//     MazeSolution MazeSolutionFactory.createMazeSolution(
//         int width, int height,
//         int startXPos, int startYPos,
//         int endXPos, int endYPos)
//
// and passing six parameters that describe the maze for which this is a
// solution: its width and height, the x- and y-coordinates of the starting
// position of the maze, and the x- and y-coordinates of the ending position
// of the maze.
//
// NOTE: You may not need to use all of the methods in this interface.

public interface MazeSolution
{
	// getMazeWidth() returns the width of the maze for which this is a
	// solution.
	public int getMazeWidth();

	// getMazeHeight() returns the height of the maze for which this is a
	// solution.
	public int getMazeHeight();

	// solutionComplete() returns true if the last position in the sequence
	// is the ending position of the maze, or false if not.
	public boolean solutionComplete();

	// getLastXPosition() returns the x-coordinate of the last position in
	// the sequence.
	public int getLastXPosition();

	// getLastYPosition() returns the y-coordinate of the last position in
	// the sequence.
	public int getLastYPosition();

	// getXPositions() returns an array of the x-coordinates of all of the
	// positions in the sequence.  The 0th cell of the array contains the
	// x-coordinate of the first position in the sequence, and so on.  The
	// length of the array will be equivalent to the number of positions in
	// the sequence.
	public int[] getXPositions();

	// getYPositions() returns an array of the y-coordinates of all of the
	// positions in the sequence.  The 0th cell of the array contains the
	// y-coordinate of the first position in the sequence, and so on.  The
	// length of the array will be equivalent to the number of positions in
	// the sequence.
	public int[] getYPositions();

	// getLength() returns the number of positions in the sequence.
	public int getLength();

	// moveNorth() adds a new position to the sequence that is one cell above
	// the last position.  Throws a MazeSolutionException if the last position
	// is in top row of the maze.
	public void moveNorth();

	// moveSouth() adds a new position to the sequence that is one cell below
	// the last position.  Throws a MazeSolutionException if the last position
	// is in the bottom row of the maze.
	public void moveSouth();

	// moveEast() adds a new position to the sequence that is one cell to the
	// right of the last position.  Throws a MazeSolutionException if the last
	// position is in the rightmost column of the maze.
	public void moveEast();

	// moveWest() adds a new position to the sequence that is one cell to the
	// left of the last position.  Throws a MazeSolutionException if the last
	// position is in the leftmost column of the maze.
	public void moveWest();

	// backUp() removes the last position from the sequence.  Throws a
	// MazeSolutionException if there is only one position in the sequence.
	public void backUp();
}
