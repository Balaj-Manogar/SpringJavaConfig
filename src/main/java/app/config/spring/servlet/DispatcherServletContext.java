package app.config.spring.servlet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import app.config.spring.context.SpringGlobalContext;

/**
 * Created by Balaji on 01/11/16.
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "org.baali.web.controller",
                basePackageClasses = SpringGlobalContext.class)
public class DispatcherServletContext extends WebMvcConfigurerAdapter
{
    @Bean
    public ViewResolver viewResolverBean()
    {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
