package mx.itson.vetpetflauros;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import mx.itson.vetpetflauros.utilerias.Utils;
import mx.itson.vetpetflauros.entidades.ListaMascotas;
import mx.itson.vetpetflauros.adapters.MascotaAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VetListActivity extends AppCompatActivity {
    Context context;
    ListView ListaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_list);

        ListaMascotas = findViewById(R.id.listaMascotas);

        context = this;
        obtenerMascotas();
    }

    public void obtenerMascotas(){
        //ListaUsuarios usuarios = new ListaUsuarios();

        try {
            Call<ListaMascotas> call = Utils.getApi().getMascotas();
            call.enqueue(new Callback<ListaMascotas>() {
                @Override
                public void onResponse(Call<ListaMascotas> call, Response<ListaMascotas> response) {
                    ListaMascotas mascotas = response.body();

                    MascotaAdapter adapter = new MascotaAdapter(VetListActivity.this, mascotas);

                    ListaMascotas.setAdapter(adapter);

                    registerForContextMenu(ListaMascotas);

                    ListaMascotas.setOnItemClickListener((adapterView, view, i, l) -> {
                        int idUsuario = Integer.parseInt(((TextView)view.findViewById(R.id.txtId)).getText().toString());

                        Intent intentInfo = new Intent(VetListActivity.this, VetInfoActivity.class);
                        intentInfo.putExtra(VetListActivity.this.getPackageName()+".dataInt",idUsuario);
                        startActivity(intentInfo);

                    });
                }

                @Override
                public void onFailure(Call<ListaMascotas> call, Throwable t) {
                    Log.e("Error en API","Error: " + t.getMessage());
                }

            });

        } catch (Exception ex){
            Log.e("Error en API","Error: " + ex.getMessage());
        }

    }
}
