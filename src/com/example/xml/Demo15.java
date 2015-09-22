package com.example.xml;

import java.io.File;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Demo15 {

 
	public static void main(String[] args) throws Exception {
		//1.创建SAXParser对象
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		
		//2.调用parse方法
		/**
		 * 参数一： xml文档
		 * 参数二： DefaultHandler的子类
		 */
		parser.parse(new File("./src/contact.xml"), new MyDefaultHandler());
	}

}
