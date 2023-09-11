package hello.advanced.proxy.pureproxy.decorator.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DecoratorPatternClient {

    private Component component;


    public DecoratorPatternClient(Component component) {
        this.component = component;
    }

    public void excute() {
        String result = component.operation();
        log.info("result={}", result);
    }
}
