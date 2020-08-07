package com.brandmaker.util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.namespace.QName;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

public class XmlUtils {

	public static Document convertStringToDocument(String xmlStr) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xmlStr)));
			return doc;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Convert PoJo to XML String
	 * 
	 * @param <T> JAXB annotated type
	 * @param r Object to be converted
	 * @param model Package path
	 * @return
	 * @throws IOException
	 * @throws TransformerException
	 * @throws JAXBException
	 */
	public static <T> String pojoToXmlString(T r, String model) throws IOException, TransformerException, JAXBException {
		StringWriter stringWriter = new StringWriter();
		pojoToXml(r, model, stringWriter);
		return stringWriter.toString();
	}
	
	/**
	 * Convert an arbitrary, JAXB annotated object into an XML stream and write to the given Writer.
	 * The object is encapsulated into a JAXB Element in order to prevent errors, if there is no @XMLRootElement annotation.
	 * 
	 * @param <T>n Object type
	 * @param pojo The object to be converted
	 * @param model fully qualified class path
	 * @param out
	 * @throws IOException
	 * @throws TransformerException
	 * @throws JAXBException
	 */
	@SuppressWarnings("unchecked")
	public static <T> void pojoToXml(T pojo, String model, Writer out) throws IOException, TransformerException, JAXBException {
		JAXBContext contextObj = JAXBContext.newInstance(pojo.getClass());  
	    Marshaller marshallerObj = contextObj.createMarshaller();  
	    marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
	    
	    /*
	     * We need to wrap the raw element into a JAXB Element since @XmlRootElement annotation is missing
	     * see https://codenotfound.com/jaxb-marshal-element-missing-xmlrootelement-annotation.html
	     */
	    QName qName = new QName(model, "object");
	    JAXBElement<T> root = new JAXBElement<T>(qName, (Class<T>) pojo.getClass(), pojo);
	    
	    marshallerObj.marshal(root, out);
	    
	}

	public static void pojoToXSD(Class<?> pojo, OutputStream out) throws IOException, TransformerException, JAXBException {

		JAXBContext context = JAXBContext.newInstance(pojo);
		final List<DOMResult> results = new ArrayList<>();

		context.generateSchema(new SchemaOutputResolver() {

			@Override
			public Result createOutput(String ns, String file) throws IOException {
				DOMResult result = new DOMResult();
				result.setSystemId(file);
				results.add(result);
				return result;
			}
		});

		DOMResult domResult = results.get(0);

		// Use a Transformer for output
		TransformerFactory tFactory = TransformerFactory.newInstance();
		Transformer transformer = tFactory.newTransformer();

		DOMSource source = new DOMSource(domResult.getNode());
		StreamResult result = new StreamResult(out);
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.transform(source, result);
	}

}
