package com.example.xml;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo8 {

	//修改：属性值，文本
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("C:/Users/Administrator/Desktop/contact.xml"));
		
		// 方案一： 修改属性值   1.得到标签对象 2.得到属性对象 3.修改属性值
		//1.1  得到标签对象
		Element contactElem = doc.getRootElement().element("contact");
		//1.2 得到属性对象
		Attribute idAttr = contactElem.attribute("id");
		//1.3 修改属性值
		idAttr.setValue("003");
		
		//方案二： 修改属性值
		//1.1  得到标签对象
		Element contactElem1 = doc.getRootElement().element("contact");
		//1.2 通过增加同名属性的方法，修改属性值
		contactElem.addAttribute("id", "004");
		
		//修改文本 1.得到标签对象 2.修改文本
		Element nameElem = doc.getRootElement().element("contact").element("name");
		nameElem.setText("demo7");
		
		FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/test/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}

}
