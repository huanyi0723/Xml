package com.example.xml;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

//读取XML文档
public class Demo1 {

	public static void main(String[] args) {
		try {
			//1.创建一个xml解析器对象
			SAXReader reader = new SAXReader();
			//2.读取xml文档，返回Document对象
			Document doc = reader.read(new File("./src/contact.xml"));
			
			System.out.println(doc);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
}
