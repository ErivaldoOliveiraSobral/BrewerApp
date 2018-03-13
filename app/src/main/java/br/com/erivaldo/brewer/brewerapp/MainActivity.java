package br.com.erivaldo.brewer.brewerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends DebugActivity {

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
                TextView txtViewUsuario = (TextView) findViewById(R.id.txtUsuario);
                TextView txtViewSenha = (TextView) findViewById(R.id.txtSenha);

                String txtUsuario = txtViewUsuario.getText().toString();
                String txtSenha = txtViewSenha.getText().toString();

                if (txtUsuario.equals("admin") && txtSenha.equals("123")){
                    Toast.makeText(MainActivity.this, "Login Efetuado com Sucesso", Toast.LENGTH_LONG).show();
                    //setContentView(R.layout.activity_index);
                    setContentView(R.layout.activity_index);
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
