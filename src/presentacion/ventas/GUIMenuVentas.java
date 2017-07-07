package presentacion.ventas;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import presentacion.GUI;
import presentacion.controlador.Controlador;
import presentacion.eventos.Evento;

/**Interfaz grafica del menu de clasificacion de la aplicacion*/
public class GUIMenuVentas extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actualizar(Evento evento, Object objeto) {

	}

	/**Constructora de la GUI. Contendra botones para cada una`
	 * de las funciones de clasificacion.*/
	public GUIMenuVentas() {
		
		initGui();
		
	}

	private void initGui() {
		
		setTitle("Menu Venta");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2, 20, 20));
		
		JButton abrir = new JButton("Abrir");
		JButton devolver = new JButton("Devolver");
		JButton mostrarUna = new JButton("Mostrar Una");
		JButton mostrarTodas = new JButton("Mostrar Todas");
		JButton volver = new JButton("Volver");
		
		abrir.addActionListener(new ActionListener() {
			/**Accede al menu de abrir venta*/
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
				Controlador.obtenerInstancia().accion(Evento.abrirVenta, null);
			}
		});
		
		
		devolver.addActionListener(new ActionListener(){
			/**Accede al menu de cerrar venta */
			public void actionPerformed(ActionEvent e){
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirDevolverVenta, null);
			}
		});
		
		mostrarTodas.addActionListener(new ActionListener() {
			/**Accede al menu de mostrar todas las ventas*/
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.mostrarTodasVentas, null);
			}
		});
		
		mostrarUna.addActionListener(new ActionListener() {
			/**Accede al menu de mostrar venta*/
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMostrarUnaVenta, null);
			}
		});

		volver.addActionListener(new ActionListener() {
			/**Regresa al menu principal*/
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuPrincipal, null);
			}
		});

		panel.add(abrir);
		panel.add(devolver);
		panel.add(mostrarUna);
		panel.add(mostrarTodas);
		panel.add(volver);
		getContentPane().add(panel);
		
		pack();
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setLocation(450, 250);
		this.setSize(500, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}
}

