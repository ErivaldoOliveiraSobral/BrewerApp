package br.com.erivaldo.brewer.brewerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends DebugActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(onClickLogin());
    }

    private View.OnClickListener onClickLogin() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           /*
                Bundle params = new Bundle();
                params.putString("nome", "Erivaldo");
                params.putString("numero", "123");
            */

                TextView txtViewUsuario = (TextView) findViewById(R.id.txtUsuario);
                TextView txtViewSenha = (TextView) findViewById(R.id.txtSenha);

                String txtUsuario = txtViewUsuario.getText().toString();
                String txtSenha = txtViewSenha.getText().toString();

                if (txtUsuario.equals("admin") && txtSenha.equals("123")){
                    Toast.makeText(MainActivity.this, "Login Efetuado com Sucesso", Toast.LENGTH_LONG).show();
                    //setContentView(R.layout.activity_index);
                    Intent it = new Intent(MainActivity.this,IndexActivity.class);
                    startActivity(it);
                } else {
                    Toast.makeText(
                            MainActivity.this,
                            "Usuário = admin e Senha = 123",
                            Toast.LENGTH_LONG).show();
                }
            }
        };
    }
}
