package aahl.actividadcuatro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnDPS, btnSent, btnCont, btnInic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDPS = findViewById(R.id.btn_dps);
        btnSent = findViewById(R.id.btn_sentinelas);
        btnCont = findViewById(R.id.btn_controladores);
        btnInic = findViewById(R.id.btn_iniciadores);

        // Se carga un fragmento inicial cuando se abre la aplicación
        loadFragment(new fragment_dps());

        btnDPS.setOnClickListener(v -> loadFragment(new fragment_dps()));
        btnSent.setOnClickListener(v -> loadFragment(new fragment_sentinelas()));
        btnCont.setOnClickListener(v -> loadFragment(new fragment_controladores()));
        btnInic.setOnClickListener(v -> loadFragment(new fragment_iniciadores()));

    }

    private void loadFragment(Fragment fragment) {
        // Inicia una transacción de fragmentos
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        // Reemplaza el contenido del FrameLayout con el nuevo fragmento
        transaction.replace(R.id.fragment_container, fragment);

        // Confirma los cambios
        transaction.commit();
    }
}