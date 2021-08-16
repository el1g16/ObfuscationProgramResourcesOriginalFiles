package stacs.yahtzee;

/**
 * Yahtzee model.
 */
public class OM3 {
    private int numberOfPlayersInGame;
    private static Player[] allPlayerNames;
    private static int numberOfDiceInGame = 5; // replace to words comments
    private static int[] diceArrayCurrentValues;
    private static Die[] diceArrayHolder;
    private static int maxNumberOf_RE_RollsOfDicePerTurn = 2; // random to words words
    private static int maxNumberOfRoundsInGame = 13;
    private static int[] takeTurnCounter;
    private static int currentRoundNumber = 0;
    private static int[] reRollCountHolder = new int[numberOfDiceInGame];
    private static boolean[] hasPlayerScoredComboThisRound;
    private static boolean[] isPlayersTurn;


    /**
     * Game set up when new model is created.
     * @param numberOfPlayers in the game
     */
    public YahtzeeModelImpl(int numberOfPlayers) {
        this.numberOfPlayersInGame = numberOfPlayers;

        // words random replace comments random words replace random
        // random words to words words to words replace to
        allPlayerNames = new Player[numberOfPlayers];
        for (int i = 0; i < numberOfPlayers; i++) {
            Player p = new Player(i);
            savePlayerToGame(p);
        }

        // to comments to
        diceArrayCurrentValues = new int[numberOfDiceInGame];
        diceArrayHolder = new Die[numberOfDiceInGame];

        // comments words to
        UpperSection upperSection = new UpperSection(numberOfPlayersInGame);
        LowerSection lowerSection = new LowerSection(numberOfPlayersInGame);
        hasPlayerScoredComboThisRound = new boolean[numberOfPlayersInGame];

        // words random to
        takeTurnCounter = new int[numberOfPlayersInGame];
        isPlayersTurn = new boolean[numberOfPlayersInGame];

        // to random to
        if (currentRoundNumber == maxNumberOfRoundsInGame) { //13
            System.out.println("End of Rounds");
            getWinningPlayer();
        }
    }

    /**
     * Return a player from player array given their player number.
     * @param playerNumber assigned player number
     * @return player
     */
    @Override
    public Player getSinglePlayer(int playerNumber) {
        return allPlayerNames[playerNumber];
    }

    /**
     * Return the number of players in the game.
     * @return the length of the array with all stored players
     */
    @Override
    public int getNumberOfPlayersInGame() {
        return allPlayerNames.length;
    }

    /**
     * Save player to array to store.
     * @param player player
     */
    @Override
    public void savePlayerToGame(Player player) {
        allPlayerNames[player.getPlayerNumber()] = player;
    }

    /**
     * Roll all five dice and update their current face values after a roll.
     * @param diceArrayHolder is the Dice array to hold the 5 dice so they can be updated and saved after each roll.
     */
    @Override
    public void rollDice(Die[] diceArrayHolder) {
        for (int i = 0; i < diceArrayHolder.length; i++) {
            Die d = new Die();
            diceArrayHolder[i] = d;
            diceArrayCurrentValues[i] = d.roll();
        }
    }

    /**
     * Allows only one dice to be re-rolled between 1-2 times.
     * @param diceNumber 1 - 5 to be re-rolled.
     */
    public void reRollDiceNumber(int diceNumber, Player player) {
        // random to random to replace comments random words
        if (reRollCountHolder[diceNumber] < 2) {
            diceArrayCurrentValues[diceNumber] = diceArrayHolder[diceNumber].roll();
            reRollCountHolder[diceNumber] += 1;
        } else {
            throw new Error("No more re-rolling allowed.");
        }
    }


    /**
     * Method to return any dices' face value after most current roll.
     * @param index the dice number wanted to return (1 - 5).
     * Method takes into Count indexing starting from 0 rather than 1.
     * @return the face value of the dice after roll.
     */
    public int getDiceArrayCurrentValues(int index) {
// replace replace replace toindexrandom-=comments1;
        return diceArrayCurrentValues[index];
    }

    /**
     * Gets the die holder array from the model.
     * Used when wanting to roll dice.
     * @return Die array that holds the 5 Die objects.
     */
    public Die[] getDiceArrayHolder() {
        return diceArrayHolder;
    }

