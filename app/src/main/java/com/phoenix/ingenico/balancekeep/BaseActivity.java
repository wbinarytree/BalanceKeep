package com.phoenix.ingenico.balancekeep;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

public class BaseActivity extends AppCompatActivity {
    private FrameLayout contentView = null;
    private DrawerLayout drawer;
    public FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //override fab.setOnClickListener in Activity
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Initial Drawer
        drawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new MyOnNavigationItemSelectedListener());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_base, menu);
        return true;
    }

    //override this method to binding listener menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        if (R.layout.activity_base_drawer == layoutResID) {
            super.setContentView(R.layout.activity_base_drawer);
            contentView = (FrameLayout) findViewById(R.id.layout_content);
            contentView.removeAllViews();

        } else {
            View addView = LayoutInflater.from(this).inflate(layoutResID, null);
            contentView.addView(addView);
        }
    }

    //Navigation Drawer Menu Selected Listener
    class MyOnNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            int id = item.getItemId();
            switch (id) {
                case R.id.nav_camera:
                    break;
                case R.id.nav_gallery:
                    break;
                case R.id.nav_manage:
                    break;
                /*
                * ...else menu
                *
                * */

                default:

            }
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }
    }

}

