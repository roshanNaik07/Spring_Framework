package com.xworkz.pickleBall.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class PickleBallInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    public PickleBallInit() {
        System.out.println("Running initializer");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{PickleConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/**"};
    }
}
