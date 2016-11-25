package com.example.homin.p4.rest.okhttp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.homin.p4.R;
import com.example.homin.p4.base.util.LogTag;
import com.example.homin.p4.rest.okhttp.decorator.UrlBase;
import com.example.homin.p4.rest.okhttp.decorator.UrlHost;
import com.example.homin.p4.rest.okhttp.decorator.UrlPathSegment;
import com.example.homin.p4.rest.okhttp.decorator.UrlScheme;
import com.example.homin.p4.rest.okhttp.pojo.get.GistDatum;
import com.example.homin.p4.rest.okhttp.pojo.post.PostRespond;
import com.example.homin.p4.webview.WebView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by HOMIN on 2016-11-17.
 **/

public class OkHttpActivity extends AppCompatActivity {
    public static final String TAG = OkHttpActivity.class.getSimpleName();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private OkHttpAdapter okHttpAdapter;
    private EditText editText;
    private List<OkHttpCustom> customData;
    private OkHttpClient client;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rest_okhttp_activity);

        customData = new ArrayList<>();
        setView();
    }

    private void setView() {
        setEditText();
        setRecyclerView();
        setOnClickListener();
    }

    private void setEditText() {
        editText = (EditText) findViewById(R.id.rest_okhttp_editText);
    }

    private void setRecyclerView() {
        okHttpAdapter = new OkHttpAdapter(null, getApplicationContext());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rest_okhttp_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(okHttpAdapter);


        Button button = (Button) findViewById(R.id.rest_okhttp_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (customData.size() > 0) {
                    customData.clear();
                    okHttpAdapter.setCustomData(null);
                    okHttpAdapter.notifyDataSetChanged();
                    Toast.makeText(getApplicationContext(), "clear", Toast.LENGTH_SHORT).show();

                } else {
                    if (LogTag.DEBUG) Log.d(TAG, "Posted !");
                    if (editText.getText().length() == 0) {
                        postGists(postRequest(setJSON("haha", "hihihi")));
                    } else {
                        getGists(getRequest(editText.getText().toString()));
                    }
                }


            }
        });

        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                customData.clear();
                okHttpAdapter.setCustomData(null);
                okHttpAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "clear", Toast.LENGTH_SHORT).show();

                return true;
            }
        });
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

    private JSONObject setJSON(String fileName, String contentBody) {
        JSONObject object = new JSONObject();
        JSONObject file = new JSONObject();
        JSONObject content = new JSONObject();

        try {
            content.put("content", contentBody);
            file.put(fileName, content);

            object.put("description", "A description of the gist.");
            object.put("public", true);
            object.put("files", file);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return object;
    }


    private Request getRequest(String Id) {

        UrlBase url = new UrlBase();
        url = new UrlScheme(url, url.getHttp());
        url = new UrlHost(url, url.getGithubHost());
        url = new UrlPathSegment(url, url.getSegmentUser());
        url = new UrlPathSegment(url, "/" + Id);
        url = new UrlPathSegment(url, url.getSegmentGists());

        if(LogTag.DEBUG)Log.d(TAG, "Url Base : " + url);

        return new Request.Builder()
                .url(url.getUrl())
                .get()
                .build();
    }

    private Request postRequest(JSONObject object) {
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme("https")
                .host("api.github.com")
                .addPathSegment("gists")
                .build();

        RequestBody requestBody = RequestBody.create(JSON, object.toString());

        return new Request.Builder()
                .url(httpUrl)
                .post(requestBody)
                .build();
    }

    private void getGists(final Request request) {
        client = OkHttpProvider.getInstance().getOkHttpClient();
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
                    customData.add(new OkHttpCustom(datum.getHtmlUrl(), null));

                    //파일이 안불려짐... ㄴ미;ㅇ러ㅣㅁ;날엄ㄴ;ㅣㅏ
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        okHttpAdapter.setCustomData(customData);
                        okHttpAdapter.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    private void postGists(final Request request) {
        client = OkHttpProvider.getInstance().getOkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                if (LogTag.DEBUG) Log.d(TAG, "Failed !!!");

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (LogTag.DEBUG) Log.d(TAG, "Posted !!!");
                PostRespond gistsData = new Gson().fromJson(response.body().charStream(), PostRespond.class);
//                if(LogTag.DEBUG) Log.d(TAG, "Size : "+ gistsData.get(0).getFiles().getGistfile1Java().getFilename());
                customData.add(new OkHttpCustom(null, gistsData.getHtmlUrl()));

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        okHttpAdapter.setCustomData(customData);
                        okHttpAdapter.notifyDataSetChanged();

                    }
                });
            }
        });
    }
}