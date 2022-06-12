/* 
*BLACKJACK DARIO RATA
*/
package juego;

import java.awt.Image;

public class Cartas {

	public enum Palo {
		Reyes, Espadas, Corazones, Diamantes
	}

	public enum valorCara {
		As(1), Rey(10), Reina(10), JACK(10), Diez(10), Nueve(9),
		Ocho(8), Siete(7), Seis(6), Cinco(5), Cuatro(4), Tres(3), Dos(2);

		private int ValorInt;

		valorCara(int ValorInt) {
			this.ValorInt = ValorInt;
		}

		public int getValorInt() {
			return this.ValorInt;
		}
	}

	private Palo palo;
	private valorCara valorCara;

	// iMAGENES DE LAS CARTAS

	private Image imagen;

	public Cartas(Palo palo, valorCara valorCara, Image imagen) {
		this.palo = palo;
		this.valorCara = valorCara;
		this.imagen = imagen;
	}

	// GETTERS Y SETTERS

	public Palo getPalo() {
		return palo;
	}

	public void setPalo(Palo Palo) {
		this.palo = Palo;
	}

	public valorCara getvalorCara() {
		return valorCara;
	}

	public void setValorCara(valorCara valorCara) {
		this.valorCara = valorCara;
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image image) {
		this.imagen = image;
	}

	// GETTERS Y SETTERS
}
