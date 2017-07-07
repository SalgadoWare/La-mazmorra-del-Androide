package presentacion.ventas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
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
import negocio.ventas.LineaVenta;
import negocio.ventas.TransferVentas;
import presentacion.GUI;
import presentacion.TipoGUI;
import presentacion.controlador.Controlador;
import presentacion.eventos.Evento;

/** Contiene las interfaces de las funciones de clasificacion */
public class GUIVentas extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	/**
	 * Muestra los mensajes de confirmacion o error de cada funcion de
	 * clasificacion
	 */
	public void actualizar(Evento evento, Object datos) {
		switch (evento) {

		// Mantened el orden alfabetico

		case cerrarVenta:
			String s = "Id: " + ((TransferVentas) datos).getIdVenta() + "\n    Cliente: " + ((TransferVentas) datos).getIdCliente()
			+ "\n    Precio: " + ((TransferVentas) datos).getPrecio() + "\n    Fecha: " + ((TransferVentas) datos).getFecha() + "\n    Productos: \n";
			Iterator<LineaVenta> iteradorProductos = ((TransferVentas) datos).getProductos().values().iterator();
			while(iteradorProductos.hasNext()){
				LineaVenta producto = iteradorProductos.next();
				s += "        Id: " + producto.getId() + " - Cantidad: " + producto.getCantidad() + " - Precio: " + producto.getPrecio() + '\n';
			}
			JOptionPane.showMessageDialog(null, "Venta realizada correctamente\n" + (String) s);
			break;

		case devolverVenta:
			JOptionPane.showMessageDialog(null, "Devolucion realizada correctamente");
			setVisible(true);
			break;

		case devolverVentaDuplicada:
			JOptionPane.showMessageDialog(null, "Esta venta ya ha sido devuelta");
			setVisible(true);
			break;
			
		case errorArgumentos:
			JOptionPane.showMessageDialog(null, "Error al introducir argumentos");
			setVisible(true);
			break;
			
		case errorDevolverVenta:
			JOptionPane.showMessageDialog(null, "ID de venta no existente");
			break;
			
		case errorCerrarVentaCliente:
			JOptionPane.showMessageDialog(null, "El cliente indicado no existe");
			break;
		
		case errorCerrarVentaCarrito:
			JOptionPane.showMessageDialog(null, "Los productos insertados no estan disponibles o no se ha insertado ningun producto");
			break;
			
		case errorMostrarTodasVentas:
			JOptionPane.showMessageDialog(null, "No existen ventas o error en entrada/salida");
			setVisible(true);
			break;

		case errorMostrarUnaVenta:
			JOptionPane.showMessageDialog(null, "ID de venta inexistente o error en entrada/salida");
			setVisible(true);
			break;
			
		case mostrarCarrito:
			actualizarMostrarCarrito((HashMap<Integer, LineaVenta>) datos);
			break;
			
		case mostrarTodasVentas:
			actualizarMostrarTodasVentas((TransferVentas[]) datos);
			break;

		case mostrarUnaVenta:
			actualizarMostrarUnaVenta((TransferVentas) datos);
			break;
			
		default:
			break;
		}
	}

	

	/**
	 * Constructora que crea el panel de cada una de las funciones de
	 * clasificaion. Cada accion pedira los datos que necesite y los ejecutara a
	 * traves del controlador.
	 */
	public GUIVentas(TipoGUI tipo) {
		if (tipo != null){
			switch (tipo) {
			case abrirVenta:
				
				Calendar c1 = GregorianCalendar.getInstance();
				int day = c1.get(Calendar.DAY_OF_MONTH);
				int month =	c1.get(Calendar.MONTH);
				int year = c1.get(Calendar.YEAR);
				TransferVentas tVen = new TransferVentas(day, month, year);
				
				initGUIAbrirVenta(tVen);
				break;
				
			case devolverVenta:
				initGuiDevolverVenta();
				break;

			case mostrarUno:
				initGuiMostrarUno();
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
	
	@SuppressWarnings("incomplete-switch")
	public GUIVentas(TipoGUI tipo, TransferVentas tVen){
		if (tipo != null){
			switch (tipo) {
			case abrirVenta:
				
				initGUIAbrirVenta(tVen);
				break;
			}
		}
	}
	
	private void initGUIAbrirVenta(TransferVentas tVentas){
		JPanel panel;
		JPanel dataPanel;
		JPanel clientePanel;
		JPanel productoPanel;
		JPanel buttonPanel;
		final JTextField tidProd;
		final JTextField tcantidad;
		final JTextField tidCli;
		JButton anadir;
		JButton eliminar;
		JButton cerrar;
		JButton cancelar;
		JButton mostrar;
		final TransferVentas tVen = tVentas;
		
		setTitle("Carrito");
		
		this.setLayout(new BorderLayout());
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		dataPanel = new JPanel();
		dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
		clientePanel = new JPanel();
		clientePanel.setLayout(new BoxLayout(clientePanel, BoxLayout.X_AXIS));
		productoPanel = new JPanel();
		productoPanel.setLayout(new FlowLayout());
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		tidProd = new JTextField(3);
		tcantidad = new JTextField(3);
		tidCli = new JTextField(3);
		
		tidCli.setPreferredSize(new Dimension(50, 25));
		tidCli.setMinimumSize(new Dimension(50, 25));
		tidCli.setMaximumSize(new Dimension(50, 25));
		tidProd.setPreferredSize(new Dimension(50, 25));
		tidProd.setMinimumSize(new Dimension(50, 25));
		tidProd.setMaximumSize(new Dimension(50, 25));
		tcantidad.setPreferredSize(new Dimension(50, 25));
		tcantidad.setMinimumSize(new Dimension(50, 25));
		tcantidad.setMaximumSize(new Dimension(50, 25));
		
		clientePanel.add(Box.createRigidArea(new Dimension(13, 25)));
		clientePanel.add(new JLabel("ID Cliente: "));
		clientePanel.add(tidCli);
		
		productoPanel.add(new JLabel("ID Producto: "));
		productoPanel.add(tidProd);
		productoPanel.add(new JLabel("Cantidad: "));
		productoPanel.add(tcantidad);
		
		anadir = new JButton("Aadir Producto");
		anadir.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String idPro = tidProd.getText();
				String cantidadPro = tcantidad.getText();
				if(!idPro.equals("") && !cantidadPro.equals("")){
					int errCod = tVen.anadirProducto(idPro, cantidadPro);
					switch(errCod){
					case 0:
						JOptionPane.showMessageDialog(new JFrame(), "Producto insertado");
						break;
					case 1:
						JOptionPane.showMessageDialog(new JFrame(), "Cantidad aumentada");
						break;
					case 2:
						JOptionPane.showMessageDialog(new JFrame(), "Error al insertar o aumentar el producto");
						break;
					}
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Datos invalidos");
				}
				tidProd.setText("");
				tcantidad.setText("");
			}
			
		});
		
		eliminar = new JButton("Eliminar Producto");
		eliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String idPro = tidProd.getText();
				String cantidadPro = tcantidad.getText();
				if(!idPro.equals("") && !cantidadPro.equals("")){
					int errCod = tVen.eliminarProducto(idPro, cantidadPro);
					switch(errCod){
					case 0:
						JOptionPane.showMessageDialog(new JFrame(), "Producto eliminado");
						break;
					case 1:
						JOptionPane.showMessageDialog(new JFrame(), "Cantidad reducida");
						break;
					case 2:
						JOptionPane.showMessageDialog(new JFrame(), "Error al eliminar o reducir el producto");
						break;
					}
				}
				else {
					JOptionPane.showMessageDialog(new JFrame(), "Datos invalidos");
				}
				tidProd.setText("");
				tcantidad.setText("");
				
			}
			
		});
		
		mostrar = new JButton("Mostrar Carrito");
		mostrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Controlador.obtenerInstancia().accion(Evento.mostrarCarrito, tVen.getProductos());
			}
			
		});
		
		cerrar = new JButton("Cerrar Venta");
		cerrar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String idCli = tidCli.getText();
				if(!idCli.equals("")){
					tVen.setIdCliente(idCli);
					Controlador.obtenerInstancia().accion(Evento.cerrarVenta, tVen);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca el ID del cliente");
				}
				
			}
			
		});
		
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuVenta, null);
				
			}
			
		});
		
		buttonPanel.add(anadir);
		buttonPanel.add(eliminar);
		buttonPanel.add(mostrar);
		buttonPanel.add(cerrar);
		buttonPanel.add(cancelar);
		
		productoPanel.setPreferredSize(new Dimension(500, 30));
		productoPanel.setMaximumSize(new Dimension(500, 30));
		productoPanel.setMinimumSize(new Dimension(500, 30));
		buttonPanel.setPreferredSize(new Dimension(500, 200));
		buttonPanel.setMaximumSize(new Dimension(500, 200));
		buttonPanel.setMinimumSize(new Dimension(500, 200));
		
		dataPanel.add(productoPanel);
		dataPanel.add(buttonPanel);
		
		panel.add(clientePanel, BorderLayout.NORTH);
		panel.add(dataPanel, BorderLayout.CENTER);
		
		this.add(panel);
		
		pack();
		
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.setLocation(450, 250);
		this.setSize(500, 170);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}



	private void initGuiDevolverVenta() {

		JPanel panel;
		JLabel lID;
		JButton aceptar;
		JButton cancelar;
		final JTextField tID;

		setTitle("Devolver una venta");

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 5, 5));

		lID = new JLabel("ID:");
		tID = new JTextField(3);

		aceptar = new JButton("Devolver");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tID.getText();
				if (id != ""){
					TransferVentas tVen = new TransferVentas(id);
					Controlador.obtenerInstancia().accion(Evento.devolverVenta, tVen);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca el ID de la venta");
				}
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuVenta, null);
			}
		});

		panel.add(lID);
		panel.add(tID);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		this.setSize(400,100);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
	private void initGuiMostrarUno() {

		JPanel panel;
		JLabel lID;
		JButton aceptar;
		JButton cancelar;
		final JTextField tIDMostrarUna;

		setTitle("Mostrar Una Venta");

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 5, 5));

		lID = new JLabel("ID:");
		tIDMostrarUna = new JTextField(3);

		aceptar = new JButton("Buscar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tIDMostrarUna.getText();
				if (id != ""){
					TransferVentas tVen = new TransferVentas(id);
					Controlador.obtenerInstancia().accion(Evento.mostrarUnaVenta, tVen);
					setVisible(false);
				} else {
					JOptionPane.showMessageDialog(new JFrame(), "Introduzca el ID de la venta");
				}
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuVenta, null);
			}
		});

		panel.add(lID);
		panel.add(tIDMostrarUna);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();
		
		this.setSize(400,100);
	}

	private void actualizarMostrarUnaVenta(TransferVentas tVen) {
		String s = "Id: " + tVen.getIdVenta() + "\n    Cliente: " + tVen.getIdCliente()
		+ "\n    Precio: " + tVen.getPrecio() + "\n    Fecha: " + tVen.getFecha() + "\n    Productos: \n";
		Iterator<LineaVenta> iteradorProductos = tVen.getProductos().values().iterator();
		while(iteradorProductos.hasNext()){
			LineaVenta producto = iteradorProductos.next();
			s += "        Id: " + producto.getId() + " - Cantidad: " + producto.getCantidad() + " - Precio: " + producto.getPrecio() + '\n';
		}
		if(tVen.getActivo().equals("No")){
			s += "La venta ha sido Devuelta";
		}
		JOptionPane.showMessageDialog(null, s);
		setVisible(true);
	}

	private void actualizarMostrarTodasVentas(TransferVentas[] datos) {
		String s = "";
		int i = 0;
		
		JFrame ventana = new JFrame();
		
		ventana.setTitle("Lista de Ventas");
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JScrollPane lista = new JScrollPane();
		lista.setBorder(new EmptyBorder(0,0,0,0));
		lista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JTextArea panel = new JTextArea();
		panel.setEditable(false);
		panel.setOpaque(false);
		
		JButton cancelar = new JButton("Volver");
		
		cancelar.addActionListener(new ActionListener() {
			/**Vuelve al menu de ventas*/				
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuVenta, null);
			}
		});
		
		for(TransferVentas tVen : datos){
			if (i < datos.length){
				s += "Id: " + tVen.getIdVenta() + "\n    Cliente: " + tVen.getIdCliente()
				+ "\n    Precio: " + tVen.getPrecio() + "\n    Fecha: " + tVen.getFecha() + "\n    Productos: \n";
				Iterator<LineaVenta> iteradorProductos = tVen.getProductos().values().iterator();
				while(iteradorProductos.hasNext()){
					LineaVenta producto = iteradorProductos.next();
					s += "        Id: " + producto.getId() + " - Cantidad: " + producto.getCantidad() + " - Precio: " + producto.getPrecio() + '\n';
				}
				if(tVen.getActivo().equals("No")){
					s += "    DEVUELTA\n";
				}
				
				s += "\n";
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
		
		lista.setPreferredSize(new Dimension(400,200));
		ventana.setSize(400,300);
		panel.setBorder(new EmptyBorder(5,5,5,5));
		ventana.setLocation(450, 250);
		ventana.setVisible(true);


	}
	
	private void actualizarMostrarCarrito(HashMap<Integer, LineaVenta> datos) {
		HashMap<Integer, LineaVenta> mapProductos = (HashMap<Integer, LineaVenta>) datos;
		Collection<LineaVenta> coleccionProductos = mapProductos.values();
		Iterator<LineaVenta> iteradorProductos = coleccionProductos.iterator();
		
		JFrame ventana = new JFrame();
		
		String s = "";
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		JScrollPane lista = new JScrollPane();
		lista.setBorder(new EmptyBorder(0,0,0,0));
		lista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JTextArea panel = new JTextArea();
		panel.setEditable(false);
		panel.setOpaque(false);
		
		while(iteradorProductos.hasNext()){
			LineaVenta producto = iteradorProductos.next();
			s += "Id: " + producto.getId() + " Cantidad: " + producto.getCantidad()
			+ "\n\n";
			panel.setText(s);
		}
		
		lista.getViewport().add(panel);
		
		mainPanel.add(lista, BorderLayout.CENTER);
		
		ventana.add(mainPanel);
		pack();
		
		lista.setPreferredSize(new Dimension(400,200));
		ventana.setSize(400,300);
		panel.setBorder(new EmptyBorder(5,5,5,5));
		ventana.setLocation(450, 250);
		ventana.setVisible(true);
		
		ventana.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
