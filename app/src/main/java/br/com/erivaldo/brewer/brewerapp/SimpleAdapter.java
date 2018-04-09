package br.com.erivaldo.brewer.brewerapp;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
