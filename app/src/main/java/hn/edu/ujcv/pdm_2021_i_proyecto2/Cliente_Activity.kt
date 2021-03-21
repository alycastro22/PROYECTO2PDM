package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cliente_.*
import java.lang.StringBuilder

class Cliente_Activity : AppCompatActivity() {

    var valores : HashMap<Int,String> = hashMapOf()
    var  numero = 0
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

    fun guardaralumno(){
        if (txtId.text.isNotEmpty() && txtNombre.text.isNotEmpty() && txtCorreo.text.isNotEmpty()){
            val dato = StringBuilder()
            numero + 1
            dato.append(txtId.text.toString().trim()).append("|")
            dato.append(txtNombre.text.toString().trim()).append("|")
            dato.append(txtCorreo.text.toString())
            valores.put(numero, dato.toString())

        }

    }
    fun cambioPantalla(view: View){
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }
}