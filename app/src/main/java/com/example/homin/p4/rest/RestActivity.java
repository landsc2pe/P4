package com.example.homin.p4.rest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.LogTag;
import com.example.homin.p4.rest.pojo.RestData;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HOMIN on 2016-08-27.
 */
public class RestActivity extends AppCompatActivity {
    public static final String TAG = RestActivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private RestData restData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_activity);

        init();
    }

    private void init() {
        setRetrofit();
        setViews();

//        setOkHttp();
    }

    private void setViews() {
        setRecyclerView();
        setToolBar();
    }

    private void setRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.rest_activity_recyclerview);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);



    }

    private void setToolBar() {

    }

    private void setRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestService service = retrofit.create(RestService.class);
        Call<RestData> call = service.getRestPojo("", "");

        call.enqueue(new Callback<RestData>() {
            @Override
            public void onResponse(Call<RestData> call, Response<RestData> response) {
                if (response != null && response.body() != null) {
                    restData = response.body();
                    recyclerView.setAdapter(new RestAdapter(restData, getApplicationContext()));
                    if (LogTag.DEBUG) Log.d(TAG, "getKind : " + restData.getKind());
                    if (LogTag.DEBUG)
                        Log.d(TAG, "size : " + restData.getData().getChildren().size());
                }
            }

            @Override
            public void onFailure(Call<RestData> call, Throwable t) {
                if (LogTag.DEBUG) Log.d(TAG, "failed");

            }
        });


    }

    private void setOkHttp() {
        OkHttpClient client = RestOkhttpProvider.getInstance().getOkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("www.reddit.com")
                .addPathSegment("top.jason")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
    }

}
