package com.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler2 extends DefaultHandler {
	
	//�洢xml�ĵ���Ϣ
	private StringBuffer sb = new StringBuffer();
	
	//��ȡxml��Ϣ
	public String getContent(){
		return sb.toString();
	}
	
	// ��ʼ��ǩ
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		
		sb.append("<"+qName);
		//�ж��Ƿ�������
		if(attributes!=null){
			for(int i=0;i<attributes.getLength();i++){
				//�õ���������
				String attrName = attributes.getQName(i);
				//�õ�����ֵ
				String attrValue = attributes.getValue(i);
				sb.append(" "+attrName+"=\""+attrValue+"\"");
			}
		}
		sb.append(">");
	}

	//�ı�����
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		//�õ���ǰ��ȡ���ı�
		String content = new String(ch,start,length);
		sb.append(content);
	}

	//������ǩ
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		sb.append("</"+qName+">");
	}
	
}

