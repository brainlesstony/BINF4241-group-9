#Task 1
We have implemented setters to bypass the user input section.
Since we have limited board size, each category needs to be tested.
#Task 2

**Gameboard**

The first error we found was in the "mark" method. We found this error because we thought it was strange that multiple tests which use the "mark" method failed. So, we had a look at the method and found that the return statements were incorrect. If board[row][col] was indeed null, the function returned false which was incorrect, since it should only return false if the position was occupied/marked. We then changed the return statements and the test passed.

The second error was in the "getOpenPositions" method. Since the tests "getOpenPositions" and "getOpenPositionsAll" both failed repeatedly, it was quite evident that something was wrong with the method "getOpenPositions". After having a look at the method, we saw that the second for loop did not start at 0. That was a problem because the position (2,0) would not be looked at. After changing it from col = 1 to col = 0 all tests passed.

**Gamestate**

Here we found the first error in the "getCurrentPlayer" method. With the method implemented like this, the return value would always be Player X, even after switching players. After changing the return value to "return this.currentPlayer" the error was resolved.

We could find another error in the "completesDiagonal" function, in the last return statement it was supposed to be ...board.getMark(**2**, 2) instead of ...board.getMark(**1**,2).

The next error was in the "hasWin" method. If either of the players had completed or a row, the method would return false which was incorrect. After changing line 103 from "return false" to "return true" all tests passed.

