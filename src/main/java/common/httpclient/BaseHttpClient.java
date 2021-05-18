package common.httpclient;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class BaseHttpClient {
    protected static final int ONE_SECOND = 1000;
    protected Map<String, String> authCookie;
    protected Map<String, String> authHeader;

    public BaseHttpClient() {
        authCookie = new HashMap<>();
        authHeader = new HashMap<>();
    }

    public Map<String, String> getAuthCookie() {
        return authCookie;
    }

    public void addAuthCookie(String key, String value) {
        authCookie.put(key, value);
    }

    public Map<String, String> getAuthHeader() {
        return authHeader;
    }

    public void addAuthHeader(String key, String value) {
        authHeader.put(key, value);
    }

    public <T> T sendGetRequest(String url, Class<T> type) {
        RestTemplate restTemplate = new RestTemplate();
        //TODO: Добавить в запрос authCookie authHeader
        return restTemplate.getForObject(url, type);
    }
}