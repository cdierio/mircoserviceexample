/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chdi.kundenverwaltung;

import com.chdi.kundenverwaltung.representation.Customer;
import com.chdi.kundenverwaltung.representation.Customers;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author chdi
 */
@Path("/")
public class KundenVerwaltungsService{
    
    KundenVerwaltungsLogic kvl = new KundenVerwaltungsLogic();
    
    @POST
    @Path("/customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer){
        
        customer.setID();
        
        kvl.insertCustomer(customer);
        
        return Response.status(Response.Status.OK).entity(customer).build();
    }
    
    @GET
    @Path("/customer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam ("id") String id){
        
        Customer customer = kvl.findById(id);
        
        return Response.status(Response.Status.OK).entity(customer).build();
    }

    @DELETE
    @Path("/customer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustomer(@PathParam ("id") String id){
        
        if(kvl.deleteCustomer(id))
        {
            return Response.status(Response.Status.OK).build();    
        }
        
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();    
    }
    
    
    @GET
    @Path("/customers")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers(){
        
        Customers customersRepresentation = new Customers();
        customersRepresentation.setArray(kvl.findAllCustomer());
        
        return Response.status(Response.Status.OK).entity(customersRepresentation).build();
    }
    
    @GET
    @Path("/kundenfrontend/")
    @Produces(MediaType.TEXT_HTML)
    public InputStream getCustomerfrontend() throws FileNotFoundException{
        
        File htmlPage = new File(getClass().getResource("/index.html").getPath());
        
        return new FileInputStream(htmlPage);
    }
    
    @GET
    @Path("{path:.*}")
    public InputStream getStaticFile(@PathParam("path") String path) throws FileNotFoundException {
        
        System.out.println(path);
        
        File someFile = new File(getClass().getResource("/"+path).getPath());
        
        return new FileInputStream(someFile);
    } 
}
