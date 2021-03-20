package hn.edu.ujcv.pdm_2021_i_proyecto2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_empleados_.*

class Empleados_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleados_)
    }
    fun validar(){
        if (txtCodigo.text.isEmpty()){
            Toast.makeText(this, "Ingrese el código del empleado", Toast.LENGTH_LONG).show()
        }
        if (txtNombre3.text.isEmpty()){
            Toast.makeText(this, "Ingrese el nombre del empleado", Toast.LENGTH_LONG).show()
        }

    }
}