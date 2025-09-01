package aahl.actividadtres;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnOnClick = findViewById(R.id.btnOnClick);
        Button btnOnLongClick = findViewById(R.id.btnOnLongClick);
        Button btnOnTouch = findViewById(R.id.btnOnTouch);

        EditText fieldDeTexto = findViewById(R.id.fieldDeTexto);
        EditText fieldDeTextoDos = findViewById(R.id.fieldDeTextoDos);

        TextView txtDetalle = findViewById(R.id.txtDetalle);

        btnOnClick.setOnClickListener(view -> {
            txtDetalle.setText("Evento OnClick!");
            Toast.makeText(this, "Evento onClick", Toast.LENGTH_SHORT).show();
        });

        btnOnLongClick.setOnLongClickListener(view -> {
            txtDetalle.setText("Evento OnLongClick!");
            Toast.makeText(this, "Evento onLongClick", Toast.LENGTH_SHORT).show();
            return true;
        });

        fieldDeTexto.setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                txtDetalle.setText("Evento OnFocus:Focuseado!");
                Toast.makeText(this, "Evento onFocus:Focuseado", Toast.LENGTH_SHORT).show();
            } else {
                txtDetalle.setText("Evento OnFocus:Ignorao!");
                Toast.makeText(this, "Evento onFocus:Ignorado", Toast.LENGTH_SHORT).show();
            }
        });

        fieldDeTextoDos.setOnFocusChangeListener((view, hasFocus) -> {
            if (hasFocus) {
                txtDetalle.setText("Evento OnFocus:Focuseado!");
                Toast.makeText(this, "Evento onFocus:Focuseado", Toast.LENGTH_SHORT).show();
            } else {
                txtDetalle.setText("Evento OnFocus:Ignorao!");
                Toast.makeText(this, "Evento onFocus:Ignorado", Toast.LENGTH_SHORT).show();
            }
        });

        btnOnTouch.setOnTouchListener((view, motionEvent) -> {
            if(motionEvent.getAction() == MotionEvent.ACTION_UP){
                txtDetalle.setText("Evento OnTouch:UP!");
                Toast.makeText(this, "Evento onTouch:UP", Toast.LENGTH_SHORT).show();
                return true;
            } else if (motionEvent.getAction() == MotionEvent.ACTION_DOWN){
                txtDetalle.setText("Evento OnTouch:DOWN!");
                Toast.makeText(this, "Evento onTouch:DOWN", Toast.LENGTH_SHORT).show();
                return true;
            }
            return false;
        });
    }
}