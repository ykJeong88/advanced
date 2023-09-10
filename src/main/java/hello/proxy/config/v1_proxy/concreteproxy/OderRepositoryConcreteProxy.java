package hello.proxy.config.v1_proxy.concreteproxy;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.LogTrace;
import hello.proxy.app.v2.OrderRepositoryV2;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    @Override
    public void save(String itemId) {
        TraceStatus status = null;

        try{
            status = logTrace.begin("OrderRepository.request()");
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }

}
