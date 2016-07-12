package com.cnu2016.nagarwal.controller;

/**
 * Created by niteshagarwal002 on 07/07/16.
 */
import com.cnu2016.nagarwal.helpers.AWSSQSUtility;
import com.cnu2016.nagarwal.model.Product;
import com.cnu2016.nagarwal.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.MediaType;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
public class ProductController {


    @Autowired
    private ProductRepository repository;
    HttpHeaders responseHeaders = new HttpHeaders();

    public void ProductController() {
    }

    @RequestMapping(path="/api/products", method=RequestMethod.GET)
    public ResponseEntity<?> getProducts() {
        List<Product> pro = new ArrayList<Product>();
        for(Product product : repository.findAll()) {
            if (product.isAvailable())
                pro.add(product);
        }
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<Object>(pro,responseHeaders, HttpStatus.OK);
    }


    @RequestMapping(path="/api/products/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> getProduct(@PathVariable Integer id) {
        Product product = repository.findOne(id);
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        if(repository.exists(id)&&product.isAvailable())
            return new ResponseEntity<Object>(product,responseHeaders,HttpStatus.OK);
        else
            return new ResponseEntity<Object>("{\"detail\":\"Not found.\"}",responseHeaders,HttpStatus.NOT_FOUND);
    }




    @RequestMapping(path="/api/products", method=RequestMethod.POST)
    public ResponseEntity<?> insertProduct(@RequestBody Product product) {
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        product.setAvailable(true);
        product.setId(repository.save(product).getId());
        return new ResponseEntity<Object>(product,responseHeaders,HttpStatus.CREATED);
    }

    @RequestMapping(path="/api/products/{id}", method=RequestMethod.PUT)
    public ResponseEntity<?> putProduct(@RequestBody Product product,@PathVariable Integer id) {
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        if(repository.exists(id)) {
            Product productInDb = repository.findOne(id);
            productInDb.putProductProperties(product);
            repository.save(productInDb);
            return new ResponseEntity<Object>(productInDb,responseHeaders,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Object>("{\"detail\":\"Not found.\"}",responseHeaders, HttpStatus.NOT_FOUND);
        }
    }


    @RequestMapping(path="/api/products/{id}", method=RequestMethod.PATCH)
    public ResponseEntity<?> patchProduct(@RequestBody Product product,@PathVariable Integer id, HttpServletRequest request) {
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        if(repository.exists(id)) {
            Product productInDb = repository.findOne(id);
            productInDb.patchProductProperties(product);
            repository.save(productInDb);

            return new ResponseEntity<Object>(productInDb,responseHeaders,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Object>("{\"detail\":\"Not found.\"}",responseHeaders,HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path="/api/products/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        responseHeaders.setContentType(MediaType.APPLICATION_JSON);
        if(repository.exists(id)) {
            Product productInDb = repository.findOne(id);
            if(productInDb.isAvailable()) {
                productInDb.setAvailable(false);
                repository.save(productInDb);
                return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            }
            else {
                return new ResponseEntity<Object>("{\"detail\":\"Not found.\"}",responseHeaders,HttpStatus.NOT_FOUND);
            }
        }
        else {
            return new ResponseEntity<Object>("{\"detail\":\"Not found.\"}",responseHeaders,HttpStatus.NOT_FOUND);
        }
    }
}