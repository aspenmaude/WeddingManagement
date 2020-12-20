/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.qltc.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author Vo Pham Huyen Khanh
 */
@FacesValidator("UploadValidator")
public class UploadValidator implements Validator{

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object t) throws ValidatorException {
        Part p = (Part) t;
        // image must be png of jpg
        if(!p.getContentType().equals("image/png") &&
                !p.getContentType().equals("image/jpg")){
            FacesMessage msg = new FacesMessage("Need file type is png or jpg");
            throw new ValidatorException(msg);
        }
        // Dung luong phai nho hon hoac bang (1MB)
        if(p.getSize() > 2097152){
            FacesMessage msg = new FacesMessage("Size <= 2MB");
            throw new ValidatorException(msg);
        }
    }
    
}
