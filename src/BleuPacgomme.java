public class BleuPacgomme implements Pacgomme{
    
    private final Position pos;
    private int point;

	/**
	 * Constructeur de la classe BleuPacgomme
	 * 
	 * @param p
	 */
    public BleuPacgomme(Position p){
        this.pos = p;
        this.point = 100;
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
		return PacgommeType.BLEU;
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
