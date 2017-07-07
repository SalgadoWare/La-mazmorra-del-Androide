package integracion.proveedor;

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
import negocio.proveedor.TransferProveedor;

public class DAOProveedorImp implements DAOProveedor {

	@Override
	public TransferProveedor read(int id) {
		TransferProveedor tProv = null;
		boolean found = false;
		try {

			File fXmlFile = new File("./datos/proveedores.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("proveedor");

			for (int i = 0; i < nList.getLength() && !found; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (Integer.parseInt(eElement.getAttribute("id")) == id) {
						found = true;
						String nombre = eElement.getAttribute("nombre");
						String pais = eElement.getAttribute("pais");
						String activo = eElement.getAttribute("activo");
						tProv = new TransferProveedor(eElement.getAttribute("id"), activo, nombre, pais);
					}
				}
			}

			return tProv;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public TransferProveedor[] readAll() {
		TransferProveedor[] coleccion = null;
		try {

			File fXmlFile = new File("./datos/proveedores.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("proveedor");

			int total = nList.getLength();
			coleccion = new TransferProveedor[total];

			for (int i = 0; i < total; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String nombre = eElement.getAttribute("nombre");
					String pais = eElement.getAttribute("pais");
					String id = eElement.getAttribute("id");
					String activo = eElement.getAttribute("activo");

					coleccion[i] = new TransferProveedor(id, activo, nombre, pais);
				}
			}

			return coleccion;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int write(TransferProveedor tProv) {
		try {
			File fXmlFile = new File("./datos/proveedores.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node clasificaciones = doc.getElementsByTagName("proveedores").item(0);

			Element eElement = doc.createElement("proveedor");
			eElement.setAttribute("id", tProv.getId());
			eElement.setAttribute("nombre", tProv.getNombre());
			eElement.setAttribute("pais", tProv.getPais());
			eElement.setAttribute("activo", tProv.getActivo());

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
	public int update(TransferProveedor tProv) {
		try {
			File fXmlFile = new File("./datos/proveedores.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("proveedor");

			Node nodo = nList.item(Integer.parseInt(tProv.getId()));
			Element eElement = (Element) nodo;

			eElement.setAttribute("nombre", tProv.getNombre());
			eElement.setAttribute("pais", tProv.getPais());
			eElement.setAttribute("activo", tProv.getActivo());

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
