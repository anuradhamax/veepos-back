package com.mathalee.veepos.repository;

import com.mathalee.veepos.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ProductRepo extends JpaRepository<Product, Integer> {

    boolean existsByProductIdAndActiveState(int productId, boolean activeState);

    Product getProductByProductIdAndActiveState(int productId, boolean activeState);
}
