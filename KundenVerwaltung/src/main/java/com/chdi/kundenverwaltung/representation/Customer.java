/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chdi.kundenverwaltung.representation;

import java.util.UUID;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chdi
 */
@XmlRootElement
public class Customer{
 
    @XmlElement
    private String ID;
    
    @XmlElement
    private String name;
    
    @XmlElement
    private String companyName;
    
    @XmlElement
    private String adress;

    public Customer() {
    }

    public Customer(String ID, String name, String companyName, String adress) {
        this.ID = ID;
        this.name = name;
        this.companyName = companyName;
        this.adress = adress;
    }
    
    public String getID() {
        return ID;
    }

    public void setID() {
        ID = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Customer{" + "ID=" + ID + ", name=" + name + ", companyName=" + companyName + ", adress=" + adress + '}';
    }
    
    
    
}
