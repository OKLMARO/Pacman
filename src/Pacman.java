
public class Pacman {
    private Position currentPosition;
    private int point;
    private int life;
    private State state;
    private Direction direction;
    private int gainLife;

    /**
     * Constructeur de la classe Pacman
     */
    public Pacman(){
        this.life = 3;
        this.point = 0;
        this.currentPosition = new Position(17, 18);
        this.state = new StateNormal();
        this.direction = Direction.UP;
        this.gainLife = 0;
    }

    /**
     * Retourne vrai si pacman est en vie
     * 
     * @return boolean
     */
    public boolean isAlive(){
        return this.life > 0;
    }

    /**
     * Retourne la valeur de x de la position de pacman
     * 
     * @return int
     */
    public int getX(){
        return this.currentPosition.getX();
    }

    /**
     * Retourne la valeur de y de la position de pacman
     * 
     * @return int
     */
    public int getY() {
        return this.currentPosition.getY();
    }

    /**
     * Retourne le nombre de points de pacman
     * 
     * @return int
     */
    public int getPoint(){
        return this.point;
    }

    /**
     * Retourne la direction de pacman
     * 
     * @return Direction
     */
    public Direction getDirection(){
        return this.direction;
    }

    /**
     * Change les points de pacman
     * 
     * @param point
     */
    public void setPoint(int point){
        this.point = point;
    }

    /**
     * Ajoute des points à pacman
     * 
     * @param p
     */
    public void addPoint(int p) {
        this.point = this.point + p;
        this.gainLife = this.gainLife + p;
        if(this.gainLife >= 5000){
            this.incLife();
            this.gainLife = 0;
        }
    }

    /**
     * Change la direction de pacman
     * 
     * @param direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Incrémente la vie de pacman
     */
    public void incLife() {
        this.life = this.life + 1;
    }

    /**
     * Décrémente la vie de pacman
     */
    public void decLife(){
        this.life = this.life - 1;
    }

    /**
     * Retourne le nombre de vie de pacman
     * 
     * @return int
     */
    public int getLife() {
        return this.life;
    }

    /**
     * Retourne l'état de pacman
     * 
     * @return State
     */
    public State getState(){
        return this.state;
    }

    /**
     * Change l'état de pacman
     * 
     * @param state
     */
    public void changeState(State state){
        this.state = state;
    }

    /**
     * Retourne le pacman à sa position initiale
     */
    public void setInitialPosition(){
        this.currentPosition = new Position(17, 18);
    }
    
    /**
     * Déplace le pacman
     * 
     * @param direction
     */
    public void step(Direction direction){
        this.currentPosition = this.currentPosition.move(direction);
    }


    /**
     * Retourne la position de pacman
     * 
     * @return Position
     */
    public Position getPosition(){
        return this.currentPosition;
    }
}