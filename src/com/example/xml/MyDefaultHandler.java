package com.example.xml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

// SAX处理程序（如何解析xml文档）
public class MyDefaultHandler extends  DefaultHandler{
	
	//开始文档时调用
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("MyDefaultHandler.startDocument()");
	}
	
	//开始标签时调用
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		System.out.println("MyDefaultHandler.startElement()-->"+qName);
	}
	
	//结束标签时调用
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		System.out.println("MyDefaultHandler.endElement()-->"+qName);
	}

	//读到文本内容的时调用
	//ch: 表示当前读完的所有文本内容
	//start： 表示当前文本内容的开始位置
	//length: 表示当前文本内容的长度
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
