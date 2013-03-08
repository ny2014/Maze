// MazeSolverListener.java
//
// ICS 23 / CSE 23 Summer 2012
// Project #1: Dark at the End of the Tunnel


// The MazeSolverListener defines a set of notification methods that
// are to be called while a maze is being solved.  As your solver
// searches for a solution, you'll call these methods as you make
// changes to it, which will cause the animation to be updated.

public interface MazeSolverListener
{
	// startingMazeSolution() should be called when the maze solving
	// process has just begun, after the MazeSolution has been created.
	// The newly-created MazeSolution should be passed as a parameter.
	public void startingMazeSolution(MazeSolution solution);

	// solutionChanged() should be called every time the solution is
	// changed while a solution is being sought.  The current MazeSolution
	// object should be passed as a parameter.
	public void solutionChanged(MazeSolution solution);
}
