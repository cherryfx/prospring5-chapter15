package com.cherry.prospring5.ch15.config;

import com.cherry.prospring5.ch15.AppStatistics;
import com.cherry.prospring5.ch15.AppStatisticsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jmx.export.MBeanExporter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashMap;
import java.util.Map;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"com.cherry.prospring5.ch15"})
public class WebConfig implements WebMvcConfigurer {
    @Bean
    AppStatistics appStatisticsBean() {
        return new AppStatisticsImpl();
    }

    @Bean
    MBeanExporter jmxExporter() {
        MBeanExporter exporter = new MBeanExporter();
        Map<String, Object> beans = new HashMap<>();
        beans.put("bean:name=ProSpring5SingerApp", appStatisticsBean());
        exporter.setBeans(beans);
        return exporter;
    }
}
