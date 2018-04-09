package br.com.erivaldo.brewer.brewerapp;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class IndexActivity extends DebugActivity {

    private String [] listaCervejas = new String[]{"Franziskaner", "Paulaner", "Hofabrau", "Sierra Nevada", "Heineken", "Murphys"};

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
    // Método para colocar o menu na ActionBar
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflar o menu na view
        getMenuInflater().inflate(R.menu.menu_main, menu);

        // Recuperar SearchView
        MenuItem item = menu.findItem(R.id.action_buscar);
        SearchView searchView = (SearchView) item.getActionView();
        // Listener que espera a ação de buscar
        searchView.setOnQueryTextListener(onSearch());

        // Recuperar  botão de compartilhar
        MenuItem shareItem = menu.findItem(R.id.action_share);
        ShareActionProvider share = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
        //Listener que espera a ação de compartilhar
        share.setShareIntent(getDefautIntent());
        return true;
    }

    // Funcao para retornar o tratamento do evento de compartilhamento
    private Intent getDefautIntent() {
        // Intent ACTION_SEND. Qualquer app que responde essa intenção pode ser chamado
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/*");
        String textoShare = "Minha Lista de cervejas! \n";

        for (String cerveja: listaCervejas) {
            textoShare += cerveja +"\n";
        }
        intent.putExtra(Intent.EXTRA_TEXT, textoShare);
        return intent;
    }

    // Funcao para retornar o tratamento do evento no SearchView
    private SearchView.OnQueryTextListener onSearch() {
        return new SearchView.OnQueryTextListener() {
            @Override
            // Tratamento do evento quando termina de escrever
            public boolean onQueryTextSubmit(String query) {
                query = query.toLowerCase();
                Toast.makeText(IndexActivity.this, query, Toast.LENGTH_SHORT).show();
                String results = "";
                for (String cerveja: listaCervejas) {
                    if(cerveja.toLowerCase().contains(query)){
                        results += cerveja +"\n";
                    }
                }
                //TextView texto = (TextView) findViewById(R.id.textoInicial);
                //texto.setText(results);
                return false;
            }

            @Override
            // Tratamento do evento enquanto ainda está escrevendo
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(IndexActivity.this, newText, Toast.LENGTH_SHORT).show();
                return false;
            }
        };
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
