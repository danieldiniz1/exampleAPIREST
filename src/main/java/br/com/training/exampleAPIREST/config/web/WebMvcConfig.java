package br.com.training.exampleAPIREST.config.web;

import io.netty.channel.ChannelOption;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.netty.http.client.HttpClient;

import javax.net.ssl.SSLException;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Value("${web.cors.origin}")
    private String origin;

    @Value("${api.base.url}")
    private String baseUrl;

    @Override
    public void addCorsMappings(CorsRegistry registry) { //Configuracao para cors e aceitar requisições do front
        registry.addMapping("/**")
                .allowedOrigins(origin)
                .allowedMethods("HEAD", "OPTIONS", "PUT", "POST", "GET", "DELETE", "PATCH")
                .maxAge(3600L);
        WebMvcConfigurer.super.addCorsMappings(registry);
    }

    @Bean
    public WebClient client() throws SSLException {
//        Somente usar a config de SSL se o certificado for dinamico.
//        var sslContext = SslContextBuilder
//                .forClient()
//                .trustManager(InsecureTrustManagerFactory.INSTANCE)
//                .build();
//
//        var httpClient = HttpClient.create()
//                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS,1000)
//                .secure(t -> t.sslContext(sslContext));
//
//        ReactorClientHttpConnector connector = new ReactorClientHttpConnector(httpClient);

        return WebClient
                .builder()
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .clientConnector(connector) //usar somente quando api usa ssl dinamico.
                .build();

    }


}
