package hello.advanced.porxy.pureproxy.concreteproxy;

import hello.advanced.porxy.pureproxy.concreteproxy.code.ConcreteClient;
import hello.advanced.porxy.pureproxy.concreteproxy.code.ConcreteLogic;
import hello.advanced.porxy.pureproxy.concreteproxy.code.TimeProxy;
import org.junit.jupiter.api.Test;

public class ConcreteProxyTest {

    @Test
    void noPorxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }
}
