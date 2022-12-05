package ex.pro20.ex01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CalcTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("AOPTest.xml");
		Calculator cal = (Calculator) context.getBean("proxyCal");
		cal.add(10, 20); 
		System.out.println();
		cal.subtract(20, 10); 
		System.out.println();
		cal.multiply(10, 20); 
		System.out.println();
		cal.divide(20, 10); 
	}
}
