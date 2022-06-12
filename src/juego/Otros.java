/* 
*BLACKJACK DARIO RATA
*/
package juego;

/*
 * Clase OTROS. Determina quien es el ganador
 */
public class Otros {

	// Valor de un blackjack

	static final int BLACK_JACK = 21;

	// Define quien es el ganador
	// defineix qui es el guañador

	public enum ganador {
		jugador, latieneMasGrande, crupier
	}

	/*
	 * determina el ganador dependiendo de quien tiene la carta más grande.
	 * Cuatro manos en total (jugador: AS=1, AS=11) (crupier: AS=1, AS=11)
	 * 
	 * determina el guanyador depenent de qui té la carta més gran.
	 * Quatre mans en total (jugador: AS=1, AS=11) (crupier: AS=1, AS=11)
	 */
	public ganador determineganador(Jugador jugador, Jugador crupier) {
		int manomasgrandejugador = 0;
		int manomasgrandecrupier = 0;

		// Busca la mayor mano del jugador ¡SIENDO MENOR A 21!
		// Busca la mà del jugador més gran SENT MENOR A 21!

		if (jugador.getvalorMano()[0] > BLACK_JACK) {
			manomasgrandejugador = jugador.getvalorMano()[1];
		} else if (jugador.getvalorMano()[1] > BLACK_JACK) {
			manomasgrandejugador = jugador.getvalorMano()[0];
		} else if (jugador.getvalorMano()[0] >= jugador.getvalorMano()[1]) {
			manomasgrandejugador = jugador.getvalorMano()[0];
		} else {
			manomasgrandejugador = jugador.getvalorMano()[1];
		}
		// Busca la mayor mano del crupier ¡SIENDO MENOR A 21!
		// Busca la mà més gran del crupier SENT MENOR A 21!

		if (crupier.getvalorMano()[0] > BLACK_JACK) {
			manomasgrandecrupier = crupier.getvalorMano()[1];
		} else if (crupier.getvalorMano()[1] > BLACK_JACK) {
			manomasgrandecrupier = crupier.getvalorMano()[0];
		} else if (crupier.getvalorMano()[0] >= crupier.getvalorMano()[1]) {
			manomasgrandecrupier = crupier.getvalorMano()[0];
		} else {
			manomasgrandecrupier = crupier.getvalorMano()[1];
		}

		// Comprueba quien tiene la mano más grande
		// Comprova qui té la mà més gran

		if (manomasgrandejugador == manomasgrandecrupier) {
			return ganador.latieneMasGrande;

		} else if (manomasgrandejugador > manomasgrandecrupier) {
			return ganador.jugador;

		} else {
			return ganador.crupier;
		}

	}

	// Después de repartir las dos primeras cartas mira si el jugador ha conseguido
	// un blackjack
	// Després de repartir les dues primeres cartes mira si el jugador ha aconseguit
	// un blackjack

	public boolean checkBlackJack(Jugador jugador) {
		if ((jugador.getvalorMano()[0] == BLACK_JACK) || (jugador.getvalorMano()[1] == BLACK_JACK)) {
			return true;
		} else {
			return false;
		}
	}

	// Comprueba si el jugador se ha pasado de 21, si es así gana el crupier
	// Comprova si el jugador ha passat de 21, si és així guanya el crupier

	public boolean seHaPasado(Jugador jugador) {
		if ((jugador.getvalorMano()[0] > BLACK_JACK) && (jugador.getvalorMano()[1] > BLACK_JACK)) {
			return true;
		} else {
			return false;
		}
	}

}
