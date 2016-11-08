package com.jeroenreijn.examples.factory;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.web.context.ServletContextAware;

public class ServletContextFactory implements FactoryBean<ServletContext>, ServletContextAware {

    private ServletContext servletContext;

    @Override
    public ServletContext getObject() throws Exception {
        return this.servletContext;
    }

    @Override
    public Class<?> getObjectType() {
        return ServletContext.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
