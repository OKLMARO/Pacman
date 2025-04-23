import java.util.Random;

public class Ghost {

    private Position position_courante;     // position du fantome
    private Direction direction;            // direction de deplacement du fantome
    
    /**
     * Constructeur pour Ghost
     */
    public Ghost(){
        this.position_courante = new Position(17, 9);
        this.direction = Direction.UP;
    }

    /**
     * Retourne la coordonnée x de la position du fantôme
     * 
     * @return int
     */
    public int getX() {
        return this.position_courante.getX();
    }

    /**
     * Retourne la coordonnée y de la position du fantôme
     * 
     * @return int
     */
    public int getY() {
        return this.position_courante.getY();
    }

    /**
     * Retourne la direction du fantôme
     * 
     * @return Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Change la direction du fantôme
     * 
     * @param d
     */
    public void setDirection(Direction d){
        this.direction = d;
    }

    /**
     * Change la position x du fantôme
     * 
     * @param x
     */
    public void setPos_x(int x){
        this.position_courante = new Position(x, this.getY());
    }

    /**
     * Change la position y du fantôme
     * 
     * @param y
     */
    public void setPos_y(int y){
        this.position_courante = new Position(this.getX(), y);
    }

    /**
     * Change la direction du fantôme
     */
    public void changeDirection(){
        Direction[] directions = Direction.values();
        int randomIndex = new Random().nextInt(directions.length);
        this.setDirection( directions[randomIndex]);
    }

    /**
     * Change la position du fantôme a sa position initiale
     */
    public void setInitialPosition(){
        this.position_courante = new Position(17, 9);
    }

    /**
     * Retourne la position du fantôme
     * 
     * @return Position
     */
    public Position getPosition(){
        return this.position_courante;
    }

    /**
     * Action du fantôme
     * 
     * @param pacman
     */
    public void action(Pacman pacman){
        switch (pacman.getState().getState()) {
            case NORMAL:
                pacman.setInitialPosition();
                pacman.decLife();
                break;
        
            case SUPER:
                this.setInitialPosition();
                break;
            default:
                break;
        }
    }
}