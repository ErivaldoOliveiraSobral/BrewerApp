package br.com.erivaldo.brewer.brewerapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Android on 09/04/2018.
 */

public class SimpleAdapter extends BaseAdapter {

    public String[] listaDeCervejas = new String[] {"Franziskaner", "Paulaner", "Hofabrau", "Sierra Nevada", "Heineken", "Murphys"};
    Context contexto;

    public SimpleAdapter(Context contexto){
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return this.listaDeCervejas.length;
    }

    @Override
    public Object getItem(int i) {
        return this.listaDeCervejas[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup viewGroup){
        String cerveja = listaDeCervejas[posicao];

        View viewText = LayoutInflater.from(contexto).inflate(R.layout.tela_inicial_itens, viewGroup, false);
        TextView t = (TextView) viewText.findViewById(R.id.textItemList);
        t.setText(cerveja);

        return viewText;
    }
}
