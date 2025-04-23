import java.util.ArrayList;

public class Partie {
    private Pacman pacman;
    private Ghost[] ghosts;
    private ArrayList<Pacgomme> pacgommes = new ArrayList<>();

    Position[][] board;
    

    String[][] map1 = {
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "-", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "-", "-", "-", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "#", "#", "#", "#", "-", "-", "-", "#", "#", "#", "#", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#"},
            {"#", "-", "-", "-", "-", "#", "#", "#", "#", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "#", "#", "#", "#", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "-", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
    };

    String[][] map2 = {
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "-", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "-", "-", "-", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "#", "#", "#", "#", "-", "-", "-", "#", "#", "#", "#", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#"},
            {"#", "-", "-", "-", "-", "#", "#", "#", "#", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "#", "#", "#", "#", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "#", "#", "#", "#", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "-", "-", "#", "#", "#", "#", "#", "#", "#", "#", "#", "-", "#", "#", "#", "#", "-", "#"},
            {"#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
    };

    /**
     * Constructeur de la classe Partie qui nous permet de créer une partie avec un pacman et 4 fantômes
     * et de créer le plateau de jeu avec les murs et les pacgommes (bleu, orange, violet et vert) 
     * et de les placer aléatoirement sur le plateau de jeu
     */

    public Partie() {
        this.pacman = new Pacman();
        this.ghosts = new Ghost[4];
        this.board = new Position[21][35];
        
        this.ghosts[0] = new Ghost();
        this.ghosts[1] = new Ghost();
        this.ghosts[2] = new Ghost();
        this.ghosts[3] = new Ghost();
        for (int y = 0; y < 21; y++) {
            for (int x = 0; x < 35; x++) {
                if (this.map1[y][x].equals("#")) {
                    this.board[y][x] = new Position(y, x, true);
                } else {
                    Position pos = new Position(y, x);
                    this.board[y][x] = pos;
                    
                    double temp = Math.floor(Math.random() * 100);
                    if(temp < 1){
                        pacgommes.add(new VertPacgomme(new Position(x, y)));
                    }else if(temp >= 1 && temp < 2){
                        pacgommes.add(new OrangePacgomme(new Position(x, y)));

                    }else if (temp >= 2 && temp < 4){
                        pacgommes.add(new VioletPacgomme(new Position(x, y)));
                    }else{
                        pacgommes.add(new BleuPacgomme(new Position(x, y)));
                    }
                }
            }

        }
    }

    /**
     * Méthode qui nous permet de retourner le plateau de jeu
     * 
     * @return String[][]
     */
    public String[][] getMap() {
        return map1;
    }

    /**
     * Méthode qui nous permet de retourner les fantômes
     * 
     * @return Ghost[]
     */
    public Ghost[] getGhosts() {
        return this.ghosts;
    }

    /**
     * Méthode qui nous permet de retourner le pacman
     * 
     * @return Pacman
     */
    public Pacman getPacman() {
        return pacman;
    }

    /**
     * Méthode qui nous permet de retourner les pacgommes
     * 
     * @return ArrayList<Pacgomme>
     */
    public ArrayList<Pacgomme> getPacgommes(){
        return this.pacgommes;
    }

    /**
     * Méthode qui nous permet de déplacer les fantômes
     */
    public void moveGhost(){
        int x, y;
        for( int i = 0; i < 4; i++){
            x = this.ghosts[i].getX();
            y = this.ghosts[i].getY();

            while(!isValidMove(this.board[y][x], this.ghosts[i].getDirection())){
                ghosts[i].changeDirection();
            }
            switch (this.ghosts[i].getDirection()) {
                case UP:
                    y = y - 1;
                    break;
                case DOWN:
                    y = y + 1;
                    break;
                case LEFT:
                    x = x - 1;
                    break;
                case RIGHT:
                    x = x + 1;
                    break;
                default:
                    break;
            }
            this.ghosts[i].setPos_x(x);
            this.ghosts[i].setPos_y(y);
        }
    }

    /**
     * Méthode qui nous permet de vérifier si le déplacement est valide
     * 
     * @param cell position de la cellule
     * @param direction direction du déplacement
     * 
     * @return boolean
     */
    public boolean isValidMove(Position cell, Direction direction) {
        int y = cell.getX();
        int x = cell.getY();

        switch (direction) {
            case UP:
                y = y - 1;
                break;
            case DOWN:
                y = y + 1;
                break;
            case LEFT:
                x = x - 1;
                break;
            case RIGHT:
                x = x + 1;
                break;
            default:
                break;
        }
        if (this.board[y][x].isWall()) {
            return false;
        }
        return true;
    }

    /**
     * Méthode qui nous permet de mettre à jour la direction du pacman et de vérifier si la partie est terminée
     * 
     * @param direction direction du pacman
     */
    public boolean update(Direction direction){
        pacman.setDirection(direction);
        return !isOver();
    }

    /**
     * Méthode qui nous permet de retourner le plateau de jeu
     * 
     * @return Position[][]
     */
    public Position[][] getBoard() {
        return this.board;
    }

    /**
     * Méthode qui nous permet de vérifier si la partie est terminée
     * 
     * @return boolean
     */
    public boolean isOver() {
        return !(this.pacman.isAlive() && this.hasPacgomme());
    }

    /**
     * Méthode qui nous permet de vérifier si il reste des pacgommes
     * 
     * @return boolean
     */
    public boolean hasPacgomme() {
        return this.pacgommes.size() > 0;
    }

    /**
     * Méthode qui nous permet de changer le plateau de jeu
     * 
     * @param map plateau de jeu
     */
    public void changeMap(String[][] map){
        for (int y = 0; y < 21; y++) {
            for (int x = 0; x < 35; x++) {
                if (this.map2[y][x].equals("#")) {
                    this.board[y][x] = new Position(y, x, true);
                    for (int index = 0; index < pacgommes.size(); index++) {
                        if(pacgommes.get(index).getPosition().getX() == x && pacgommes.get(index).getPosition().getY() == y){
                            pacgommes.remove(index);
                        }
                    }
                } else {
                    Position pos = new Position(y, x);
                    this.board[y][x] = pos;
                }
            }
        }
    }

    /**
     * Méthode qui nous permet de vérifier si il y a une pacgomme à la position pos
     * 
     * @param pos position à vérifier
     * 
     * @return boolean
     */
    private boolean checkPacgomme(Position pos){
        for( Pacgomme p: pacgommes) {
            
            if( pos.equals(p.getPosition())){
                return true;
            } 
        }
        return false;
    }

    /**
     * Méthode qui nous permet de vérifier si il y a un fantôme à la position pos
     * 
     * @param pos position à vérifier
     * 
     * @return boolean
     */
    private boolean checkGhost(Position pos){
        for(Ghost g: this.ghosts){
            if( g.getPosition().equals(pos)){
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode qui nous permet de retourner une pacgomme si elle est à la position pos
     * 
     * @param pos position à vérifier
     * 
     * @return Pacgomme
     */
    private Pacgomme getPacgomme(Position pos){
        for( Pacgomme p: pacgommes) {
            if( p.getPosition().equals(pos)){
                return p;
            }
        }
        throw new NullPointerException("pas de pacgomme ici");
    }
    
    /**
     * retourne un fantome s'il est à la position pos
     * 
     * @param pos position à verifier
     * 
     * @return Ghost a la position pos sinon NullPointerException
     */
    private Ghost getGhost(Position pos){
        for(Ghost g: this.ghosts) {
            if( g.getPosition().equals(pos)){
                return g;
            }
        }
        throw new NullPointerException("pas de pacgomme ici");
    }

    /**
     * Méthode qui nous permet de déplacer le pacman
     * 
     * @param direction
     */
    public void move(Direction direction){
        this.pacman.setDirection(direction);
        Position temp = pacman.getPosition().move(direction);
        if(!board[temp.getY()][temp.getX()].isWall()){
            this.pacman.getState().move(this.pacman, direction);
        }
        
        if(checkGhost(this.pacman.getPosition())){
            Ghost g = getGhost(this.pacman.getPosition());
            g.action(this.pacman);
        }
        if (checkPacgomme(this.pacman.getPosition())) {
            Pacgomme p = getPacgomme(this.pacman.getPosition());
            p.action(this.pacman);
            if(p.getType() == Pacgomme.PacgommeType.VERT){
                changeMap(map2);
            }
            pacgommes.remove(p);
        }
    }
}
