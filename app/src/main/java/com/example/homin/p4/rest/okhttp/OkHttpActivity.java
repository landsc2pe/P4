package com.example.homin.p4.rest.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.homin.p4.R;
import com.example.homin.p4.rest.okhttp.pojo.GistDatum;
import com.example.homin.p4.webview.WebView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by HOMIN on 2016-11-17.
 **/

public class OkHttpActivity extends AppCompatActivity {
    public static final String TAG = OkHttpActivity.class.getSimpleName();
    private OkHttpAdapter okHttpAdapter;
    private EditText editText;
    private List<OkHttpCustom> customData;
    private android.webkit.WebView myWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_okhttp_activity);
        myWebView = (android.webkit.WebView) findViewById(R.id.webview);

        customData = new ArrayList<>();
        setView();
    }

    private void setView() {
        setButton();
        setEditText();
        setRecyclerView();
        setOnClickListener();
    }

    private void setButton() {
        Button button = (Button) findViewById(R.id.rest_okhttp_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getGists(setOkHttp(editText.getText().toString()));
            }
        });
    }

    private void setEditText() {
        editText = (EditText) findViewById(R.id.rest_okhttp_editText);
    }

    private void setRecyclerView() {
        okHttpAdapter = new OkHttpAdapter(customData, getApplicationContext());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rest_okhttp_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(okHttpAdapter);
    }

    private void setOnClickListener() {
        okHttpAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onClick(String url) {
                Fragment webView = WebView.newInstance(url);
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.rest_okhttp_container, webView, WebView.TAG);
                transaction.addToBackStack(WebView.TAG);
                transaction.commit();
            }
        });
    }

    // TODO: 2016. 11. 19. POST https://api.github.com/gists
    // In Content-Body
    /*
    {
        "description": "the description for this gist",
            "public": true,
            "files": {
        "file1.txt": {
            "content": "String file contents"
        }
    }
    }
    */

    // TODO: 2016. 11. 19. GET /users/jayjaykim/followers 
    // TODO: 2016. 11. 19. host : api.github.com
    private Request setOkHttp(String Id) {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.github.com")
                .addPathSegment("users")
                .addPathSegment(Id)
                .addPathSegment("gists")
                .build();

        return new Request.Builder()
                .url(httpUrl)
                .get()
                .build();
    }

    private void getGists(final Request request) {
        OkHttpClient client = OkHttpProvider.getInstance().getOkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Type collectionType = new TypeToken<List<GistDatum>>() {
                }.getType();
                List<GistDatum> gistsData = new Gson().fromJson(response.body().charStream(), collectionType);
//                if(LogTag.DEBUG) Log.d(TAG, "Size : "+ gistsData.get(0).getFiles().getGistfile1Java().getFilename());
                for (GistDatum datum : gistsData) {
                    customData.add(new OkHttpCustom(
                            datum.getHtmlUrl()));

                    //파일이 안불려짐... ㄴ미;ㅇ러ㅣㅁ;날엄ㄴ;ㅣㅏ
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        okHttpAdapter.setGistsUpdate(customData);
                        okHttpAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }
}
