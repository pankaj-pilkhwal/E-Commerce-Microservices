//package com.pilkhwal;
//
//import io.restassured.RestAssured;
//import org.hamcrest.Matcher;
//import org.hamcrest.Matchers;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
//import org.testcontainers.containers.MongoDBContainer;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class ProductServiceApplicationTest {
//
//    @ServiceConnection
//    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:7.0.5");
//
//    @LocalServerPort
//    private Integer port;
//
//    @BeforeEach
//    void setUp() {
//        RestAssured.baseURI = "http://loaclhost";
//        RestAssured.port = port;
//    }
//
//    static {
//        mongoDBContainer.start();
//    }
//
//
//    @Test
//    void shouldCreateProduct() {
//        String requestBody = """
//                {
//                    "name": "Dell P2424HE",
//                    "description": "24 inch monitor with type-c support for charging and display connection",
//                    "price": 14000
//                }
//                """;
//
//        RestAssured.given().contentType("application/json")
//                .body(requestBody)
//                .when()
//                .post()
//                .then()
//                .statusCode(201)
//                .body("id", Matchers.notNullValue())
//                .body("name", Matchers.equalTo("Dell P2424HE"))
//                .body("price", Matchers.equalTo(14000))
//                ;
//    }
//
//
//
//}