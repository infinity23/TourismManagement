package spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.SpringBeanPreparerFactory;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
//@ComponentScan(basePackages = {"tm"}, useDefaultFilters = false,
//        includeFilters = @ComponentScan.Filter
//                (type = FilterType.ANNOTATION, value = Controller.class))
@ComponentScan(value = {"tm.controller"},includeFilters = @ComponentScan.Filter(Controller.class))
public class WebConfig extends WebMvcConfigurerAdapter {

    //Tiles视图解析器，解析为Tiles视图
    @Bean
    public ViewResolver tilesViewResolver() {
        return new TilesViewResolver();
    }

    //普通视图解析器，解析为内部JSP
    @Bean
    public ViewResolver internalViewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(
                org.springframework.web.servlet.view.JstlView.class
        );
        return resolver;
    }

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions("/WEB-INF/layout/tiles.xml");
        tiles.setCheckRefresh(true);
        tiles.setPreparerFactoryClass(SpringBeanPreparerFactory.class);
        return tiles;
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
