package com.example.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

public class Demo7 {

	//增加：文档，标签 ，属性
	public static void main(String[] args) throws Exception {
		//1.创建文档
		Document doc = DocumentHelper.createDocument();
		//2.增加标签
		Element rootElem = doc.addElement("contactList");
		Element contactElem = rootElem.addElement("contact");
		contactElem.addElement("name");
		//3.增加属性
		contactElem.addAttribute("id", "003");
		contactElem.addAttribute("name", "demo7");
		
		//把修改后的Document对象写出到xml文档中
		FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}

}
