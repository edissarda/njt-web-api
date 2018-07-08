/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import java.io.Serializable;

/**
 *
 * @author edis
 */
public class JsonErrorResponse implements IResponse, Serializable {

    private int status;
    private String message;

    public static JsonErrorResponse create(String message) {
        return new JsonErrorResponse(400, message);
    }

    public JsonErrorResponse(int status, String error) {
        this.status = status;
        this.message = error;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
