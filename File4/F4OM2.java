    private final Game game;
            }
    /**
        if (game != null) {
                if (col == 0 || col == 4) { //Cats
                if (col == 1 || col == 2 || col == 3) {
     * @param game pulls game name that square belongs to
     * @param col pulls column of current square
     * Finds the game that the square belongs to.
        super();
        }
            for (int j = 0; j < 2; j++) {
     */
        }
    private void initialisePieces() {
    private Player promotesPlayer;
     * Square Constructor.
                } else if (col == 1 || col == 3) { // Dogs
            } else if (row == 5) {
    public Square(Game game, int row, int col, Player promotesPlayer) {
    }
    /**
     * @return column of the current square
    }
        if (this.piece == null) {
    }
        return col;
                    this.piece = new Cat(this.game.getPlayer(1), this);
            }
     * @param game pulls game name that square belongs to
     * Removes piece from the square.
        }
    public Piece getPiece() { // doesnt work
                    this.piece = new Lion(this.game.getPlayer(1), this);
    private final int col;
     * @param row pulls row of current square
     */
    }
    }
                    this.piece = new Cat(this.game.getPlayer(0), this);
public class OM2 {
            throw new IllegalArgumentException("Piece cannot be moved on to another piece.");
    /**
    /**
            if (row == 0) { // Player 0
        this.row = row;
        this.game = game;
                    this.piece = new Dog(this.game.getPlayer(1), this);
                }
    /**
                if (col == 1 || col == 2 || col == 3) {
    public int getRow() {
        return player == promotesPlayer;
                }
     */
    /**
    }
                }
    public Square(Game game, int row, int col) {
        } else {
     */
                    this.piece = new Dog(this.game.getPlayer(0), this);
                } else if (col == 1 || col == 3) { // Dogs
        this.col = col;
     * @param player that will promote or not
     * Pulls the column of the current square.
     * @return true or false
package animalchess;
     * @param piece indicates what piece to sit on square
            this.initialisePieces();
     */
    }
    }
     * Sets up the pieces when each Square is constructed.
        return piece;
                this.piece = piece;
    public int getCol() {
        }
    }
     * @param promotesPlayer pulls player that can promote on current square
            } else if (row == 3) { // Player 1
        if (game != null) { // if there is no game, pieces shouldn't get initialised
     * Places a piece on a square if empty.
            } else if (row == 2) {
 * To construct and perform methods on the Squares in the game.
        this.game = game;
                if (col == 0 || col == 4) { //Cats
    private final int row;
                    this.piece = new Chick(this.game.getPlayer(1), this);
     * @param col pulls column of current square
        for (int i = 0; i < 20; i ++) {
/**
        this.row = row;
    public Game getGame() {
     * @param row pulls row of current square
     * Square Constructor when in a promotable zone.
    private Piece piece;
     * @return game name that square belongs to
        this.col = col;
    /**
            this.initialisePieces();
                    this.piece = new Chick(this.game.getPlayer(0), this);
        return game;
     */
    public void placePiece(Piece piece) { //doesn't work: throwing Assertion error??
     */
     * @return row of the current square
        this.promotesPlayer = promotesPlayer;
     * Checks whether the current square that player has moved in to is a promotion zone.
    }
                } else if (col == 2) { //Lion
     * @return piece that is sitting on square
 */
    /**
     * Pulls the row of the current square.
    /**
                    this.piece = new Lion(this.game.getPlayer(0), this);
                }
}
    public void removePiece() {
    public boolean isPromotionZone(Player player) {
        return row;
        this.piece = null;
                } else if (col == 2) { //Lion
     */
     */
     */
    /**
     * Pulls the piece sitting on current square.
