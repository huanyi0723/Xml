package com.example.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo3 {

	public static void main(String[] args) throws Exception {
		
		// 1.��ȡxml�ĵ�������Document����
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/AndroidManifest.xml"));

		//2 ��ȡ�ڵ�
		System.out.println("��ȡ�ڵ�---------------------------------------------------------");
		Iterator<Node> it = doc.nodeIterator();
		while (it.hasNext()) {
			Node node = it.next();
			System.out.println(node.getName());
		}
	
		//2 ��ȡ���нڵ�
		System.out.println("��ȡ���нڵ�---------------------------------------------------------");
		Element rooElem = doc.getRootElement(); // �õ�����ǩ
		getChildNodes(rooElem);
		
		//��ȡ����ǩ����������
		System.out.println(rooElem.getName());
		List<Attribute> listroo = rooElem.attributes();
		for (Attribute attr : listroo) {
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
		//3  ��ȡ���Խڵ� ���Խڵ��ظ�ʱ ��ȡ��һ��
		Element manifestElem = doc.getRootElement().element("uses-feature");
		System.out.println(manifestElem.getName());
		List<Attribute> listAttri = manifestElem.attributes();
		//��������
		for (Attribute attr : listAttri) {
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
	}
	
	public static void getChildNodes(Element elem) {
		System.out.println(elem.getName());

		// �õ��ӽڵ�
		Iterator<Node> it = elem.nodeIterator();
		while (it.hasNext()) {
			Node node = it.next();

			// 1.�ж��Ƿ��Ǳ�ǩ�ڵ�
			if (node instanceof Element) {
				Element el = (Element) node;
				// �ݹ�
				getChildNodes(el);
			}
		}
	}

}
