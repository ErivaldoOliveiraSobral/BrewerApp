package br.com.erivaldo.brewer.brewerapp;

import android.content.Intent;
import android.support.v4.view.MenuItemCompat;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class IndexActivity extends DebugActivity {

    private String [] listaCervejas = new String[]{"Franziskaner", "Paulaner", "Hofabrau", "Sierra Nevada", "Heineken", "Murphys"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Define qual será a View da Activity
        setContentView(R.layout.activity_index);

        ListView lista = findViewById(R.id.listaCervejas);
        lista.setAdapter(new SimpleAdapter(IndexActivity.this));

        lista.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(IndexActivity.this, "Clicou " + listaCervejas[i], Toast.LENGTH_LONG).show();
                Toast.makeText(IndexActivity.this, listaCervejas[i], Toast.LENGTH_LONG).show();

            }
        });

        // Recupera a intent e os dados enviados na chamda da Activity
        Intent intent = getIntent();
        Bundle params = intent.getExtras();

        // verificar se existe parâmetros
        if (params != null) {
            String nome = params.getString("nome");

            // Mostra o nome do usuário enviado no log e no Toast
            Toast.makeText(IndexActivity.this, "Nome do usuário: " + nome, Toast.LENGTH_LONG).show();

            // Altera o TextView da tela com o nome do usuário
            //TextView texto = (TextView) findViewById(R.id.textoInicial);
            //texto.setText(nome);
        }
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

    // TRatar os eventos dos botões do menu
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_atualizar) {
            Toast.makeText(IndexActivity.this,
                    "Atualizar",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_buscar) {
            Toast.makeText(IndexActivity.this,
                    "Buscar",
                    Toast.LENGTH_SHORT).show();
//        } else if (id == R.id.action_adicionar) {
//            Toast.makeText(IndexActivity.this,
//                    "Buscar",
//                    Toast.LENGTH_SHORT).show();
//            Intent it = new Intent(IndexActivity.this, CadastroActivity.class);
//            startActivityForResult(it, 1);
        } else if (id == R.id.action_config) {
            Toast.makeText(IndexActivity.this,
                    "Config",
                    Toast.LENGTH_SHORT).show();
        } else if (id == R.id.action_share) {
            Toast.makeText(IndexActivity.this,
                    "Compartilhar",
                    Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    // Recuperar resultado de CadastroActivity após ela ser finalizada
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                StringBuffer textoRetorno = new StringBuffer();
                textoRetorno.append(data.getStringExtra("nomeCerveja"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("tipoCerveja"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("paisCerveja"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("enderecoCerveja"));
                textoRetorno.append("\n");
                textoRetorno.append(data.getStringExtra("precoCerveja"));

                //TextView texto = (TextView) findViewById(R.id.textoInicial);
                //texto.setText(textoRetorno.toString());

            }
        }
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
