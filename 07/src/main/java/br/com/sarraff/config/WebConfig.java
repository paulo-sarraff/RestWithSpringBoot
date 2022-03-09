package br.com.sarraff.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	
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
		.defaultContentType(MediaType.APPLICATION_JSON) .mediaType("json", MediaType.APPLICATION_JSON) 
		.mediaType("xml", MediaType.APPLICATION_XML);
	}

}
