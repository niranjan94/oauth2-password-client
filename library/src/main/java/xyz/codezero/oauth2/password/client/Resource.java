package xyz.codezero.oauth2.password.client;

import org.json.JSONException;
import org.json.JSONObject;

public class Resource {
    private String response;
    private JSONObject resource;
    private int statusCode;

    public Resource(String response, int statusCode) {
        this.response = response;
        this.statusCode = statusCode;

        try {
            this.resource = new JSONObject(response);
        } catch (JSONException e) {
            this.resource = new JSONObject();
        }
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;

        try {
            this.resource = new JSONObject(response);
        } catch (JSONException ignored) {

        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public JSONObject getResource() {
        return resource;
    }
}
