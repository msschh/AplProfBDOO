package com.apbdoo.lab8.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { Lab8Config.class };
    }
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
