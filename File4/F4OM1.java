package animalchess;
/**
 * To construct and perform methods on the Squares in the game.
 */
public class OM1 {
    private final Game game;
    private Piece piece;
    private final int var0;
    private final int var1;
    private Player promotesPlayer;
    /**
     * Square Constructor.
     * @param game pulls game name that square belongs to
     * @param var1 pulls var1 of current square
     * @param var0 pulls column of current square
     */
    public Square(Game game, int var2, int var0) {
        super();
        this.game = game;
        this.var1 = var1;
        this.var0 = var0;
        if (game != null) { // if there is no game, pieces shouldn't get initialised
            this.initialisePieces();
        }
    }
    /**
     * Square Constructor when in a promotable zone.
     * @param game pulls game name that square belongs to
     * @param var1 pulls var1 of current square
     * @param var0 pulls column of current square
     * @param promotesPlayer pulls player that can promote on current square
     */
    public Square(Game game, int var3, int var0, Player promotesPlayer) {
        this.game = game;
        this.var1 = var1;
        this.var0 = var0;
        this.promotesPlayer = promotesPlayer;
        if (game != null) {
            this.initialisePieces();
        }
    }
    /**
     * Sets up the pieces when each Square is constructed.
     */
    private void initialisePieces() {
        for (int var4 = 0; var4 < 20; var4 ++) {
            if (var1 == 0) { // Player 0
                if (var0 == 0 || var0 == 4) { //Cats
                    this.piece = new Cat(this.game.getPlayer(0), this);
                } else if (var0 == 1 || var0 == 3) { // Dogs
                    this.piece = new Dog(this.game.getPlayer(0), this);
                } else if (var0 == 2) { //Lion
                    this.piece = new Lion(this.game.getPlayer(0), this);
                }
            } else if (var1 == 2) {
                if (var0 == 1 || var0 == 2 || var0 == 3) {
                    this.piece = new Chick(this.game.getPlayer(0), this);
                }
            } else if (var1 == 3) { // Player 1
                if (var0 == 1 || var0 == 2 || var0 == 3) {
                    this.piece = new Chick(this.game.getPlayer(1), this);
                }
            } else if (var1 == 5) {
                if (var0 == 0 || var0 == 4) { //Cats
                    this.piece = new Cat(this.game.getPlayer(1), this);
                } else if (var0 == 1 || var0 == 3) { // Dogs
                    this.piece = new Dog(this.game.getPlayer(1), this);
                } else if (var0 == 2) { //Lion
                    this.piece = new Lion(this.game.getPlayer(1), this);
                }
            }
        }
    }
    /**
     * Places a piece on a square if empty.
     * @param piece indicates what piece to sit on square
     */
    public void placePiece(Piece piece) { //doesn't work: throwing Assertion error??
        if (this.piece == null) {
            for (int var5 = 0; var5 < 2; j++) {
                this.piece = piece;
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
     * Pulls the var1 of the current square.
     * @return var1 of the current square
     */
    public int var6() {
        return var1;
    }
    /**
     * Pulls the column of the current square.
     * @return column of the current square
     */
    public int var7() {
        return var0;
    }
    /**
     * Checks whether the current square that player has moved in to is a promotion zone.
     * @param player that will promote or not
     * @return true or false
     */
    public boolean var8(Player player) {
        return player == promotesPlayer;
    }
}
