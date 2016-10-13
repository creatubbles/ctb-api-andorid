package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.user.NewUser;
import com.creatubbles.api.model.user.User;
import com.github.jasminb.jsonapi.JSONAPIDocument;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Janek on 05.02.2016.
 */
public interface UserService {

    @GET(EndPoints.USERS + "/{id}")
    Call<JSONAPIDocument<User>> getUserById(@Path("id") String id);

    @GET(EndPoints.USERS + "/{id}/creators")
    Call<JSONAPIDocument<List<User>>> getCreators(@Path("id") String id);

    @GET(EndPoints.USERS + "/{id}/managers")
    Call<JSONAPIDocument<List<User>>> getManagers(@Path("id") String id);

    @GET(EndPoints.USERS + "/{id}/connected_users")
    Call<JSONAPIDocument<List<User>>> getConnections(@Path("id") String id);

    @GET(EndPoints.USERS + "/{id}/followed_users")
    Call<JSONAPIDocument<List<User>>> getFollowedUsers(@Path("id") String id);
    
    @POST(EndPoints.CREATORS)
    Call<JSONAPIDocument<User>> createUser(@Body NewUser newUser);

    @GET(EndPoints.SWITCH_USERS)
    Call<JSONAPIDocument<List<User>>> getSwitchUsers();
}
