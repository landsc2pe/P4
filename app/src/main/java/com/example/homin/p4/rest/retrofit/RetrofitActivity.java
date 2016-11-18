package com.example.homin.p4.rest.retrofit;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.LogTag;
import com.example.homin.p4.rest.okhttp.OkHttpProvider;
import com.example.homin.p4.rest.retrofit.pojo.Child;
import com.example.homin.p4.rest.retrofit.pojo.RedditDatum;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by HOMIN on 2016-08-27.
 */
public class RetrofitActivity extends AppCompatActivity {
    public static final String TAG = RetrofitActivity.class.getSimpleName();
    private List<Child> restData;
    private List<RedditCustom> mRedditCustomList;
    private RetrofitAdapter retrofitAdapter;
    private RetrofitService service;
    private String restAfter;
    private Call<RedditDatum> call;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_activity);
        mRedditCustomList = new ArrayList<>();

        setRetrofit();
        setRecyclerView();
    }

    private void setRecyclerView() {
        retrofitAdapter = new RetrofitAdapter(mRedditCustomList, getApplicationContext());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rest_activity_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(retrofitAdapter);
        recyclerView.addOnScrollListener(new EndlessRecyclerViewScrollListener(layoutManager) {
            public int curSize;

            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                curSize = retrofitAdapter.getItemCount();
                if (LogTag.DEBUG) Log.d(TAG, restAfter);
                call = service.getRedditPOJO(restAfter, 20);
                if (LogTag.DEBUG) Log.d(TAG, "url : " + call.request().url());
                call.enqueue(new Callback<RedditDatum>() {
                    @Override
                    public void onResponse(Call<RedditDatum> call, Response<RedditDatum> response) {
                        if (LogTag.DEBUG) Log.d(TAG, "" + curSize);
                        restAfter = response.body().getData().getAfter();
                        if (LogTag.DEBUG) Log.d(TAG, restAfter);
                        restData = response.body().getData().getChildren();
                        List<RedditCustom> pojos = new ArrayList<>();
                        for (Child data : restData) {
                            pojos.add(new RedditCustom(data.getData().getTitle(), data.getData()
                                    .getAuthor(), data.getData().getSubreddit(), data.getData()
                                    .getScore(), data.getData().getNumComments(), data.getData().getThumbnail()));
                        }
                        mRedditCustomList.addAll(pojos);
                        retrofitAdapter.notifyItemRangeInserted(curSize, restData.size());
                        if (LogTag.DEBUG) Log.d(TAG, "" + curSize);

                    }

                    @Override
                    public void onFailure(Call<RedditDatum> call, Throwable t) {
                        if (LogTag.DEBUG) {
                            Log.d(TAG, "failed : " + t.getMessage());
                            t.printStackTrace();
                        }
                    }
                });
            }
        });
    }


    private void setRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .client(OkHttpProvider.getInstance().getOkHttpClient())
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(RetrofitService.class);
        call = service.getRedditPOJO("", 20);
        call.enqueue(new Callback<RedditDatum>() {
            @Override
            public void onResponse(Call<RedditDatum> call, Response<RedditDatum> response) {
                if (response != null && response.body() != null) {
                    restAfter = response.body().getData().getAfter();
                    restData = response.body().getData().getChildren();
                    for (Child data : restData) {
                        mRedditCustomList.add(new RedditCustom(data.getData().getTitle(), data.getData()
                                .getAuthor(), data.getData().getSubreddit(), data.getData()
                                .getScore(), data.getData().getNumComments(), data.getData().getThumbnail()));
                    }
                    retrofitAdapter.setRedditCustomList(mRedditCustomList);
                    retrofitAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<RedditDatum> call, Throwable t) {
                if (LogTag.DEBUG) {
                    Log.d(TAG, "failed : " + t.getMessage());
                    t.printStackTrace();
                }

            }
        });
    }




}
