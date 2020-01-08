package com.example.bkrc.swankysocialnetwork;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private NavigationView navigationViewStart;
    private NavigationView navigationViewEnd;
    private NavigationView navigationViewBottom;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private RecyclerView postList;
    private Toolbar mToolbar;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mAuth = FirebaseAuth.getInstance();


        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("Swanky");

        drawerLayout = (DrawerLayout) findViewById(R.id.drawable_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.drawer_open, R.string.drawer_close );
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationViewEnd = (NavigationView) findViewById(R.id.nav_view_end);
        navigationViewStart = (NavigationView) findViewById(R.id.nav_view_start);
        navigationViewBottom = (NavigationView) findViewById(R.id.nav_view_bottom);
        View navStartView = navigationViewStart.inflateHeaderView(R.layout.layout_navigation_start_header);
        View navEndView = navigationViewEnd.inflateHeaderView(R.layout.layout_navigation_end_header);

        navigationViewStart.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                StartMenuSelector(item);
                return false;
            }
        });
       navigationViewEnd.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                EndMenuSelector(item);
                return false;
            }
        });
       /* navigationViewBottom.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                return false;
            }
        });*/

        }



      protected void onStart(){

        super.onStart();

            FirebaseUser currentUser= mAuth.getCurrentUser();
            if(currentUser==null){
                //SendUserToLoginActivity();
            }
        }

    private void SendUserToLoginActivity() {
        Intent loginIntent=new Intent(MainActivity.this, LoginActivity.class);
        loginIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(loginIntent);
        finish();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private void StartMenuSelector(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.nav_yarismalar:
                Toast.makeText(this, "Yarışmalar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_blog:
                Toast.makeText(this, "Blog", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_haftanin_kazananlari:
                Toast.makeText(this, "Haftanın Kazananları", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_iletisim:
                Toast.makeText(this, "İletişim", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void EndMenuSelector(MenuItem item)
    {

        switch (item.getItemId())
        {
            case R.id.nav_profil:
                Toast.makeText(this, "Yarışmalar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_ayarlar:
                Toast.makeText(this, "Ayarlar", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav_cikis:
                Toast.makeText(this, "Çıkış", Toast.LENGTH_SHORT).show();
                break;
        }
    }
       // postList = (RecyclerView) findViewById(R.id.recycle_view);
    }

