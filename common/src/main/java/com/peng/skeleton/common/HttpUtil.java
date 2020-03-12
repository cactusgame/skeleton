package com.peng.skeleton.common;

import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtil {

    public static void main(String[] args){
        System.out.println("a");

        System.out.println(post("http://www.baidu.com"));
    }

    protected static Log logger = LogFactory.getLog(HttpUtil.class);

    private static CloseableHttpClient defaultClient = HttpManager.newHttpClient();

    public static void updateHttpClient(CloseableHttpClient client) {
        defaultClient = client;
    }

    public static String postByClient(CloseableHttpClient httpClient, String httpUrl, Map<String, String> maps, long timeout) {
        HttpPost httpPost = new HttpPost(httpUrl);
        if (timeout != 0) {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout((int) timeout)
                    .build();
            httpPost.setConfig(requestConfig);
        }
        List<NameValuePair> nameValuePairs = Lists.newArrayList();
        for (String key : maps.keySet()) {
            nameValuePairs.add(new BasicNameValuePair(key, maps.get(key)));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return sendHttp(httpClient, httpPost);
    }

    public static String postByClient(CloseableHttpClient httpClient, String httpUrl, Map<String, String> maps, long timeout, Map<String, String> headers) {
        HttpPost httpPost = new HttpPost(httpUrl);
        if (timeout != 0) {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout((int) timeout)
                    .build();
            httpPost.setConfig(requestConfig);
        }
        if (headers != null) {
            for (Entry<String, String> entry : headers.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        List<NameValuePair> nameValuePairs = Lists.newArrayList();
        for (String key : maps.keySet()) {
            nameValuePairs.add(new BasicNameValuePair(key, maps.get(key)));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return sendHttp(httpClient, httpPost);
    }


    public static String postByClient(CloseableHttpClient httpClient, String httpUrl, Map<String, String> maps) {
        return postByClient(httpClient, httpUrl, maps, 0);
    }

    public static String post(String httpUrl, Map<String, String> maps, long timeout) {
        return postByClient(defaultClient, httpUrl, maps, timeout);
    }

    public static String post(String httpUrl, Map<String, String> maps) {
        return postByClient(defaultClient, httpUrl, maps);
    }

    public static String post(String httpUrl, Map<String, String> maps, Map<String, String> header) {
        return postByClient(defaultClient, httpUrl, maps, 0, header);
    }

    public static String post(String httpUrl) {
        return postByClient(defaultClient, httpUrl, new HashMap<String, String>());
    }

    private static String postForDPLogByClient(CloseableHttpClient httpClient, String httpUrl, String body, long timeout, Map<String, String> headers) {
        HttpPost httpPost = new HttpPost(httpUrl);
        if (timeout != 0) {
            RequestConfig requestConfig = RequestConfig.custom()
                    .setSocketTimeout((int) timeout)
                    .setConnectTimeout((int) timeout)
                    .build();
            httpPost.setConfig(requestConfig);
        }
        if (headers != null) {
            for (Entry<String, String> entry : headers.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        try {
            httpPost.setEntity(new StringEntity(URLEncoder.encode(body, "UTF-8"), "UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        return sendHttp(httpClient, httpPost);
    }

    public static String postForDPLog(String httpUrl, String body, long timeout, Map<String, String> headers) {
        return postForDPLogByClient(defaultClient, httpUrl, body, timeout, headers);
    }

    private static String sendHttp(CloseableHttpClient client, HttpRequestBase request) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            httpClient = client;
            response = httpClient.execute(request);

            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode < 200 || statusCode > 299) {
                throw new RuntimeException(response.toString());
            }

            entity = response.getEntity();
            if (entity == null) {
                return null;
            }
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            String requestBody = "";
            if (request instanceof HttpPost) {
                HttpEntity errorEntity = ((HttpPost) request).getEntity();
                try {
                    requestBody = CharStreams.toString(new InputStreamReader(errorEntity.getContent()));
                } catch (IOException e1) {
                    logger.error(e.getMessage(), e);
                }
            }
            throw new RuntimeException(e.getMessage() + ", request: " + requestBody, e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (request != null) {
                    request.releaseConnection();
                }
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }
        return responseContent;
    }
}

