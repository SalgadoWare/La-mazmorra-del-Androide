package integracion.cliente;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import negocio.cliente.TransferCliente;
import negocio.cliente.TransferClienteEstandar;
import negocio.cliente.TransferClienteVip;

public class DAOClienteImp implements DAOCliente {

	@Override
	public TransferCliente read(int id) {
		TransferClienteEstandar tCliEst = null;
		boolean found = false;
		try {

			File fXmlFile = new File("./datos/clientesEstandar.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("cliente");

			for (int i = 0; i < nList.getLength() && !found; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (Integer.parseInt(eElement.getAttribute("id")) == id) {
						found = true;
						String nombre = eElement.getAttribute("nombre");
						String direccion = eElement.getAttribute("direccion");
						String correo = eElement.getAttribute("correo");
						String activo = eElement.getAttribute("activo");
						tCliEst = new TransferClienteEstandar(eElement.getAttribute("id"), activo, nombre, direccion, correo);
					}
				}
			}

			if (found) return tCliEst;

		} catch (Exception e) {
			return null;
		}
		
		TransferClienteVip tCliVip = null;
		try {

			File fXmlFile = new File("./datos/clientesVip.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("cliente");

			for (int i = 0; i < nList.getLength() && !found; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (Integer.parseInt(eElement.getAttribute("id")) == id) {
						found = true;
						String nombre = eElement.getAttribute("nombre");
						String direccion = eElement.getAttribute("direccion");
						String correo = eElement.getAttribute("correo");
						String descuento = eElement.getAttribute("descuento");
						String puntos = eElement.getAttribute("puntos");
						String activo = eElement.getAttribute("activo");
						tCliVip = new TransferClienteVip(eElement.getAttribute("id"), activo, nombre, direccion, correo, descuento, puntos);
					}
				}
			}

			if (found) return tCliVip;

		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public TransferCliente[] readAll() {
		TransferClienteEstandar[] coleccionEst = null;
		try {

			File fXmlFile = new File("./datos/clientesEstandar.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("cliente");

			int total = nList.getLength();
			coleccionEst = new TransferClienteEstandar[total];

			for (int i = 0; i < total; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String correo = eElement.getAttribute("correo");
					String direccion = eElement.getAttribute("direccion");
					String nombre = eElement.getAttribute("nombre");
					String activo = eElement.getAttribute("activo");
					String id = eElement.getAttribute("id");

					coleccionEst[i] = new TransferClienteEstandar(id, activo, nombre, direccion, correo);
				}
			}

		} catch (Exception e) {
			return null;
		}
		
		TransferClienteVip[] coleccionVip = null;
		try {

			File fXmlFile = new File("./datos/clientesVip.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("cliente");

			int total = nList.getLength();
			coleccionVip = new TransferClienteVip[total];

			for (int i = 0; i < total; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String puntos = eElement.getAttribute("puntos");
					String descuento = eElement.getAttribute("descuento");
					String correo = eElement.getAttribute("correo");
					String direccion = eElement.getAttribute("direccion");
					String nombre = eElement.getAttribute("nombre");
					String activo = eElement.getAttribute("activo");
					String id = eElement.getAttribute("id");

					coleccionVip[i] = new TransferClienteVip(id, activo, nombre, direccion, correo, descuento, puntos);
				}
			}

		} catch (Exception e) {
			return null;
		}
		
		TransferCliente[] coleccion = new TransferCliente[coleccionEst.length + coleccionVip.length];
		System.arraycopy(coleccionEst, 0, coleccion, 0, coleccionEst.length);
		System.arraycopy(coleccionVip, 0, coleccion, coleccionEst.length, coleccionVip.length);
		return coleccion;
	}
	
	@Override
	public int write(TransferCliente tCli) {
		String tipo = tCli.getTipo();
		try {
			File fXmlFile = new File("./datos/clientes" + tipo + ".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node clientes = doc.getElementsByTagName("clientes").item(0);

			Element eElement = doc.createElement("cliente");
			eElement.setAttribute("id", tCli.getId());
			eElement.setAttribute("nombre", tCli.getNombre());
			eElement.setAttribute("direccion", tCli.getDireccion());
			eElement.setAttribute("correo", tCli.getCorreo());
			eElement.setAttribute("activo", tCli.getActivo());
			if (tipo.equalsIgnoreCase("vip")) {
				eElement.setAttribute("descuento", ((TransferClienteVip) tCli).getDescuento());
				eElement.setAttribute("puntos", ((TransferClienteVip) tCli).getPuntos());
			}

			clientes.appendChild(eElement);

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fXmlFile);
			transformer.transform(source, result);

			return 0;
		} catch (Exception e) {
			return -3;
		}

	}

	@Override
	public int update(TransferCliente tCli) {
		boolean found = false;
		int id = Integer.parseInt(tCli.getId());
		String tipo = tCli.getTipo();
		try {
			File fXmlFile = new File("./datos/clientes" + tipo + ".xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("cliente");
			
			for (int i = 0; i < nList.getLength() && !found; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					

					if (Integer.parseInt(eElement.getAttribute("id")) == id) {
						found = true;
						eElement.setAttribute("nombre", tCli.getNombre());
						eElement.setAttribute("direccion", tCli.getDireccion());
						eElement.setAttribute("correo", tCli.getCorreo());
						eElement.setAttribute("activo", tCli.getActivo());
						if (tipo.equalsIgnoreCase("vip")) {
							eElement.setAttribute("descuento", ((TransferClienteVip) tCli).getDescuento());
							eElement.setAttribute("puntos", ((TransferClienteVip) tCli).getPuntos());
						}
					}
				}
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(fXmlFile);
			transformer.transform(source, result);

			return 0;
		} catch (Exception e) {
			return -3;
		}
	}

}
