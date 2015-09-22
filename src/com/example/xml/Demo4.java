package com.example.xml;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;

public class Demo4 {

	//������ȡXML����
	public static void main(String[] args) throws Exception {
		
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("./src/AndroidManifest.xml"));

		Element rootELem = doc.getRootElement();
		
		StringBuffer sb = new StringBuffer();
		
		getChildNodes(rootELem,sb);
		
		System.out.println(sb.toString());
	}

	private static void getChildNodes(Element elem,StringBuffer sb){
		
		//��ʼ��ǩ
		sb.append("<"+elem.getName());
		
		//�õ���ǩ�������б�
		List<Attribute> attrs = elem.attributes();
		if(attrs!=null){
			for (Attribute attr : attrs) {
				//System.out.println(attr.getName()+"="+attr.getValue());
				sb.append(" "+attr.getName()+"=\""+attr.getValue()+"\"");
			}
		}
		sb.append(">");
		
		//�õ��ı�
		//String content = elem.getText();
		//System.out.println(content);
		Iterator<Node> it = elem.nodeIterator();
		while(it.hasNext()){
			Node node = it.next();
			//��ǩ
			if(node instanceof Element){
				Element el = (Element)node;
				getChildNodes(el,sb);
			}
			//�ı�
			if(node instanceof Text){
				Text text = (Text)node;
				sb.append(text.getText());
			}
		}
		//������ǩ
		sb.append("</"+elem.getName()+">");
	}
}
