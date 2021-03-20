package hn.edu.ujcv.pdm_2021_i_proyecto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu_.*

class Menu_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_)
    }
    fun validar(){
        if (txtCodigo.text.isEmpty()){
            Toast.makeText(this, "Ingrese el código del platillo", Toast.LENGTH_LONG).show()
        }
        if (txtNombre3.text.isEmpty()){
            Toast.makeText(this, "Ingrese el nombre del platillo", Toast.LENGTH_LONG).show()
        }
        if (txtPrecio.text.isEmpty()){
            Toast.makeText(this, "Ingrese el precio del platillo", Toast.LENGTH_LONG).show()
        }
        if (txtDescripcion.text.isEmpty()){
            Toast.makeText(this, "Ingrese la descripción del platillo", Toast.LENGTH_LONG).show()
        }
    }
}