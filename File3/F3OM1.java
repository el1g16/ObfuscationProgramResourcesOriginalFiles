package stacs.yahtzee;

/**
 * Yahtzee model.
 */
public class OM1 implements YahtzeeModel {
    private int var0;
    private static Player[] allPlayerNames;
    private static int var1 = 5; // Five dice in game
    private static int[] var21;
    private static Die[] diceArrayHolder;
    private static int var2 = 2; // used for re-roll method
    private static int var3 = 13;
    private static int[] var22;
    private static int var4 = 0;
    private static int[] var23 = new int[var1];
    private static boolean[] hasPlayerScoredComboThisRound;
    private static boolean[] isPlayersTurn;


    /**
     * Game set up when new model is created.
     * @param var5 in the game
     */
    public YahtzeeModelImpl(int var5) {
        this.var0 = var5;

        // when model initialised with number of players given
        // set up players and save to array to store
        allPlayerNames = new Player[var5];
        for (int var6 = 0; var6 < var5; i++) {
            Player var13 = new Player(var6);
            savePlayerToGame(var13);
        }

        // Set up dice
        var21 = new int[var1];
        diceArrayHolder = new Die[var1];

        // Set Up Scoring
        UpperSection upperSection = new UpperSection(var0);
        LowerSection lowerSection = new LowerSection(var0);
        hasPlayerScoredComboThisRound = new boolean[var0];

        // Rounds & turns:
        var22 = new int[var0];
        isPlayersTurn = new boolean[var0];

        // END OF GAME:
        if (var4 == var3) { //13
            System.out.println("End of Rounds");
            getWinningPlayer();
        }
    }

    /**
     * Return a player from player array given their player number.
     * @param var7 assigned player number
     * @return player
     */
    @Override
    public Player getSinglePlayer(int var7) {
        return allPlayerNames[var7];
    }

    /**
     * Return the number of players in the game.
     * @return the length of the array with all stored players
     */
    @Override
    public int var8() {
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
        for (int var9 = 0; var6 < diceArrayHolder.length; i++) {
            Die d = new Die();
            diceArrayHolder[var6] = d;
            var21[var6] = d.roll();
        }
    }

    /**
     * Allows only one dice to be re-rolled between 1-2 times.
     * @param var10 1 - 5 to be re-rolled.
     */
    public void reRollDiceNumber(int var10, Player player) {
        // don't allow more than 2 re-rolls per die
        if (var23[var10] < 2) {
            var21[var10] = diceArrayHolder[var10].roll();
            var23[var10] += 1;
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
    public int var11(int index) {
//        index -= 1;
        return var21[index];
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
        if (isPlayersTurn[player.getPlayerNumber()]) { // only allow to take turn if it is players turn
            if (var22[player.getPlayerNumber()] == 0) { // allow player to take their go
                // reset re-rolling counter each new turn:
                for (int var12 = 0; var12 < var2; r++) {
                    var23[var12] = 0;
                }
                // player rolls the dice
                rollDice(getDiceArrayHolder()); // play first roll
                var22[player.getPlayerNumber()] += 1;
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
        if (var4 < var3) {
            var4 += 1;

            // Take turn counter set to zero each round for all players
            // reset combo counter to zero each round
            // Reset all players players' turns to false each round
            for (int var13 = 0; var13 < var0; p++) {
                var22[var13] = 0;
                hasPlayerScoredComboThisRound[var13] = false;
                isPlayersTurn[var13] = false;
            }
            // start players 1's turn at the start of each round
            isPlayersTurn[0] = true;

        } else {
            throw new Error("No more rounds to play. End of game.");
        }
    }


    /**
     * Allows player to select which combo they wish to use
     * @param var14 integer (1-13) of the combinations to choose.
     */
    @Override
    public void playerSelectCombo(Player player, int var14) {

        if (isPlayersTurn[player.getPlayerNumber()]) {

            // Only allow players to use one combo per round
            if (hasPlayerScoredComboThisRound[player.getPlayerNumber()]) {
                throw new Error("Player has already scored a combo this round");
            } else {
                if (var14 == 1) {
                    if (!UpperSection.isAces(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 2) {
                    if (!UpperSection.isTwos(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 3) {
                    if (!UpperSection.isThrees(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 4) {
                    if (!UpperSection.isFours(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 5) {
                    if (!UpperSection.isFives(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 6) {
                    if (!UpperSection.isSixes(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 7) {
                    if (!LowerSection.isThreeOfAKind(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 8) {
                    if (!LowerSection.isFourOfAKind(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 9) {
                    if (!LowerSection.isFullHouse(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 10) {
                    if (!LowerSection.isSmallStraight(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 11) {
                    if (!LowerSection.isLargeStraight(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 12) {
                    if (!LowerSection.isYahtzee(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 13) {
                    if (!LowerSection.isChance(getDiceArrayHolder(), player)) {
                        throw new Error("You cannot choose that combination. Choose a different one");
                    } else {
                        hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                    }
                } else if (var14 == 0) {
                    //score equals zero
                    hasPlayerScoredComboThisRound[player.getPlayerNumber()] = true;
                } else {
                    throw new IllegalArgumentException("Choose a combination 1-13 or the value of zero.");
                }

            }
        } else {
            throw new Error("Cannot score a combo while not player's turn.");
        }
        if (hasPlayerScoredComboThisRound[player.getPlayerNumber()]) {
            // once combo scored:
            isPlayersTurn[player.getPlayerNumber()] = false; // end players turn
            // if player is not the last player:
            if (player.getPlayerNumber() < var0 - 1) {
                isPlayersTurn[player.getPlayerNumber() + 1] = true; // start next players turn
            }
        }
    }

    /**
     * Gets the number of turns that have taken place each round.
     * Dependent on the number of players in the game.
     * @return integer number of turns taken place per round.
     */
    public int var15(Player player) {
        return var22[player.getPlayerNumber()];
    }

    /**
     * Gets the round number of the current round.
     * @return integer of the round number
     */
    public int var16() {
        return var4;
    }

    /**
     * Method to calculate all players scores and return the player with the highest score.
     * @return Player that has won the game.
     */
    public Player getWinningPlayer() {
        if (var4 == var3) {
            int var17 = 0;
            int[] var24 = new int[var0];
            Player winner = null;

            for (int var18 = 0; var18 < var0 - 1; w++) {
                Player player = this.getSinglePlayer(var18);
                int var19 = UpperSection.calculateUpperSectionTotalScore(player);
                int var20 = LowerSection.calculateLowerSectionTotalScore(player);

                var24[var18] = var19 + var20;

                if (var24[var18] > var17) {
                    var17 = var24[var18];
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
