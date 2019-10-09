package com.mooc.wxsell.service.impl;

import com.mooc.wxsell.dataobject.ProductInfo;
import com.mooc.wxsell.enums.ProductStatusEnums;
import com.mooc.wxsell.repository.ProductInfoRepository;
import com.mooc.wxsell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnums.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }


    @Override
    public ProductInfo save(ProductInfo pi) {
        return repository.save(pi);
    }
}
