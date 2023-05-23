package com.example.verb2.DB;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RetrofitSrv {
        private static Retrofit retrofit;

        private static final String BASE_URL = "http://192.168.1.103:8080";
        private static Retrofit create() {
            return new Retrofit.Builder()
                    .addConverterFactory(MoshiConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }

        public static Retrofit getInstance(){
            if (retrofit == null) retrofit = create();

            return retrofit;
        }
}
