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

		// 1.读取xml文档，返回Document对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/contact.xml"));

		// 2.nodeIterator: 得到当前节点下的所有子节点对象(不包含孙以下的节点)
		System.out
				.println("test1---------------------------------------------------------");
		Iterator<Node> it = doc.nodeIterator();
		while (it.hasNext()) {
			Node node = it.next();
			String name = node.getName();
			System.out.println(name);
			System.out.println(node.getClass());

			// 继续取出其下面的子节点 只有标签节点才有子节点 判断当前节点是否是标签节点
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

		System.out.println("获取所有节点---------------------------------------------------------");
		// 获取所有节点
		SAXReader reader2 = new SAXReader();
		Document doc2 = reader2.read(new File("./src/contact.xml"));
		Element rooElem = doc.getRootElement(); // 得到根标签
		System.out.println(rooElem.getName());

		getChildNodes(rooElem);

		System.out.println("获取标签---------------------------------------------------------");
		List<Element> list = rooElem.elements();
		System.out.println("传统for循环---------------------------------------------------------");
		for (int i = 0; i < list.size(); i++) {
			Element e = list.get(i);
			System.out.println(e.getName());
		}
		System.out.println("增强for循环---------------------------------------------------------");
		for(Element e:list){
			System.out.println(e.getName());
		}
		System.out.println("迭代器---------------------------------------------------------");
		Iterator<Element> itElem = list.iterator(); //ctrl+2 松开 l
		while(itElem.hasNext()){
			Element elem = itElem.next();
			System.out.println(elem.getName());
		}
		System.out.println("获取更深层次的标签---------------------------------------------------------");
		Element nameElem = doc.getRootElement().element("contact").element("name");
		System.out.println(nameElem.getName());
		
		System.out.println("获取属性---------------------------------------------------------");
		Element contactElem = doc.getRootElement().element("contact");
		System.out.println("得到指定名称的属性值---------------------------------------------------------");
		String idValue = contactElem.attributeValue("id");
		System.out.println(idValue);
		System.out.println("得到指定属性名称的属性对象---------------------------------------------------------");
		Attribute idAttr = contactElem.attribute("id");
		System.out.println(idAttr.getName() +"=" + idAttr.getValue());
		System.out.println("遍历所有属性---------------------------------------------------------");
		List<Attribute> listAttri = contactElem.attributes();
		//遍历属性
		for (Attribute attr : listAttri) {
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
		Iterator<Attribute> itAttri = contactElem.attributeIterator();
		while(itAttri.hasNext()){
			Attribute attr = itAttri.next();
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
		System.out.println("获取文本---------------------------------------------------------");
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

		// 得到子节点
		Iterator<Node> it = elem.nodeIterator();
		while (it.hasNext()) {
			Node node = it.next();

			// 1.判断是否是标签节点
			if (node instanceof Element) {
				Element el = (Element) node;
				// 递归
				getChildNodes(el);
			}
		}
	}

}
