package Localisation;

/**
 * classe representant une position
 */
public class Position {
	/**coordonnée X*/
	private int posX;
	/**coordonnée Y*/
	private int posY;

	/**
	 * constructeur par defaut
	 * @param x co X
	 * @param y co Y
	 */
	public Position(int x, int y) {
		this.posX = x;
		this.posY = y;
	}

	/*GETTERS ET SETTERS*/

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
