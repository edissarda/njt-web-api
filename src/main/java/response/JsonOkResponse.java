/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package response;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author edis
 */
public class JsonOkResponse implements IResponse, Serializable {

    private int status;
    private int count;
    private Object data;

    public static JsonOkResponse createOkResponse(Object data) {
        return new JsonOkResponse(data, 200);
    }

    public static JsonOkResponse createResponse(Object data, int status) {
        return new JsonOkResponse(data, status);
    }

    public JsonOkResponse() {
    }

    public JsonOkResponse(Object data, int status) {
        this.data = data;
        this.status = status;
        setCount();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
        setCount();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCount() {
        if (data instanceof List) {
            List aData = (List) data;
            return aData.size();
        }

        return 1;
    }

    public void setCount() {
        if (data instanceof Collection) {
            Collection aData = (Collection) data;
            this.count = aData.size();
        } else {
            this.count = 1;
        }
    }

}
