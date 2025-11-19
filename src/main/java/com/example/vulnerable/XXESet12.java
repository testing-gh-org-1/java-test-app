package com.example.vulnerable;

import org.xml.sax.*;
import javax.xml.parsers.*;
import java.io.*;

/**
 * XXE vulnerabilities - Set 12
 * CWE-611: XML External Entity
 */
public class XXESet12 {
    
    public void vuln111(String xml) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
    }
    
    public void vuln112(InputStream is) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.newDocumentBuilder().parse(is);
    }
    
    public void vuln113(String xmlContent) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.newSAXParser().parse(new InputSource(new StringReader(xmlContent)), null);
    }
    
    public void vuln114(File xmlFile) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.newDocumentBuilder().parse(xmlFile);
    }
    
    public void vuln115(String xml) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        parser.parse(new InputSource(new StringReader(xml)), null);
    }
    
    public void vuln116(InputStream stream) throws Exception {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        dBuilder.parse(stream);
    }
    
    public void vuln117(String xmlData) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.newDocumentBuilder().parse(new ByteArrayInputStream(xmlData.getBytes()));
    }
    
    public void vuln118(File file) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        sp.parse(file, null);
    }
    
    public void vuln119(String xml) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        dbf.newDocumentBuilder().parse(new InputSource(new StringReader(xml)));
    }
    
    public void vuln120(InputStream input) throws Exception {
        SAXParserFactory saxFactory = SAXParserFactory.newInstance();
        saxFactory.newSAXParser().parse(input, null);
    }
}
