package com.example.xml;

import java.io.File;
import java.io.FileOutputStream;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Demo11 {

 
	public static void main(String[] args) throws Exception {
		
		//1.内存创建xml文档
		Document doc = DocumentHelper.createDocument();
		//2.写入内容
		Element rootElem = doc.addElement("Students");
		
		//2.1 增加标签
		Element studentElem1 = rootElem.addElement("Student");
		//2.2 增加属性
		studentElem1.addAttribute("id", "1");
		//2.3 增加标签，同时设置文本
		studentElem1.addElement("name").setText("张三");
		studentElem1.addElement("gender").setText("男");
		studentElem1.addElement("grade").setText("计算机1班");
		studentElem1.addElement("address").setText("广州天河");
		
		//2.1 增加标签
		Element studentElem2 = rootElem.addElement("Student");
		//2.2 增加属性
		studentElem2.addAttribute("id", "2");
		//2.3 增加标签，同时设置文本
		studentElem2.addElement("name").setText("李四");
		studentElem2.addElement("gender").setText("女");
		studentElem2.addElement("grade").setText("计算机2班");
		studentElem2.addElement("address").setText("广州越秀");
		
		//3.内容写出到xml文件
		save(doc);
		
		//删除除id值为2的学生标签  使用xpath
		Document doc1 = new SAXReader().read(new File("C:/Users/Administrator/Desktop/test/student.xml"));
		Element stuElem = (Element)doc1.selectSingleNode("//Student[@id='2']");
		stuElem.detach();
		
		save(doc1);
	}

	private static void save(Document  doc) throws Exception{
		//3.1 输出位置
		FileOutputStream out = new FileOutputStream("C:/Users/Administrator/Desktop/test/student.xml");
		//3.2 指定格式
		OutputFormat format = OutputFormat.createPrettyPrint();
		// 设置编码
		format.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(out,format);
		//3.3 写出内容
		writer.write(doc);
		//3.4关闭资源
		writer.close();
	}
}
