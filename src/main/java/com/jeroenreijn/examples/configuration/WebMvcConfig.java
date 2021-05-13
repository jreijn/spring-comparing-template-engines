package com.jeroenreijn.examples.configuration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import com.jeroenreijn.examples.view.*;
import org.apache.velocity.tools.generic.LinkTool;
import org.fusesource.scalate.spring.view.ScalateViewResolver;
import org.rythmengine.spring.web.RythmConfigurer;
import org.rythmengine.spring.web.RythmViewResolver;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;

import com.github.enpassant.ickenham.springmvc.IckenhamViewResolver;
import com.github.jknack.handlebars.springmvc.HandlebarsViewResolver;
import com.jeroenreijn.examples.repository.InMemoryPresentationsRepository;
import com.jeroenreijn.examples.repository.PresentationsRepository;
import com.x5.template.spring.ChunkTemplateView;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.spring.template.SpringTemplateLoader;
import de.neuland.jade4j.spring.view.JadeViewResolver;
import httl.web.springmvc.HttlViewResolver;

import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityLayoutViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.jeroenreijn.examples.controller", "com.jeroenreijn.examples.factory"})
public class WebMvcConfig implements ApplicationContextAware, WebMvcConfigurer {
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/robots.txt").addResourceLocations("/robots.txt");
        registry.addResourceHandler("/webjars/**").addResourceLocations("/webjars/");
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:/messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Bean
    public LocaleResolver myLocaleResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);

        return slr;
    }

    @Bean
    public PresentationsRepository presentationsRepository() {
        PresentationsRepository inMemory = new InMemoryPresentationsRepository();

        return inMemory;
    }

    @Bean
    public SpringResourceTemplateResolver thymeleafTemplateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(this.applicationContext);
        templateResolver.setPrefix("/WEB-INF/thymeleaf/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCacheable(false);
        templateResolver.setCharacterEncoding("UTF-8");

        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine thymeleafTemplateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(thymeleafTemplateResolver());

        return templateEngine;
    }

    @Bean
    public ViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setViewNames(new String[]{"*-thymeleaf"});
        viewResolver.setTemplateEngine(thymeleafTemplateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setCache(false);

        return viewResolver;
    }

    @Bean
    public ViewResolver velocityViewResolver() {
        VelocityLayoutViewResolver bean = new VelocityLayoutViewResolver();
        bean.setPrefix("/WEB-INF/velocity/");
        bean.setViewNames("*-velocity");
        bean.setLayoutUrl("/WEB-INF/velocity/layout.vm");
        bean.setSuffix(".vm");
//        bean.setToolboxConfigLocation("/WEB-INF/velocity/toolbox.xml");
        LinkTool l = new LinkTool();
        bean.getAttributesMap().put("link",l);
        bean.setCache(false);
        return bean;
    }

    @Bean
    public VelocityConfigurer velocityConfig() {
        VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
        velocityConfigurer.setResourceLoaderPath("/");
        return velocityConfigurer;
    }

    @Bean
    public ViewResolver handlebarsViewResolver() {
        HandlebarsViewResolver viewResolver = new HandlebarsViewResolver();
        viewResolver.setViewNames("*-handlebars");
        viewResolver.setPrefix("/WEB-INF/handlebars/");
        viewResolver.setSuffix(".hbs");
        viewResolver.setCache(false);

        return viewResolver;
    }

    @Bean(name = "chunkTemplatesConfig")
    @Scope("prototype")
    public Map<String, String> chunkTemplatesConfig() {
        Map<String, String> config = new HashMap<>();
        config.put("default_extension", "chtml");
        config.put("cache_minutes", "0");
        config.put("layers", "");
        config.put("theme_path", "");
        config.put("hide_errors", "FALSE");
        config.put("error_log", "");
        config.put("encoding", "UTF-8");
        config.put("locale", "");
        config.put("filters", "");

        return config;
    }

    @Bean
    public ViewResolver chunkViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(ChunkTemplateView.class);
        viewResolver.setPrefix("/WEB-INF/chunk/");
        viewResolver.setViewNames("*-chunk");
        viewResolver.setSuffix(".chtml");
        viewResolver.setCache(false);
        viewResolver.setRequestContextAttribute("rc");
        viewResolver.setContentType("text/html;charset=UTF-8");

        return viewResolver;
    }

    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setViewClass(JstlView.class);
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setViewNames("*-jsp");
        viewResolver.setSuffix(".jsp");
        viewResolver.setCache(false);
        viewResolver.setRequestContextAttribute("rc");

        return viewResolver;
    }

    @Bean
    public ViewResolver httlViewResolver() {
        HttlViewResolver viewResolver = new HttlViewResolver();
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setViewNames("*-httl");
        viewResolver.setCache(false);

        return viewResolver;
    }

    @Bean
    public SpringTemplateLoader jade4jTemplateLoader() {
        SpringTemplateLoader templateLoader = new SpringTemplateLoader();
        templateLoader.setEncoding("UTF-8");

        return templateLoader;
    }

    @Bean
    public JadeConfiguration jadeConfiguration() {
        JadeConfiguration config = new JadeConfiguration();
        config.setPrettyPrint(true);
        config.setCaching(false);
        config.setTemplateLoader(applicationContext.getBean(SpringTemplateLoader.class));

        return config;
    }

    @Bean
    public ViewResolver jadeViewResolver() {
        JadeViewResolver viewResolver = new JadeViewResolver();
        viewResolver.setPrefix("/WEB-INF/jade/");
        viewResolver.setSuffix(".jade");
        viewResolver.setViewNames("*-jade");
        viewResolver.setRenderExceptions(true);
        viewResolver.setCache(false);
        viewResolver.setConfiguration(applicationContext.getBean(JadeConfiguration.class));

        return viewResolver;
    }

    @Bean
    public ViewResolver scalateViewResolver() {
        ScalateViewResolver viewResolver = new ScalateViewResolver();
        viewResolver.setPrefix("/WEB-INF/scalate/");
        viewResolver.setSuffix(".scaml");
        viewResolver.setViewNames("*-scalate");
        viewResolver.setRequestContextAttribute("rc");
        viewResolver.setCache(false);
        viewResolver.setContentType("text/html;charset=UTF-8");

        return viewResolver;
    }

    @Bean
    public ViewResolver htmlFlowViewResolver() {
        HtmlFlowViewResolver viewResolver = new HtmlFlowViewResolver();
        viewResolver.setViewNames("*-htmlFlow");
        viewResolver.setCache(false);

        return viewResolver;
    }

    @Bean
    public ViewResolver trimouViewResolver() {
        MessageSource messageSource = applicationContext.getBean(MessageSource.class);
        TrimouViewResolver viewResolver = new TrimouViewResolver(messageSource);
        viewResolver.setPrefix("classpath:/templates/trimou/");
        viewResolver.setSuffix(".trimou");
        viewResolver.setViewNames("*-trimou");
        viewResolver.setCache(false);

        return viewResolver;
    }

    @Bean
    public ViewResolver rockerViewResolver() {
        RockerViewResolver viewResolver = new RockerViewResolver();
        viewResolver.setViewNames("*-rocker");
        viewResolver.setCache(false);

        return viewResolver;
    }

    @Bean
    public ViewResolver ickenhamViewResolver() {
        IckenhamViewResolver viewResolver = new IckenhamViewResolver();
        viewResolver.setPrefix("/WEB-INF/ickenham/");
        viewResolver.setSuffix(".hbs");
        viewResolver.setViewNames("*-ickenham");
        viewResolver.setRequestContextAttribute("rc");
        viewResolver.setCache(false);
        viewResolver.setContentType("text/html;charset=UTF-8");

        return viewResolver;
    }

    @Bean
    public RythmConfigurer rythmConfigurer() {
        RythmConfigurer conf = new RythmConfigurer();
        conf.setDevMode(true);
        conf.setResourceLoaderPath("/WEB-INF/rythm/");
        conf.setAutoImports("com.jeroenreijn.examples.model.*");

        return conf;
    }

    @Bean
    public ViewResolver rythmViewResolver() {
        RythmViewResolver viewResolver = new RythmViewResolver();
        viewResolver.setPrefix("/WEB-INF/rythm/");
        viewResolver.setSuffix(".html");
        viewResolver.setViewNames("*-rythm");
        viewResolver.setCache(false);
        viewResolver.setContentType("text/html;charset=UTF-8");

        return viewResolver;
    }

    @Bean
    public LiqpViewResolver liqpViewResolver() {
        LiqpViewResolver viewResolver = new LiqpViewResolver(applicationContext.getBean(MessageSource.class));
        viewResolver.setViewClass(LiqpView.class);
        viewResolver.setPrefix("classpath:./templates/liqp/");
        viewResolver.setSuffix(".liqp");
        viewResolver.setViewNames("*-liqp");
        viewResolver.setCache(false);
        viewResolver.setContentType("text/html;charset=UTF-8");

        return viewResolver;
    }

    @Bean
    public ViewResolver kotlinxHtmlViewResolver() {
        KotlinxHtmlViewResolver viewResolver = new KotlinxHtmlViewResolver();
        viewResolver.setViewNames("*-kotlinx");
        viewResolver.setCache(false);

        return viewResolver;
    }

    @Controller
    static class FaviconController {
        @RequestMapping("favicon.ico")
        String favicon() {
            return "forward:/resources/images/favicon.ico";
        }
    }
}
