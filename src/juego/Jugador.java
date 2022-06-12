/* 
*BLACKJACK DARIO RATA
*/
package juego;

import java.util.ArrayList;

public class Jugador {

	// Arraylist con la mano del jugador
	// Arraylist amb la mà del jugador

	private ArrayList<Cartas> mano = new ArrayList<Cartas>();
	private int[] valorDeMano;

	public Jugador() {
		valorDeMano = new int[2];
	}

	// Añadir una carta a la mano para incrementar el valor total
	// Afegir una carta a la mà per incrementar el valor total

	public void añadircarta(Cartas carta) {
		boolean EncontrarAs = false;

		// Comprueba si la mano tiene un As
		// Comprova si la mà té un As

		if (getmano().size() > 0) {
			for (Cartas index : getmano()) {
				if (index.getvalorCara() == Cartas.valorCara.As) {
					EncontrarAs = true;
				}
			}
		}
		// Añade una carta a la mano
		// Afegeix una carta a la mà

		getmano().add(carta);

		// Calcula la mano y si tiene un as se le setea lo que tenga + 11//
		// Calcula la mà i si té un as se li seteja el que tingui + 11//

		if (carta.getvalorCara() == Cartas.valorCara.As) {

			// Si encuentra un As a la mano se le suma 11
			// Si trobeu un As a la mà se li suma 11
			if (EncontrarAs) {
				valorDeMano[0] += 1;
			} else {
				valorDeMano[0] += 11;
			}
			valorDeMano[1] += 1;
		} else {

			// Calcula otras cartas junto al valor de As
			// Calcula altres cartes al costat del valor d'As

			valorDeMano[0] += carta.getvalorCara().getValorInt();
			valorDeMano[1] += carta.getvalorCara().getValorInt();
		}
	}

	// SETTERS Y GETTERS

	public ArrayList<Cartas> getmano() {
		return mano;
	}

	public int[] getvalorMano() {
		return valorDeMano;
	}

	public void setvalorDeMano(int[] valorDeMano) {
		this.valorDeMano = valorDeMano;
	}

	// SETTERS Y GETTERS

}
