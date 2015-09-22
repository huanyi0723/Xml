package com.example.xml;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class Demo14 {

	//ʹ��xpath������ȡһ���淶��html�ĵ�
	public static void main(String[] args) throws Exception {
		Document doc = new SAXReader().read(new File("./src/personList.html"));
		
		Element titleElem = (Element)doc.selectSingleNode("//title");
		String title = titleElem.getText();
		System.out.println(title);
		
		/**
		 * ��ϰ����ȡ��ϵ�˵�������Ϣ
		 * �������¸�ʽ�����
		 * 		 ���:001 ����:���� �Ա�:�� ����:18 ��ַ��xxxx �绰�� xxxx
		 *       ���:002 ����:���� �Ա�:Ů ����:20 ��ַ��xxxx �绰�� xxxx
		 *       ......
		 */
		//1.��ȡ������tbody�е�tr��ǩ
		List<Element> list = (List<Element>)doc.selectNodes("//tbody/tr");
		//2.����
		for (Element elem : list) {
			//���
			//String id = ((Element)elem.elements().get(0)).getText();
			String id = elem.selectSingleNode("td[1]").getText();
			//����
			String name = ((Element)elem.elements().get(1)).getText();
			//�Ա�
			String gender = ((Element)elem.elements().get(2)).getText();
			//����
			String age = ((Element)elem.elements().get(3)).getText();
			//��ַ
			String address = ((Element)elem.elements().get(4)).getText();
			//�绰
			String phone = ((Element)elem.elements().get(5)).getText();
			
			System.out.println("��ţ�"+id+"\t������"+name+"\t�Ա�"+
								gender+"\t���䣺"+
								age+"\t��ַ��"+address+
								"\t�绰��"+phone);
		}
	
	
	}

}
