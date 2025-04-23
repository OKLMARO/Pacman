public class VioletPacgomme implements Pacgomme {
    
    private final Position pos;
    private int point;

	/**
	 * Constructeur pour VioletPacgomme
	 * 
	 * @param p
	 */
    public VioletPacgomme(Position p){
        this.pos = p;
        this.point = 300;
    }

	/**
	 * Action de la pacgomme
	 * 
	 * @param pacman
	 */
	@Override
	public void action(Pacman pacman) {
		StateInvisible temp = new StateInvisible();
		temp.setTimer(System.currentTimeMillis());
		pacman.changeState(temp);
        pacman.addPoint(this.point);
	}

	/**
	 * Retourne le type de la pacgomme
	 * 
	 * @return PacgommeType
	 */
	@Override
	public Pacgomme.PacgommeType getType() {
		return PacgommeType.VIOLET;
	}

	/**
	 * Retourne la position de la pacgomme
	 * 
	 * @return Position
	 */
	@Override
	public Position getPosition() {
		return this.pos;
	}
}
