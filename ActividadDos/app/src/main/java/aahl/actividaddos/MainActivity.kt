package aahl.actividaddos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referencias a los botones usando el method "findViewById"
        val btnRelative: Button = findViewById(R.id.btnRelativeLayout)
        val btnLinear: Button = findViewById(R.id.btnLinearLayout)
        val btnTable: Button = findViewById(R.id.btnTableLayout)
        val btnGrid: Button = findViewById(R.id.btnGridLayout)

        // Configurar los clicks de forma más sencilla con lambdas
        btnRelative.setOnClickListener {
            // Un Intent en Kotlin usa la sintaxis `::class.java`
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }

        btnLinear.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        btnTable.setOnClickListener {
            val intent = Intent(this, TableLayoutActivity::class.java)
            startActivity(intent)
        }

        btnGrid.setOnClickListener {
            val intent = Intent(this, GridLayoutActivity::class.java)
            startActivity(intent)
        }
    }
}