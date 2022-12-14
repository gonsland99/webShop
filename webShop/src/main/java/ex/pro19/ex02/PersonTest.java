package ex.pro19.ex02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class PersonTest {
	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		PersonService person = (PersonService) factory.getBean("personService1");
		person.sayHello();
		System.out.println();
		PersonService person2 = (PersonService) factory.getBean("personService2");
		person2.sayHello();
	}
}
