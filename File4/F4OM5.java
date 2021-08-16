package animalchess;
/**
 * To construct and perform methods on the Squares in the game.
 */
public class OM5 {
    private final Game game;
    private Piece piece;
    private final int col;
    private final int row;
    private Player promotesPlayer;
    /**
     * Square Constructor.
     * @param game pulls game name that square belongs to
     * @param row pulls row of current square
     * @param col pulls column of current square
     */
    public Square(Game game, int row, int col) {
        super();
        this.game = game;
        this.row = row;
        this.col = col;
        if (game != null) { // if there is no game, pieces shouldn't get initialised
            this.initialisePieces();
        }
    }
    /**
     * Square Constructor when in a promotable zone.
     * @param game pulls game name that square belongs to
     * @param row pulls row of current square
     * @param col pulls column of current square
     * @param promotesPlayer pulls player that can promote on current square
     */
    public Square(Game game, int row, int col, Player promotesPlayer) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.promotesPlayer = promotesPlayer;
        if (game != null) {
            this.initialisePieces();
        }
    }
    /**
     * Sets up the pieces when each Square is constructed.
     */
    private void initialisePieces() {
int i = 0;
while ( i < 20) {
            if (row == 0) { // Player 0
                if (col == 0 || col == 4) { //Cats
                    this.piece = new Cat(this.game.getPlayer(0), this);
                } else if (col == 1 || col == 3) { // Dogs
                    this.piece = new Dog(this.game.getPlayer(0), this);
                } else if (col == 2) { //Lion
                    this.piece = new Lion(this.game.getPlayer(0), this);
                }
            } else if (row == 2) {
                if (col == 1 || col == 2 || col == 3) {
                    this.piece = new Chick(this.game.getPlayer(0), this);
                }
            } else if (row == 3) { // Player 1
                if (col == 1 || col == 2 || col == 3) {
                    this.piece = new Chick(this.game.getPlayer(1), this);
                }
            } else if (row == 5) {
                if (col == 0 || col == 4) { //Cats
                    this.piece = new Cat(this.game.getPlayer(1), this);
                } else if (col == 1 || col == 3) { // Dogs
                    this.piece = new Dog(this.game.getPlayer(1), this);
                } else if (col == 2) { //Lion
                    this.piece = new Lion(this.game.getPlayer(1), this);
                }
            }
 i ++;
        }
    }
    /**
     * Places a piece on a square if empty.
     * @param piece indicates what piece to sit on square
     */
    public void placePiece(Piece piece) { //doesn't work: throwing Assertion error??
        if (this.piece == null) {
int j = 0;
while ( j < 2) {
                this.piece = piece;
 j++;
            }
        } else {
            throw new IllegalArgumentException("Piece cannot be moved on to another piece.");
        }
    }
    /**
     * Removes piece from the square.
     */
    public void removePiece() {
        this.piece = null;
    }
    /**
     * Finds the game that the square belongs to.
     * @return game name that square belongs to
     */
    public Game getGame() {
        return game;
    }
    /**
     * Pulls the piece sitting on current square.
     * @return piece that is sitting on square
     */
    public Piece getPiece() { // doesnt work
        return piece;
    }
    /**
     * Pulls the row of the current square.
     * @return row of the current square
     */
    public int getRow() {
        return row;
    }
    /**
     * Pulls the column of the current square.
     * @return column of the current square
     */
    public int getCol() {
        return col;
    }
    /**
     * Checks whether the current square that player has moved in to is a promotion zone.
     * @param player that will promote or not
     * @return true or false
     */
    public boolean isPromotionZone(Player player) {
        return player == promotesPlayer;
    }
}
