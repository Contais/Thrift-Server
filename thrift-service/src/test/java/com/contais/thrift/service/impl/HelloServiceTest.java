package com.contais.thrift.service.impl;

import com.contais.thrift.AbstractTest;
import com.contais.thrift.thrift.api.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.service
 * @date 2019/3/16
 */
@Slf4j
public class HelloServiceTest extends AbstractTest{

    @Autowired
//    @Qualifier("helloService")
    private HelloService.Iface helloService;

    @Test
    public void testLocal(){
        try {
            log.info("本地调用服务...{}", helloService.greet("Local"));
        } catch (TException e) {
            log.error("本地调用异常...", e);
        }
    }

    @Test
    public void testRemote() {
        try (TTransport transport = new TSocket("localhost", 9898, 30000)) {
            TProtocol protocol = new TBinaryProtocol(transport);
            HelloService.Client helloService = new HelloService.Client(protocol);
            transport.open();
            log.info("远程调用服务...{}", helloService.greet("Remote"));
        } catch (TException e) {
            log.error("远程调用异常.", e);
        }
    }

}
