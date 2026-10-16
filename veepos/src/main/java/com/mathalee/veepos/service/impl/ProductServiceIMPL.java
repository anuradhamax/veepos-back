package com.mathalee.veepos.service.impl;

import com.mathalee.veepos.dto.ProductDTO;
import com.mathalee.veepos.entity.Product;
import com.mathalee.veepos.exception.NotFoundException;
import com.mathalee.veepos.repository.ProductRepo;
import com.mathalee.veepos.service.ProductService;
import com.mathalee.veepos.util.VarList;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductServiceIMPL implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDTO getProductById(int productId) {

        if (productRepo.existsById(productId)){
            Product product= productRepo.getReferenceById(productId);
            ProductDTO productDTO= new ProductDTO(
                    product.getProductId(),
                    product.getProductName(),
                    product.isActiveState()
            );
            return productDTO;
        }else{
            throw new NotFoundException(VarList.RSP_NO_DATA_FOUND);
        }


    }

    @Override
    public ProductDTO getProductByIdAndActiveState(int productId, boolean activeState) {
        if (productRepo.existsByProductIdAndActiveState(productId,activeState)){
        Product product= productRepo.getProductByProductIdAndActiveState(productId,activeState);

        ProductDTO productDTO= new ProductDTO(
                product.getProductId(),
                product.getProductName(),
                product.isActiveState()
        );

        return productDTO;
        }else {
            throw  new NotFoundException(VarList.RSP_NO_DATA_FOUND);
        }
    }
}
