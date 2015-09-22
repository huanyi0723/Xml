package com.example.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler3 extends DefaultHandler{
	
	private List<Contact> list = new ArrayList<Contact>(); //存储所有联系人对象
	public List<Contact> getList(){
		return list;
	}
	//保存一个联系人信息
	private Contact contact;
	/**
	 * 思路： 
	 * 	1）创建Contact对象
	 *  2）把每个contact标签内容存入到Contact对象
	 *  3）把Contact对象放入List中
	 */
	private String curTag; //用于临时存储当前读到的标签名

	//开始文档时调用
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("MyDefaultHandler.startDocument()");
	}
	
	//开始标签时调用
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		curTag = qName;
		//读取到contact的开始标签创建Contact对象
		if("contact".equals(qName)){
			contact = new Contact();
			
			//设置id值
			contact.setId(attributes.getValue("id"));
		}
	}
	
	//读到文本内容的时调用
	//ch: 表示当前读完的所有文本内容
	//start： 表示当前文本内容的开始位置
	//length: 表示当前文本内容的长度
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		//当前文本内容
		String content = new String(ch,start,length);
		
		if("name".equals(curTag)){
			contact.setName(content);
		}
		
		if("age".equals(curTag)){
			contact.setAge(content);
		}
		
		if("phone".equals(curTag)){
			contact.setPhone(content);
		}
		
		if("email".equals(curTag)){
			contact.setEmail(content);
		}
		
		if("qq".equals(curTag)){
			contact.setQq(content);
		}
	}
	
	//结束标签时调用
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		//设置空时为了避免空格换行设置到对象的属性中
		curTag = null;
		//读到contact的结束标签放入List中
		if("contact".equals(qName)){
			list.add(contact);
		}
	}

	@Override
	public void endDocument() throws SAXException {
		super.endDocument();
		System.out.println("MyDefaultHandler.endDocument()");
	}
	
}
