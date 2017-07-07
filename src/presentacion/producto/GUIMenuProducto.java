package presentacion.producto;

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
public class GUIMenuProducto extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actualizar(Evento evento, Object objeto) {

	}

	/**Constructora de la GUI. Contendra botones para cada una`
	 * de las funciones de clasificacion.*/
	public GUIMenuProducto() {
		
		initGui();}

	private void initGui() {
		
		setTitle("Menu Producto");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2, 20, 20));
		
		JButton alta = new JButton("Alta");
		JButton baja = new JButton("Baja");
		JButton actualizar = new JButton("Actualizar");
		JButton mostrarUno = new JButton("Mostrar Uno");
		JButton mostrarTodos = new JButton("Mostrar Todos");
		JButton volver = new JButton("Volver");
		
		alta.addActionListener(new ActionListener() {
			/**Accede al menu de alta clasificacion*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirAltaProducto, null);
			}
		});
		
		baja.addActionListener(new ActionListener() {
			/**Accede al menu de baja clasificacion*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirBajaProducto, null);
			}
		});
		
		actualizar.addActionListener(new ActionListener() {
			/**Accede al menu de actualizar clasificacion*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirActualizarProducto, null);
			}
		});
		
		mostrarTodos.addActionListener(new ActionListener() {
			/**Accede al menu de mostrar todas clasificaciones*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.mostrarTodosProductos, null);
			}
		});
		
		mostrarUno.addActionListener(new ActionListener() {
			/**Accede al menu de mostrar una clasificacion*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMostrarUnProducto, null);
			}
		});

		volver.addActionListener(new ActionListener() {
			/**Regresa al menu principal*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuPrincipal, null);
			}
		});

		panel.add(alta);
		panel.add(baja);
		panel.add(actualizar);
		panel.add(mostrarUno);
		panel.add(mostrarTodos);
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
