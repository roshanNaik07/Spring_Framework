package com.xworkz.scott.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ScottInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    public ScottInit(){
        System.out.println("ScottInit running");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{TransportConfiguration.class,ArtConfiguration.class,SmartPhoneConfiguration.class, FashionConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }
}
