 package presentacion.clasificacion;

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
import negocio.clasificacion.TransferClasificacion;
import presentacion.GUI;
import presentacion.TipoGUI;
import presentacion.controlador.Controlador;
import presentacion.eventos.Evento;

/** Contiene las interfaces de las funciones de clasificacion */
public class GUIClasificacion extends JFrame implements GUI {

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

		// Mantened el orden alfabetico

		case actualizarClasificacion:
			JOptionPane.showMessageDialog(null, "Actualizacion realizada correctamente");
			setVisible(true);
			break;

		case altaClasificacion:
			JOptionPane.showMessageDialog(null, "Alta realizada correctamente con id:" + (String) datos);
			setVisible(true);
			break;

		case altaClasificacionDuplicada:
			JOptionPane.showMessageDialog(null, "Esta clasificacion ya estaba en el sistema, se ha activado");
			setVisible(true);
			break;

		case bajaClasificacion:
			JOptionPane.showMessageDialog(null, "Baja realizada correctamente");
			setVisible(true);
			break;

		case bajaClasificacionDuplicada:
			JOptionPane.showMessageDialog(null, "Esta clasificacion ya esta dada de baja");
			setVisible(true);
			break;

		case errorActualizarClasificacion:
			JOptionPane.showMessageDialog(null, "Id de clasificacion inexistente o error en entrada/salida");
			setVisible(true);
			break;	

		case errorAltaClasificacion:
			JOptionPane.showMessageDialog(null, "La clasificacion ya existe y esta activa");
			setVisible(true);
			break;
			
		case errorArgumentos:
			JOptionPane.showMessageDialog(null, "Error al introducir argumentos");
			setVisible(true);
			break;

		case errorBajaClasificacion:
			JOptionPane.showMessageDialog(null, "Id de clasificacion inexistente o error en entrada/salida");
			setVisible(true);
			break;

		case errorMostrarTodasClasificaciones:
			JOptionPane.showMessageDialog(null, "No existen clasficaciones o error en entrada/salida");
			setVisible(true);
			break;

		case errorMostrarUnaClasificacion:
			JOptionPane.showMessageDialog(null, "Id de clasificacion inexistente o error en entrada/salida");
			setVisible(true);
			break;

		case errorProductosAsignados:
			JOptionPane.showMessageDialog(null, "No se puede dar de baja porque tiene productos asignados");
			setVisible(true);
			break;
			
		case mostrarTodasClasificaciones:
			actualizarMostrarTodasClasificaciones((TransferClasificacion[]) datos);
			break;

		case mostrarUnaClasificacion:
			actualizarMostrarUnaClasificacion((TransferClasificacion) datos);
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
	public GUIClasificacion(TipoGUI tipo) {
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
	
	//Ordenados alfabeticamente segn el switch

	private void initGuiAlta() {
		JPanel panel;
		JLabel lEdad;
		JLabel lContenidos;
		JButton aceptar;
		JButton cancelar;
		final JTextField tEdadAlta;
		final JTextField tContenidosAlta;

		setTitle("Alta Clasificacion");

		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1, 5, 5));

		lEdad = new JLabel("Edad Minima:");
		tEdadAlta = new JTextField(3);
		lContenidos = new JLabel("Contenidos:");
		tContenidosAlta = new JTextField(20);
		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String edad = tEdadAlta.getText();
				String contenidos = tContenidosAlta.getText();
				TransferClasificacion transferClasificacion = new TransferClasificacion(edad, contenidos);
				Controlador.obtenerInstancia().accion(Evento.altaClasificacion, transferClasificacion);
				setVisible(false);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuClasificacion, null);
			}
		});

		panel.add(lEdad);
		panel.add(tEdadAlta);
		panel.add(lContenidos);
		panel.add(tContenidosAlta);
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

		setTitle("Eliminar Una Clasificacion");

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 5, 5));

		lID = new JLabel("ID:");
		tIDBaja = new JTextField(3);

		aceptar = new JButton("Eliminar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tIDBaja.getText();
				TransferClasificacion transferClasificacion = new TransferClasificacion(id);
				Controlador.obtenerInstancia().accion(Evento.bajaClasificacion, transferClasificacion);
				setVisible(false);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuClasificacion, null);
			}
		});

		panel.add(lID);
		panel.add(tIDBaja);
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
		final JTextField tIDMostrarUno;

		setTitle("Mostrar Una Clasificacion");

		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 1, 5, 5));

		lID = new JLabel("ID:");
		tIDMostrarUno = new JTextField(3);

		aceptar = new JButton("Buscar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = tIDMostrarUno.getText();
				TransferClasificacion tCla = new TransferClasificacion(id);
				Controlador.obtenerInstancia().accion(Evento.mostrarUnaClasificacion, tCla);
				setVisible(false);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuClasificacion, null);
			}
		});

		panel.add(lID);
		panel.add(tIDMostrarUno);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();
		
		this.setSize(400,100);
	}

	

	private void initGuiUpdate() {

		JPanel panel;
		JLabel lEdad;
		JLabel lContenidos;
		JLabel lID;
		JButton aceptar;
		JButton cancelar;
		final JTextField tEdadUpdate;
		final JTextField tContenidosUpdate;
		final JTextField tIDUpdate;
		setTitle("Actualizar Clasificacion");

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 1, 5, 5));

		lID = new JLabel("ID:");
		tIDUpdate = new JTextField(3);
		lEdad = new JLabel("Edad Minima:");
		tEdadUpdate = new JTextField(3);
		lContenidos = new JLabel("Contenidos:");
		tContenidosUpdate = new JTextField(20);

		aceptar = new JButton("Aceptar");
		cancelar = new JButton("Cancelar");

		aceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String idupdate = tIDUpdate.getText();
				String edad = tEdadUpdate.getText();
				String contenidos = tContenidosUpdate.getText();
				TransferClasificacion transferClasificacion = new TransferClasificacion(idupdate, edad, contenidos);
				Controlador.obtenerInstancia().accion(Evento.actualizarClasificacion, transferClasificacion);
				setVisible(false);
			}
		});

		cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Controlador.obtenerInstancia().accion(Evento.abrirMenuClasificacion, null);
			}
		});

		panel.add(lID);
		panel.add(tIDUpdate);
		panel.add(lEdad);
		panel.add(tEdadUpdate);
		panel.add(lContenidos);
		panel.add(tContenidosUpdate);
		panel.add(aceptar);
		panel.add(cancelar);
		getContentPane().add(panel);

		pack();

		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

	}

	//Actualizar Mostrar

	private void actualizarMostrarTodasClasificaciones(TransferClasificacion[] datos) {
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
				Controlador.obtenerInstancia().accion(Evento.abrirMenuClasificacion, null);
			}
		});
		
		for(TransferClasificacion tCla : datos){
			if (i < datos.length){
				s += "Id: " + tCla.getId() + "\n    Edad Minima: " + tCla.getEdadMinima()
				+ "\n    Contenidos: " + tCla.getContenidos() + "\n    Activa: " + tCla.getActivo() + "\n\n";
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
	
	private void actualizarMostrarUnaClasificacion(TransferClasificacion tCla) {
		String advertencia = "";
		if (tCla.getActivo().equals("No")) {
			advertencia = "\nADVERTENCIA La clasificacion esta inactiva";
		}
		JOptionPane.showMessageDialog(null, "Id: " + tCla.getId() + "\nEdad Minima: " + tCla.getEdadMinima()
				+ "\nContenidos: " + tCla.getContenidos() + advertencia);
		setVisible(true);
	}

}
