public class OrangePacgomme implements Pacgomme{

    private final Position pos;
	private int point;

	/**
	 * Constructeur de la classe OrangePacgomme
	 * 
	 * @param p
	 */
    public OrangePacgomme(Position p){
        this.pos = p;
		this.point = 500;
    }

	/**
	 * Action de la pacgomme
	 * 
	 * @param pacman
	 */
	@Override
	public void action(Pacman pacman) {
		StateSuperPacman temp = new StateSuperPacman();
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
		return PacgommeType.ORANGE;
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
