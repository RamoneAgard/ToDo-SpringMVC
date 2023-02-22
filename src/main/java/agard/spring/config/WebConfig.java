package agard.spring.config;

import agard.spring.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "agard.spring")
public class WebConfig implements WebMvcConfigurer {

    // Constants
    private static final String RESLOVER_PREFIX = "/WEB-INF/view/";
    private static final String RESLOVER_SUFFIX = ".jsp";

    // Bean Methods
    @Bean
    public ViewResolver viewResolver(){
        UrlBasedViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix(RESLOVER_PREFIX);
        viewResolver.setSuffix(RESLOVER_SUFFIX);
        return viewResolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME);
    }
}
