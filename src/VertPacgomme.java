public class VertPacgomme implements Pacgomme {

    private final Position pos;
    private int point;

	/**
	 * Constructeur pour VertPacgomme
	 * 
	 * @param p
	 */
    public VertPacgomme(Position p){
        this.pos = p;
        this.point = 1000;
    }

	/**
	 * Action de la pacgomme
	 * 
	 * @param pacman
	 */
	@Override
	public void action(Pacman pacman) {
        pacman.addPoint(this.point);
	}

	/**
	 * Retourne le type de la pacgomme
	 * 
	 * @return PacgommeType
	 */
	@Override
	public Pacgomme.PacgommeType getType() {
		return PacgommeType.VERT;
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
