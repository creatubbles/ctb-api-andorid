package com.creatubbles.api.di.modules;

import android.content.Context;

import com.creatubbles.api.Configuration;
import com.creatubbles.api.ContentType;
import com.creatubbles.api.ServiceGenerator;
import com.creatubbles.api.exception.InitializationException;
import com.creatubbles.api.model.AuthToken;
import com.creatubbles.api.repository.CreationRepository;
import com.creatubbles.api.repository.CreationRepositoryImpl;
import com.creatubbles.api.repository.GalleryRepository;
import com.creatubbles.api.repository.GalleryRepositoryImpl;
import com.creatubbles.api.repository.LandingUrlsRepository;
import com.creatubbles.api.repository.LandingUrlsRepositoryImpl;
import com.creatubbles.api.repository.OAuthRepository;
import com.creatubbles.api.repository.OAuthRepositoryImpl;
import com.creatubbles.api.repository.UploadRepository;
import com.creatubbles.api.repository.UploadRepositoryImpl;
import com.creatubbles.api.repository.UserRepository;
import com.creatubbles.api.repository.UserRepositoryImpl;
import com.creatubbles.api.service.ActivityService;
import com.creatubbles.api.service.CommentService;
import com.creatubbles.api.service.CreationService;
import com.creatubbles.api.service.CustomStyleService;
import com.creatubbles.api.service.GalleryService;
import com.creatubbles.api.service.LandingUrlsService;
import com.creatubbles.api.service.OAuthService;
import com.creatubbles.api.service.UploadService;
import com.creatubbles.api.service.UserService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.TimeZone;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Janek on 16.02.2016.
 */
@Module
public class ApiModule {

    private static ApiModule instance = null;
    private static AuthToken authToken = null;
    private Configuration configuration = null;

    public static void initialize(Configuration apiConfiguration) {
        if (instance == null) {
            instance = new ApiModule(apiConfiguration);
        }
    }

    private ApiModule(Configuration configuration) {
        this.configuration = configuration;
        provideServiceGenerator(configuration, provideObjectMapper()).initialize();
    }

    public static ApiModule getInstance(AuthToken token) {
        if (instance == null) {
            throw new InitializationException("Creatubbles Api wasn't initialized!");
        } else {
            authToken = token;
            return instance;
        }
    }

    public static ApiModule getInstance() {
        if (instance == null) {
            throw new InitializationException("CreatubblesApi wasn't initialized!");
        } else {
            return instance;
        }
    }

    @Provides
    @Singleton
    Configuration provideConfiguration() {
        return configuration;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return configuration.getContext();
    }

    @Provides
    @Singleton
    ServiceGenerator provideServiceGenerator(Configuration configuration, ObjectMapper objectMapper) {
        return new ServiceGenerator(configuration, objectMapper);
    }

    @Provides
    @Singleton
    ObjectMapper provideObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.setTimeZone(TimeZone.getTimeZone("UTC"));
        // important: when updating a resource we want to skip fields that weren't set so we don't override them with nulls
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        return objectMapper;
    }

    @Provides
    @Singleton
    OAuthService provideOAuthService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(OAuthService.class, ContentType.URL_ENCODED);
    }

    @Provides
    @Singleton
    OAuthRepository provideOAuthRepository(OAuthService oAuthService, ObjectMapper objectMapper) {
        return new OAuthRepositoryImpl(objectMapper, oAuthService);
    }

    @Provides
    @Singleton
    GalleryService provideGalleryService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(GalleryService.class, ContentType.VND_JSON,
                authToken);
    }

    @Provides
    @Singleton
    GalleryRepository provideGalleryRepository(GalleryService galleryService, ObjectMapper objectMapper) {
        return new GalleryRepositoryImpl(objectMapper, galleryService);
    }

    @Provides
    @Singleton
    CreationService provideCreationService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(CreationService.class, ContentType.VND_JSON,
                authToken);
    }

    @Provides
    @Singleton
    CreationRepository provideCreationRepository(CreationService creationService, ObjectMapper objectMapper) {
        return new CreationRepositoryImpl(objectMapper, creationService);
    }

    @Provides
    @Singleton
    UserService provideUserService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(UserService.class, ContentType.VND_JSON, authToken);
    }

    @Provides
    @Singleton
    UserRepository provideUserRepository(UserService userService, ObjectMapper objectMapper) {
        return new UserRepositoryImpl(objectMapper, userService);
    }

    @Provides
    @Singleton
    UploadService provideUploadService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(UploadService.class);
    }

    @Provides
    @Singleton
    UploadRepository provideUploadRepository(UploadService uploadService, Context context, ObjectMapper objectMapper) {
        return new UploadRepositoryImpl(objectMapper, uploadService, context);
    }

    @Provides
    @Singleton
    LandingUrlsService provideLandingUrlsService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(LandingUrlsService.class, ContentType.URL_ENCODED,
                authToken);
    }

    @Provides
    @Singleton
    LandingUrlsRepository provideLandingUrlsRepository(LandingUrlsService landingUrlsService, ObjectMapper objectMapper) {
        return new LandingUrlsRepositoryImpl(objectMapper, landingUrlsService);
    }

    @Provides
    @Singleton
    ActivityService provideActivityService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(ActivityService.class, ContentType.VND_JSON, authToken);
    }
    @Provides
    @Singleton
    CommentService provideCommentService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(CommentService.class, ContentType.VND_JSON, authToken);
    }

    @Provides
    @Singleton
    CustomStyleService provideCustomStyleService(ServiceGenerator serviceGenerator) {
        return serviceGenerator.createService(CustomStyleService.class, ContentType.VND_JSON, authToken);
    }

    /**
     * Method created only for the purpose of making unit tests independent
     */
    @SuppressWarnings("unused")
    private static void reset() {
        instance = null;
    }
}
