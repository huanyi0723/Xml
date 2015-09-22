package com.example.xml;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Demo15 {

 
	public static void main(String[] args) throws Exception {
		//1.����SAXParser����
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		
		//2.����parse����
		/**
		 * ����һ�� xml�ĵ�
		 * �������� DefaultHandler������
		 */
		parser.parse(new File("./src/contact.xml"), new MyDefaultHandler());
	}

}
