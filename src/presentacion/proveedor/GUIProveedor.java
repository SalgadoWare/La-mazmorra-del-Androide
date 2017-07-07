package presentacion.proveedor;

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


import negocio.proveedor.TransferProveedor;
import presentacion.GUI;
import presentacion.TipoGUI;
import presentacion.controlador.Controlador;
import presentacion.eventos.Evento;

public class GUIProveedor extends JFrame implements GUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	/**
	 * Muestra los mensajes de confirmacion o error de cada funcion de
	 * clasificacion
	 */
	public void actualizar(Evento evento, Object datos) {
		switch (evento) {
		case actualizarProveedor:
			JOptionPane.showMessageDialog(null, "Actualizacion realizada correctamente");
			setVisible(true);
			break;
		
		case altaProveedor:
			JOptionPane.showMessageDialog(null, "Alta realizada correctamente con id:" + (String) datos);
			setVisible(true);
			break;

		case altaProveedorDuplicado:
			JOptionPane.showMessageDialog(null, "Este proveedor ya estaba en el sistema, se ha activado");
			setVisible(true);
			break;

		case bajaProveedor:
			JOptionPane.showMessageDialog(null, "Baja realizada correctamente");
			setVisible(true);
			break;

		case bajaProveedorDuplicado:
			JOptionPane.showMessageDialog(null, "Este proveedor ya esta dado de baja");
			setVisible(true);
			break;
			
		case errorActualizarProveedor:
			JOptionPane.showMessageDialog(null, "Id de la clasificacion inexistente o error en entrada/salida");
			setVisible(true);
			break;
			
			
		case errorAltaProveedor:
			JOptionPane.showMessageDialog(null, "El proveedor ya existe");
			setVisible(true);
			break;


		case errorArgumentos:
			JOptionPane.showMessageDialog(null, "Error al introducir argumentos");
			setVisible(true);
			break;

		case errorBajaProveedor:
			JOptionPane.showMessageDialog(null, "Id de proveedor no existente o error en entrada/salida");
			setVisible(true);
			break;

		case errorMostrarTodosProveedores:
			JOptionPane.showMessageDialog(null, "No existen proveedores o error en entrada/salida");
			setVisible(true);
			break;
			
		case errorMostrarUnProveedor:
			JOptionPane.showMessageDialog(null, "Id de proveedor inexistente o error en entrada/salida");
			setVisible(true);
			break;
			
		case errorProductosAsignados:
			JOptionPane.showMessageDialog(null, "Este proveedor tiene productos asociados, no se puede eliminar");
			setVisible(true);
			break;
		
		case mostrarTodosProveedores:
			actualizarMostrarTodosProveedores((TransferProveedor[]) datos);
			break;
		
		case mostrarUnProveedor:
			actualizarMostrarUnProveedor((TransferProveedor) datos);
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
	public GUIProveedor(TipoGUI tipo) {
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

	//Ordenado alfabticamente segn el switch
	
	private void initGuiAlta() {
		JPanel panel;
		JLabel lNombre;
		JLabel lPais;
		JButton aceptar;
		JButton cancelar;
		final JTextField tNombreAlta;
		final JTextField tPaisAlta;

		setTitle("Alta Proveedor");

		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 5, 5));

		lNombre = new JLabel("Nombre:");
		tNombreAlta = new JTextField(3);
		lPais = new JLabel("Pais:");
		tPaisAlta = new JTextField(20);
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String nombre = tNombreAlta.getText();
				String pais = tPaisAlta.getText();
				TransferProveedor transferProveedor = new TransferProveedor(
						nombre, pais);
				dispose();
				Controlador.obtenerInstancia().accion(Evento.altaProveedor,
						transferProveedor);
				
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(
						Evento.abrirMenuProveedores, null);
			}
		});

		panel.add(lNombre);
		panel.add(tNombreAlta);
		panel.add(lPais);
		panel.add(tPaisAlta);
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

		setTitle("Eliminar Un Proveedor");

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 5, 5));

		lID = new JLabel("ID:");
		tIDBaja = new JTextField(3);

		aceptar = new JButton("Eliminar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String id = tIDBaja.getText();
				TransferProveedor transProveedor = new TransferProveedor(id);
				dispose();
				Controlador.obtenerInstancia().accion(Evento.bajaProveedor,
						transProveedor);
				
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Controlador.obtenerInstancia().accion(
						Evento.abrirMenuProveedores, null);
			}
		});

		panel.add(lID);
		panel.add(tIDBaja);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}	
	
	private void initGuiMostrarUno() {

		 JPanel panel;
		 JLabel lID;
		 JButton aceptar;
		 JButton cancelar;
		 final JTextField tIDMostrarUno;
		
		 setTitle("Mostrar un Proveedor");
		
		 panel = new JPanel();
		 panel.setLayout(new GridLayout(2, 1, 5, 5));
		
		 lID = new JLabel("ID:");
		 tIDMostrarUno = new JTextField(3);
		
		 aceptar = new JButton("Buscar");
		 cancelar = new JButton("Cancelar");
		
		 aceptar.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		 String id = tIDMostrarUno.getText();
		 TransferProveedor tProv = new TransferProveedor(id);
		 Controlador.obtenerInstancia().accion(Evento.mostrarUnProveedor,
		 tProv);
		 setVisible(false);
		 }
		 });
		
		 cancelar.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		 setVisible(false);
		 Controlador.obtenerInstancia().accion(Evento.abrirMenuPrincipal,
		 null);
		 }
		 });
		
		 panel.add(lID);
		 panel.add(tIDMostrarUno);
		 panel.add(aceptar);
		 panel.add(cancelar);
		 getContentPane().add(panel);
		
		 pack();
	}


	private void initGuiUpdate() {

		 JPanel panel;
		 JLabel lNombre;
		 JLabel lPais;
		 JLabel lID;
		 JButton aceptar;
		 JButton cancelar;
		 final JTextField tNombreUpdate;
		 final JTextField tPaisUpdate;
		 final JTextField tIDUpdate;
		 setTitle("Actualizar Proveedor");

		 panel = new JPanel();
		 panel.setLayout(new GridLayout(4, 1, 5, 5));
		
		 lID = new JLabel("ID:");
		 tIDUpdate = new JTextField(3);
		 lNombre = new JLabel("Nombre:");
		 tNombreUpdate = new JTextField(3);
		 lPais = new JLabel("Pais:");
		 tPaisUpdate = new JTextField(20);
		
		 aceptar = new JButton("Aceptar");
		 cancelar = new JButton("Cancelar");
	
		 aceptar.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		 String idupdate = tIDUpdate.getText();
		 String nombre = tNombreUpdate.getText();
		 String pais = tPaisUpdate.getText();
		 TransferProveedor transferProveedor = new TransferProveedor(idupdate, "Si", nombre, pais);
		 Controlador.obtenerInstancia().accion(Evento.actualizarProveedor, transferProveedor);
		 setVisible(false);
		 }
		 });
		
		 cancelar.addActionListener(new ActionListener() {
		 public void actionPerformed(ActionEvent e) {
		 setVisible(false);
		 Controlador.obtenerInstancia().accion(Evento.abrirMenuProveedores,
		 null);
		 }
		 });
		
		 panel.add(lID);
		 panel.add(tIDUpdate);
		 panel.add(lNombre);
		 panel.add(tNombreUpdate);
		 panel.add(lPais);
		 panel.add(tPaisUpdate);
		 panel.add(aceptar);
		 panel.add(cancelar);
		 getContentPane().add(panel);
		
		 pack();
		
		 panel.setBorder(new EmptyBorder(5, 5, 5, 5));

	}

	
	//Actualizar Mostrar
	
	private void actualizarMostrarTodosProveedores(TransferProveedor[] datos) {
		// TODO Auto-generated method stub
		String s = "";
		int i = 0;
		
		JFrame ventana = new JFrame();
		
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
			/**Vuelve al menu de clasificacion*/				
			public void actionPerformed(ActionEvent e) {
				ventana.setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuProveedores, null);
			}
		});
		
		for(TransferProveedor tProv : datos){
			if (i < datos.length){
				s += "Id :" + tProv.getId() + "\n    Nombre: " + tProv.getNombre() 
				+ "\n    Pais: " + tProv.getPais()  +  "\n    Activo: " + tProv.getActivo() +  "\n\n" ;
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
	
	private void actualizarMostrarUnProveedor(TransferProveedor datos) {
		// TODO Auto-generated method stub
		String advertencia = "";
		if (datos.getActivo().equals("No")) {
			advertencia = "\nADVERTENCIA El producto esta inactivo";
		}
		JOptionPane.showMessageDialog(null, "Id: " + datos.getId() + "\nNombre: " + datos.getNombre()
				+ "\nPais: " + datos.getPais() + advertencia);
		setVisible(true);
	}

	
}
