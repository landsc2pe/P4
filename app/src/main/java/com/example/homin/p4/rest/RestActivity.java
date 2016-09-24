package com.example.homin.p4.rest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.LogTag;
import com.example.homin.p4.rest.interfaces.OkHttpRequest;
import com.example.homin.p4.rest.interfaces.OkhttpListener;
import com.example.homin.p4.rest.interfaces.RestService;
import com.example.homin.p4.rest.pojo.Child;
import com.example.homin.p4.rest.pojo.RestData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

        OkHttpRequest request1 = new OkHttpConcreteRequest();
        setOkHttp(request1.webRequest(null).get());

        OkHttpRequest request2 = new OkHttpConcreteRequest();
        setOkHttp(request2.webRequest(null).get());
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
                if (LogTag.DEBUG) Log.d(TAG, restAfter);
                call = service.getRestPojo(restAfter, 20);
                if (LogTag.DEBUG) Log.d(TAG, "url : " + call.request().url());
                call.enqueue(new Callback<RestData>() {
                    @Override
                    public void onResponse(Call<RestData> call, Response<RestData> response) {
                        if (LogTag.DEBUG) Log.d(TAG, "" + curSize);
                        restAfter = response.body().getData().getAfter();
                        if (LogTag.DEBUG) Log.d(TAG, restAfter);
                        restData = response.body().getData().getChildren();
                        List<RestPojo> pojos = new ArrayList<>();
                        for (Child data : restData) {
                            pojos.add(new RestPojo(data.getData().getTitle(), data.getData()
                                    .getAuthor(), data.getData().getSubreddit(), data.getData()
                                    .getScore(), data.getData().getNumComments(), data.getData().getThumbnail()));
                        }
                        restPojoList.addAll(pojos);
                        restAdapter.notifyItemRangeInserted(curSize, restData.size());
                        if (LogTag.DEBUG) Log.d(TAG, "" + curSize);

                    }

                    @Override
                    public void onFailure(Call<RestData> call, Throwable t) {
                        if (LogTag.DEBUG) {
                            Log.d(TAG, "failed : " + t.getMessage());
                            t.printStackTrace();
                        }
                    }
                });
            }
        });
    }

    private void setToolBar() {

    }

    private void setRetrofit() {
        retrofit = new Retrofit.Builder()
                .client(OkHttpProvider.getInstance().getOkHttpClient())
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RestService.class);
        call = service.getRestPojo("", 20);
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
                if (LogTag.DEBUG) {
                    Log.d(TAG, "failed : " + t.getMessage());
                    t.printStackTrace();
                }

            }
        });
    }

    private void setOkHttp(Request request) {
        OkhttpAdapter adapter = new OkhttpAdapter(request);
        adapter.makeCall(new OkhttpListener() {
            @Override
            public void onFail(okhttp3.Call call, IOException io) {

            }

            @Override
            public void onRes(okhttp3.Call call, okhttp3.Response response) {

            }
        });
    }


}
