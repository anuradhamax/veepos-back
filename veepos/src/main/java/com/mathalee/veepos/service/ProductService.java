package com.mathalee.veepos.service;

import com.mathalee.veepos.dto.ProductDTO;

public interface ProductService {
    ProductDTO getProductById(int productId);

    ProductDTO getProductByIdAndActiveState(int productId, boolean b);
}
