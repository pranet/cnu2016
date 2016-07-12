package com.cnu2016.nagarwal;

import com.cnu2016.nagarwal.model.Product;
import com.cnu2016.nagarwal.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

/**
 * Created by niteshagarwal002 on 12/07/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest
public class ProductControllerTest {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private ProductRepository productRepository;

    private RestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetProduct()throws Exception{
        Product product = new Product("testProduct","descrip","awesom",100.0f,90.0f,5,"p1",true);
        productRepository.save(product);
        int id = product.getId();
        Product apiResponse = restTemplate.getForObject("http://localhost:8080/api/products/"+id,Product.class);
        assertNotNull(apiResponse);
        assertEquals(apiResponse.getProductName(),product.getProductName());
    }
}
