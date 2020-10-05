package com.example.depay;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navItemListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.wallet:
                            selectedFragment = new WalletFragment();
                            break;
                        case R.id.history:
                            selectedFragment = new HistoryFragment();
                            break;
                        case R.id.receive:
                            selectedFragment = new ReceiveFragment();
                            break;
                        case R.id.account:
                            selectedFragment = new AccountFragment();
                            break;
                        default:
                            selectedFragment = new WalletFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, selectedFragment)
                            .commit();
                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navItemListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.frag_container, new WalletFragment())
                .commit();

        FloatingActionButton sendButton = findViewById(R.id.send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToPayScreen = new Intent(HomeActivity.this, PayActivity.class);
                startActivity(goToPayScreen);
            }
        });
    }
}