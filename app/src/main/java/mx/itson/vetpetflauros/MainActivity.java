package mx.itson.vetpetflauros;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button btnConsultar;
    Button btnSolicitar;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnConsultar = findViewById(R.id.btnConsultar);
        btnConsultar.setOnClickListener(this);

        btnSolicitar = findViewById(R.id.btnSolicitar);
        btnSolicitar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnConsultar:
                Intent intentAgregar = new Intent(MainActivity.this, VetListActivity.class);
                startActivity(intentAgregar);
                break;

            case R.id.btnSolicitar:
                Intent intentConsultar = new Intent(MainActivity.this, VetInfoActivity.class);
                startActivity(intentConsultar);
                break;
        }
    }
}