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

	//ɾ������ǩ������
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("C:/Users/Administrator/Desktop/contact.xml"));
		//1.ɾ����ǩ     1.1 �õ���ǩ����  1.2 ɾ����ǩ����    
		Element ageElem = doc.getRootElement().element("contact").element("age");
		//1.2 ɾ����ǩ����
		ageElem.detach();
		//ageElem.getParent().remove(ageElem);
		
		//2.ɾ������   2.1�õ����Զ���  2.2 ɾ������
		//�õ��ڶ���contact��ǩ
		Element contactElem = (Element)doc.getRootElement().elements().get(1);
		//2.2 �õ����Զ���
		Attribute idAttr = contactElem.attribute("id");
		//2.3 ɾ������
		idAttr.detach();
		
		FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/test/contact.xml");
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		writer.write(doc);
		writer.close();
	}

}
