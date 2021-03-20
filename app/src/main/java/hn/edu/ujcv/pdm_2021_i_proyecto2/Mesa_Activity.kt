package hn.edu.ujcv.pdm_2021_i_proyecto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mesa_.*

class Mesa_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesa_)
    }
    fun validar(){
        if(txtCodigo.text.isEmpty()){
            Toast.makeText(this, "Ingrese el código de la mesa", Toast.LENGTH_LONG).show()
        }
        if (txtDescripcion.text.isEmpty()){
            Toast.makeText(this, "Ingrese la descripción de la mesa", Toast.LENGTH_LONG).show()
        }
    }
}