package integracion.producto;

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

import negocio.producto.TransferProducto;

public class DAOProductoImp implements DAOProducto {

	@Override
	public TransferProducto read(int id) {
		TransferProducto tPro = null;
		boolean found = false;
		try {

			File fXmlFile = new File("./datos/productos.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("producto");

			for (int i = 0; i < nList.getLength() && !found; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (Integer.parseInt(eElement.getAttribute("id")) == id) {
						found = true;
						String precio = eElement.getAttribute("precio");
						String stock = eElement.getAttribute("stock");
						String nombre = eElement.getAttribute("nombre");
						String so = eElement.getAttribute("sistema_operativo");
						String idC = eElement.getAttribute("id_clasificacion");
						String idProv = eElement.getAttribute("id_proveedor");
						String activo = eElement.getAttribute("activo");

						tPro = new TransferProducto(String.valueOf(id), activo, precio, stock, idC, so, nombre, idProv);
					}
				}
			}

			return tPro;

		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public TransferProducto[] readAll() {
		TransferProducto[] coleccion = null;

		try {

			File fXmlFile = new File("./datos/productos.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("producto");

			int total = nList.getLength();
			coleccion = new TransferProducto[total];

			for (int i = 0; i < total; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String precio = eElement.getAttribute("precio");
					String stock = eElement.getAttribute("stock");
					String nombre = eElement.getAttribute("nombre");
					String so = eElement.getAttribute("sistema_operativo");
					String idC = eElement.getAttribute("id_clasificacion");
					String activo = eElement.getAttribute("activo");
					String idProv = eElement.getAttribute("id_proveedor");
					String id = eElement.getAttribute("id");

					coleccion[i] = new TransferProducto(id, activo, precio, stock, idC, so, nombre, idProv);
				}
			}

			return coleccion;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int write(TransferProducto tPro) {
		try {
			File fXmlFile = new File("./datos/productos.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node productos = doc.getElementsByTagName("productos").item(0);

			Element eElement = doc.createElement("producto");
			eElement.setAttribute("id", tPro.getId());
			eElement.setAttribute("sistema_operativo", tPro.getSo());
			eElement.setAttribute("nombre", tPro.getName());
			eElement.setAttribute("activo", tPro.getActivo());
			eElement.setAttribute("id_clasificacion", tPro.getIdClasificacion());
			eElement.setAttribute("precio", tPro.getPrecio());
			eElement.setAttribute("id_proveedor", tPro.getIdProveedor());
			
			eElement.setAttribute("stock", tPro.getStock());

			productos.appendChild(eElement);

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
	public int update(TransferProducto tPro) {
		try {
			File fXmlFile = new File("./datos/productos.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("producto");

			Node nodo = nList.item(Integer.parseInt(tPro.getId()));
			Element eElement = (Element) nodo;

			eElement.setAttribute("sistema_operativo", tPro.getSo());
			eElement.setAttribute("nombre", tPro.getName());
			eElement.setAttribute("activo", tPro.getActivo());
			eElement.setAttribute("id_clasificacion", tPro.getIdClasificacion());
			eElement.setAttribute("precio", tPro.getPrecio());
			eElement.setAttribute("id_proveedor", tPro.getIdProveedor());
			eElement.setAttribute("stock", tPro.getStock());

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
	public TransferProducto[] readProductosPorClasificacion(int idClasificacion) {
		TransferProducto[] aux = readAll();
		int total = 0;
		TransferProducto[] coleccionTPconId = null;

		for (TransferProducto t : aux) {
			if (Integer.valueOf(t.getIdClasificacion()) == idClasificacion && t.getActivo().equalsIgnoreCase("si")) {
				total++;
			}
		}

		if (total != 0) {
			coleccionTPconId = new TransferProducto[total];
			int i = 0;

			for (TransferProducto t : aux) {
				if (Integer.valueOf(t.getIdClasificacion()) == idClasificacion && t.getActivo().equalsIgnoreCase("si")) {
					coleccionTPconId[i] = t;
					i++;
				}
			}
		}

		return coleccionTPconId;
	}

	@Override
	public TransferProducto[] readProductosPorProovedor(int idProveedor) {
		TransferProducto[] aux = readAll();
		int total = 0;
		TransferProducto[] coleccionTPconId = null;

		for (TransferProducto t : aux) {
			if (Integer.valueOf(t.getIdProveedor()) == idProveedor && t.getActivo().equalsIgnoreCase("si")) {
				total++;
			}
		}

		if (total != 0) {
			coleccionTPconId = new TransferProducto[total];
			int i = 0;

			for (TransferProducto t : aux) {
				if (Integer.valueOf(t.getIdProveedor()) == idProveedor && t.getActivo().equalsIgnoreCase("si")) {
					coleccionTPconId[i] = t;
					i++;
				}
			}
		}

		return coleccionTPconId;
	}
}
