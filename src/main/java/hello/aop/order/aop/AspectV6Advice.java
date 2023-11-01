package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Slf4j
@Aspect
public class AspectV6Advice {

    @Around("hello.aop.order.aop.Pointcuts.allOrderAndAllService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            //@Before
            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            //@AfterReturning
            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            //@AfterThrowing
            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
            throw e;
        } finally {
            //@After
            log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
        }
    }

    @Before("hello.aop.order.aop.Pointcuts.allOrderAndAllService()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("[before] {}", joinPoint.getSignature());
    }

    @AfterReturning(value="hello.aop.order.aop.Pointcuts.allOrderAndAllService()", returning = "result")
    public void doReturn(JoinPoint joinPoint, Object result) {
        log.info("[afterReturning] joinPoint = {}, result = {}", joinPoint.getSignature(), result);
    }

    @AfterReturning(value="hello.aop.order.aop.Pointcuts.allOrder()", returning = "result")
    public void doReturn2(JoinPoint joinPoint, Object result) {
        log.info("[doReturn2] joinPoint = {}, result = {}", joinPoint.getSignature(), result);
    }

    @AfterThrowing(value="hello.aop.order.aop.Pointcuts.allOrderAndAllService()", throwing = "ex")
    public void doReturn(JoinPoint joinPoint, Exception ex) {
        log.info("[AfterThrowing] joinPoint = {}, ex = {}", joinPoint.getSignature(), ex);
    }

    @After(value="hello.aop.order.aop.Pointcuts.allOrderAndAllService()")
    public void doAfter(JoinPoint joinPoint) {
        log.info("[After] {}", joinPoint.getSignature());
    }
}
