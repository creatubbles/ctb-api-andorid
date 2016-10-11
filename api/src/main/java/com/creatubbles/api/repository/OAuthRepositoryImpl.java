package com.creatubbles.api.repository;

import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.response.CallbackMapper;
import com.creatubbles.api.response.ResponseCallback;
import com.creatubbles.api.service.GrantType;
import com.creatubbles.api.service.OAuthService;

import retrofit2.Call;

/**
 * @author Matthew Platek on 11.02.2016.
 */
public class OAuthRepositoryImpl implements OAuthRepository {

    private OAuthService oAuthService;

    private String clientId;

    private String clientSecret;

    public OAuthRepositoryImpl(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    @Override
    public void authorize(ResponseCallback<AuthToken> callback) {
        Call<AuthToken> call = oAuthService.getAccessToken(clientId, clientSecret, GrantType.CLIENT_CREDENTIALS);
        call.enqueue(new CallbackMapper<AuthToken>().map(callback));
    }

    @Override
    public void authorize(String login, String password, ResponseCallback<AuthToken> callback) {
        Call<AuthToken> call = oAuthService.getAccessToken(clientId, clientSecret, GrantType.PASSWORD, login,
                password);
        call.enqueue(new CallbackMapper<AuthToken>().map(callback));
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }
}