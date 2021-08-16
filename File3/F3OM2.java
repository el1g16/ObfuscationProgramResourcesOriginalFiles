            }
                    if (!UpperSection.isAces(getDiceArrayHolder(), player)) {
                } else if (comboNumber == 11) {
    }
    /**
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
            diceArrayCurrentValues[i] = d.roll();
    @Override
     */
            return winner;
    public int getTakeTurnCounter(Player player) {
                    } else {
        }

     */
    }
        }
                    } else {

                        throw new Error("You cannot choose that combination. Choose a different one");
        } else {
                    if (!LowerSection.isYahtzee(getDiceArrayHolder(), player)) {
        // don't allow more than 2 re-rolls per die
            diceArrayHolder[i] = d;
        this.numberOfPlayersInGame = numberOfPlayers;
            throw new Error("No more re-rolling allowed.");
     * Game set up when new model is created.
     * Player takes a turn.
            int max = 0;
    /**
        } else {
        // when model initialised with number of players given
    private static int[] takeTurnCounter;

                } else {
     * @return Die array that holds the 5 Die objects.
                    if (!UpperSection.isThrees(getDiceArrayHolder(), player)) {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
     * @param diceNumber 1 - 5 to be re-rolled.
                    if (!UpperSection.isFours(getDiceArrayHolder(), player)) {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
        for (int i = 0; i < numberOfPlayers; i++) {
 */
            throw new Error("Cannot score a combo while not player's turn.");
        hasPlayerScoredComboThisRound = new boolean[numberOfPlayersInGame];
     * @return Player that has won the game.
        }
                finalScore[w] = u + l;
        if (currentRoundNumber < maxNumberOfRoundsInGame) {
 * Yahtzee model.
    @Override
                    } else {
    @Override

                        throw new Error("You cannot choose that combination. Choose a different one");
     */
     */
    public Die[] getDiceArrayHolder() {
    /**

     * Start the round of the game.
                    }
     * Dependent on the number of players in the game.
        allPlayerNames[player.getPlayerNumber()] = player;

                        throw new Error("You cannot choose that combination. Choose a different one");
                    }
                    }
            // once combo scored:
    private static int[] diceArrayCurrentValues;
     * Method to calculate all players scores and return the player with the highest score.
                if (comboNumber == 1) {
                } else if (comboNumber == 5) {
                    }
     */
                    }
            int[] finalScore = new int[numberOfPlayersInGame];
                isPlayersTurn[p] = false;
                isPlayersTurn[player.getPlayerNumber() + 1] = true; // start next players turn
                        throw new Error("You cannot choose that combination. Choose a different one");
        }
    private static int maxNumberOfRoundsInGame = 13;
    /**
    }
    public int getNumberOfPlayersInGame() {
    @Override
                }
        isPlayersTurn = new boolean[numberOfPlayersInGame];
     * Gets the die holder array from the model.
     * @param numberOfPlayers in the game
     */
            throw new Error("No more rounds to play. End of game.");
                } else if (comboNumber == 3) {
    /**
                    }
            diceArrayCurrentValues[diceNumber] = diceArrayHolder[diceNumber].roll();
                    }
                } else if (comboNumber == 13) {
     * @param comboNumber integer (1-13) of the combinations to choose.
                    //score equals zero
     * Game allows only 13 rounds to be played and each round, each player gets to take their turn.
            System.out.println("End of Rounds");

                    if (!LowerSection.isLargeStraight(getDiceArrayHolder(), player)) {

        }
    }
                hasPlayerScoredComboThisRound[p] = false;
                } else if (comboNumber == 9) {
        if (currentRoundNumber == maxNumberOfRoundsInGame) { //13
        return allPlayerNames.length;
    }
                        throw new Error("You cannot choose that combination. Choose a different one");
                }
            currentRoundNumber += 1;
     * @return the length of the array with all stored players
}
            reRollCountHolder[diceNumber] += 1;
                if (finalScore[w] > max) {
     * @return integer of the round number

                for (int r = 0; r < maxNumberOf_RE_RollsOfDicePerTurn; r++) {
        LowerSection lowerSection = new LowerSection(numberOfPlayersInGame);
        // END OF GAME:
                throw new Error("Player has already scored a combo this round");
    public void playerSelectCombo(Player player, int comboNumber) {
    /**
                    } else {
    public int getDiceArrayCurrentValues(int index) {
                int u = UpperSection.calculateUpperSectionTotalScore(player);
                // reset re-rolling counter each new turn:
/**
                    } else {
                } else if (comboNumber == 6) {
    /**
    public YahtzeeModelImpl(int numberOfPlayers) {
                    } else {
     * Return the number of players in the game.
        } else {
    }
            // reset combo counter to zero each round
                    reRollCountHolder[r] = 0;
        if (isPlayersTurn[player.getPlayerNumber()]) { // only allow to take turn if it is players turn
            } else {
     * Allows only one dice to be re-rolled between 1-2 times.
                    } else {
                    } else {
    private static Die[] diceArrayHolder;
            if (takeTurnCounter[player.getPlayerNumber()] == 0) { // allow player to take their go
                        throw new Error("You cannot choose that combination. Choose a different one");
                        throw new Error("You cannot choose that combination. Choose a different one");
                    if (!UpperSection.isFives(getDiceArrayHolder(), player)) {

    private int numberOfPlayersInGame;
    public void takeTurn(Player player) {
public class OM2 {
            Die d = new Die();

    public void playRound() {
     * @param playerNumber assigned player number
    }
     */

                } else if (comboNumber == 0) {
                    } else {
     * @return the face value of the dice after roll.
    @Override
            } else {
    /**
        }
        // Set Up Scoring
                    } else {
    private static int numberOfDiceInGame = 5; // Five dice in game
                    max = finalScore[w];
    @Override
    public Player getSinglePlayer(int playerNumber) {
                }
     */
     * Save player to array to store.
                int l = LowerSection.calculateLowerSectionTotalScore(player);
     * Gets the number of turns that have taken place each round.
    public void rollDice(Die[] diceArrayHolder) {
        if (reRollCountHolder[diceNumber] < 2) {
            }
            }
     */
        if (isPlayersTurn[player.getPlayerNumber()]) {

     * Method takes into Count indexing starting from 0 rather than 1.
    }
     * Gets the round number of the current round.
    private static boolean[] hasPlayerScoredComboThisRound;



                        throw new Error("You cannot choose that combination. Choose a different one");
        } else {
        allPlayerNames = new Player[numberOfPlayers];
    private static Player[] allPlayerNames;
                } else if (comboNumber == 8) {
    /**
    public int getCurrentRoundNumber() {
            for (int p = 0; p < numberOfPlayersInGame; p++) {

            isPlayersTurn[player.getPlayerNumber()] = false; // end players turn
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
        } else {
    private static int maxNumberOf_RE_RollsOfDicePerTurn = 2; // used for re-roll method
                    winner = player;

    private static int currentRoundNumber = 0;
    }
                    if (!LowerSection.isThreeOfAKind(getDiceArrayHolder(), player)) {
    public void savePlayerToGame(Player player) {
            // Reset all players players' turns to false each round
                        throw new Error("You cannot choose that combination. Choose a different one");
                    }
    }
                getSinglePlayer(winner.getPlayerNumber()).setPlayerAsWinner();
     * Allows player to roll 5 dice.
        return diceArrayCurrentValues[index];
    /**
            }

                    if (!LowerSection.isFullHouse(getDiceArrayHolder(), player)) {
                    }
            } catch (Exception e) {
        return diceArrayHolder;
            // if player is not the last player:
        if (hasPlayerScoredComboThisRound[player.getPlayerNumber()]) {
                } else if (comboNumber == 4) {
                    if (!UpperSection.isSixes(getDiceArrayHolder(), player)) {
//        index -= 1;
    }
                    hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                } else if (comboNumber == 2) {


                    if (!UpperSection.isTwos(getDiceArrayHolder(), player)) {
        }
                        throw new Error("You cannot choose that combination. Choose a different one");
            isPlayersTurn[0] = true;


     * Allows player to select which combo they wish to use
     */
                throw new Error("Cannot take more than one turn per round.");
            throw new Error("Not player's turn.");
        // set up players and save to array to store
            for (int w = 0; w < numberOfPlayersInGame - 1; w++) {
        }
    /**
                    }
            }
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
     * Return a player from player array given their player number.
                        throw new Error("You cannot choose that combination. Choose a different one");
     * @param player player
                    }


        return takeTurnCounter[player.getPlayerNumber()];
        return allPlayerNames[playerNumber];
                    throw new IllegalArgumentException("Choose a combination 1-13 or the value of zero.");

    /**
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
     */
     * @param index the dice number wanted to return (1 - 5).
package stacs.yahtzee;
    public void reRollDiceNumber(int diceNumber, Player player) {
     */
    @Override
    }
        takeTurnCounter = new int[numberOfPlayersInGame];
            if (player.getPlayerNumber() < numberOfPlayersInGame - 1) {
            // start players 1's turn at the start of each round
     * Used when wanting to roll dice.
     */
            // Only allow players to use one combo per round
                takeTurnCounter[p] = 0;
                    if (!LowerSection.isChance(getDiceArrayHolder(), player)) {
     * @return player
            if (hasPlayerScoredComboThisRound[player.getPlayerNumber()]) {
            throw new Error("Can't get winner before the end of the game");
                    if (!LowerSection.isSmallStraight(getDiceArrayHolder(), player)) {

     * @param diceArrayHolder is the Dice array to hold the 5 dice so they can be updated and saved after each roll.
                Player player = this.getSinglePlayer(w);
     * @return integer number of turns taken place per round.
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;

     * Roll all five dice and update their current face values after a roll.
     */
        if (currentRoundNumber == maxNumberOfRoundsInGame) {
                } else if (comboNumber == 12) {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
        diceArrayCurrentValues = new int[numberOfDiceInGame];

    }
        }
            Player p = new Player(i);
            try {
        // Rounds & turns:
    private static int[] reRollCountHolder = new int[numberOfDiceInGame];
        UpperSection upperSection = new UpperSection(numberOfPlayersInGame);
        return currentRoundNumber;


            }
                takeTurnCounter[player.getPlayerNumber()] += 1;
                rollDice(getDiceArrayHolder()); // play first roll
                } else if (comboNumber == 10) {
                        throw new Error("You cannot choose that combination. Choose a different one");
        diceArrayHolder = new Die[numberOfDiceInGame];
    }
                    } else {
     * Method to return any dices' face value after most current roll.
                } else if (comboNumber == 7) {
            // Take turn counter set to zero each round for all players
        for (int i = 0; i < diceArrayHolder.length; i++) {
                // player rolls the dice
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
            savePlayerToGame(p);
                    }
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
            getWinningPlayer();
                throw new NullPointerException("Winner is null");
                    if (!LowerSection.isFourOfAKind(getDiceArrayHolder(), player)) {
    private static boolean[] isPlayersTurn;
        // Set up dice

    /**
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
            Player winner = null;
    public Player getWinningPlayer() {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
    /**
                        throw new Error("You cannot choose that combination. Choose a different one");
