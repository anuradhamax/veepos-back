package com.mathalee.veepos.controller;

import com.mathalee.veepos.dto.ProductDTO;
import com.mathalee.veepos.service.ProductService;
import com.mathalee.veepos.util.StandardResponse;
import com.mathalee.veepos.util.VarList;
import com.mathalee.veepos.util.VarSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(VarSettings.BASE_URL+"product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(
            path = "/get-product-by-id",
            params = "id"
    )
    public ResponseEntity<StandardResponse>getProductById(@RequestParam(value ="id") int productId){
            ProductDTO productDTO= productService.getProductById(productId);
            return new ResponseEntity<StandardResponse>(
                    new StandardResponse(201, VarList.RSP_SUCCESS, productDTO), HttpStatus.CREATED
            );

        }


    @GetMapping(
            path = "/get-product-by-id-and-activeState",
            params = "id"
    )
    public ResponseEntity<StandardResponse>getProductByIdAndActiveState(@RequestParam(value ="id") int productId){
        ProductDTO productDTO= productService.getProductByIdAndActiveState(productId, true);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, VarList.RSP_SUCCESS, productDTO), HttpStatus.CREATED
        );

    }






}
