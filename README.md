# HW1-Big-2

*As directed below, you need to upload your submission files to the github repository under the exact guidelines of the TAs.*

***Any form of cheating, lying or plagiarism will not be tolerated. Students can get zero scores and/or fail
the class and/or be kicked out of school and/or receive other punishments for those kinds of misconducts.**
Discussions on course materials and homework solutions are encouraged. But you should write the final
solutions alone and understand them fully. Books, notes, and Internet resources can be consulted, but not
copied from.*

*Since everyone needs to write the final solutions alone, there is absolutely no need to lend your homework
solutions and/or source codes to your classmates at any time. In order to maximize the level of fairness
in this class, lending and borrowing homework solutions are both regarded as dishonest behaviors and will
be punished according to the honesty policy.*

*Only English is allowed for writing any part of your homework. We do not accept any other languages*


## Table Of Content

- [Overview](#overview)
- [Software Requirement Specification](#software-requirement-specification)
    - [Glossary](#glossary)
    - [Game Flow](#game-flow)
    - [Input Format](#input-format)
    - [Output Format](#output-format)
    - [Sample Input](#sample-input)
    - [Sample Output](#sample-output)
- [Writing Java Program](#writing-java-program)
- [Grading](#grading)
- [Design Tips](#design-tips)

## Overview

You are going to develop a poke card game called Big-2.

"The game is called Big Two because the highest card you can play is a 2. Nothing beat a 2"

Four players in a Big-2 game take turns to play cards. The cards are ordered by certain rules. You must 'pass' to skip
your turn if you have no cards that have a higher order than the "top-play's". The first player who empties his all
hand-cards wins, and the game immediately ends up.

You must follow the spec very carefully regarding the rules. The spec is self-contained, you don't need to take any
references on the internet. There are many Big-2 variations you may find on the internet, however, you only need to
follow this spec entirely.

Please don't seek any help from any 'Big-2 Open Sources', you may regret because typically they did it in a
noodle-oriented way.

## Software Requirement Specification

## Glossary

1. **Big-2**: The poke card game we are going to develop.
2. **Player**: The player in the game. (There must be four for a Big-2 Game.)
3. **Card**: A card consists of a *rank*, and a *suit*.
4. **Deck**: A stack of 52 cards.
5. **Deal**: The action of getting a card from the *Deck*.
6. **Suit**: There are four suits (Club♣, Diamond♦, Heart♥, Spade♠)
7. **Rank**: There are 13 ranks (A, 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K)
8. **Hand-Cards**: The cards owned by a player.
9. **Card Pattern**: A combination of cards that represents different type of card pattern.
10. **Play**: A play is a combination of cards (which must be of a legal card pattern) a player plays during his turn.
11. **Top-Play**: The highest play so far in a round. (We say c1 is higher than c2 if and only if c1's order is higher
    than c2's)
12. **Top-Player**: The player who played the *Top-Play*.
13. **Round**: Big-2 game consist of several rounds. In every round, players take turn to play cards until three-pass in
    a row occurs.

## Game Flow

1. When the program starts, first ask the four players to input their names.
2. Deal every card on the top of the Deck (there are 52 cards) to the four players one-by-one until the deck is empty.
   Each player should have 13 hand-cards.
3. The game then is started, and the *first round* begins.


* (R1) At the *first round*, the player who owns a **club 3** takes the first turn to play.

* (R2) In every round, the four players take turns and perform an action in his turn. The action can either be (1) Play
  legal cards (2) Pass. The player repeats his turn until he made a legal action.

* When you pass, it means you have no cards to beat the top-play, or you don't want to. So you decide to skip your
  turn.  **If you are the *top-player*, you can't pass. (R3)**

* (R4) The legality of a play is determined by the following rules:
    1. The play's cards must be of a legal card pattern.
    2. The play's order must be higher than the top-play's. (If the top-play is J-J, you can't play a 5-5, but you can
       play an A-A)
    3. The play must have the same card pattern's type as the top-play's.
       (If the top-play is a single card 5, you can't play a *pair* J-J or a *straight* 3-4-5-6-7)
    4. If this is the first round in the game, the first play must contain a club 3.

* (R5) After the player has played, he loses the cards he played from his hand-cards, the play is set as the current
  top-play, and the player becomes the top-player.

* (R6) Every player continues to play, until there are 3 players pass in a row. If so, the current round ends, and a 
  *new round* begins, with the top-play removed and then the
  *top-player* takes the first turn.

> For example, if you play a 2 and other three players pass in a row, then a new round begins.
> You take the first turn in the new round since you are the top-player,
> and you can play arbitrary cards as long as it's of a legal card pattern.

* (R7) Once a player empties his *hand-cards* after his play, the player immediately wins, and the game is over.

(R8) Card Pattern Types
===

* *Single*: A single card.
* *Pair*: Two cards with the same rank.
* *Straight*: Any 5 cards in a sequence (e.g., 3-4-5-6-7, 10-J-Q-K-A or K-A-2-3-4).
* *FullHouse*: A composite of a three-of-a-kind combination (triple) and a pair. (e.g., 3-3-3-2-2, A-A-A-7-7)

(R9) Ordering Rules
===

- Single Card Ordering:
    * The game is called Big Two because the highest card you can play is a 2 –– that is, the order of *Rank* in this
      games goes 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A, 2. Nothing beats a 2.
    * Furthermore, the *Suits* are ordered as: *Club*, *Diamond*, *Heart*, *Spade*. Therefore, the lowest card in the
      game is the Club 3, and the highest card is the Spade 2.

- Pair/Straight Ordering:
    - The order is determined by the highest card. For example, 3-3 (Pair) is lower than 4-4, as 3 < 4. 3-4-5-6-7 is
      lower than 2-3-4-5-6, since 7 < 2. (Use Suit as the tie-breaker)

- FullHouse Ordering:
    - The order is determined by the highest card of the triple, regardless of the pair.
    
### Input Format

 ```
 <Deck>
 <Player 1's name>
 <Player 2's name>
 <Player 3's name>
 <Player 4's name>
 <A sequence of Player's actions>
 ```

The first line specifies the cards in the Deck:
`<Deck>` = `<suit>[<rank>]  <suit>[<rank>]  <suit>[<rank>] ...`

* Suit is limited to 'C', 'D', 'H', 'S'. 'C' stands for a club, 'D' stands for diamond,
  'H' stands for heart and 'S' stands for spade.
* Rank is limited to '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A', '2'.

Notice that the leftmost card is placed at the bottom of the Deck and the rightmost card is placed at the top. We always
deal a card from the top.

After, below the first line, there will be four lines of player's names.

Finally, a sequence of player's actions: Each line is an action which is either a **selection indices (split by
spaces)** to select which cards to play from his **ordered hand-cards** or **-1** stands for 'Pass'.

### Output Format

> Every white space in our output is exactly the ' ' instead of '\t'

* Print `New Round begins.` when a new round begins.
* At every turn, first print `Next turn: <player's name>` and then print the player's **ordered**
  hand-cards in a pretty format as follows:

```
    0      1      2      3      ...
  C[3]   D[3]   H[4]   H[5]     ...
```

The hand-cards should be ordered (ascending, see [(R9) Ordering Rules](#user-content-r9-ordering-rules)).

* If the player plays legally, print `Player <player's name> plays a <card pattern> <suit>[<rank>]  
  <suit>[<rank>]  <suit>[<rank>]...`. Otherwise, print `Invalid play, please try again.`

* If the player passes legally, print `Player <player's name> pass.`. Otherwise,
  print `You can't pass in the new round.` (This is the only case you can't pass for sure)

* When the game is over, print `Game over, the winner is <winner's name>.`

### Sample Input

```
D[6] C[6] D[2] D[10] C[Q] S[K] C[3] D[5] H[8] S[6] S[10] S[5] H[6] H[A] H[5] D[A] S[7] H[J] D[J] H[9] H[3] S[J] D[3] S[8] C[9] D[K] H[K] C[7] C[K] S[4] H[Q] C[A] H[7] S[A] H[4] S[3] H[10] C[2] D[9] S[2] D[8] D[4] C[10] D[Q] C[5] D[7] C[J] S[9] S[Q] C[8] H[2] C[4]
Waterball
Chaoyu
CC-Chen
GodTien
0 1
0 1
2 3
6 7
5 6
4 5
8 9
8 9
7 8
-1
-1
-1
3 4
4 5
-1
-1
-1
0 1
2 3
-1
-1
2 3
-1
-1
-1
0
4
6
3
1
-1
-1
-1
0
```

### Sample Output

```
New Round begins.
Next turn: Chaoyu
    0      1      2      3      4      5      6      7      8      9     10     11     12  
  C[3]   D[3]   H[4]   H[5]   D[9]  C[10]  S[10]   C[J]   D[J]   H[Q]   H[K]   D[2]   H[2] 
Player Chaoyu plays a Pair C[3] D[3].
Next turn: CC-Chen
    0      1      2      3      4      5      6      7      8      9     10     11     12  
  D[4]   S[4]   C[6]   S[6]   D[7]   C[8]   H[J]   S[J]   D[K]   S[K]   H[A]   S[A]   C[2] 
Player CC-Chen plays a Pair D[4] S[4].
Next turn: GodTien
    0      1      2      3      4      5      6      7      8      9     10     11     12  
  H[3]   C[5]   D[6]   H[6]   H[7]   S[7]   D[8]   H[8]   C[9]  H[10]   C[Q]   S[Q]   C[K] 
Player GodTien plays a Pair D[6] H[6].
Next turn: Waterball
    0      1      2      3      4      5      6      7      8      9     10     11     12  
  S[3]   C[4]   D[5]   S[5]   C[7]   S[8]   H[9]   S[9]  D[10]   D[Q]   C[A]   D[A]   S[2] 
Player Waterball plays a Pair H[9] S[9].
Next turn: Chaoyu
    0      1      2      3      4      5      6      7      8      9     10  
  H[4]   H[5]   D[9]  C[10]  S[10]   C[J]   D[J]   H[Q]   H[K]   D[2]   H[2] 
Player Chaoyu plays a Pair C[J] D[J].
Next turn: CC-Chen
    0      1      2      3      4      5      6      7      8      9     10  
  C[6]   S[6]   D[7]   C[8]   H[J]   S[J]   D[K]   S[K]   H[A]   S[A]   C[2] 
Player CC-Chen plays a Pair H[J] S[J].
Next turn: GodTien
    0      1      2      3      4      5      6      7      8      9     10  
  H[3]   C[5]   H[7]   S[7]   D[8]   H[8]   C[9]  H[10]   C[Q]   S[Q]   C[K] 
Player GodTien plays a Pair C[Q] S[Q].
Next turn: Waterball
    0      1      2      3      4      5      6      7      8      9     10  
  S[3]   C[4]   D[5]   S[5]   C[7]   S[8]  D[10]   D[Q]   C[A]   D[A]   S[2] 
Player Waterball plays a Pair C[A] D[A].
Next turn: Chaoyu
    0      1      2      3      4      5      6      7      8  
  H[4]   H[5]   D[9]  C[10]  S[10]   H[Q]   H[K]   D[2]   H[2] 
Player Chaoyu plays a Pair D[2] H[2].
Next turn: CC-Chen
    0      1      2      3      4      5      6      7      8  
  C[6]   S[6]   D[7]   C[8]   D[K]   S[K]   H[A]   S[A]   C[2] 
Player CC-Chen pass.
Next turn: GodTien
    0      1      2      3      4      5      6      7      8  
  H[3]   C[5]   H[7]   S[7]   D[8]   H[8]   C[9]  H[10]   C[K] 
Player GodTien pass.
Next turn: Waterball
    0      1      2      3      4      5      6      7      8  
  S[3]   C[4]   D[5]   S[5]   C[7]   S[8]  D[10]   D[Q]   S[2] 
Player Waterball pass.
New Round begins.
Next turn: Chaoyu
    0      1      2      3      4      5      6  
  H[4]   H[5]   D[9]  C[10]  S[10]   H[Q]   H[K] 
Player Chaoyu plays a Pair C[10] S[10].
Next turn: CC-Chen
    0      1      2      3      4      5      6      7      8  
  C[6]   S[6]   D[7]   C[8]   D[K]   S[K]   H[A]   S[A]   C[2] 
Player CC-Chen plays a Pair D[K] S[K].
Next turn: GodTien
    0      1      2      3      4      5      6      7      8  
  H[3]   C[5]   H[7]   S[7]   D[8]   H[8]   C[9]  H[10]   C[K] 
Player GodTien pass.
Next turn: Waterball
    0      1      2      3      4      5      6      7      8  
  S[3]   C[4]   D[5]   S[5]   C[7]   S[8]  D[10]   D[Q]   S[2] 
Player Waterball pass.
Next turn: Chaoyu
    0      1      2      3      4  
  H[4]   H[5]   D[9]   H[Q]   H[K] 
Player Chaoyu pass.
New Round begins.
Next turn: CC-Chen
    0      1      2      3      4      5      6  
  C[6]   S[6]   D[7]   C[8]   H[A]   S[A]   C[2] 
Player CC-Chen plays a Pair C[6] S[6].
Next turn: GodTien
    0      1      2      3      4      5      6      7      8  
  H[3]   C[5]   H[7]   S[7]   D[8]   H[8]   C[9]  H[10]   C[K] 
Player GodTien plays a Pair H[7] S[7].
Next turn: Waterball
    0      1      2      3      4      5      6      7      8  
  S[3]   C[4]   D[5]   S[5]   C[7]   S[8]  D[10]   D[Q]   S[2] 
Player Waterball pass.
Next turn: Chaoyu
    0      1      2      3      4  
  H[4]   H[5]   D[9]   H[Q]   H[K] 
Player Chaoyu pass.
Next turn: CC-Chen
    0      1      2      3      4  
  D[7]   C[8]   H[A]   S[A]   C[2] 
Player CC-Chen plays a Pair H[A] S[A].
Next turn: GodTien
    0      1      2      3      4      5      6  
  H[3]   C[5]   D[8]   H[8]   C[9]  H[10]   C[K] 
Player GodTien pass.
Next turn: Waterball
    0      1      2      3      4      5      6      7      8  
  S[3]   C[4]   D[5]   S[5]   C[7]   S[8]  D[10]   D[Q]   S[2] 
Player Waterball pass.
Next turn: Chaoyu
    0      1      2      3      4  
  H[4]   H[5]   D[9]   H[Q]   H[K] 
Player Chaoyu pass.
New Round begins.
Next turn: CC-Chen
    0      1      2  
  D[7]   C[8]   C[2] 
Player CC-Chen plays a Single D[7].
Next turn: GodTien
    0      1      2      3      4      5      6  
  H[3]   C[5]   D[8]   H[8]   C[9]  H[10]   C[K] 
Player GodTien plays a Single C[9].
Next turn: Waterball
    0      1      2      3      4      5      6      7      8  
  S[3]   C[4]   D[5]   S[5]   C[7]   S[8]  D[10]   D[Q]   S[2] 
Player Waterball plays a Single D[10].
Next turn: Chaoyu
    0      1      2      3      4  
  H[4]   H[5]   D[9]   H[Q]   H[K] 
Player Chaoyu plays a Single H[Q].
Next turn: CC-Chen
    0      1  
  C[8]   C[2] 
Player CC-Chen plays a Single C[2].
Next turn: GodTien
    0      1      2      3      4      5  
  H[3]   C[5]   D[8]   H[8]  H[10]   C[K] 
Player GodTien pass.
Next turn: Waterball
    0      1      2      3      4      5      6      7  
  S[3]   C[4]   D[5]   S[5]   C[7]   S[8]   D[Q]   S[2] 
Player Waterball pass.
Next turn: Chaoyu
    0      1      2      3  
  H[4]   H[5]   D[9]   H[K] 
Player Chaoyu pass.
New Round begins.
Next turn: CC-Chen
    0  
  C[8] 
Player CC-Chen plays a Single C[8].
Game over, the winner is CC-Chen.
```

## Writing Java program

* Java Version: 11 </br>
    * You can download the JDK [here](https://adoptopenjdk.net/)
    
* Entry point of your program should be main inside the Main class. (Which is put under the `src/` directory.
* Outputting: use `System.out.print`, `System.out.println` or `System.out.printf`.
* Inputting: use `new Scanner(System.in)` to instantiate a `Scanner`, and use the scanner's methods: `next`, `nextInt`, `nextLine` 
to consume and parse the input from the standard in.

## Grading

- Grading:
    - **Program Correctness**:
        - Four test cases:
            - always-play-first-card [13%]
            - normal-no-error-play1 [16%]
            - normal-no-error-play2 [16%]
            - illegal-actions [30%]
    - **Software design** [25%]
    - **Bonus Test case**:
        - straight [8%]: Extend your big-2 game with Straight card pattern.
        - fullhouse [8%]: Extend your big-2 game with FullHouse card pattern.
    - **Bonus Design**:
        - **Open-Close principle (OCP)** [14%]: "Your software should be open for extension, but closed for modification." 
          Let's say your client asks you to extend the big-2 game with new card patterns. Can you support his requirement 
          in such a way that "you only need to write new classes, 
          without any modifications to the previously existing classes (except Main, we typically call the Main class 'the Client')"?
          Provide a design report (Design-Report.md) proving how do you achieve this.
          
          
## Design Tips

1. Keep every Java class less than 150 SLOC (source lines of code). If there's any class that has greater than 150
   SLOC, it just means the class does so many jobs. (Violate Single Responsibility Principle)
2. Model the Big-2 Game flow and every rule very carefully! You absolutely needn't waste your time on trial-and-error
   over our test cases! So draw a flow-chart may help you capture all the details.
3. Separate your "Card Pattern's evaluation algorithms" from the Game-Flow.
4. Separate your "Ordering rules" from the Game-Flow.
5. Separate your "Player's decision-making procedure" from the Game-Flow.
6. You should use "enum" type for Suit and Rank instead of any primitive types.
7. Encapsulate the Game-Flow in a Separate class, instead of your Main class.
