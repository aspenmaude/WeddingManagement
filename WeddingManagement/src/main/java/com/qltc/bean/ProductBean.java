/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.bean;

import com.qltc.pojo.Product;
import com.qltc.services.ProductService;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Vo Pham Huyen Khanh
 */
@ManagedBean
@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {
 private final static ProductService productService = new ProductService();
    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }
    
    public List<Product> getAllHall() {
        List<Product> products = productService.getAllHall();
        return products;
    }
    
    public List<Product> getHallByKeyword() {
        List<Product> products = productService.getHallByKeyword(null);
        return products;
    }
}
