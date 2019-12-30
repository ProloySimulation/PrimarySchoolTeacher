package com.example.primaryschoolteachers_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.primaryschoolteachers_app.Fragment.HomeFragment;
import com.example.primaryschoolteachers_app.Fragment.LogFragment;
import com.example.primaryschoolteachers_app.Fragment.ProfileFragment;
import com.goodiebag.pinview.Pinview;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNv = findViewById(R.id.bottomNav);
        bottomNv.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,
                new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectFragment = null ;

            switch (menuItem.getItemId())
            {
                case R.id.nav_home:
                    selectFragment = new HomeFragment();
                    break;
                case R.id.nav_log:
                    selectFragment = new LogFragment();
                    break;
                case  R.id.nav_profile:
                    selectFragment = new ProfileFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,
                    selectFragment).commit();

            return true ;
        }
    };

}
