public class Position{
    private int x;
    private int y;
    private boolean isWall;

    /**
     * Constructeur pour Position
     * 
     * @param x
     * @param y
     * @param isWall
     */
    public Position(int x, int y, boolean isWall){
        this.x = x;
        this.y = y;
        this.isWall = isWall;
    }
    
    /**
     * Constructeur pour Position
     * 
     * @param x
     * @param y
     */
    public Position(int x, int y){
        this.x = x;
        this.y = y;
        this.isWall = false;
    }

    /**
     * Retourne x
     * 
     * @return x
     */
    public int getX(){
        return this.x;
    }

    /**
     * Retourne y
     * 
     * @return y
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * Retourne une nouvelle position en fonction de la direction
     * 
     * @param direction
     * @return Position
     */
    public Position move(Direction direction) {
        int temp_x = x;
        int temp_y = y;
        switch (direction) {
            case RIGHT -> temp_x++;
            case LEFT -> temp_x--;
            case UP -> temp_y--;
            case DOWN -> temp_y++;
            default -> throw new IllegalStateException("Unexpected value: " + direction);
        }
        
        return new Position(temp_x, temp_y);
    }
    
    /**
     * Fais une egalite entre deux positions
     * 
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().equals(this.getClass())) {
            Position p = (Position) obj;
            return (this.x == p.x) && (y == p.y);
        }
        else return false;
    }

    /**
     * Retourne si la position est un mur
     * 
     * @return boolean
     */
    boolean isWall(){
        return this.isWall;
    }
}
