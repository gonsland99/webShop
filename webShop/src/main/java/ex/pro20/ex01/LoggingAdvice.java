package ex.pro20.ex01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LoggingAdvice implements MethodInterceptor{
	public Object invoke(MethodInvocation invocation) throws Throwable{
		System.out.println("메서드 호출전: LogginAdvice");
		System.out.println(invocation.getMethod() + "메서드 호출전");
		
		Object object = invocation.proceed();
		
		System.out.println("메서드 호출후: loggingAdvice");
		System.out.println(invocation.getMethod()+"메서드 호출후");
		return object;
	}
}

