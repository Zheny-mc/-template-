import java.text.DateFormat;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy     
public class CalcInfoAspect {

	@Before("execution(* springhw.*.*.*(..))")
    public void calcStartInfo(JoinPoint jp) {
    	System.out.println("start: "+jp.getSignature());
    }
	/*
	@Before("execution(* springhw.aopendtoendservices.*.toString(..))")
    public void calcShow(JoinPoint jp) {
    	System.out.println("start: " + jp.getSignature());
    }
	*/
	@Around("execution(* springhw.*.*.*(..))")
	public Object checkExecutionTime(ProceedingJoinPoint jp) throws Throwable{		
		long start = System.currentTimeMillis();
		System.out.println("---------------------"+ DateFormat.getTimeInstance().format(start)+ "-------------");		
		System.out.println("Время запуска: "+  start);		
		
		Object r = jp.proceed();
		
		long end = System.currentTimeMillis();		
		System.out.println("Время остановки:  "+ end);
		System.out.println("Выполнение метода "+jp.getSignature()+" заняло "+ (end-start)+ " мсек." );
        return r;    		
	}
	/*
	@AfterThrowing("execution(* springhw.aopendtoendservices.NumGenerator.getSqrtSum(..))")
    public void calcStertInfo() {
    	System.out.println("Аспект: Под знаком корня отрицательное значение");
    }
	
	@AfterThrowing("execution(* springhw.aopendtoendservices.NumGenerator.getDocument(..))")
    public void calcStartInfo() {
    	System.out.println("Аспект: документ создан");
    }
	*/
	
}
