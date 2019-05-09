Prerequisite :

- apache Maven > 3.x and JDK - version > 1.6

Description: 
- This TennisGame project provides the implementation to decide the winner by taking only a single game in a set.

Input:
 - Game request contains List of pairs of Score and Player object. Player object has name and Number of points won 
   after forty which is used to decide winner/advantage/.

 - Score enum is used. So that, the List of Pairs of Score should contain only combinations of 0, 15, 30 and 40. 
   Illegal argument exception is thrown if score these points mentioned above.

Output:

- ScoreBoard is the output which tracks complete score of the game for given input.

How to Run the Project:

- Run the project from tennis/TennisGameTest.java.




 

