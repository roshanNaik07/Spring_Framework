package com.xworkz.grocery.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class GroceryInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    public GroceryInit() {
        System.out.println("Running GroceryInit created by spring");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{GroceryConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/mashroom", "/soap", "/butter", "/bottle", "/shoe", "/chappal", "/socks", "/chutney", "/onion", "/milk", "/curry", "/biryani", "/parota", "/egg"};
    }
}
