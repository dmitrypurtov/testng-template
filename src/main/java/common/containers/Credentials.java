package common.containers;

import java.util.Map;

public class Credentials {
    public String baseUrl;
    public String username;
    public String password;

    public Map<String, String> authCookie;
    public Map<String, String> authHeader;
    public Map<String, String> keys;

    public Credentials(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public boolean isAuthMaps() {
        return keys != null;
    }
}