/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.bean;

import com.qltc.pojo.Code;
import com.qltc.services.CodeService;
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
@Named(value = "codeBean")
@SessionScoped
public class CodeBean implements Serializable {

    private final static CodeService codeService = new CodeService();

    /**
     * Creates a new instance of CodeBean
     */
    public CodeBean() {
    }

    public List<Code> getFoodCategories() {
        return codeService.getFoodCategories();
    }

    public List<Code> getDrinkCategories() {
        return codeService.getDrinkCategories();
    }
}
