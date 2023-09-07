package hello.advanced.porxy.pureproxy.proxy.code;

import hello.advanced.porxy.pureproxy.proxy.code.CasheProxy;
import hello.advanced.porxy.pureproxy.proxy.code.ProxyPatternClient;
import hello.advanced.porxy.pureproxy.proxy.code.RealSubject;
import org.junit.jupiter.api.Test;

public class ProxyPatterTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CasheProxy casheProxy = new CasheProxy(realSubject);
        ProxyPatternClient client = new ProxyPatternClient(casheProxy);
        client.execute();
        client.execute();
        client.execute();
    }
}
