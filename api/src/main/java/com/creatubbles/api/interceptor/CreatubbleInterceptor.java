package com.creatubbles.api.interceptor;

import android.content.Context;

import com.creatubbles.api.utils.UploadRepositoryCacheUtil;

import java.io.IOException;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by mariuszostapowicz on 03.03.2016.
 */
public class CreatubbleInterceptor {

    public static Interceptor getHeaderInterceptor(final Map<String, String> headerParamrMap) {
        return new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {

                Request.Builder builder = chain.request().newBuilder();

                for (Map.Entry<String, String> headerParam : headerParamrMap.entrySet()) {
                    builder.addHeader(headerParam.getKey(), headerParam.getValue());
                }

                return chain.proceed(builder.build());
            }
        };
    }

    public static Interceptor getLogginInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }

    public static Interceptor getFileUploadInterceptor(Context context) {
        return new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request.Builder builder = chain.request().newBuilder();

                if (!UploadRepositoryCacheUtil.isEmptySendCache(context)) {
                    UploadRepositoryCacheUtil.sendFileFromCache(context);
                }

                return chain.proceed(builder.build());
            }
        };
    }
}
