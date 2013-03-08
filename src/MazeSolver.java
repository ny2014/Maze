// MazeSolver.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #1: Dark at the End of the Tunnel


// The MazeSolver interface defines what it means to be a maze solver.  A
// maze solver finds a solution to a maze, where a "solution" is defined as
// a sequence of legal moves (i.e., not moving through walls) leading from
// the starting position to the ending position of the maze.  As the process
// of solving the maze progresses, a MazeSolverListener object is notified,
// so that the changes can be animated one at a time.

public interface MazeSolver
{
	// solveMaze() finds a solution to the given maze, returning it as a
	// MazeSolution object.  Each time the solution is modified as it is
	// being created, the given MazeSolverListener object should be
	// notified.  This allows the solution process to be animated.
	public MazeSolution solveMaze(Maze maze, MazeSolverListener listener);
}
