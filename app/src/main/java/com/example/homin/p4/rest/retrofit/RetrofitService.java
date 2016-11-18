package com.example.homin.p4.rest.retrofit;

import com.example.homin.p4.rest.retrofit.pojo.RedditDatum;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by HOMIN on 2016-08-28.
 */
public interface RetrofitService {
    @GET("top.json")
    Call<RedditDatum> getRedditPOJO(@Query("after") String after, @Query("limit") int limit);


//

}
