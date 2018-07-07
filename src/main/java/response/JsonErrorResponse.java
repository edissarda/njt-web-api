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
    private String error;

    public static JsonErrorResponse create(String message) {
        return new JsonErrorResponse(400, message);
    }

    public JsonErrorResponse(int status, String error) {
        this.status = status;
        this.error = error;
    }

    public String getMessage() {
        return error;
    }

    public void setMessage(String message) {
        this.error = message;
    }

}
