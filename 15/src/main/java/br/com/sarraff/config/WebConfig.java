package br.com.sarraff.config;


import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.sarraff.serialization.converter.YamlJackson2HttpMessageConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	
	private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
	
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJackson2HttpMessageConverter());
	}
	
	public void addCorsMappigs(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedMethods("GET","POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
	}
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		/* content negotiation via extensão: localhost:8080/api/person/v1.json
		 * configurer.favorParameter(false) .ignoreAcceptHeader(false)
		 * .defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json",
		 * MediaType.APPLICATION_JSON) .mediaType("xml", MediaType.APPLICATION_XML);
		 */
		
		
		//content negotiation via url: localhost:8080/api/person/v1?mediaType=json
		/*configurer.favorPathExtension(false)
		.favorParameter(true)
		.parameterName("mediaType")
		.ignoreAcceptHeader(true)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json", MediaType.APPLICATION_JSON) 
		.mediaType("xml", MediaType.APPLICATION_XML);*/
		
		//content negotiation via header: colocar parâmetros no header (Accept = application/json)
		configurer.favorPathExtension(false)
		.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON) 
		.mediaType("json", MediaType.APPLICATION_JSON) 
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("x-yaml", MEDIA_TYPE_YML);
	}

}
