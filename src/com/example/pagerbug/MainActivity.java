
package com.example.pagerbug;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }
    
    @Override
    protected void onStart() {
        super.onStart();
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.activity_test, container, false);
            ViewPager pager = (ViewPager) rootView.findViewById(R.id.pager);
            pager.setOffscreenPageLimit(2);
            pager.setAdapter(new PagerAdapter(getChildFragmentManager()));
            return rootView;
        }
        
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            getLoaderManager().enableDebugLogging(true);
            
            getView().post(new Runnable() {
                
                @Override
                public void run() {
                    Log.v("jason", "has running loaders = " + getLoaderManager().hasRunningLoaders());
                }
            });
        }
        
        @Override
        public void onStart() {
            super.onStart();
            Thread.dumpStack();
        }
    }
}
