package presentacion.cliente;

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

/**Interfaz grafica del menu de cliente de la aplicacion*/
public class GUIMenuCliente extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actualizar(Evento evento, Object objeto) {

	}

	/**Constructora de la GUI. Contendra botones para cada una
	 * de las funciones de cliente.*/
	public GUIMenuCliente() {
		initGui();
	}

	private void initGui() {
		setTitle("Menu Cliente");
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2, 20, 20));
		
		JButton alta = new JButton("Alta");
		JButton baja = new JButton("Baja");
		JButton actualizar = new JButton("Actualizar");
		JButton mostrarUna = new JButton("Mostrar Uno");
		JButton mostrarTodas = new JButton("Mostrar Todos");
		JButton volver = new JButton("Volver");
		
		alta.addActionListener(new ActionListener() {
			/**Accede al menu de alta cliente*/
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirAltaCliente, null);
			}
		});
		
		baja.addActionListener(new ActionListener() {
			/**Accede al menu de baja cliente*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirBajaCliente, null);
			}
		});
		
		actualizar.addActionListener(new ActionListener() {
			/**Accede al menu de actualizar cliente*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirActualizarCliente, null);
			}
		});
		
		mostrarTodas.addActionListener(new ActionListener() {
			/**Accede al menu de mostrar todos clientes*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.mostrarTodosClientes, null);
			}
		});
		
		mostrarUna.addActionListener(new ActionListener() {
			/**Accede al menu de mostrar un cliente*/
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMostrarUnCliente, null);
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
