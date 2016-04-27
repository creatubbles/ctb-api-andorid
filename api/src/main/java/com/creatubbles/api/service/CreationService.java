package com.creatubbles.api.service;

import com.creatubbles.api.EndPoints;
import com.creatubbles.api.model.CreationListResponse;
import com.creatubbles.api.model.CreationResponse;
import com.creatubbles.api.model.UploadResponse;
import com.creatubbles.api.request.CreationListRequest;
import com.creatubbles.api.request.CreationRequest;
import com.creatubbles.api.request.UploadRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Janek on 11.02.2016.
 */
public interface CreationService {


    @GET(EndPoints.CREATIONS)
    Call<CreationListResponse> getListOfCreation(@Body CreationListRequest body);

    @GET(EndPoints.CREATIONS + "/{creationId}")
    Call<CreationResponse> getCreationById(@Path("creationId") String creationId);

    @PUT(EndPoints.CREATIONS + "/{creationId}")
    Call<Void> updateCreation(@Path("creationId") String creationId, @Body
    CreationRequest body);

    @POST(EndPoints.CREATIONS)
    Call<CreationResponse> createCreation(@Body CreationRequest body);

    @POST(EndPoints.CREATIONS_UPLOADS)
    Call<UploadResponse> createUpload(@Path("id") String id, @Body UploadRequest body);

    @PUT(EndPoints.PING_CREATIONS_UPLOADS)
    Call<String> updateCreationUpload(@Path("id") String id);
}
