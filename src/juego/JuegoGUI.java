/* 
*BLACKJACK v1.0 RELEASE
*Imagenes de las cartas sacadas de internet
*Fuentes sacadas de intrnet
*Todas los códigos comentados
*He generat el botons amb la página https://www.clickminded.com/button-generator/
*añadidos todos los cometarios a valenciano
*/

package juego;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class JuegoGUI {

	/* VARIABLES */
	// Cuando el crupier llegue a este limite parará
	// Quan el crupier arribi a aquest límit pararà
	static final int crupier_LIMITE = 17;
	// JFRAME principal
	static JFrame frameJuego;
	// baraja de cartas
	// baralla de cartes
	private Baraja baraja;
	// draw panel
	private DrawFrame ventanajuego, ventanamain, ventanacreditos;
	// jugador y crupier
	private Jugador jugador, crupier;
	// mensaje de la pantalla deljuego
	// missatge de la pantalla de joc
	private String Mensaje = "";
	// clase otros
	private Otros otros;
	// boolean para ver si esta el juego on
	// boolean per veure si està el joc on
	private boolean juegoActivo;
	// JLABELS
	private JLabel backgroundmain, fondocreditos, logo, creditos1, creditos2, creditos3;
	// JBUTTONS
	private JButton botonjugar, botoninstrucciones, botoncreditos, botonsalir, botonvolver1, botonvolver2,
			botonnuevoJuego, botonpedirCarta, botonPlantarse;
	/* VARIABLES */

	// IMATGES \\

	ImageIcon imglogo = new ImageIcon("src/juego/imagenes/imglogo.png");
	ImageIcon jugar = new ImageIcon("src/juego/imagenes/button_jugar-removebg-preview.png");
	ImageIcon instruccions = new ImageIcon("src/juego/imagenes/button_instrucciones.png");
	ImageIcon creditos = new ImageIcon("src/juego/imagenes/button_creditos.png");
	ImageIcon salir = new ImageIcon("src/juego/imagenes/button_salir.png");
	ImageIcon imgbackground = new ImageIcon("src/juego/imagenes/backmain.jpg");
	ImageIcon backgroundcreditos = new ImageIcon("src/juego/imagenes/fondocreditos.jpg");
	ImageIcon volver = new ImageIcon("src/juego/imagenes/button_menu-principal.png");

	// IMATGES \\

	// MAIN DE LA GUI \\
	public static void main(String[] args) {
		JuegoGUI gui = new JuegoGUI();
		gui.init();
	}
	// MAIN DE LA GUI \\

	public void init() {

		try {
			// * FONTS *//

			Font fuente1 = new Font("SansSerif Bold", Font.BOLD, 30);
			Font fuente2 = new Font("SansSerif Plan", Font.BOLD, 25);
			Font fuente3 = Font.createFont(Font.TRUETYPE_FONT, new File("src/juego/fuentes/Cute Notes.ttf"))
					.deriveFont(25f);
			Font fuente4 = Font.createFont(Font.TRUETYPE_FONT, new File("src/juego/fuentes/1up.ttf")).deriveFont(25f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

			// Registrar fuente
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/juego/fuentes/Cute Notes.ttf")));
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("src/juego/fuentes/1up.ttf")));

			// * FONTS *//

			// FRAME PRINCIPAL \\

			frameJuego = new JFrame();
			frameJuego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frameJuego.setTitle("BlackJack");
			frameJuego.setResizable(false);
			frameJuego.setIconImage(new ImageIcon("src/juego/imagenes/logo.png").getImage());

			// FRAME PRINCIPAL \\

			/* PANTALLA PRINCIPAL */

			// Draw panel pantalla principal
			ventanamain = new DrawFrame();
			ventanamain.setBounds(0, 0, 1024, 768);
			ventanamain.setLayout(null);
			frameJuego.getContentPane().setLayout(null);
			frameJuego.getContentPane().add(ventanamain);
			frameJuego.setSize(1024, 768);
			frameJuego.setVisible(true);

			// Draw Panel Ventana de Juego
			// Draw Panell Finestra de Joc
			ventanajuego = new DrawFrame();
			ventanajuego.setBounds(0, 0, 600, 500);
			ventanajuego.setLayout(null);

			// Draw Panel Ventana creditos
			// Draw Panel Finestra creditos
			ventanacreditos = new DrawFrame();
			ventanacreditos.setBounds(0, 0, 500, 500);
			ventanacreditos.setLayout(null);

			// Titul joc image
			logo = new JLabel(imglogo);
			logo.setBounds(380, 05, 250, 250);
			ventanamain.add(logo);

			// Boton de jugar
			botonjugar = new JButton(jugar);
			botonjugar.setRolloverIcon(jugar);
			botonjugar.setBounds(405, 304, 183, 40);
			ventanamain.add(botonjugar);
			botonjugar.setBorder(null);

			// Boton de instruccions
			botoninstrucciones = new JButton(instruccions);
			botoninstrucciones.setRolloverIcon(instruccions);
			botoninstrucciones.setBounds(385, 398, 220, 47);
			ventanamain.add(botoninstrucciones);
			botoninstrucciones.setBorder(null);

			// Boton de creditos
			botoncreditos = new JButton(creditos);
			botoncreditos.setRolloverIcon(creditos);
			botoncreditos.setBounds(405, 495, 175, 50);
			ventanamain.add(botoncreditos);
			botoncreditos.setBorder(null);

			// Boton de salir
			botonsalir = new JButton(salir);
			botonsalir.setRolloverIcon(salir);
			botonsalir.setBounds(405, 600, 175, 50);
			ventanamain.add(botonsalir);
			botonsalir.setBorder(null);

			// Fons de pantalla main
			backgroundmain = new JLabel("", imgbackground, JLabel.CENTER);
			backgroundmain.setBounds(0, 0, 1024, 768);
			ventanamain.add(backgroundmain);

			/* PANTALLA PRINCIPAL */

			/* BOTONES Y MENU BAR DE LA VENTANA DEL JUEGO */
			/* BOTONS I MENU BAR DE LA FINESTRA DEL JOC */

			// Boton de juego nuevo
			ImageIcon nuevoJuego = new ImageIcon("src/juego/imagenes/button_nuevo-juego.png");
			botonnuevoJuego = new JButton(nuevoJuego);
			botonnuevoJuego.setBounds(50, 428, 150, 35);
			ventanajuego.add(botonnuevoJuego);

			// Boton para pedir carta
			ImageIcon Pedir = new ImageIcon("src/juego/imagenes/button_pedir.png");
			botonpedirCarta = new JButton(Pedir);
			botonpedirCarta.setBounds(200, 428, 90, 35);
			ventanajuego.add(botonpedirCarta);

			// Boton para plantarse
			ImageIcon Plantarse = new ImageIcon("src/juego/imagenes/button_plantarse.png");
			botonPlantarse = new JButton(Plantarse);
			botonPlantarse.setBounds(290, 428, 90, 35);
			ventanajuego.add(botonPlantarse);

			ImageIcon volver = new ImageIcon("src/juego/imagenes/button_menu-principal.png");
			botonvolver2 = new JButton(volver);
			botonvolver2.setRolloverIcon(volver);
			botonvolver2.setBounds(380, 428, 135, 35);
			ventanajuego.add(botonvolver2);

			/* BOTONES Y MENU BAR DE LA VENTANA DEL JUEGO */
			/* BOTONS I MENU BAR DE LA FINESTRA DEL JOC */

			/* VENTANA DE CREDITOS */

			creditos1 = new JLabel("CREADOR: DARIO RATA");
			creditos1.setBounds(50, -100, 400, 400);
			ventanacreditos.add(creditos1);
			creditos1.setFont(fuente3);
			creditos1.setForeground(Color.WHITE);

			creditos2 = new JLabel("PROGRAMADO EN JAVA");
			creditos2.setBounds(50, 0, 400, 400);
			ventanacreditos.add(creditos2);
			creditos2.setFont(fuente4);
			creditos2.setForeground(Color.WHITE);

			creditos3 = new JLabel("V1.0 BETA");
			creditos3.setBounds(150, 100, 400, 400);
			ventanacreditos.add(creditos3);
			creditos3.setFont(fuente4);
			creditos3.setForeground(Color.WHITE);

			// Boton de volver
			ImageIcon volver2 = new ImageIcon("src/juego/imagenes/button_menu-principal1.png");
			botonvolver1 = new JButton(volver2);
			botonvolver1.setRolloverIcon(volver2);
			botonvolver1.setBounds(145, 380, 215, 30);
			ventanacreditos.add(botonvolver1);
			botonvolver1.setBorder(null);

			// imagen de fondo
			// imatge de fons
			fondocreditos = new JLabel("", backgroundcreditos, JLabel.CENTER);
			fondocreditos.setBounds(0, 0, 500, 500);
			ventanacreditos.add(fondocreditos);

			creditos1.addMouseListener(new MouseListener() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					creditos1.setFont(fuente3);
					creditos1.setBounds(50, -100, 400, 400);
					creditos1.setForeground(Color.yellow);

					creditos2.setFont(fuente4);
					creditos2.setBounds(50, 0, 400, 400);
					creditos2.setForeground(Color.PINK);

					creditos3.setFont(fuente4);
					creditos3.setBounds(150, 100, 400, 400);
					creditos3.setForeground(Color.RED);
				}

				@Override
				public void mouseClicked(java.awt.event.MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(java.awt.event.MouseEvent e) {
					// TODO Auto-generated method stub
					creditos1.setFont(fuente3);
					creditos1.setBounds(50, -100, 400, 400);
					creditos1.setForeground(Color.WHITE);

					creditos2.setFont(fuente4);
					creditos2.setBounds(50, 0, 400, 400);
					creditos2.setForeground(Color.WHITE);

					creditos3.setFont(fuente4);
					creditos3.setBounds(150, 100, 400, 400);
					creditos3.setForeground(Color.WHITE);
				}

				@Override
				public void mousePressed(java.awt.event.MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseReleased(java.awt.event.MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});

			/* VENTANA DE CREDITOS */

			/* ACTION LISTENER PARA TODOS LOS BOTONES */
			/* ACTION LISTENIR PER A TOTS ELS BOTONS */

			// action listener - boton para jugar
			botonjugar.addActionListener(new botonJugarListener());
			// action listener - boton para instrucciones
			botoninstrucciones.addActionListener(new botonInstruccionesListener());
			// action listener - boton para creditos
			botoncreditos.addActionListener(new botonCreditosListener());
			// action listener - boton volver del menu principal
			botonvolver1.addActionListener(new botonVolver1Listener());
			// action listener - boton para salir
			botonsalir.addActionListener(new botonSalirListener());
			// action listener - boton para juego nuevo
			botonnuevoJuego.addActionListener(new nuevoJuegoListener());
			// action listener - boton para pedir carta
			botonpedirCarta.addActionListener(new pedirCartaListener());
			// action listener - boton para plantarse
			botonPlantarse.addActionListener(new botonPlantarseListener());
			// action listener - boton volver del juego
			botonvolver2.addActionListener(new botonVolver2Listener());

			/* ACTION LISTENER PARA TODOS LOS BOTONES */
			/* ACTION LISTENIR PER A TOTS ELS BOTONS */

		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}
	}

	/* CLASE PARA SETEAR EL JUEGO CUANDO LE DES A JUGAR */
	/* CLASSE PER ASSETEJAR EL JOC QUAN LI DONIS A JUGAR */

	private void crearJuegoNuevo() {
		// create a new baraja
		baraja = new Baraja();
		// new jugador
		jugador = new Jugador();
		// new crupier
		crupier = new Jugador();
		// new otros class
		otros = new Otros();
		// clear Mensaje
		Mensaje = "";
		// game is on
		juegoActivo = true;
	}

	/* CLASE PARA SETEAR EL JUEGO CUANDO LE DES A JUGAR */
	/* CLASSE PER ASSETEJAR EL JOC QUAN LI DONIS A JUGAR */

	////////////// CLASES DE TODOS LOS ACTIONLISTENERS\\\\\\\\\\\\\\\\\\\\\\
	////////////// CLASSES DE TOTS ELS ACTIONLISTENERS\\\\\\\\\\\\\\\\\\\\\

	class botonJugarListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			ventanamain.setVisible(false);
			ventanajuego.setVisible(true);
			frameJuego.getContentPane().setLayout(null);
			frameJuego.getContentPane().add(ventanajuego);
			frameJuego.setSize(600, 500);

		}

	}

	class botonInstruccionesListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"> El objetivo es simple: Ganarle al Croupier obteniendo el puntaje más cercano a 21."
							+
							"\n\n> Las figuras (el Jack, la Reina y el Rey) valen 10, el As vale 11 o 1 y todas las otras cartas conservan su valor."
							+
							"\n\n> Cada jugador comienza con dos cartas. Una de las cartas del crupier se oculta hasta el final."
							+
							"\n\n> El Black Jack se produce cuando las dos (2) primeras cartas son un diez o cualquier figura más un As."
							+
							"\n\n> Si te pasas de 21, se pasa y el crupier gana independientemente de la mano del crupier.",
					"INSTRUCCIONES BLACKJACK",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	class botonCreditosListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ventanamain.setVisible(false);
			ventanacreditos.setVisible(true);
			ventanacreditos.setLayout(null);
			frameJuego.setSize(500, 500);
			frameJuego.setContentPane(ventanacreditos);
			ventanacreditos.setBackground(Color.CYAN);
		}

	}

	class botonVolver1Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			ventanacreditos.setVisible(false);
			ventanamain.setVisible(true);
			ventanamain.setLayout(null);
			frameJuego.setSize(1024, 768);
			frameJuego.setContentPane(ventanamain);
		}

	}

	class botonSalirListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?",
					"Ventana de confirmación", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (confirmacion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

	}

	// Action listener del boton para nuevo juego
	// Action listener del botó per a nou joc
	class nuevoJuegoListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// empezar un juego nuevo
			// començar un joc nou
			if (!juegoActivo) {
				crearJuegoNuevo();
				// repartir dos cartas al crupier y al jugador
				// repartir dues cartes al crupier i al jugador
				for (int i = 0; i < 2; i++) {
					crupier.añadircarta(baraja.repartidorDeCartas());
					jugador.añadircarta(baraja.repartidorDeCartas());
				}
				// comprueba si el jugador ha hecho un blackjack
				// comprova si el jugador ha fet un blackjack
				if (otros.checkBlackJack(jugador)) {
					// en caso de que el crupier haya hecho un blackjack se ejecutaria la funcion//
					// en cas que el crupier hagi fet un blackjack s'executaria la funcio
					// <latienemasgrande>

					if (otros.determineganador(jugador, crupier) == Otros.ganador.latieneMasGrande) {
						Mensaje = "Blackjack ! Te ha doblado!";
						juegoActivo = false;
					} else {
						Mensaje = "Blackjack ! ¡Has Ganado!";
						juegoActivo = false;
					}
				}

				// aqí iniciaremos el juego con todo
				// açi iniciarem el joc amb tot
				ventanajuego.setcrupiermano(crupier.getmano());
				ventanajuego.setjugadormano(jugador.getmano());
				ventanajuego.setMensaje(Mensaje);
				ventanajuego.setjuegoActivo(juegoActivo);
				frameJuego.repaint();
			}
		}
	}

	// Action listener del boton para pedir las cartas
	// Action listener del botó per demanar les cartes
	class pedirCartaListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if (juegoActivo) {
				// si el juego esta activo se reparte una carta y se la da al jugador
				// si el joc aquesta actiu es reparteix una carta i la dóna al jugador
				jugador.añadircarta(baraja.repartidorDeCartas());
				// seHaPasado es para comprobar si te has pasado de 21, entonces pierdes
				// seHaPasado és per comprovar si t'has passat de 21, aleshores perds
				if (otros.seHaPasado(jugador)) {
					Mensaje = "¡Te Has pasado!";
					juegoActivo = false;
				}
				// aquí setea la mano del jugador
				ventanajuego.setjugadormano(jugador.getmano());
				ventanajuego.setMensaje(Mensaje);
				ventanajuego.setjuegoActivo(juegoActivo);
				frameJuego.repaint();
			}
		}
	}

	// Action listener para el boton de plantarse
	class botonPlantarseListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Otros.ganador ganador;
			if (juegoActivo) {
				juegoActivo = false;
				// se reparte una carta al crupier si esta tiene un valor establecido por debajo
				// del limite
				// es reparteix una carta al crupier si aquesta té un valor establert per sota
				// del límit
				while ((crupier.getvalorMano()[0] < crupier_LIMITE)
						&& (crupier.getvalorMano()[1] < crupier_LIMITE)) {
					crupier.añadircarta(baraja.repartidorDeCartas());
				}
				// aquí si el crupier se pasa de 21 gana el jugador
				if (otros.seHaPasado(crupier)) {
					Mensaje = "¡Felicidades Chico! ¡Has Ganado!";
					ventanajuego.setMensaje(Mensaje);
					ventanajuego.setjuegoActivo(juegoActivo);
					frameJuego.repaint();
				} else {
					// determina el ganador y lanza el mensaje
					// determina el guanyador i llança el missatge
					ganador = otros.determineganador(jugador, crupier);
					switch (ganador) {
						case jugador:
							Mensaje = "¡Felicidades Chico! ¡Has Ganado!";
							break;
						case crupier:
							Mensaje = "¡Has Perdido, no llores!";
							break;
						case latieneMasGrande:
							Mensaje = "¡Te has pasado!";
							break;
						default:
							break;
					}
					ventanajuego.setMensaje(Mensaje);
					ventanajuego.setjuegoActivo(juegoActivo);
					frameJuego.repaint();
				}
			}
		}

	}

	// Action listener de la primera opcion del menu bar
	class mi1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			ventanajuego.setVisible(false);
			ventanamain.setVisible(true);
			frameJuego.getContentPane().setLayout(null);
			frameJuego.getContentPane().add(ventanamain);
			frameJuego.setSize(1024, 768);
		}

	}

	// Action listener de la segunda opcion del menu bar
	class mi2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres salir?",
					"Ventana de confirmación", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (confirmacion == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

	}

	// Action listener para el boton de la ventana del juego
	class botonVolver2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			ventanajuego.setVisible(false);
			ventanamain.setVisible(true);
			frameJuego.getContentPane().setLayout(null);
			frameJuego.getContentPane().add(ventanamain);
			frameJuego.setSize(1024, 768);

		}

	}

	////////////// CLASES DE TODOS LOS ACTIONLISTENERS\\\\\\\\\\\\\\\\\\\\\\
	////////////// CLASSES DE TOTS ELS ACTIONLISTENERS\\\\\\\\\\\\\\\\\\\\\

	// Clase usada para todos los drawframe aunque en verdad solo se usa para la
	// pantalla del juego \\
	// Classe usada per a tots els drawframe encara que en veritat només es fa
	// servir per a la pantalla del joc \\

	class DrawFrame extends JPanel {

		// arraylist de las cartas para la mano del jugador
		// arraylist de les cartes per a la mà del jugador
		private ArrayList<Cartas> jugadormano;
		// arraylist de las cartas para la mano del crupier
		// arraylist de les cartes per a la mà del crupier
		private ArrayList<Cartas> crupiermano;
		// Mensaje principal vacio
		String Mensaje = "";
		// determina si el juego esta activo
		// determina si el joc està actiu
		boolean juegoActivo;

		// setea la mano del jugador para que se dibuje en el drawpanel
		// seteja la mà del jugador perquè es dibuixi al drawpanel
		public void setjugadormano(ArrayList<Cartas> jugadormano) {
			this.jugadormano = jugadormano;
		}

		// setea la mano del crupier para que se dibuje en el drawpanel
		// seteja la mà del crupier perquè es dibuixi al drawpanel
		public void setcrupiermano(ArrayList<Cartas> crupiermano) {
			this.crupiermano = crupiermano;
		}

		// setea el mensaje nulo
		// seteja el missatge nul
		public void setMensaje(String Mensaje) {
			this.Mensaje = Mensaje;
		}

		// setea que el juego esta activo
		// estableix que el joc està actiu
		public void setjuegoActivo(boolean juegoActivo) {
			this.juegoActivo = juegoActivo;
		}

		// metodo que he utilizado para el fondo, el tipo de letra entre otros del draw
		// panel...
		// mètode que he utilitzat per al fons, el tipus de lletra entre d'altres del
		// draw panel

		public void paintComponent(Graphics g) {
			// fondo de pantalla verde
			// fons de pantalla verda
			g.setColor(new Color(0.0f, 0.5f, 0.0f));
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			// tipo de fuente y color del mensaje
			// tipus de font i color del missatge
			g.setFont(new Font("Arial Black", Font.BOLD, 20));
			g.setColor(new Color(1.0f, 0.0f, 0.0f));
			g.drawString(Mensaje, 150, 225);

			// mete las imagenes a la mano del jugador
			// fica les imatges a la mà del jugador
			if (jugadormano != null) {
				for (int i = 0; i < jugadormano.size(); i++) {
					Image imagen = jugadormano.get(i).getImagen();
					g.drawImage(imagen, (240 + i * 20), (285), this);
				}
			}
			// mete las imagenes a la mano del crupier
			// fica les imatges a la mà del crupier
			if (crupiermano != null) {
				for (int i = 0; i < crupiermano.size(); i++) {
					Image imagen;
					if (juegoActivo) {
						// AQUI HACEMOS QUE LA PRIMERA CARTA DEL CRUPIER ESTE BOCA ABAJO CON UNA IMAGEN
						// DE UNA CARTA GIRADA POR DETRAS
						// AQUI FEM QUE LA PRIMERA CARTA DEL CRUPIER AQUEST BOCA BAIX AMB UNA IMATGE
						// D'UNA CARTA GIRADA PER DARRERE
						if (i == 0) {
							imagen = new ImageIcon("src/juego/imagenes/b1fv.png").getImage();
						} else {
							imagen = crupiermano.get(i).getImagen();
						}
						// AQUI DAMOS LA VUELTA A LA CARTA PARA VER SU VALORb
						// AQUI DONEM LA TORNADA A LA CARTA PER VEURE EL SEU VALORb
					} else {
						imagen = crupiermano.get(i).getImagen();
					}
					g.drawImage(imagen, (240 + i * 20), (50), this);
				}
			}
		}

	}

	// Clase usada para todos los drawframe aunque en verdad solo se usa para la
	// pantalla del juego \\
	// Classe usada per a tots els drawframe encara que en veritat només s'usa per a
	// la pantalla del joc \\
}
