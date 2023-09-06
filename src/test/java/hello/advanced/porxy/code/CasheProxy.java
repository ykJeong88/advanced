package hello.advanced.porxy.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CasheProxy implements Subject{

    private Subject target;
    private String cacheValue;

    public CasheProxy(Subject target) {
        this.target = target;
    }

    @Override
    public String operation() {
        log.info("프록시 호출");
        if(cacheValue == null) {
            cacheValue = target.operation();
        }
        return null;
    }
}
