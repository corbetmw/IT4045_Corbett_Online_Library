package com.it4045.common.networking;


import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.AbstractResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class NetworkHttp implements INetworkHttp {

    /**
     * Uses Http client to implement a GET request.
     * @param url
     * @return null
     */
    public String sendGetRequest(String url) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(url);
        AbstractResponseHandler<String> responseHandler = new BasicResponseHandler();
        try {
            return client.execute(get, responseHandler);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
