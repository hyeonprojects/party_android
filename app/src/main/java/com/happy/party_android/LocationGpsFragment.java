package com.happy.party_android;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class LocationGpsFragment extends Fragment {

    private WebView webView;
    private final String VIEW_URL = "https://www.google.co.kr/maps/";
    private static final int MY_PERMISSION_REQUEST_LOCATION = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_location_gps, container, false);
        webView = (WebView) view.findViewById(R.id.webview_location_gps);

        webView.getSettings().setJavaScriptEnabled(true); //자바스크립트 사용허가
        webView.setWebViewClient(new WebViewClient()); //새로운창을 띄우지 않고 내부에서 웹뷰를 실행

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                super.onGeolocationPermissionsShowPrompt(origin, callback);
                callback.invoke(origin, true, false);
            }
        });

        webView.loadUrl(VIEW_URL);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setRetainInstance(true);
    }


}