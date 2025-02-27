package kuks.back.kuksmsa.config;

@Configuration
public class WebServerConfig implements WebMvcConfigurer{

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new MappingJackson2HttpMessageConverter());
        converters.add(new MappingJackson2XmlHttpMessageConverter());
    }
}
