package com.rpc.spring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.lang.annotation.Annotation;

/**
 * @Author: djc
 * @Date: 2024-09-12-19:57
 * @Description:
 */
public class CustomScanner extends ClassPathBeanDefinitionScanner {
    public CustomScanner(BeanDefinitionRegistry registry, Class<? extends Annotation> annType){
        super(registry);
        super.addIncludeFilter(new AnnotationTypeFilter(annType));
    }
    @Override
    public int scan(String... basePackages) {
        return super.scan(basePackages);
    }
}
