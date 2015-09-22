package com.example.xml;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo9 {

	//删除：标签，属性
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("C:/Users/Administrator/Desktop/contact.xml"));
		//1.删除标签     1.1 得到标签对象  1.2 删除标签对象    
		Element ageElem = doc.getRootElement().element("contact").element("age");
		//1.2 删除标签对象
		ageElem.detach();
		//ageElem.getParent().remove(ageElem);
		
		//2.删除属性   2.1得到属性对象  2.2 删除属性
		//得到第二个contact标签
		Element contactElem = (Element)doc.getRootElement().elements().get(1);
		//2.2 得到属性对象
		Attribute idAttr = contactElem.attribute("id");
		//2.3 删除属性
		idAttr.detach();
		
		FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/test/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}

}
