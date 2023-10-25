package edu.spring.mall.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // Proxy ��ü�� ����(injection)�ϱ� ���� ����
@Aspect // Aspect = Advice + Pointcut
public class HomeAspect {
	private static final Logger logger =
			LoggerFactory.getLogger(HomeAspect.class);
	
	// * Aspect
	// - �Ϲ������� �޼ҵ忡 Ư�� ����� �����Ŵ
	// - �޼ҵ� ���� ���Ŀ� Ư�� ����� �����ų �� ����
	
	// * Pointcut�� �����ϴ� ���
	// 1. @Before, @After, ... ������̼� �ȿ��� ����
	// 2. @Pointcut ������̼� �ȿ��� ����
	// - ������ Pointcut �� �ݺ��Ǵ� ���� ���� �� ����
	// - �� �� ������ Pointcut�� ���� advice �޼ҵ忡�� ����
	// �ȶ��ؾ� ��
	
	@Pointcut("execution(* edu.spring.mall.HomeController.home(..))") // �� ��ġ�� Ȩ�̶�� �޼ҵ�.���ٰ� �����̽��� �ϰ��ִ�.
	public void pcHome() {} // ����Ʈ�� ��ġ ����
	
	@Around("pcHome()") // ����Ʈ�� �޼ҵ带 ����
	public Object homeAdvice(ProceedingJoinPoint jp) {
		Object result = null;
		
		logger.info("===== homeAdvice");
		
		try {
			logger.info("===== home() ȣ�� ��"); // @before
			result = jp.proceed(); // HomeController.home() ����
			logger.info("===== home() ���� ��"); //@afterReturning
		} catch (Throwable e) { 
			// @afterThrowing
			logger.info("===== ���� �߻� : " + e.getMessage());
		} finally {
			logger.info("===== finally");
		}
		
		return result;
	}
}
