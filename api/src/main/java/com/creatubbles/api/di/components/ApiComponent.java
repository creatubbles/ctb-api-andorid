package com.creatubbles.api.di.components;

import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.repository.CreationRepositoryBuilder;
import com.creatubbles.api.repository.GalleryRepositoryBuilder;
import com.creatubbles.api.repository.LandingUrlsRepositoryBuilder;
import com.creatubbles.api.repository.OAuthRepositoryBuilder;
import com.creatubbles.api.repository.UploadRepositoryBuilder;
import com.creatubbles.api.repository.UserRepositoryBuilder;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Janek on 16.02.2016.
 */
@Singleton
@Component(modules = ApiModule.class)
public interface ApiComponent {

    void inject(OAuthRepositoryBuilder builder);

    void inject(CreationRepositoryBuilder builder);

    void inject(UserRepositoryBuilder builder);

    void inject(GalleryRepositoryBuilder builder);

    void inject(UploadRepositoryBuilder builder);

    void inject(LandingUrlsRepositoryBuilder landingUrlsRepositoryBuilder);
}