package com.oanhkieu.th2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.oanhkieu.th2.fragment.InfoFragment;
import com.oanhkieu.th2.fragment.ListFragment;
import com.oanhkieu.th2.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottomNav);
        setupBottomNav();
    }
    private void setupBottomNav(){
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.frgList:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fcv, new ListFragment(),null).commit();
                        break;
                    case R.id.frgInfo:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fcv, new InfoFragment(),null).commit();
                        break;
                    case R.id.frgSearch:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fcv, new SearchFragment(),null).commit();
                        break;
                }
                return true;
            }

        });
    }
}