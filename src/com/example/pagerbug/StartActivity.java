
package com.example.pagerbug;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void onFragmentClick(View v) {
        Intent intent = new Intent(this, BrokenActivity.class);
        startActivity(intent);
    }
    
    public void onActivityClick(View v) {
        Intent intent = new Intent(this, WorkingActivity.class);
        startActivity(intent);
    }

}
