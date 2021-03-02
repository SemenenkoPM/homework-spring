//package ru.itsjava.quoters;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.config.BeanPostProcessor;
//
//import java.lang.reflect.Proxy;
//import java.util.HashMap;
//import java.util.Map;
//
//public class ProFilingHandlerBeanPostProcessor implements BeanPostProcessor {
//    private Map<String, Class> map = new HashMap<>();
//    @Override
//    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
////        Class<?> beanClass = bean.getClass();
////        if(beanClass.isAnnotationPresent(Profiling.class)) {
////            map.put(beanName, beanClass)
////        }
////        return bean;
////    }
//
//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        Class beanClass = map.get(beanName);
//        if(beanClass !=null){
//            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), );
//        }
//        return bean;
//    }
//}
