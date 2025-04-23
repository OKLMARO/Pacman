public class StateNormal implements State{

    /**
     * Deplace le pacman dans la direction donnee
     * 
     * @param pacman
     * @param direction
     */
    @Override
    public void move(Pacman pacman, Direction direction) {
        pacman.step(direction);
    }

    /**
     * Retourne l'etat du pacman
     * 
     * @return PacmanState
     */
    @Override
    public State.PacmanState getState() {
        return PacmanState.NORMAL;
    }
    
}
