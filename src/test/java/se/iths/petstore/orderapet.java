package se.iths.petstore;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.Date;

// import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class orderapet<date> {
    private Date date = new Date();


    private int id;
    private int petid;
    // Date shipDate = date;
    private String status;
    private String complete;
    private String quantity;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPetid() {
        return petid;
    }

    public void setPetid(int petid) {
        this.petid = petid;

    }

    public Date getShipDate() {
        return date;
    }

   // public void setShipDate(String shipDate) {
    //    this.shipDate = date;
   // }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComplete() {
        return complete;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    orderapet(int id, int petid, String quantity,  String status, String complete) throws JsonProcessingException, UnirestException {



        this.complete = complete;
        this.id = id;
        this.petid = petid;

        this.status = status;
        this.quantity = quantity;








    }



}



