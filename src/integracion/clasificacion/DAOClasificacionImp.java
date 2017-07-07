package integracion.clasificacion;

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

import negocio.clasificacion.TransferClasificacion;

public class DAOClasificacionImp implements DAOClasificacion {
	@Override
	public TransferClasificacion read(int id) {
		TransferClasificacion tCla = null;
		boolean found = false;
		try {

			File fXmlFile = new File("./datos/clasificacion.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("clasificacion");

			for (int i = 0; i < nList.getLength() && !found; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (Integer.parseInt(eElement.getAttribute("id")) == id) {
						found = true;
						String edadMinima = eElement.getAttribute("edadminima");
						String contenido = eElement.getAttribute("contenidos");
						String activo = eElement.getAttribute("activo");
						tCla = new TransferClasificacion(eElement.getAttribute("id"), activo, edadMinima, contenido);
					}
				}
			}

			return tCla;

		} catch (Exception e) {
			return null;
		}
	}

	public TransferClasificacion[] readAll() {

		TransferClasificacion[] coleccion = null;
		try {

			File fXmlFile = new File("./datos/clasificacion.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("clasificacion");

			int total = nList.getLength();
			coleccion = new TransferClasificacion[total];

			for (int i = 0; i < total; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String edadMinima = eElement.getAttribute("edadminima");
					String contenido = eElement.getAttribute("contenidos");
					String id = eElement.getAttribute("id");
					String activo = eElement.getAttribute("activo");

					coleccion[i] = new TransferClasificacion(id, activo, edadMinima, contenido);
				}
			}

			return coleccion;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int write(TransferClasificacion tCla) {
		try {
			File fXmlFile = new File("./datos/clasificacion.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node clasificaciones = doc.getElementsByTagName("clasificaciones").item(0);

			Element eElement = doc.createElement("clasificacion");
			eElement.setAttribute("id", tCla.getId());
			eElement.setAttribute("edadminima", tCla.getEdadMinima());
			eElement.setAttribute("contenidos", tCla.getContenidos());
			eElement.setAttribute("activo", tCla.getActivo());

			clasificaciones.appendChild(eElement);

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
	public int update(TransferClasificacion tCla) {
		try {
			File fXmlFile = new File("./datos/clasificacion.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("clasificacion");

			Node nodo = nList.item(Integer.parseInt(tCla.getId()));
			Element eElement = (Element) nodo;

			eElement.setAttribute("edadminima", tCla.getEdadMinima());
			eElement.setAttribute("contenidos", tCla.getContenidos());
			eElement.setAttribute("activo", tCla.getActivo());

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
