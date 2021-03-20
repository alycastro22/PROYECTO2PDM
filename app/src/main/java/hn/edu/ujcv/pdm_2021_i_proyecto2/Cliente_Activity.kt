package hn.edu.ujcv.pdm_2021_i_proyecto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cliente_.*

class Cliente_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_)
    }

    fun validaciones(){
        if(txtId.text.isEmpty()){
            Toast.makeText(this, "Ingrese el ID del cliente", Toast.LENGTH_LONG).show()
        }
        if (txtNombre.text.isEmpty()){
            Toast.makeText(this, "Ingrese el nombre del cliente", Toast.LENGTH_LONG).show()
        }
        if (txtCorreo.text.isEmpty()){
            Toast.makeText(this, "Ingrese el correo del cliente", Toast.LENGTH_LONG).show()
        }
    }
}