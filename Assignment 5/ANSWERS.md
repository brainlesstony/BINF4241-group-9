#Task 1 Snake&Ladders Game

Main Function is in the GameLogic.
First of all, our snake & ladders game was a bit unstructured so in order to test a few methods,
the test cases need to be in a different test class or need to be hardcoded to test.
E.g. private methods and methods from classes which access other classes in order to function.
Furthermore, we used setters in order to test methods that were not testable from outside the class. 
Our snake & ladders game has the main restriction which is the limited board size.
Since we have limited board size, each category needs to be tested.
This is the way we constructed it in the first assignment. 
First Square/Last Square/Square, Snakes and Ladders are all tested in the BoardTest (since they are crucial for tests on the board class). 

*Bugfixes*

- Fixed empty input for board size in Board Class. 
- Fixed empty input for amount of players in PlayerList Class.







#Task 2 Tic Tac Toe

**Gameboard**

The first error we found was in the "mark" method. We found this error because we thought it was strange that multiple tests which use the "mark" method failed. So, we had a look at the method and found that the return statements were incorrect. If board[row][col] was indeed null, the function returned false which was incorrect, since it should only return false if the position was occupied/marked. We then changed the return statements and the test passed.

The second error was in the "getOpenPositions" method. Since the tests "getOpenPositions" and "getOpenPositionsAll" both failed repeatedly, it was quite evident that something was wrong with the method "getOpenPositions". After having a look at the method, we saw that the second for loop did not start at 0. That was a problem because the position (2,0) would not be looked at. After changing it from col = 1 to col = 0 all tests passed.

**Gamestate**

Here we found the first error in the "getCurrentPlayer" method. With the method implemented like this, the return value would always be Player X, even after switching players. After changing the return value to "return this.currentPlayer" the error was resolved.

We could find another error in the "completesDiagonal" function, in the last return statement it was supposed to be ...board.getMark(**2**, 2) instead of ...board.getMark(**1**,2).

The next error was in the "hasWin" method. If either of the players had completed or a row, the method would return false which was incorrect. After changing line 103 from "return false" to "return true" all tests passed.

#Task 3 Uno

**1 Behavior of the System**

As the previous assignments, it is assumed that the UNO program should also be a console application. Therefore, we can specify in the following how the game should work.

At the start of the game, the console asks how many players are playing. Then, it initializes for each of the player 7 cards, a draw pile and a discard pile, where the top card is visible.
Because it is a console application, there must just one players handdeck be visible. The player then chooses a card, which will then fit on the discard pile. 
Then the next player plays his card and so on till the first player has zero cards left.

*1.a which inputs should be accepted?*  
How many players are playing is defined by input. The input should be an integer from 2 to 10 from type int. e.g.: 5. 
Another input a player can do is which card should be placed on the discard pile. 
To choose a card a player has to input a string in code format. Because there are just four colors and card numbers from 0 to 9 and some wild cards we define each card like this:
First capital letter = Color, Second letter = number of the card. eg: "G4" = green 4.
Wild cards are defined for example like that: 
"WDR" = wild draw 4 color asked = red, "WG" = Wild next color asked = green, "YDT" = yellow draw two, "RS" = red skip, "BR" = blue reverse.
Those inputs are from type String.
If one have two card left and plays the second last card, in analog, one have to say "UNO". In this case if the second last card is played one just have to add a "U" to the card codes. eg.: "B7U".
If a player did not add a "U" to his second last card. Anyone can then type: "nU" to punish the player with two extra cards.
If a player wants to skip his turn he can type "S".
So those are the only inputs the game should accept. Any others should not be accepted.


*1.b what to do with the inputs?*  
The input to specify the number of players will be first checked if it is between 2 and 10 and then passed to a method to create the amount of player objects. This is the only thing what one should do with this input.
The input for which one want to choose a card should be first checked if the cards are on the handdeck and then checked if it fits to the card on top of the discard pile. If it is a wild card it should do the action. Like giving the next player 4 cards when "WDY" is the input. It should not give it to the next after the next or the previous player.
If the input is a "nU" it should check if the previous player has one card and did not typed a "U" to his second last card.
If the input is a "S" it should do nothing the next player should play something.

*1.c what are the expected outputs?*  
The outputs should be the handdeck of the active player, the discard pile with the top card visible and for completeness the draw pile which is invisible.
For example:  
Active Player: Player 3  
Handdeck of Player 3: [B5][Y9][G3][WD][DT]  
Discard Pile|Draw Pile: [B2]|[ ] 

There can also be other outputs like instead of Player 3, one can save for each player object the name.
Also if a reverse card is played the next active player from player 3 should be player 2 not player 4 and after player 2 it should be player 1 and so on.
Also to make it more like the real UNO game, one can display all handdeck to see weather a player has one card left or to make strategic decisions.
But it shouldn`t display all handdeck visible, just the active players handdeck should be visible.















