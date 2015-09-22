package com.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// SAX���������ν���xml�ĵ���
public class MyDefaultHandler extends  DefaultHandler{
	
	//��ʼ�ĵ�ʱ����
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("MyDefaultHandler.startDocument()");
	}
	
	//��ʼ��ǩʱ����
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("MyDefaultHandler.startElement()-->"+qName);
	}
	
	//������ǩʱ����
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("MyDefaultHandler.endElement()-->"+qName);
	}

	//�����ı����ݵ�ʱ����
	//ch: ��ʾ��ǰ����������ı�����
	//start�� ��ʾ��ǰ�ı����ݵĿ�ʼλ��
	//length: ��ʾ��ǰ�ı����ݵĳ���
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		String content = new String(ch,start,length);
		System.out.println("MyDefaultHandler.characters()-->"+content);
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("MyDefaultHandler.endDocument()");
	}

	

	



}
