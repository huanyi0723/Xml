package com.example.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class Demo2 {

	public static void main(String[] args) throws Exception {

		// 1.��ȡxml�ĵ�������Document����
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));

		// 2.nodeIterator: �õ���ǰ�ڵ��µ������ӽڵ����(�����������µĽڵ�)
		System.out
				.println("test1---------------------------------------------------------");
		Iterator<Node> it = doc.nodeIterator();
		while (it.hasNext()) {
			Node node = it.next();
			String name = node.getName();
			System.out.println(name);
			System.out.println(node.getClass());

			// ����ȡ����������ӽڵ� ֻ�б�ǩ�ڵ�����ӽڵ� �жϵ�ǰ�ڵ��Ƿ��Ǳ�ǩ�ڵ�
			if (node instanceof Element) {
				Element elem = (Element) node;
				System.out.println(elem);
				Iterator<Node> it2 = elem.nodeIterator();
				while (it2.hasNext()) {
					Node n2 = it2.next();
					System.out.println(n2.getName());
				}
			}
		}

		System.out.println("��ȡ���нڵ�---------------------------------------------------------");
		// ��ȡ���нڵ�
		SAXReader reader2 = new SAXReader();
		Document doc2 = reader2.read(new File("./src/contact.xml"));
		Element rooElem = doc.getRootElement(); // �õ�����ǩ
		System.out.println(rooElem.getName());

		getChildNodes(rooElem);

		System.out.println("��ȡ��ǩ---------------------------------------------------------");
		List<Element> list = rooElem.elements();
		System.out.println("��ͳforѭ��---------------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			Element e = list.get(i);
			System.out.println(e.getName());
		}
		System.out.println("��ǿforѭ��---------------------------------------------------------");
		for(Element e:list){
			System.out.println(e.getName());
		}
		System.out.println("������---------------------------------------------------------");
		Iterator<Element> itElem = list.iterator(); //ctrl+2 �ɿ� l
		while(itElem.hasNext()){
			Element elem = itElem.next();
			System.out.println(elem.getName());
		}
		System.out.println("��ȡ�����εı�ǩ---------------------------------------------------------");
		Element nameElem = doc.getRootElement().element("contact").element("name");
		System.out.println(nameElem.getName());
		
		System.out.println("��ȡ����---------------------------------------------------------");
		Element contactElem = doc.getRootElement().element("contact");
		System.out.println("�õ�ָ�����Ƶ�����ֵ---------------------------------------------------------");
		String idValue = contactElem.attributeValue("id");
		System.out.println(idValue);
		System.out.println("�õ�ָ���������Ƶ����Զ���---------------------------------------------------------");
		Attribute idAttr = contactElem.attribute("id");
		System.out.println(idAttr.getName() +"=" + idAttr.getValue());
		System.out.println("������������---------------------------------------------------------");
		List<Attribute> listAttri = contactElem.attributes();
		//��������
		for (Attribute attr : listAttri) {
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
		Iterator<Attribute> itAttri = contactElem.attributeIterator();
		while(itAttri.hasNext()){
			Attribute attr = itAttri.next();
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
		System.out.println("��ȡ�ı�---------------------------------------------------------");
		String content = doc.getRootElement().getText();
		System.out.println(content);
		
		Element nameELem = doc.getRootElement().element("contact").element("name");
		String text = nameELem.getText();
		System.out.println(text);
		String text2 = doc.getRootElement().element("contact").elementText("phone");
		System.out.println(text2);
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
