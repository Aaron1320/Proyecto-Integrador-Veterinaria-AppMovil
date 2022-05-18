package mx.itson.vetpetflauros;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.StringReader;
import java.util.Map;

import mx.itson.vetpetflauros.adapters.MascotaAdapter;
import mx.itson.vetpetflauros.entidades.ListaMascotas;
import mx.itson.vetpetflauros.utilerias.Utils;
import retrofit2.Call;
import retrofit2.Callback;

public class VetLoginActivity extends AppCompatActivity {
    Context context;
    EditText edtTelefono;
    EditText edtContrasena;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vet_login);
        edtTelefono =findViewById(R.id.edtTelefono);
        edtContrasena =findViewById(R.id.edtContrasena);
        btnLogin =findViewById(R.id.btnLogin);
    }

}