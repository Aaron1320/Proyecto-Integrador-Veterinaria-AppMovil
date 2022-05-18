package mx.itson.vetpetflauros.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import mx.itson.vetpetflauros.R;
import mx.itson.vetpetflauros.entidades.Cita;
import mx.itson.vetpetflauros.entidades.ListaCitas;
import mx.itson.vetpetflauros.entidades.ListaMascotas;
import mx.itson.vetpetflauros.entidades.Mascota;

public class CitaAdapter extends BaseAdapter {

    private Context context;
    private ListaCitas citas;

    public CitaAdapter(Context context, ListaCitas citas){
        this.context = context;
        this.citas = citas;
    }

    @Override
    public int getCount() {

        return citas.getCitas().size();
    }

    @Override
    public Object getItem(int i) {

        return citas.getCitas().get(i);

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        try{
            Cita cita = (Cita) getItem(i);
            view = LayoutInflater.from(context).inflate(R.layout.item_cita, null);
            TextView txtId = view.findViewById(R.id.txtId);
            txtId.setText(String.valueOf(cita.getId()));

            TextView txtIdUsuario = view.findViewById(R.id.txtIdUsuario);
            txtIdUsuario.setText(String.valueOf(cita.getIdUsuario()));

            TextView txtIdMascota = view.findViewById(R.id.txtIdMascota);
            txtIdMascota.setText(String.valueOf(cita.getIdMascota()));

            TextView txtDescripcion = view.findViewById(R.id.txtDescripcion);
            txtDescripcion.setText(cita.getDescripcion());


        } catch (Exception ex){
            Log.e("Error en el adaptador",ex.getMessage());
        }
        return view;
    }
}
