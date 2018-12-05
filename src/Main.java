import java.io.File;
import java.io.FileWriter;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class Main {

	public static void main(String[] args) {
		generarXml();
		editXml();
	}
	
	private static void generarXml() {
		Document doc = new Document();
		Element equipo = new Element("Equipo");
		
		Element portero = new Element("Portero");
		portero.addContent("Ochoa");
		
		Element defensa = new Element("Defensa");
		defensa.addContent("Marquez");
		
		Element delantero = new Element("Delantero");
		delantero.addContent("CH14");
		
		equipo.addContent(portero);
		equipo.addContent(defensa);
		equipo.addContent(delantero);
		
		doc.setRootElement(equipo);
		
		XMLOutputter out = new XMLOutputter();
		out.setFormat(Format.getPrettyFormat());
		
		try {
			out.output(doc, new FileWriter(new File("/Users/alanramirez/Downloads/equipo.xml")));
			System.out.println("Generado exitosamente");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void editXml() {
		try {
			SAXBuilder builder = new SAXBuilder();
			File xmlFile = new File("/Users/alanramirez/Downloads/equipo.xml");
			Document doc = (Document) builder.build(xmlFile);
			
			Element rootNode = doc.getRootElement();
			rootNode.getChild("Portero").setText("Marche");
			
			XMLOutputter out = new XMLOutputter();
			out.setFormat(Format.getPrettyFormat());
			out.output(doc, new FileWriter(xmlFile));
			
			System.out.println("Generado exitosamente");
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
