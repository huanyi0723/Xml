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

	//�޸ģ�����ֵ���ı�
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("C:/Users/Administrator/Desktop/contact.xml"));
		
		// ����һ�� �޸�����ֵ   1.�õ���ǩ���� 2.�õ����Զ��� 3.�޸�����ֵ
		//1.1  �õ���ǩ����
		Element contactElem = doc.getRootElement().element("contact");
		//1.2 �õ����Զ���
		Attribute idAttr = contactElem.attribute("id");
		//1.3 �޸�����ֵ
		idAttr.setValue("003");
		
		//�������� �޸�����ֵ
		//1.1  �õ���ǩ����
		Element contactElem1 = doc.getRootElement().element("contact");
		//1.2 ͨ������ͬ�����Եķ������޸�����ֵ
		contactElem.addAttribute("id", "004");
		
		//�޸��ı� 1.�õ���ǩ���� 2.�޸��ı�
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
