/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chdi.kundenverwaltung;

import com.chdi.kundenverwaltung.db.MongoConnectioFactory;
import com.chdi.kundenverwaltung.representation.Customer;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chdi
 */
public class KundenVerwaltungsLogic {

    // Map <Integer, Customer> dataSave = new HashMap<Integer, Customer>();
    private MongoConnectioFactory mongoConnectioFactory = new MongoConnectioFactory();

    private DB db;

    public KundenVerwaltungsLogic() {

        db = mongoConnectioFactory.getMongoDatabase("userDatabase");

    }

    public void insertCustomer(Customer customer) {

        DBCollection table = db.getCollection("user");

        BasicDBObject query = new BasicDBObject();

        query.append("ID", customer.getID());
        query.append("CompanyName", customer.getCompanyName());
        query.append("Name", customer.getName());
        query.append("Adress", customer.getAdress());

        table.insert(query);
    }

    public Customer findById(String id) {

        DBCollection table = db.getCollection("user");

        BasicDBObject searchQuery2
                = new BasicDBObject().append("ID", id);

        DBObject user = table.findOne(searchQuery2);

        return new Customer(user.get("ID").toString(), user.get("CompanyName").toString(), user.get("Name").toString(), user.get("Adress").toString());

    }

    public List<Customer> findAllCustomer() {
        List<Customer> customers = new ArrayList<Customer>();

        DBCollection table = db.getCollection("user");

        DBCursor cursor = table.find();

        while (cursor.hasNext()) {

            DBObject tobj = cursor.next();
            Customer tmp = new Customer((String) tobj.get("ID"), (String) tobj.get("CompanyName"), (String) tobj.get("Name"), (String) tobj.get("Adress"));
            customers.add(tmp);
        }

        return customers;
    }

    public boolean deleteCustomer(String id) {

        DBCollection table = db.getCollection("user");

        BasicDBObject searchQuery2
                = new BasicDBObject().append("ID", id);

        DBObject user = table.findOne(searchQuery2);

        table.remove(user);

        DBObject usObject = table.findOne(searchQuery2);

        if (usObject == null) {

            return true;
        } else {
            return false;
        }

    }

}
