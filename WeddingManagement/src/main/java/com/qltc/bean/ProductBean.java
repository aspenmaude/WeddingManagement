/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.bean;

import com.qltc.pojo.Product;
import com.qltc.services.ProductService;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author Vo Pham Huyen Khanh
 */
@ManagedBean
@Named(value = "productBean")
@SessionScoped
public class ProductBean implements Serializable {
    private String hallName;
    private String hallDescription;
    private BigDecimal hallPrice;
    private String hallNote;
    private boolean hallStatus;
    private Part hallImageFile;
    
 private static ProductService productService = new ProductService();
    /**
     * Creates a new instance of ProductBean
     */
    public ProductBean() {
    }
    
    public List<Product> getAllHall() {
        List<Product> products = getProductService().getAllHall();
        return products;
    }
    
    public List<Product> getHallByKeyword() {
        List<Product> products = getProductService().getHallByKeyword(null);
        return products;
    }
    
    private void uploadFile() throws IOException{
//        String path = FacesContext.getCurrentInstance()
//                .getExternalContext().getRealPath("/resources/images/upload")
//                + "/" + this.hallImageFile.getSubmittedFileName();
//        String path = "F:\\GithubDesktop\\WeddingManagement\\WeddingManagement\\src\\main\\webapp\\resources\\images\\upload\\"
//                + this.hallImageFile.getSubmittedFileName();
        String path = FacesContext.getCurrentInstance()
                                    .getExternalContext()
                                    .getInitParameter("com.qltc.uploadPath") 
                                    + this.hallImageFile.getSubmittedFileName();
        try(InputStream in = this.hallImageFile.getInputStream()){
            FileOutputStream out = new FileOutputStream(path);
            byte[] b = new byte[1024];
            int byteRead;
            while ((byteRead = in.read(b)) != -1)
                out.write(b, 0 , byteRead);
        }
    }
    
    public String addProduct(){
        Product p = new Product();
        p.setName(this.hallName);
        p.setDescription(this.hallDescription);
        p.setUnit("02");
        p.setType("03");
        p.setCategory("0301");
        p.setPrice(this.hallPrice);
        p.setNote(this.hallNote);
        p.setStatus(this.hallStatus);
        
        try {
            this.uploadFile();
            
            p.setImageUrl("upload" + this.hallImageFile.getSubmittedFileName());
            
            if(productService.createOrUpdateHall(p) == true)
                return "manage-hall?faces-redirect=true";
        } catch (IOException ex) {
            Logger.getLogger(ProductBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "hall";
    }
    

    /**
     * @return the hallName
     */
    public String getHallName() {
        return hallName;
    }

    /**
     * @param hallName the hallName to set
     */
    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    /**
     * @return the hallDescription
     */
    public String getHallDescription() {
        return hallDescription;
    }

    /**
     * @param hallDescription the hallDescription to set
     */
    public void setHallDescription(String hallDescription) {
        this.hallDescription = hallDescription;
    }

    /**
     * @return the hallPrice
     */
    public BigDecimal getHallPrice() {
        return hallPrice;
    }

    /**
     * @param hallPrice the hallPrice to set
     */
    public void setHallPrice(BigDecimal hallPrice) {
        this.hallPrice = hallPrice;
    }

    /**
     * @return the hallNote
     */
    public String getHallNote() {
        return hallNote;
    }

    /**
     * @param hallNote the hallNote to set
     */
    public void setHallNote(String hallNote) {
        this.hallNote = hallNote;
    }

    /**
     * @return the hallStatus
     */
    public boolean isHallStatus() {
        return hallStatus;
    }

    /**
     * @param hallStatus the hallStatus to set
     */
    public void setHallStatus(boolean hallStatus) {
        this.hallStatus = hallStatus;
    }

    /**
     * @return the productService
     */
    public static ProductService getProductService() {
        return productService;
    }

    /**
     * @param aProductService the productService to set
     */
    public static void setProductService(ProductService aProductService) {
        productService = aProductService;
    }

    /**
     * @return the hallImageFile
     */
    public Part getHallImageFile() {
        return hallImageFile;
    }

    /**
     * @param hallImageFile the hallImageFile to set
     */
    public void setHallImageFile(Part hallImageFile) {
        this.hallImageFile = hallImageFile;
    }
}
