package integracion.ventas;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
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
import negocio.ventas.LineaVenta;
import negocio.ventas.TransferVentas;

public class DAOVentasImp implements DAOVentas {
	
	@Override
	public TransferVentas read(int id) {
		TransferVentas tVen = null;
		boolean found = false;
		try {

			File fXmlFile = new File("./datos/ventas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("venta");

			for (int i = 0; i < nList.getLength() && !found; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					if (Integer.parseInt(eElement.getAttribute("id")) == id) {
						found = true;
						String precio = eElement.getAttribute("precio");
						String fecha = eElement.getAttribute("fecha");
						String cliente = eElement.getAttribute("cliente");
						String activo = eElement.getAttribute("activo");
						NodeList productos = nNode.getChildNodes();
						HashMap<Integer, LineaVenta> mapProductos = new HashMap<Integer, LineaVenta>();
						for (int j = 0; j < productos.getLength(); j++){
							Node pNode = productos.item(j);
							Element producto = (Element) pNode;
							LineaVenta lVen = new LineaVenta(producto.getAttribute("id"), producto.getAttribute("cantidad"), producto.getAttribute("precio"));
							mapProductos.put(Integer.parseInt(producto.getAttribute("id")), lVen);
						}
						tVen = new TransferVentas(eElement.getAttribute("id"), cliente, fecha, precio, mapProductos, activo);
					}
				}
			}

			return tVen;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public TransferVentas[] readAll() {
		TransferVentas[] coleccion = null;
		try {

			File fXmlFile = new File("./datos/ventas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("venta");

			int total = nList.getLength();
			coleccion = new TransferVentas[total];

			for (int i = 0; i < total; i++) {
				Node nNode = nList.item(i);

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;

					String fecha = eElement.getAttribute("fecha");
					String precio = eElement.getAttribute("precio");
					String cliente = eElement.getAttribute("cliente");
					String id = eElement.getAttribute("id");
					String activo = eElement.getAttribute("activo");
					NodeList productos = nNode.getChildNodes();
					HashMap<Integer, LineaVenta> mapProductos = new HashMap<Integer, LineaVenta>();
					for (int j = 0; j < productos.getLength(); j++){
						Node pNode = productos.item(j);
						Element producto = (Element) pNode;
						LineaVenta lVen = new LineaVenta(producto.getAttribute("id"), producto.getAttribute("cantidad"), producto.getAttribute("precio"));
						mapProductos.put(Integer.parseInt(producto.getAttribute("id")), lVen);
					}
					coleccion[i] = new TransferVentas(id, cliente, fecha, precio, mapProductos, activo);
				}
			}

			return coleccion;

		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int write(TransferVentas tVen) {
		try {
			File fXmlFile = new File("./datos/ventas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			Node clasificaciones = doc.getElementsByTagName("ventas").item(0);

			Element eElement = doc.createElement("venta");
			eElement.setAttribute("id", tVen.getIdVenta());
			eElement.setAttribute("cliente", tVen.getIdCliente());
			eElement.setAttribute("fecha", tVen.getFecha());
			eElement.setAttribute("precio", tVen.getPrecio());
			eElement.setAttribute("activo", tVen.getActivo());
			HashMap<Integer, LineaVenta> mapProductos = tVen.getProductos();
			Collection<LineaVenta> coleccionProductos = mapProductos.values();
			Iterator<LineaVenta> iteradorProductos = coleccionProductos.iterator();
			
			while(iteradorProductos.hasNext()){
				LineaVenta producto = iteradorProductos.next();
				Element pElement = doc.createElement("producto");
				
				pElement.setAttribute("id", producto.getId());
				pElement.setAttribute("cantidad", producto.getCantidad());
				pElement.setAttribute("precio", producto.getPrecio());
				
				eElement.appendChild(pElement);
			}

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
	public int update(TransferVentas tVen) {
		try {
			File fXmlFile = new File("./datos/ventas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			NodeList nList = doc.getElementsByTagName("venta");

			Node nodo = nList.item(Integer.parseInt(tVen.getIdVenta()));
			Element eElement = (Element) nodo;
			
			eElement.setAttribute("activo", tVen.getActivo());			

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
