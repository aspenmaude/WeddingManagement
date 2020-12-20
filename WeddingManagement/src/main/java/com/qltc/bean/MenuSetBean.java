/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.bean;

import com.qltc.pojo.MenuSet;
import com.qltc.services.MenuSetService;
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
@Named(value = "menuSetBean")
@SessionScoped
public class MenuSetBean implements Serializable {
private final static MenuSetService menuSetService = new MenuSetService();
    /**
     * Creates a new instance of MenuSetBean
     */
    public MenuSetBean() {
    }
    
    public List<MenuSet> getAllMenuSet() {
        List<MenuSet> menuSetList = menuSetService.getAllMenuSet();
        return menuSetList;
    }
    
}
