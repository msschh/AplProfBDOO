package com.apbdoo.lab8.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.dialect.SpringStandardDialect;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;

@Configuration
@EnableWebMvc
public class Lab8Config {

    @Bean(name = "templateEngine")
    public SpringTemplateEngine templateEngine(ServletContext servletContext){
        SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
        springTemplateEngine.setDialect(new SpringStandardDialect());

        springTemplateEngine.setTemplateResolver(templateResolver(servletContext));
        return springTemplateEngine;
    }

    @Bean(name = "ServletContextTemplateResolver")
    public ServletContextTemplateResolver templateResolver(ServletContext servletContext){
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);
        templateResolver.setPrefix("WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }

    @Bean(name = "viewResolver")
    public ViewResolver viewResolver(ServletContext servletContext){
        ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
        thymeleafViewResolver.setCharacterEncoding("UTF-8");
        thymeleafViewResolver.setTemplateEngine(templateEngine(servletContext));
        return thymeleafViewResolver;
    }

}
