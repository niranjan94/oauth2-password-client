package xyz.codezero.oauth2.password.client;

import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class OAuth2Client {

    private Token token;
    private OAuth2Config config;
	
	public OAuth2Client(OAuth2Config config) {
        this.config = config;
	}

    public OAuth2Config getConfig() {
        return config;
    }

    public void setConfig(OAuth2Config config) {
        this.config = config;
    }

    public Token getAccessToken() {
        token = OAuthUtils.getAccessToken(config);
        return token;
	}

    public Resource post(String path,  List<BasicNameValuePair> parametersBody){
        return OAuthUtils.getProtectedResourcePost(this,token,path,parametersBody);
    }

    public Resource post(String path){
        List<BasicNameValuePair> parametersBody = new ArrayList<>();
        return OAuthUtils.getProtectedResourcePost(this,token,path,parametersBody);
    }

    public Resource get(String path){
        return OAuthUtils.getProtectedResource(this, token, path);
    }


}
