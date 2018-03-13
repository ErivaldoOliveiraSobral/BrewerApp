package br.com.erivaldo.brewer.brewerapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class DebugActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);
        Log.i("MY_APP", getClassName() + " Chamou onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MY_APP", getClassName() + " Chamou onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("MY_APP", getClassName() + " Chamou onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MY_APP", getClassName() + " Chamou onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MY_APP", getClassName() + " Chamou onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MY_APP", getClassName() + " Chamou onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MY_APP", getClassName() + " Chamou onDestroy()");
    }

    private String getClassName() {
        String s = getClass().getName();
        return s.substring(s.lastIndexOf("."));
    }
}
