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
		
		// 1.读取xml文档，返回Document对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/AndroidManifest.xml"));

		//2 获取节点
		System.out.println("获取节点---------------------------------------------------------");
		Iterator<Node> it = doc.nodeIterator();
		while (it.hasNext()) {
			Node node = it.next();
			System.out.println(node.getName());
		}
	
		//2 获取所有节点
		System.out.println("获取所有节点---------------------------------------------------------");
		Element rooElem = doc.getRootElement(); // 得到根标签
		getChildNodes(rooElem);
		
		//获取根标签的所有属性
		System.out.println(rooElem.getName());
		List<Attribute> listroo = rooElem.attributes();
		for (Attribute attr : listroo) {
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
		//3  获取属性节点 属性节点重复时 获取第一个
		Element manifestElem = doc.getRootElement().element("uses-feature");
		System.out.println(manifestElem.getName());
		List<Attribute> listAttri = manifestElem.attributes();
		//遍历属性
		for (Attribute attr : listAttri) {
			System.out.println(attr.getName()+"="+attr.getValue());
		}
		
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
