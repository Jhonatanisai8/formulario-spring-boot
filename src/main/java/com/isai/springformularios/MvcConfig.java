package com.isai.springformularios;

import com.isai.springformularios.interceptors.TiempoTranscurridoInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig
        implements WebMvcConfigurer {


    @Autowired
    @Qualifier("tiempoTranscurridoInterceptor") // inyectamos la clase que hemos preparado
    private HandlerInterceptor tiempoTranscurridoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tiempoTranscurridoInterceptor);
    }
}
