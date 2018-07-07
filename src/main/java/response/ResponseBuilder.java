/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;


/**
 *
 * @author edis
 */
public class ResponseBuilder {

    public static JsonErrorResponse getErrorResponse(String msg) {
        return JsonErrorResponse.create(msg);
    }

    public static JsonOkResponse getOkResponse(Object data) {
        return JsonOkResponse.createOkResponse(data);
    }
}
