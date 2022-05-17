package mx.itson.vetpetflauros.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import mx.itson.vetpetflauros.R;
import mx.itson.vetpetflauros.entidades.ListaMascotas;
import mx.itson.vetpetflauros.entidades.Mascota;

public class MascotaAdapter extends BaseAdapter {

    private Context context;
    private ListaMascotas mascotas;

    public MascotaAdapter(Context context, ListaMascotas mascotas){
        this.context = context;
        this.mascotas = mascotas;
    }

    @Override
    public int getCount() {

        return mascotas.getMascotas().size();
    }

    @Override
    public Object getItem(int i) {

        return mascotas.getMascotas().get(i);

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        try{
            Mascota mascota = (Mascota) getItem(i);
            view = LayoutInflater.from(context).inflate(R.layout.item_mascota, null);
            TextView txtId = view.findViewById(R.id.txtId);
            txtId.setText(String.valueOf(mascota.getId()));

            TextView txtNombre = view.findViewById(R.id.txtNombre);
            txtNombre.setText(mascota.getNombre());

            TextView txtRaza = view.findViewById(R.id.txtRaza);
            txtRaza.setText(mascota.getRaza());


        } catch (Exception ex){
            Log.e("Error en el adaptador",ex.getMessage());
        }
        return view;
    }
}
