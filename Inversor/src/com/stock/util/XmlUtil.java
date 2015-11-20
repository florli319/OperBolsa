package com.stock.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import java.io.File;
import java.io.IOException;

public class XmlUtil {
	/**
	 * Metodo que transforma un objeto a un xml
	 */
	public static void marshallObtjectToXml(Object jaxbObject, String pathFile) {
		try {
			File file = new File(pathFile);
			JAXBContext jaxbContext = JAXBContext.newInstance(jaxbObject
					.getClass());
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(jaxbObject, file);
			jaxbMarshaller.marshal(jaxbObject, System.out);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que transforma un xml a un objeto
	 */
	@SuppressWarnings("unchecked")
	public static <T> T unmarshallXmlToObject(Class<T> clase, String pathFile) {
		try {
			JAXBContext jc = JAXBContext.newInstance(clase);
			Unmarshaller u = jc.createUnmarshaller();
			return (T) u.unmarshal(new File(pathFile));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void stringToFile(String xmlSource, String pathFile)
			throws IOException {
		java.io.FileWriter fw = new java.io.FileWriter(pathFile);
		fw.write(xmlSource);
		fw.close();
	}

}
