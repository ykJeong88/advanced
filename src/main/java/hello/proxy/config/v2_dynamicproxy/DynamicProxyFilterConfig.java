package hello.proxy.config.v2_dynamicproxy;

import hello.advanced.trace.logtrace.LogTrace;
import hello.proxy.app.v1.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Proxy;

@Configuration
public class DynamicProxyFilterConfig {

    private static final String[] PATTERNS = {"request*", "order*", "save*"};
    @Bean
    OrderControllerV1 orderControllerV1(LogTrace logTrace) {
        OrderControllerV1 orderControllerV1 = new OrderControllerV1Impl(orderServiceV1(logTrace));
        OrderControllerV1 proxy = (OrderControllerV1) Proxy.newProxyInstance(OrderControllerV1.class.getClassLoader()
                , new Class[]{OrderControllerV1.class}
                , new LogTraceFilterHandler(orderControllerV1, logTrace, PATTERNS));

        return proxy;
    }

    @Bean
    OrderServiceV1 orderServiceV1(LogTrace logTrace) {
        OrderServiceV1 orderServiceV1 = new OrderServiceV1Impl(orderRepositoryV1(logTrace));
        OrderServiceV1 proxy = (OrderServiceV1) Proxy.newProxyInstance(OrderServiceV1.class.getClassLoader()
                , new Class[]{OrderServiceV1.class}
                , new LogTraceFilterHandler(orderServiceV1, logTrace, PATTERNS));

        return proxy;
    }

    @Bean
    public OrderRepositoryV1 orderRepositoryV1(LogTrace logTrace) {
        OrderRepositoryV1 orderRepositoryV1 = new OrderRepositoryV1Impl();
        OrderRepositoryV1 proxy = (OrderRepositoryV1) Proxy.newProxyInstance(OrderRepositoryV1.class.getClassLoader()
                , new Class[]{OrderRepositoryV1.class}
                , new LogTraceFilterHandler(orderRepositoryV1, logTrace, PATTERNS));

        return proxy;
    }
}
