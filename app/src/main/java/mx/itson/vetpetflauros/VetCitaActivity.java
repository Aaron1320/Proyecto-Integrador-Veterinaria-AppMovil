package mx.itson.vetpetflauros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import mx.itson.vetpetflauros.adapters.CitaAdapter;
import mx.itson.vetpetflauros.entidades.ListaCitas;
import mx.itson.vetpetflauros.utilerias.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VetCitaActivity extends AppCompatActivity {
    Context context;
    ListView ListaCitas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_cita);

        ListaCitas = findViewById(R.id.listaCitas);
        context = this;
        obtenerCitas();
    }

    public void obtenerCitas(){

        try {
            Call<ListaCitas> call = Utils.getApi().getCitas();
            call.enqueue(new Callback<ListaCitas>() {
                @Override
                public void onResponse(Call<ListaCitas> call, Response<ListaCitas> response) {
                    ListaCitas citas = response.body();

                    CitaAdapter adapter = new CitaAdapter(VetCitaActivity.this, citas);

                    ListaCitas.setAdapter(adapter);

                    registerForContextMenu(ListaCitas);

                    ListaCitas.setOnItemClickListener((adapterView, view, i, l) -> {
                        int idCita = Integer.parseInt(((TextView)view.findViewById(R.id.txtId)).getText().toString());

                        Intent intentInfo = new Intent(VetCitaActivity.this, VetCitaInfoActivity.class);
                        intentInfo.putExtra(VetCitaActivity.this.getPackageName()+".dataInt",idCita);
                        startActivity(intentInfo);

                    });
                }

                @Override
                public void onFailure(Call<ListaCitas> call, Throwable t) {
                    Log.e("Error en API","Error: " + t.getMessage());
                }

            });

        } catch (Exception ex){
            Log.e("Error en API","Error: " + ex.getMessage());
        }

    }
}