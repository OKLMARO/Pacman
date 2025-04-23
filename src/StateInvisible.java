public class StateInvisible implements State{

    private long timer = 0;
    
    /**
     * Deplace le pacman dans la direction donnee
     * 
     * @param pacman
     * @param direction
     */
    @Override
    public void move(Pacman pacman, Direction direction) {
        if(System.currentTimeMillis() >= timer + 10000 && timer != 0) {
            pacman.changeState(new StateNormal());
            timer = 0;
        }
        pacman.step(direction);
    }

    /**
     * Retourne l'etat du pacman
     * 
     * @return PacmanState
     */
    @Override
    public State.PacmanState getState() {
        return PacmanState.INVISBLE;
    }

    /**
     * Retourne le timer
     * 
     * @return long
     */
    public void setTimer(long debut){
        this.timer = debut;
    }
}
