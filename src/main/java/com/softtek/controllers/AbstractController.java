package com.softtek.controllers;

import java.nio.charset.Charset;
import java.util.Collection;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softtek.model.Count;

/**
 * Created by damian on 25/03/16.
 */
public class AbstractController<T> {

    private static final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    protected ResponseEntity<T> createdResult(T result) {
        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.setLocation(ServletUriComponentsBuilder
//                .fromCurrentRequest().path("/{id}")
//                .buildAndExpand(((TransactionGeneratedData) result).getTransactionid()).toUri());

        httpHeaders.setContentType(contentType);
        return new ResponseEntity<T>(result, httpHeaders, HttpStatus.CREATED);
    }

    protected ResponseEntity<T> createdErrorResult(T result) {
        HttpHeaders httpHeaders = buildHeaders();
        return new ResponseEntity<>(result, httpHeaders, HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<Collection<T>> collectionResult(Collection<T> result) {
        HttpHeaders httpHeaders = buildHeaders();
        return new ResponseEntity<Collection<T>>(result, httpHeaders, HttpStatus.OK);
    }

    protected ResponseEntity<T> singleResult(T result) {
        HttpHeaders httpHeaders = buildHeaders();
        return new ResponseEntity<T>(result, httpHeaders, HttpStatus.OK);
    }
    
    protected ResponseEntity<Count> singleResult(Count result) {
        HttpHeaders httpHeaders = buildHeaders();
        return new ResponseEntity<Count>(result, httpHeaders, HttpStatus.OK);
    }

    private HttpHeaders buildHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder
                .fromCurrentRequest().path("/")
                .build().toUri());
        httpHeaders.setAccessControlAllowOrigin("*");
        httpHeaders.setContentType(contentType);
        return httpHeaders;
    }

}
