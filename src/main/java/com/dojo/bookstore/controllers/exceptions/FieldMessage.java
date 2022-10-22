package com.dojo.bookstore.controllers.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String menssage;

    public FieldMessage() {super();}

    public FieldMessage(String fieldName, String menssage) {
        super();
        this.fieldName = fieldName;
        this.menssage = menssage;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getMenssage() {
        return menssage;
    }

    public void setMenssage(String menssage) {
        this.menssage = menssage;
    }
}
