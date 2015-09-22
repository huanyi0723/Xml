package com.example.xml;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyDefaultHandler3 extends DefaultHandler{
	
	private List<Contact> list = new ArrayList<Contact>(); //�洢������ϵ�˶���
	public List<Contact> getList(){
		return list;
	}
	//����һ����ϵ����Ϣ
	private Contact contact;
	/**
	 * ˼·�� 
	 * 	1������Contact����
	 *  2����ÿ��contact��ǩ���ݴ��뵽Contact����
	 *  3����Contact�������List��
	 */
	private String curTag; //������ʱ�洢��ǰ�����ı�ǩ��

	//��ʼ�ĵ�ʱ����
	@Override
	public void startDocument() throws SAXException {
		super.startDocument();
		System.out.println("MyDefaultHandler.startDocument()");
	}
	
	//��ʼ��ǩʱ����
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		super.startElement(uri, localName, qName, attributes);
		curTag = qName;
		//��ȡ��contact�Ŀ�ʼ��ǩ����Contact����
		if("contact".equals(qName)){
			contact = new Contact();
			
			//����idֵ
			contact.setId(attributes.getValue("id"));
		}
	}
	
	//�����ı����ݵ�ʱ����
	//ch: ��ʾ��ǰ����������ı�����
	//start�� ��ʾ��ǰ�ı����ݵĿ�ʼλ��
	//length: ��ʾ��ǰ�ı����ݵĳ���
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		super.characters(ch, start, length);
		//��ǰ�ı�����
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
	
	//������ǩʱ����
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		super.endElement(uri, localName, qName);
		//���ÿ�ʱΪ�˱���ո������õ������������
		curTag = null;
		//����contact�Ľ�����ǩ����List��
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
