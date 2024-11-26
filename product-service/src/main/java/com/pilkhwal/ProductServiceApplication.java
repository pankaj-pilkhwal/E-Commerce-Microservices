package com.pilkhwal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {
    public static void main( String[] args ) {
        SpringApplication.run(ProductServiceApplication.class);
        System.out.println( "***** Product service *****" );

    }
}
