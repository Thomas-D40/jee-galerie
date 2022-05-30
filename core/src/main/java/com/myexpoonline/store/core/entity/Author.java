/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myexpoonline.store.core.entity;

import java.io.Serializable;

/**
 *
 * @author Tom
 */
public class Author implements Serializable{
    
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }  
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
