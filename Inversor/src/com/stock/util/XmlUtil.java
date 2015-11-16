package com.stock.util;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;


public class XmlUtil {

	/**
	 * Método que transforma un objeto a un xml
	 */
	public static void marshallObtjectToXml(Object jaxbObject, String pathFile){
	  try {
		File file = new File(pathFile);
		JAXBContext jaxbContext = JAXBContext.newInstance(jaxbObject.getClass());
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
   		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(jaxbObject, file);
		jaxbMarshaller.marshal(jaxbObject, System.out);
		} catch (JAXBException e) {
		  e.printStackTrace();
		}
	}
	
	/**
	 * Método que transforma un xml a un objeto
	 */
	public static Object unmarshallXmlToObject(Class clase, String pathFile){
		 try {

				File file = new File(pathFile);
				JAXBContext jaxbContext = JAXBContext.newInstance(clase);

				Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
				Object obj = (Object) jaxbUnmarshaller.unmarshal(file);
				System.out.println(obj);

				return obj;
			  } catch (JAXBException e) {
				e.printStackTrace();
			  }
		 return null;
	}	
	
}
