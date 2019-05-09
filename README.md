Prerequisite :

- apache Maven > 3.x and JDK - version 1.8

Description: 
- This TennisGame project provides the implementation to decide the winner by taking only a single game in a set.

Input:
 - Game request contains List of Score pair and Player object. Player object has name and Number of points won 
   after forty which is used to decide winner/advantage/deuce.

 - Score enum is used. So that, the List of Score pair should contain only combinations of 0, 15, 30 and 40. 
   Illegal argument exception is thrown if input Score is not one of these points mentioned above.

Output:

- ScoreBoard is the output which tracks complete score of the game for given input.



- Various tests are provided in tennis/TennisGameTest.java.




 

