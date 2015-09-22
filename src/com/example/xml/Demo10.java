package com.example.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo10 {

	/** 
	 *  ����
	 * 1.ʹ��dom4j��api���������µ�xml�ļ�
	<Students>
	<Student id="1">
		<name>����</name>
		<gender>��</gender>
		<grade>�����1��</grade>
		<address>�������</address>
	</Student>
	<Student id="2">
		<name>����</name>
		<gender>Ů</gender>
		<grade>�����2��</grade>
		<address>����Խ��</address>
	</Student>
	</Students>

	2.�޸�idΪ2��ѧ������������Ϊ��������

	3.ɾ��idΪ2��ѧ��
	 *
	 */
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
		
		//�޸�idΪ2��ѧ������
		//1.��ѯ��idΪ2��ѧ��
		Document doc1 = new SAXReader().read(new File("C:/Users/Administrator/Desktop/test/student.xml"));
		//1.1 �ҵ����е�Student��ǩ
		Iterator<Element> it = doc1.getRootElement().elementIterator("Student");
		while(it.hasNext()){
			Element stuElem = it.next();
			//1.2 ��ѯidΪid��ѧ����ǩ
			if(stuElem.attributeValue("id").equals("2")){
				stuElem.element("name").setText("����");
				break;
			}
		}
		
		save(doc1);
		
		//ɾ��idΪ2��ѧ��
		Document doc2 = new SAXReader().read(new File("C:/Users/Administrator/Desktop/test/student.xml"));
		//1.1 �ҵ����е�Student��ǩ
		Iterator<Element> it2 = doc2.getRootElement().elementIterator("Student");
		while(it2.hasNext()){
			Element stuElem = it2.next();
			//1.2 ��ѯidΪid��ѧ����ǩ
			if(stuElem.attributeValue("id").equals("2")){
				//1.3 ɾ����ѧ����ǩ
				stuElem.detach();
				break;
			}
		}
		
		save(doc2);
	
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
