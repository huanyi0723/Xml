package com.example.xml;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Demo17 {

	//使用sax解析把 xml文档封装成对象
	public static void main(String[] args) throws Exception {
		SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
		MyDefaultHandler3 handler = new MyDefaultHandler3();
		parser.parse(new File("./src/contact.xml"), handler);
		List<Contact> list = handler.getList();
		for (Contact contact : list) {
			System.out.println(contact);
		}
	}

}