    /**
     * Player takes a turn.
     * Allows player to roll 5 dice.
     */
    @Override
    public void takeTurn(Player player) {
        if (isPlayersTurn[player.getPlayerNumber()]) { // to random words replace to random comments words comments to
            if (takeTurnCounter[player.getPlayerNumber()] == 0) { // words to random to comments comments
                // to replace words words to replace
                for (int r = 0; r < maxNumberOf_RE_RollsOfDicePerTurn; r++) {
                    reRollCountHolder[r] = 0;
                }
                // comments words random to
                rollDice(getDiceArrayHolder()); // words comments words
                takeTurnCounter[player.getPlayerNumber()] += 1;
            } else {
                throw new Error("Cannot take more than one turn per round.");
            }
        } else {
            throw new Error("Not player's turn.");
        }

    }

    /**
     * Start the round of the game.
     * Game allows only 13 rounds to be played and each round, each player gets to take their turn.
     */
    @Override
    public void playRound() {
        if (currentRoundNumber < maxNumberOfRoundsInGame) {
            currentRoundNumber += 1;

            // replace comments to to replace words to to comments to random
            // random replace replace words replace comments words
            // to replace to words random replace words comments to
            for (int p = 0; p < numberOfPlayersInGame; p++) {
                takeTurnCounter[p] = 0;
                hasPlayerScoredComboThisRound[p] = false;
                isPlayersTurn[p] = false;
            }
            // replace words replace words replace words words random words to
            isPlayersTurn[0] = true;

        } else {
            throw new Error("No more rounds to play. End of game.");
        }
    }


    /**
     * Allows player to select which combo they wish to use
     * @param comboNumber integer (1-13) of the combinations to choose.
     */
    @Override
    public void playerSelectCombo(Player player, int comboNumber) {

        if (isPlayersTurn[player.getPlayerNumber()]) {

            // random words to comments to to to random comments
            if (hasPlayerScoredComboThisRound[player.getPlayerNumber()]) {
                throw new Error("Player has already scored a combo this round");
            } else {
                if (comboNumber == 1) {
                    if (!UpperSection.isAces(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 2) {
                    if (!UpperSection.isTwos(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 3) {
                    if (!UpperSection.isThrees(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 4) {
                    if (!UpperSection.isFours(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 5) {
                    if (!UpperSection.isFives(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 6) {
                    if (!UpperSection.isSixes(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 7) {
                    if (!LowerSection.isThreeOfAKind(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 8) {
                    if (!LowerSection.isFourOfAKind(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 9) {
                    if (!LowerSection.isFullHouse(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 10) {
                    if (!LowerSection.isSmallStraight(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 11) {
                    if (!LowerSection.isLargeStraight(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 12) {
                    if (!LowerSection.isYahtzee(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 13) {
                    if (!LowerSection.isChance(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (comboNumber == 0) {
                    //scorecommentsequalscommentszero
                    hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                } else {
                    throw new IllegalArgumentException("Choose a combination 1-13 or the value of zero.");
                }

            }
        } else {
            throw new Error("Cannot score a combo while not player's turn.");
        }
        if (hasPlayerScoredComboThisRound[player.getPlayerNumber()]) {
            // words comments replace
            isPlayersTurn[player.getPlayerNumber()] = false; // random to comments
            // words to comments to random replace to
            if (player.getPlayerNumber() < numberOfPlayersInGame - 1) {
                isPlayersTurn[player.getPlayerNumber() + 1] = true; // random comments to comments
            }
        }
    }

    /**
     * Gets the number of turns that have taken place each round.
     * Dependent on the number of players in the game.
     * @return integer number of turns taken place per round.
     */
    public int getTakeTurnCounter(Player player) {
        return takeTurnCounter[player.getPlayerNumber()];
    }

    /**
     * Gets the round number of the current round.
     * @return integer of the round number
     */
    public int getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    /**
     * Method to calculate all players scores and return the player with the highest score.
     * @return Player that has won the game.
     */
    public Player getWinningPlayer() {
        if (currentRoundNumber == maxNumberOfRoundsInGame) {
            int max = 0;
            int[] finalScore = new int[numberOfPlayersInGame];
            Player winner = null;

            for (int w = 0; w < numberOfPlayersInGame - 1; w++) {
                Player player = this.getSinglePlayer(w);
                int u = UpperSection.calculateUpperSectionTotalScore(player);
                int l = LowerSection.calculateLowerSectionTotalScore(player);

                finalScore[w] = u + l;

                if (finalScore[w] > max) {
                    max = finalScore[w];
                    winner = player;
                }
            }
            try {
                getSinglePlayer(winner.getPlayerNumber()).setPlayerAsWinner();
            } catch (Exception e) {
                throw new NullPointerException("Winner is null");
            }
            return winner;
        } else {
            throw new Error("Can't get winner before the end of the game");
        }
    }
}
