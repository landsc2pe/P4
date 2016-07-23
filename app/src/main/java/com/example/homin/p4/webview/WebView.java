package com.example.homin.p4.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewClient;

import com.example.homin.p4.R;

/**
 * Created by HOMIN on 2016-07-20.
 */
// TODO: 2016-07-23 callApp(javascript calls java method), callWeb(java calls javascript method)
public class WebView extends Fragment {
    public static final String TAG = WebView.class.getSimpleName();
    private android.webkit.WebView myWebView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.webview, container, false);
        myWebView = (android.webkit.WebView) view.findViewById(R.id.webview);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {
        setWebView();
        
    }

    private void setWebView() {
        myWebView.getSettings().setLoadsImagesAutomatically(true);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setDomStorageEnabled(true);
        myWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        myWebView.setWebViewClient(new MyBrowser());
        myWebView.loadUrl("http://www.naver.com");
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(android.webkit.WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
    
//    void onBackPressed() {
//        if(myWebView != null && myWebView.canGoBack()) {
//            myWebView.goBack();
//
//            myWebView.canGoBackOrForward();
//            myWebView.goBackOrForward();
//        } else {
//            // TODO: 2016-07-23 dispatch the backkey event.
//        }
//    }
}
