package common.base;

import common.containers.Credentials;
import common.httpclient.BaseHttpClient;

import java.util.HashMap;

public class BaseAuth extends BaseHttpClient {

    protected Credentials credentials;

    public BaseAuth(Credentials credentials) {
        this.credentials = credentials;
        auth();
    }

    private void auth() {
        if (credentials.isAuthMaps()) {
            authHeader.putAll(credentials.authHeader);
            authCookie.putAll(credentials.authCookie);
        } else {
            //authCookie.putAll()
            //authHeader.putAll()
            credentials.keys = new HashMap<>();
            credentials.keys.put("APP_ID", "36fbf3e7c8c9b12fd2dda2e49f792f05");
            credentials.keys.put("ACCESS_KEY", "f14bd4514d95bf663c961b43d455f52b");
            //TODO: авторизация в приложении
        }
    }
}
