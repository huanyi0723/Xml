package com.example.xml;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo6 {

	//д�����ݵ�xml�ĵ�
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("./src/contact.xml"));
		//ָ���ļ������λ��
		FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/contact.xml");  
		//C:\Users\Administrator\Desktop\ ��д��C:/Users/Administrator/Desktop/contact.xml
		/**
		 * 1.ָ��д���ĸ�ʽ
		 */
		//OutputFormat format = OutputFormat.createCompactFormat(); //���յĸ�ʽ.ȥ���ո���.��Ŀ���ߵ�ʱ��
		OutputFormat format = OutputFormat.createPrettyPrint(); //Ư���ĸ�ʽ.�пո�ͻ���.�������Ե�ʱ��
		/**
		 * 2.ָ�����ɵ�xml�ĵ��ı���
		 *    ͬʱӰ����xml�ĵ�����ʱ�ı���  ��  xml�ĵ�������encoding�ı��루xml����ʱ�ı��룩
		 *    ���ۣ� ʹ�ø÷������ɵ�xml�ĵ����������������⡣
		 */
		format.setEncoding("utf-8");
		
		
		//1.����д������
		XMLWriter writer = new XMLWriter(out,format);
		
		//2.д������
		writer.write(doc);
		//3.�ر���
		writer.close();
	}

}