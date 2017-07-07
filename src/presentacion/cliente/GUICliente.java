package presentacion.cliente;

import java.awt.BorderLayout;
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

import negocio.cliente.TransferCliente;
import negocio.cliente.TransferClienteEstandar;
import negocio.cliente.TransferClienteVip;
import presentacion.GUI;
import presentacion.TipoGUI;
import presentacion.controlador.Controlador;
import presentacion.eventos.Evento;

/** Contiene las interfaces de las funciones de cliente */
public class GUICliente extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Muestra los mensajes de confirmacion o error de cada funcion de cliente
	 */
	public void actualizar(Evento evento, Object datos) {
		switch (evento) {

		// Mantened el orden alfabetico

		case actualizarCliente:
			JOptionPane.showMessageDialog(null, "Actualizacion realizada correctamente");
			setVisible(true);
			break;

		case altaCliente:
			JOptionPane.showMessageDialog(null, "Alta realizada correctamente con id:" + (String) datos);
			setVisible(true);
			break;

		case altaClienteDuplicado:
			JOptionPane.showMessageDialog(null, "Este cliente ya estaba en el sistema, se ha activado");
			setVisible(true);
			break;

		case bajaCliente:
			JOptionPane.showMessageDialog(null, "Baja realizada correctamente");
			setVisible(true);
			break;

		case bajaClienteDuplicado:
			JOptionPane.showMessageDialog(null, "Este cliente ya esta dado de baja");
			setVisible(true);
			break;

		case errorAltaCliente:
			JOptionPane.showMessageDialog(null, "El cliente ya existe y esta activo");
			setVisible(true);
			break;

		case errorActualizarCliente:
			JOptionPane.showMessageDialog(null, "Id del cliente inexistente o error en entrada/salida");
			setVisible(true);
			break;

		case errorBajaCliente:
			JOptionPane.showMessageDialog(null, "Id del cliente inexistente o error en entrada/salida");
			setVisible(true);
			break;

		case errorArgumentos:
			JOptionPane.showMessageDialog(null, "Error al introducir argumentos");
			setVisible(true);
			break;
			
		case errorCambioTipoCliente:
			JOptionPane.showMessageDialog(null, "Error: no se puede cambiar el tipo de un cliente");
			setVisible(true);
			break;

		case errorMostrarTodosClientes:
			JOptionPane.showMessageDialog(null, "No existen clientes o error en entrada/salida");
			setVisible(true);
			break;

		case errorMostrarUnCliente:
			JOptionPane.showMessageDialog(null, "Id del cliente inexistente o error en entrada/salida");
			setVisible(true);
			break;

		case mostrarTodosClientes:
			actualizarMostrarTodosClientes((TransferCliente[]) datos);
			break;

		case mostrarUnCliente:
			actualizarMostrarUnCliente((TransferCliente) datos);
			break;
		default:
			break;
		}
	}

	/**
	 * Constructora que crea el panel de cada una de las funciones de cliente.
	 * Cada accion pedira los datos que necesite y los ejecutara a traves del
	 * controlador.
	 */
	public GUICliente(TipoGUI tipo) {
		if(tipo != null){
			switch (tipo) {
			case alta:
				initGuiAlta();
				break;
				
			case altaEstandar:
				initGuiAltaEstandar();
				break;
				
			case altaVip:
				initGuiAltaVip();
				break;
				
			case actualizar:
				initGuiActualizar();
				break;
				
			case actualizarEstandar:
				initGuiActualizarEstandar();
				break;
				
			case actualizarVip:
				initGuiActualizarVip();
				break;
				
			case baja:
				initGuiBaja();
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

	private void initGuiAlta() {
		setTitle("Alta Cliente");
		
		JPanel tipoCliente = new JPanel();
		tipoCliente.setLayout(new GridLayout(1, 3, 5, 5));
		
		JButton vip = new JButton("Vip");
		JButton estandar = new JButton("Estandar");
		JButton cancelar = new JButton("Cancelar");
		
		vip.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirAltaClienteVip, null);
			}
		});
		estandar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirAltaClienteEstandar, null);	
			}
		});
		
		cancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);	
			}
		});
		
		tipoCliente.add(vip);
		tipoCliente.add(estandar);
		tipoCliente.add(cancelar);
		getContentPane().add(tipoCliente);
		pack();
		this.setSize(400,100);

	}
	
	private void initGuiAltaEstandar() {
		JPanel panel;
		JLabel lNombre;
		JLabel lDireccion;
		JLabel lCorreo;
		JButton aceptar;
		JButton cancelar;
		final JTextField tNombreAlta;
		final JTextField tDireccionAlta;
		final JTextField tCorreoAlta;

		setTitle("Alta Cliente");

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1, 5, 5));

		lNombre = new JLabel("Nombre:");
		tNombreAlta = new JTextField(20);
		lDireccion = new JLabel("Direccion:");
		tDireccionAlta = new JTextField(20);
		lCorreo = new JLabel("Correo:");
		tCorreoAlta = new JTextField(20);
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = tNombreAlta.getText();
				String direccion = tDireccionAlta.getText();
				String correo = tCorreoAlta.getText();
				TransferClienteEstandar transferCliente = new TransferClienteEstandar(nombre, direccion, correo);
				dispose();
				Controlador.obtenerInstancia().accion(Evento.altaCliente, transferCliente);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);
			}
		});

		panel.add(lNombre);
		panel.add(tNombreAlta);
		panel.add(lDireccion);
		panel.add(tDireccionAlta);
		panel.add(lCorreo);
		panel.add(tCorreoAlta);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
	private void initGuiAltaVip() {
		JPanel panel;
		JLabel lNombre;
		JLabel lDireccion;
		JLabel lCorreo;
		JLabel lDescuento;
		JButton aceptar;
		JButton cancelar;
		final JTextField tNombreAlta;
		final JTextField tDireccionAlta;
		final JTextField tCorreoAlta;
		final JTextField tDescuentoAlta;

		setTitle("Alta Cliente");

		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1, 5, 5));
		

		lNombre = new JLabel("Nombre:");
		tNombreAlta = new JTextField(20);
		lDireccion = new JLabel("Direccion:");
		tDireccionAlta = new JTextField(20);
		lCorreo = new JLabel("Correo:");
		tCorreoAlta = new JTextField(20);
		lDescuento = new JLabel("Descuento (%):");
		tDescuentoAlta = new JTextField(3);
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombre = tNombreAlta.getText();
				String direccion = tDireccionAlta.getText();
				String correo = tCorreoAlta.getText();
				String descuento = tDescuentoAlta.getText();
				TransferClienteVip transferCliente = new TransferClienteVip(nombre, direccion, correo, descuento);
				dispose();
				Controlador.obtenerInstancia().accion(Evento.altaCliente, transferCliente);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);
			}
		});

		panel.add(lNombre);
		panel.add(tNombreAlta);
		panel.add(lDireccion);
		panel.add(tDireccionAlta);
		panel.add(lCorreo);
		panel.add(tCorreoAlta);
		panel.add(lDescuento);
		panel.add(tDescuentoAlta);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}
	
	private void initGuiBaja() {

		JPanel panel;
		JLabel lID;
		JButton aceptar;
		JButton cancelar;
		final JTextField tIDBaja;

		setTitle("Eliminar Un Cliente");

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 5, 5));

		lID = new JLabel("ID:");
		tIDBaja = new JTextField(3);

		aceptar = new JButton("Eliminar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tIDBaja.getText();
				TransferCliente transferCliente = new TransferCliente(id);
				Controlador.obtenerInstancia().accion(Evento.bajaCliente, transferCliente);
				setVisible(false);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);
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

		JPanel panel;
		JLabel lID;
		JButton aceptar;
		JButton cancelar;
		final JTextField tIDMostrarUno;

		setTitle("Mostrar Un Cliente");

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 5, 5));

		lID = new JLabel("ID:");
		tIDMostrarUno = new JTextField(3);
		
		aceptar = new JButton("Buscar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tIDMostrarUno.getText();
				TransferCliente tCli = new TransferCliente(id);
				Controlador.obtenerInstancia().accion(Evento.mostrarUnCliente, tCli);
				setVisible(false);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);
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

	private void initGuiActualizar() {
		setTitle("Actualizar Cliente");
		
		JPanel tipoCliente = new JPanel();
		tipoCliente.setLayout(new GridLayout(1, 3, 5, 5));
		
		JButton vip = new JButton("Vip");
		JButton estandar = new JButton("Estandar");
		JButton cancelar = new JButton("Cancelar");
		
		vip.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirActualizarClienteVip, null);
			}
		});
		estandar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirActualizarClienteEstandar, null);	
			}
		});
		
		cancelar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dispose();
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);	
			}
		});
		
		tipoCliente.add(vip);
		tipoCliente.add(estandar);
		tipoCliente.add(cancelar);
		getContentPane().add(tipoCliente);
		pack();
		this.setSize(400,100);
		
	}

	private void initGuiActualizarEstandar() {

		JPanel panel;
		JLabel lNombre;
		JLabel lDireccion;
		JLabel lCorreo;
		JLabel lID;
		JButton aceptar;
		JButton cancelar;
		final JTextField tNombreUpdate;
		final JTextField tDireccionUpdate;
		final JTextField tCorreoUpdate;
		final JTextField tIDUpdate;
		setTitle("Actualizar Cliente");

		panel = new JPanel();
		panel.setLayout(new GridLayout(5, 1, 5, 5));

		lID = new JLabel("ID:");
		tIDUpdate = new JTextField(3);
		lNombre = new JLabel("Nombre:");
		tNombreUpdate = new JTextField(20);
		lDireccion = new JLabel("Direccion:");
		tDireccionUpdate = new JTextField(20);
		lCorreo = new JLabel("Correo:");
		tCorreoUpdate = new JTextField(20);

		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idupdate = tIDUpdate.getText();
				String nombre = tNombreUpdate.getText();
				String direccion = tDireccionUpdate.getText();
				String correo = tCorreoUpdate.getText();
				TransferClienteEstandar transferCliente = new TransferClienteEstandar(idupdate, nombre, direccion, correo);
				dispose();
				Controlador.obtenerInstancia().accion(Evento.actualizarCliente, transferCliente);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);
			}
		});

		panel.add(lID);
		panel.add(tIDUpdate);
		panel.add(lNombre);
		panel.add(tNombreUpdate);
		panel.add(lDireccion);
		panel.add(tDireccionUpdate);
		panel.add(lCorreo);
		panel.add(tCorreoUpdate);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

	}

	private void initGuiActualizarVip() {

		JPanel panel;
		JLabel lNombre;
		JLabel lDireccion;
		JLabel lCorreo;
		JLabel lDescuento;
		JLabel lID;
		JButton aceptar;
		JButton cancelar;
		final JTextField tNombreUpdate;
		final JTextField tDireccionUpdate;
		final JTextField tCorreoUpdate;
		final JTextField tDescuentoUpdate;
		final JTextField tIDUpdate;
		setTitle("Actualizar Cliente");

		panel = new JPanel();
		panel.setLayout(new GridLayout(6, 1, 5, 5));

		lID = new JLabel("ID:");
		tIDUpdate = new JTextField(3);
		lNombre = new JLabel("Nombre:");
		tNombreUpdate = new JTextField(20);
		lDireccion = new JLabel("Direccion:");
		tDireccionUpdate = new JTextField(20);
		lCorreo = new JLabel("Correo:");
		tCorreoUpdate = new JTextField(20);
		lDescuento = new JLabel("Descuento:");
		tDescuentoUpdate = new JTextField(3);

		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idupdate = tIDUpdate.getText();
				String nombre = tNombreUpdate.getText();
				String direccion = tDireccionUpdate.getText();
				String correo = tCorreoUpdate.getText();
				String descuento = tDescuentoUpdate.getText();
				TransferClienteVip transferCliente = new TransferClienteVip(idupdate, nombre, direccion, correo, descuento);
				dispose();
				Controlador.obtenerInstancia().accion(Evento.actualizarCliente, transferCliente);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);
			}
		});

		panel.add(lID);
		panel.add(tIDUpdate);
		panel.add(lNombre);
		panel.add(tNombreUpdate);
		panel.add(lDireccion);
		panel.add(tDireccionUpdate);
		panel.add(lCorreo);
		panel.add(tCorreoUpdate);
		panel.add(lDescuento);
		panel.add(tDescuentoUpdate);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

	}

	private void actualizarMostrarUnCliente(TransferCliente tCli) {
		String advertencia = "";
		if (tCli.getActivo().equals("No")) {
			advertencia = "\nADVERTENCIA El cliente esta inactivo";
		}
		JOptionPane.showMessageDialog(null, tCli.toString() + advertencia);
		setVisible(true);
	}

	private void actualizarMostrarTodosClientes(TransferCliente[] datos) {
		String s = "";
		int i = 0;

		JFrame ventana = new JFrame();
		ventana.setTitle("Lista de Clientes");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		JScrollPane lista = new JScrollPane();
		lista.setBorder(new EmptyBorder(0, 0, 0, 0));
		lista.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

		JTextArea panel = new JTextArea();
		panel.setEditable(false);
		panel.setOpaque(false);

		JButton cancelar = new JButton("Volver");

		cancelar.addActionListener(new ActionListener() {
			/** Vuelve al menu de cliente */
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuCliente, null);
			}
		});

		for (TransferCliente tCli : datos) {
			if (i < datos.length) {
				s += tCli.toString() + '\n';
				if (tCli.getActivo().equals("No"))
					s += "    Activo: No";
				else 
					s += "    Activo: Si";
				s += "\n\n";
				i++;
				panel.setText(s);
			} else {
				break;
			}
		}
		;

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

}
