package com.contais.thrift.service.impl;

import com.contais.thrift.thrift.api.HelloService;
import org.apache.thrift.TException;
import org.springframework.stereotype.Service;

/**
 * @author Contais
 * @version 1.0
 * @description com.contais.thrift.service
 * @date 2019/3/16
 */
@Service
public class HelloServiceImpl implements HelloService.Iface {
    @Override
    public String greet(String name) throws TException {
        return "hello thrift ~";
    }
}
