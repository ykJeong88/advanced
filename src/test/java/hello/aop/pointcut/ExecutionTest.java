package hello.aop.pointcut;

import hello.aop.member.MemberserviceImpl;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import java.lang.reflect.Method;

@Slf4j
public class ExecutionTest {

    AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
    Method helloMethod;

    @BeforeEach
    public void init() throws NoSuchMethodException {
        helloMethod = MemberserviceImpl.class.getMethod("hello", String.class);
    }

    @Test
    void printMehtod() {
        // execution(* ..package..Class.)
        // helloMethod=public java.lang.String hello.aop.member.MemberserviceImpl.hello(java.lang.String)
        log.info("helloMethod={}", helloMethod);
    }
}
