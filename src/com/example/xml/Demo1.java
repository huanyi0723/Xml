package com.example.xml;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

//��ȡXML�ĵ�
public class Demo1 {

	public static void main(String[] args) {
		try {
			//1.����һ��xml����������
			SAXReader reader = new SAXReader();
			//2.��ȡxml�ĵ�������Document����
			Document doc = reader.read(new File("./src/contact.xml"));
			
			System.out.println(doc);
		} catch (DocumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
}
