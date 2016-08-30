package com.example.homin.p4.rest;

import com.example.homin.p4.rest.pojo.RestData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HOMIN on 2016-08-28.
 */
public interface RestService {
    @GET("top.json")
    Call<RestData> getRestPojo(@Query("after") String after, @Query("limit") int limit);


//

}
