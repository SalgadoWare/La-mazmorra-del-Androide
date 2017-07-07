package presentacion.menuprincipal;

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

/** Interfaz grafica del menu principal de la aplicacion */
public class GUIMenuPrincipal extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructora de la GUI. Contendra botones para cada una de las entidades
	 * de la aplicacion.
	 */
	public GUIMenuPrincipal() {
		initGui();
	}

	private void initGui() {
		setTitle("Menu Principal");

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2, 20, 20));

		JButton clasificacion = new JButton("Clasificacion");
		JButton clientes = new JButton("Clientes");
		JButton productos = new JButton("Productos");
		JButton proveedores = new JButton("Proveedores");
		JButton ventas = new JButton("Ventas");

		clasificacion.addActionListener(new ActionListener() {
			/** Accede al menu de clasificacion */
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuClasificacion, null);
			}
		});
		
		clientes.addActionListener(new ActionListener() {
			/** Accede al menu de cliente */
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);
			}
		});
		
		productos.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuProducto, null);
			}
		});
		
		proveedores.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuProveedores, null);
			}
		});
		
		ventas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuVenta, null);
			}
		});

		panel.add(clasificacion);
		panel.add(clientes);
		panel.add(productos);
		panel.add(proveedores);
		panel.add(ventas);
		// aade el panel a los componentes
		this.getContentPane().add(panel);

		pack();

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		this.setLocation(450, 250);
		this.setSize(500, 200);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
	}

	@Override
	public void actualizar(Evento evento, Object objeto) {
		// TODO Auto-generated method stub
		
	}

}
