package br.com.erivaldo.brewer.brewerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class IndexActivity extends DebugActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
/*
        Intent it = getIntent();
        Bundle param = it.getExtras();
        String texto = param.getString("nome");
        int numero = param.getInt("numero");
*/
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
                finish();
                //setContentView(R.layout.activity_login);
            }
        };
    }
}
