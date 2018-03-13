package br.com.erivaldo.brewer.brewerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button btnVoltar = (Button) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(onclickVoltar());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private View.OnClickListener onclickVoltar() {
        return new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_login);
            }
        };
    }
}
