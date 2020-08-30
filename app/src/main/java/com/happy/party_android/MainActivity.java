package com.happy.party_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    Fragment homefragment;
    Fragment locationfragment;
    Fragment locationgpsfragment;
    Fragment pocketfragment;
    Fragment accountfragment;

    private static final int MY_PERMISSION_REQUEST_LOCATION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homefragment = new HomeFragment();
        locationfragment = new LocationFragment();
        locationgpsfragment = new LocationGpsFragment();
        pocketfragment = new PocketFragment();
        accountfragment = new AccountFragment();

        permissionCheck();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, homefragment).commit();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_main:
                        Toast.makeText(getApplicationContext(), "환영합니다!", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, homefragment).commit();
                        return true;

                    case R.id.navigation_location:
                        Toast.makeText(getApplicationContext(), "사랑합니다.!", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, locationfragment).commit();
                        return true;

                    case R.id.navigation_location_gps:
                        Toast.makeText(getApplicationContext(), "히히히!", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, locationgpsfragment).commit();
                        return true;

                    case R.id.navigation_pocket:
                        Toast.makeText(getApplicationContext(), "에에엨", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, pocketfragment).commit();
                        return true;

                    case R.id.navigation_account:
                        Toast.makeText(getApplicationContext(), "회원가입 하셨나요?", Toast.LENGTH_LONG).show();
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, accountfragment).commit();
                        return true;
                }
                return false;
            }
        });
    }

    private void permissionCheck() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
                PackageManager.PERMISSION_GRANTED){
            //gps 접근 승낙 상태 일때
        }
        else {
            //gps 접근 거절 상태일때.
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSION_REQUEST_LOCATION);
        }
    }
}