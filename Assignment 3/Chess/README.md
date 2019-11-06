***Assignment 3***

**Task 1**

**Task 2**

```puml
Board ->> Board: init_board()
Board ->> Board: move()
```

**Task 3**

We have chosen to implement the Observer Pattern. We tried to model our solution after the one shown in the lecture.

Our actual observer is called Scoreboard and its Interface is called Observer.

In the Scoreboard class the only method is update() which is used to update the scores.

The rest of the implementation is in the Board or rather Singleton class. There are functions to register, remove and notify observers.

The method scoreChanged() is used after every move to update/notify the scoreboard.

