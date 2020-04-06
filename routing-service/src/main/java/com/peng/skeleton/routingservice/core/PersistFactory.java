package com.peng.skeleton.routingservice.core;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.lang.reflect.Method;

class PersistProxy implements MethodInterceptor {

    private final Class<?> originalCls;

    PersistProxy(Class<?> cls) {
        this.originalCls = cls;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Persist persist = this.originalCls.getAnnotation(Persist.class);
        if (persist != null) {
            System.out.println(String.format("persist table = %s", persist.table()));
        }

        PersistOperation operation = method.getAnnotation(PersistOperation.class);
        if (operation != null) {
            System.out.println(String.format("persist operation = %s", operation.type().toString()));

            IPersistOperation operationObject = null;
            if (operation.type() == PersistOperationType.CREATE){
                operationObject = new CreateOperation(persist.table(), method, objects);
            }
            return operationObject.execute();
        } else {
            return methodProxy.invokeSuper(o, objects);
        }
    }
}


public class PersistFactory {
    public static <T> T getDAO(Class<T> cls) {
        Enhancer e = new Enhancer();
        e.setSuperclass(cls);
        e.setCallback(new PersistProxy(cls));
        return (T) e.create();
    }
}
