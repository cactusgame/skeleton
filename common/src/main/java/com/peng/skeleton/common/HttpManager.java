package com.peng.skeleton.common;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustAllStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeUnit;

public class HttpManager {

    private static PoolingHttpClientConnectionManager connectionManager;

    private static RequestConfig requestConfig;

    private final static int MAX_TOTAL_CONNECTIONS = 2000;

    private final static int MAX_ROUTE_CONNECTIONS = 500;

    private final static int CONNECT_TIMEOUT = 3000;

    private final static int SOCKET_TIMEOUT = 3000;

    private final static int CONNECTION_REQUEST_TIMEOUT = 3000;

    static {
        try {
            requestConfig = RequestConfig.custom()
                    .setConnectTimeout(CONNECT_TIMEOUT)
                    .setSocketTimeout(SOCKET_TIMEOUT)
                    .setConnectionRequestTimeout(CONNECTION_REQUEST_TIMEOUT)
//                    .setProxy(new HttpHost("10.130.135.128", 8888))
                    .build();

            SSLContextBuilder builder = new SSLContextBuilder();

            builder.loadTrustMaterial(null, new TrustAllStrategy());
            SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(
                    builder.build());

            Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                    .register("http", PlainConnectionSocketFactory.getSocketFactory())
                    .register("https", sslSocketFactory)
                    .build();
            connectionManager = new PoolingHttpClientConnectionManager(registry);
            SocketConfig socketConfig = SocketConfig.custom()
                    .setSoTimeout(SOCKET_TIMEOUT)
                    .build();
            connectionManager.setDefaultSocketConfig(socketConfig);
            connectionManager.setValidateAfterInactivity(1000);
            connectionManager.setMaxTotal(MAX_TOTAL_CONNECTIONS);
            connectionManager.closeExpiredConnections();
            connectionManager.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            throw new RuntimeException(e.getMessage() + "init http manager error", e);
        }

    }

    public static CloseableHttpClient newHttpClient() {
        return HttpClients.custom()
                .setConnectionManager(connectionManager)
                .setDefaultRequestConfig(requestConfig)
                .evictIdleConnections(30, TimeUnit.SECONDS)
                .setRetryHandler(new DefaultHttpRequestRetryHandler(0, false))
                .build();
    }

}

