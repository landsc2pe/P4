package com.example.homin.p4.rest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.LogTag;
import com.example.homin.p4.rest.pojo.Child;
import com.example.homin.p4.rest.pojo.RestData;

import java.util.ArrayList;
import java.util.List;

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
    private List<Child> restData;
    private List<RestPojo> restPojoList;
    private RestAdapter restAdapter;
    private RestService service;
    private Retrofit retrofit;
    private String restAfter;
    private Call<RestData> call;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_activity);
        restPojoList = new ArrayList<>();

        init();
    }

    private void init() {
        setRetrofit();
        setViews();

//        setOkHttp();
    }


    private void setViews() {
        setToolBar();
    }

    private void setRecyclerView() {
        restAdapter = new RestAdapter(restPojoList, getApplicationContext());
        recyclerView = (RecyclerView) findViewById(R.id.rest_activity_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(restAdapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            public int curSize;

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                curSize = restAdapter.getItemCount();
                if(LogTag.DEBUG)Log.d(TAG, restAfter);
                call = service.getRestPojo(restAfter, 5);
                if(LogTag.DEBUG) Log.d(TAG, "url : " + call.request().url());
                call.enqueue(new Callback<RestData>() {
                    @Override
                    public void onResponse(Call<RestData> call, Response<RestData> response) {
                        if(LogTag.DEBUG)Log.d(TAG, ""+curSize);
                        restAfter = response.body().getData().getAfter();
                        if(LogTag.DEBUG)Log.d(TAG, restAfter);
                        restData =  response.body().getData().getChildren();
                        List<RestPojo> pojos = new ArrayList<>();
                        for (Child data : restData) {
                            pojos.add(new RestPojo(data.getData().getTitle(), data.getData()
                                    .getAuthor(), data.getData().getSubreddit(), data.getData()
                                    .getScore(), data.getData().getNumComments(), data.getData().getThumbnail()));
                        }
                        restPojoList.addAll(pojos);
                        restAdapter.notifyItemRangeInserted(curSize, restData.size());
                        if(LogTag.DEBUG)Log.d(TAG, ""+curSize);

                    }

                    @Override
                    public void onFailure(Call<RestData> call, Throwable t) {
                        if (LogTag.DEBUG) Log.d(TAG, "failed");

                    }
                });
            }
        });
    }

    private void setToolBar() {

    }

    private void setRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RestService.class);
        call = service.getRestPojo("", 5);
        call.enqueue(new Callback<RestData>() {
            @Override
            public void onResponse(Call<RestData> call, Response<RestData> response) {
                if (response != null && response.body() != null) {
                    restAfter = response.body().getData().getAfter();
                    restData = response.body().getData().getChildren();
                    for (Child data : restData) {
                        restPojoList.add(new RestPojo(data.getData().getTitle(), data.getData()
                                .getAuthor(), data.getData().getSubreddit(), data.getData()
                                .getScore(), data.getData().getNumComments(), data.getData().getThumbnail()));
                    }
                    setRecyclerView();
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