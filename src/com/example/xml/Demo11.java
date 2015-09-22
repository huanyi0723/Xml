package com.example.xml;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo11 {

 
	public static void main(String[] args) throws Exception {
		
		//1.�ڴ洴��xml�ĵ�
		Document doc = DocumentHelper.createDocument();
		//2.д������
		Element rootElem = doc.addElement("Students");
		
		//2.1 ���ӱ�ǩ
		Element studentElem1 = rootElem.addElement("Student");
		//2.2 ��������
		studentElem1.addAttribute("id", "1");
		//2.3 ���ӱ�ǩ��ͬʱ�����ı�
		studentElem1.addElement("name").setText("����");
		studentElem1.addElement("gender").setText("��");
		studentElem1.addElement("grade").setText("�����1��");
		studentElem1.addElement("address").setText("�������");
		
		//2.1 ���ӱ�ǩ
		Element studentElem2 = rootElem.addElement("Student");
		//2.2 ��������
		studentElem2.addAttribute("id", "2");
		//2.3 ���ӱ�ǩ��ͬʱ�����ı�
		studentElem2.addElement("name").setText("����");
		studentElem2.addElement("gender").setText("Ů");
		studentElem2.addElement("grade").setText("�����2��");
		studentElem2.addElement("address").setText("����Խ��");
		
		//3.����д����xml�ļ�
		save(doc);
		
		//ɾ����idֵΪ2��ѧ����ǩ  ʹ��xpath
		Document doc1 = new SAXReader().read(new File("C:/Users/Administrator/Desktop/test/student.xml"));
		Element stuElem = (Element)doc1.selectSingleNode("//Student[@id='2']");
		stuElem.detach();
		
		save(doc1);
	}

	private static void save(Document  doc) throws Exception{
		//3.1 ���λ��
		FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/test/student.xml");
		//3.2 ָ����ʽ
		OutputFormat format = OutputFormat.createPrettyPrint();
		// ���ñ���
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		//3.3 д������
		writer.write(doc);
		//3.4�ر���Դ
		writer.close();
	}
}
