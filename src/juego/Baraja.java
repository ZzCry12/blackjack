/* 
*BLACKJACK DARIO RATA
*/
package juego;

import java.util.ArrayList;
import javax.swing.ImageIcon;

/*
 * Clase de la baraja
 * 52 cartas
 */
public class Baraja {

	static final int MAX = 52;

	// ArrayList de la baraja
	private ArrayList<Cartas> baraja = new ArrayList<Cartas>();

	/*
	 * Crea la baraja de las 52 cartas con sus imagenes guardadas en el fichero
	 * 'imagenes'
	 * 
	 * Crea la baralla de les 52 cartes amb les seves imatges guardades al fitxer
	 * 'imagenes'
	 */

	public Baraja() {
		int i = 0;
		for (Cartas.valorCara valorCara : Cartas.valorCara.values())
			for (Cartas.Palo suit : Cartas.Palo.values()) {
				i++;
				baraja.add(new Cartas(suit, valorCara, new ImageIcon("src/juego/imagenes/" + i + ".png").getImage()));
			}
	}

	/*
	 * funcion para repartir una carta de la baraja
	 * 
	 * funcio per repartir una carta de la baralla
	 */
	public Cartas repartidorDeCartas() {

		// aquí quitamos la carta que hemos repartido de la baraja
		// aci quitem la carta que hem repartit de la baralla
		int i = (int) (Math.random() * baraja.size());
		return baraja.remove(i);
	}

}
