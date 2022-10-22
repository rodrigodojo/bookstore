package com.dojo.bookstore.dto;

import com.dojo.bookstore.entities.Category;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "field name is requested")
    @Length(min = 3 , max = 100 , message = "this field get a minimal 3 letters and max that 100")
    private String name;
    @NotEmpty(message = "field description is requested")
    @Length(min = 3 , max = 200 , message = "this field get a minimal 3 letters and max that 200")
    private String description;

    public CategoryDTO(){super();}

    public CategoryDTO(Category obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.description = obj.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
