package com.androidhuman.example.materialdrawer;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {
    /**
     * 아래 내용은 XML파일을 인플레이션한 내용
     */
    Toolbar toolbar;
    /**
     * 좌측 숨겨진 메뉴와 메인화면을 담는 Layoiut
     * toolbar instanc에 toolbar의 속성을 정의하면 된다.
     * setTitle, setVisibility()등의 속성을 정의할수 있다.
     */
    DrawerLayout dlDrawer;
    /**
     * dtToggle은 상단 좌측의 그래픽 Animation
     */
    ActionBarDrawerToggle dtToggle;
    /**
     * 메인화면(바탕화면)
     */
    FrameLayout container;
    /**
     * 좌측 사이드에 숨겨진 메뉴
     */
    LinearLayout drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        toolbar.setTitle(R.string.main_menu);
        setSupportActionBar(toolbar);
        dlDrawer.setDrawerListener(dtToggle);
    }

    public void init() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        dlDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        dtToggle = new ActionBarDrawerToggle(this, dlDrawer, R.string.app_name, R.string.app_name);
        container = (FrameLayout) findViewById(R.id.container);
        drawer = (LinearLayout) findViewById(R.id.drawer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        dtToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        dtToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (dtToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
