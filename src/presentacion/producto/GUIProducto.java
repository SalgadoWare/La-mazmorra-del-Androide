package presentacion.producto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import negocio.producto.TransferProducto;
import presentacion.GUI;
import presentacion.TipoGUI;
import presentacion.controlador.Controlador;
import presentacion.eventos.Evento;

public class GUIProducto extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actualizar(Evento evento, Object datos) {
		switch (evento) {

		case actualizarProducto:
			JOptionPane.showMessageDialog(null, "Actualizacion correcta del producto con id: " + datos);
			break;

		case altaProducto:
			JOptionPane.showMessageDialog(null, "Alta realizada correctamente con id:" + datos);
			break;

		case altaProductoDuplicado:
			JOptionPane.showMessageDialog(null, "Esta producto ya estaba en el sistema, se ha activado");
			setVisible(true);
			break;

		case bajaProducto:
			JOptionPane.showMessageDialog(null, " El producto con id " + datos + " ha sido dado de baja");
			setVisible(true);
			break;

		case errorActualizarProducto:
			JOptionPane.showMessageDialog(null, "Id del producto inexistente o error en entrada/salida");
			setVisible(true);
			break;

		case errorActualizarProductoPorIdClasificacion:
			JOptionPane.showMessageDialog(null, "Id de la clasificacion inexistente o error en entrada/salida");
			setVisible(true);
			break;
			
		case errorActualizarProductoConProveedorInexistente:	
			JOptionPane
			.showMessageDialog(null, "Id del proveedor inexistente o error en entrada/salida");
			setVisible(true);
			break;
			
		case errorAltaProducto:
			JOptionPane.showMessageDialog(null, "Error en el proceso de dar de alta a un producto");
			setVisible(true);
			break;

		case errorAltaProductoSinClasificacion:
			JOptionPane
					.showMessageDialog(null, "Id de la clasificacion inexistente o error en entrada/salida");
			setVisible(true);
			break;
			
		case errorAltaProductoSinProveedor:
			JOptionPane
			.showMessageDialog(null, "Id del proveedor inexistente o error en entrada/salida");
			setVisible(true);
			break;

		case errorArgumentos:
			JOptionPane.showMessageDialog(null, "Error al introducir argumentos");
			setVisible(true);
			break;

		case errorBajaProducto:
			JOptionPane.showMessageDialog(null, "Id del producto no existente o error en entrada/salida");
			setVisible(true);
			break;

		case errorBajaProductoDuplicado:
			JOptionPane.showMessageDialog(null, "El producto ya estaba dado de baja");
			setVisible(true);
			break;

		case errorMostrarTodosProductos:
			JOptionPane.showMessageDialog(null, "No existen productos o error en entrada/salida");
			setVisible(true);
			break;

		case errorMostrarUnProducto:
			JOptionPane.showMessageDialog(null, "Id del producto inexistente o error en entrada/salida");
			setVisible(true);
			break;

		case mostrarTodosLosProductos:
			actualizarMostrarTodosProductos((TransferProducto[]) datos);
			break;
			
		case mostrarUnProducto:
			actualizarMostrarUnProducto((TransferProducto) datos);
			break;

		default:
			break;
		}
	}
	
	
	
	
	public GUIProducto(TipoGUI tipo) {
		if(tipo != null){
			switch (tipo) {
			case alta:
				initGuiAlta();
				break;
	
			case baja:
				initGuiBaja();
				break;
	
			case mostrarUno:
				initGuiMostrarUno();
				break;
				
			case actualizar:
				initGuiUpdate();
				break;
	
			default:
				break;
			}

			this.setLocation(450, 250);
			this.setVisible(true);
			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setResizable(false);
		}
	}
	
	
	//Ordenado alfabficamente el switch anterior
	
	
	private void initGuiAlta() {
		JPanel panel;
		JLabel lPrecio;
		JLabel lStock;
		JLabel nombre;
		JLabel idClasificacion;
		JLabel so;
		JLabel idProveedor;
		JButton aceptar;
		JButton cancelar;
		final JTextField tSo;
		final JTextField tPrecio;
		final JTextField tStock;
		final JTextField tNombre;
		final JTextField tIdClasificacion;
		final JTextField tidProveedor;

		setTitle("Alta Producto");

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1, 5, 5));

		lPrecio = new JLabel("Precio:");
		tPrecio = new JTextField(3);
		lStock = new JLabel("Numero de ejemplares:");
		tStock = new JTextField(20);
		nombre = new JLabel("Nombre del videojuego:");
		tNombre = new JTextField(20);
		idClasificacion = new JLabel("Id de su clasificacion:");
		tIdClasificacion = new JTextField(20);
		so = new JLabel("Version del Sistema Operativo:");
		tSo = new JTextField(20);
		idProveedor =  new JLabel("Id del proveedor:");
		tidProveedor = new JTextField(20);
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String price = tPrecio.getText();
				String stock = tStock.getText();
				String idC = tIdClasificacion.getText();
				String so = tSo.getText();
				String name = tNombre.getText();
				String idProveedor = tidProveedor.getText();

				TransferProducto tPro = new TransferProducto(price, stock, idC,
						so, name, idProveedor);
				dispose();
				Controlador.obtenerInstancia()
						.accion(Evento.altaProducto, tPro);
				
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuProducto,
						null);
			}
		});

		panel.add(nombre);
		panel.add(tNombre);
		panel.add(so);
		panel.add(tSo);
		panel.add(lStock);
		panel.add(tStock);
		panel.add(idClasificacion);
		panel.add(tIdClasificacion);
		panel.add(lPrecio);
		panel.add(tPrecio);
		panel.add(idProveedor);
		panel.add(tidProveedor);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

	}
	
	
	private void initGuiBaja() {
		JPanel panel = new JPanel();
		JLabel lID = new JLabel("ID:");
		JButton aceptar = new JButton("Eliminar");
		JButton cancelar = new JButton("Cancelar");
		final JTextField tIDBaja = new JTextField(3);

		setTitle("Eliminar Un Producto");
		panel.setLayout(new GridLayout(2, 1, 5, 5));

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tIDBaja.getText();
				TransferProducto transferClasificacion = new TransferProducto(
						id);
				dispose();
				Controlador.obtenerInstancia().accion(Evento.bajaProducto,
						transferClasificacion);
			
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuProducto,
						null);
			}
		});

		panel.add(lID);
		panel.add(tIDBaja);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		this.setSize(400, 100);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

	}
	
	private void initGuiMostrarUno() {

		JPanel panel = new JPanel();
		JLabel lID = new JLabel("ID:");
		JButton aceptar = new JButton("Buscar");
		JButton cancelar = new JButton("Cancelar");
		final JTextField tIDMostrarUno = new JTextField(3);

		setTitle("Mostrar Un Producto");

		panel.setLayout(new GridLayout(2, 1, 5, 5));

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tIDMostrarUno.getText();
				TransferProducto tPro = new TransferProducto(id);
				dispose();
				Controlador.obtenerInstancia().accion(Evento.mostrarUnProducto,
						tPro);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuProducto,
						null);
			}
		});

		panel.add(lID);
		panel.add(tIDMostrarUno);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		this.setSize(400, 100);
	}

	

	private void initGuiUpdate() {
		JPanel panel;
		JLabel lPrecio;
		JLabel lStock;
		JLabel nombre;
		JLabel idClasificacion;
		JLabel so;
		JLabel idProveedor;
		JLabel id = new JLabel("Id:");
		JButton aceptar;
		JButton cancelar;
		final JTextField tSo;
		final JTextField tPrecio;
		final JTextField tStock;
		final JTextField tNombre;
		final JTextField tIdClasificacion;
		final JTextField tId = new JTextField(3);
		final JTextField tidProveedor; 
		
		setTitle("Actualizar Producto");

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4, 2, 2));

		lPrecio = new JLabel("Precio:");
		tPrecio = new JTextField(3);
		lStock = new JLabel("Numero de ejemplares:");
		tStock = new JTextField(20);
		nombre = new JLabel("Nombre del videojuego:");
		tNombre = new JTextField(20);
		idClasificacion = new JLabel("Id de su clasificacion:");
		tIdClasificacion = new JTextField(20);
		so = new JLabel("Version del Sistema Operativo:");
		tSo = new JTextField(20);
		idProveedor = new JLabel("Id del proveedor:");
		tidProveedor = new JTextField(20);
		
		
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String price = tPrecio.getText();
				String stock = tStock.getText();
				String idC = tIdClasificacion.getText();
				String so = tSo.getText();
				String name = tNombre.getText();
				String id = tId.getText();
				String idProveedor = tidProveedor.getText();
				TransferProducto tPro = new TransferProducto(id, price, stock,
						idC, so, name, idProveedor);
				dispose();
				Controlador.obtenerInstancia().accion(
						Evento.actualizarProducto, tPro);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuProducto,
						null);
			}
		});

		panel.add(id);
		panel.add(tId);
		panel.add(nombre);
		panel.add(tNombre);
		panel.add(so);
		panel.add(tSo);
		panel.add(lStock);
		panel.add(tStock);
		panel.add(idClasificacion);
		panel.add(tIdClasificacion);
		panel.add(lPrecio);
		panel.add(tPrecio);
		panel.add(idProveedor);
		panel.add(tidProveedor);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
	
	//Actualizar
	
	
	private void actualizarMostrarTodosProductos(
			TransferProducto[] datos) {
		String s = "";
		int i = 0;

		JFrame ventana = new JFrame();

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.LIGHT_GRAY);

		JScrollPane lista = new JScrollPane();
		lista.setBorder(new EmptyBorder(0, 0, 0, 0));
		lista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		JTextArea panel = new JTextArea();
		panel.setEditable(false);
		panel.setOpaque(false);

		JButton cancelar = new JButton("Volver");

		cancelar.addActionListener(new ActionListener() {
			/** Vuelve al menu de clasificacion */
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuProducto,
						null);
			}
		});

		for (TransferProducto tProducto : datos) {
			if (i < datos.length) {
				s += "Id: " + tProducto.getId() + "\n    Nombre: "
						+ tProducto.getName()
						+ "\n    Version del Sistema Operativo: "
						+ tProducto.getSo() + "\n    Stock: "
						+ tProducto.getStock() + "\n    Id de su clasificacion: "
						+ tProducto.getIdClasificacion() + "\n    Precio: "
						+ tProducto.getPrecio() + "\n    Id del proveedor: " 
						+ tProducto.getIdProveedor() + "\n    Activo: "
						+ tProducto.getActivo() + "\n\n";
				i++;
				panel.setText(s);
			} else {
				break;
			}
		};

		lista.getViewport().add(panel);

		mainPanel.add(lista, BorderLayout.CENTER);
		mainPanel.add(cancelar, BorderLayout.SOUTH);

		ventana.add(mainPanel);
		pack();

		lista.setPreferredSize(new Dimension(400, 200));
		ventana.setSize(400, 300);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		ventana.setLocation(450, 250);
		ventana.setVisible(true);

	}
	
	private void actualizarMostrarUnProducto(TransferProducto tPro) {
		String advertencia = "";
		if (tPro.getActivo().equals("No")) {
			advertencia = "\nADVERTENCIA El producto esta inactivo";
		}
		JOptionPane.showMessageDialog(
				null,

				"Id: " + tPro.getId() + "\nNombre: " + tPro.getName() +

				"\nVersion del Sistema Operativo: " + tPro.getSo()
						+ "\nStock: " + tPro.getStock()
						+ "\nId de su clasificacion: "
						+ tPro.getIdClasificacion() + "\nPrecio: "
						+ tPro.getPrecio() + "\nId del proveedor: " + tPro.getIdProveedor() 
						+ advertencia);

		setVisible(true);
	}

	
}
