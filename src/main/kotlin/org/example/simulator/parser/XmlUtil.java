package org.example.simulator.parser;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.InputStream;
import java.io.OutputStream;

public class XmlUtil {

    private static JAXBContext createContext(Class<?> target) throws JAXBException {
        return JAXBContext.newInstance(target);
    }

    public static void writerXml(Object target, OutputStream os) throws JAXBException {
        JAXBContext instance = createContext(target.getClass());
        Marshaller marshaller = instance.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(target, os);
    }

    @SuppressWarnings("unchecked")
    public static <T> T readXml(InputStream is, Class<T> clazz) throws JAXBException {
        JAXBContext context = createContext(clazz);
        Object unmarshal = context.createUnmarshaller().unmarshal(is);
        System.out.println("unmarshal = " + unmarshal);
        return (T) unmarshal;
    }
}
