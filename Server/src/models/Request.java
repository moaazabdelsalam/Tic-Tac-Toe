/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author moaaz
 */
public class Request {
    RequestCode requestCode;
    Object requestData;

    public Request(RequestCode requestCode, Object requestData) {
        this.requestCode = requestCode;
        this.requestData = requestData;
    }

    public RequestCode getRequestCode() {
        return requestCode;
    }

    public Object getRequestData() {
        return requestData;
    }
    
}
