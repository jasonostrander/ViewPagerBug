
package com.example.pagerbug;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.view.ViewPager;

public class TestActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        
        LoaderManager.enableDebugLogging(true);
        
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }
    
    @Override
    protected void onStart() {
        Thread.dumpStack();
        super.onStart();
    }
}
