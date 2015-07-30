/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chdi.kundenverwaltung.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chdi
 */
public class MongoConnectioFactory {
    
    private String hostName = "localhost";
    
    private int port = 27017;
    
    MongoClient mongoClient;

    public MongoConnectioFactory() {
    
        try {
            mongoClient = new MongoClient(hostName, port);
        } catch (UnknownHostException ex) {
            System.err.println("---> " + ex.getMessage());
        }
        
    }
    
    public DB getMongoDatabase (String databaseName) {
        
        if(mongoClient == null){
           throw new RuntimeException("Mongo Client is null");
        }
        
        return mongoClient.getDB(databaseName);
    } 
    
    
    
    
}
