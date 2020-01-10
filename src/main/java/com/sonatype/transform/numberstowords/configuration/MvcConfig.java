package com.sonatype.transform.numberstowords.configuration;

import com.sonatype.transform.numberstowords.converters.BaseNumberToWordConvert;
import com.sonatype.transform.numberstowords.converters.NumberToWordConverter;
import com.sonatype.transform.numberstowords.languages.Language;
import com.sonatype.transform.numberstowords.utils.ConvertUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(
                "/webjars/**",
                "/img/**",
                "/css/**",
                "/js/**")
                .addResourceLocations(
                        "classpath:/META-INF/resources/webjars/",
                        "classpath:/static/img/",
                        "classpath:/static/css/",
                        "classpath:/static/js/");
    }

    @Bean
    public NumberToWordConverter numberToEnglishWordConverter(
            BaseNumberToWordConvert englishBaseNumberToWordConvert,
            ConvertUtils convertUtils) {
        return new NumberToWordConverter(englishBaseNumberToWordConvert, convertUtils);
    }

    @Bean
    public BaseNumberToWordConvert englishBaseNumberToWordConvert(Language englishLanguage){
        return new BaseNumberToWordConvert(englishLanguage.baseNumbers(), englishLanguage.baseForms());
    }


}
