package com.creatubbles.api.repository;

import android.content.Context;

import com.creatubbles.api.di.components.DaggerApiComponent;
import com.creatubbles.api.di.modules.ApiModule;
import com.creatubbles.api.exception.InvalidParametersException;
import com.creatubbles.api.service.UploadService;

import javax.inject.Inject;

/**
 * Created by Mariusz Ostapowicz on 20.03.2016.
 */
public class UploadRepositoryBuilder {

    @Inject
    UploadService uploadService;

    private Context context;

    public UploadRepository build() {
        if (hasValidParameters()) {
            DaggerApiComponent.builder().apiModule(new ApiModule(context)).build().inject(this);
            return new UploadRepositoryImpl(uploadService, context);
        }
        throw new InvalidParametersException("Missing application context!");
    }


    private boolean hasValidParameters() {
        return context != null;
    }

    public UploadRepositoryBuilder setContext(Context context) {
        this.context = context;
        return this;
    }

}
