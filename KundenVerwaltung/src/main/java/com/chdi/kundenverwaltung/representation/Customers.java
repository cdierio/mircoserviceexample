/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chdi.kundenverwaltung.representation;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author chdi
 */
@XmlRootElement
public class Customers {
    
   @XmlElement(name="customers")
   private List<Customer> array;

    public List<Customer> getArray() {
        return array;
    }

    public void setArray(List<Customer> array) {
        this.array = array;
    }
    
   
   
    
}
