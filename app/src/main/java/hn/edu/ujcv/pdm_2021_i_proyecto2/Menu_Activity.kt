package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu_.*
import java.lang.StringBuilder

class Menu_Activity : AppCompatActivity() {
    private var Menu : HashMap<Int,String> = hashMapOf()
    private var numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_)
        txvRegistrar.setOnClickListener{ guardarMenu() }
    }
    private fun guardarMenu(){
        if(txtCodigo.text.isNotEmpty() && txtNombre3.text.isNotEmpty() && txtPrecio.text.isNotEmpty() && txtDescripcion.text.isNotEmpty()){
            val dato = StringBuilder()
            numero+1
            dato.append(txtCodigo.text.toString().trim()).append("|")
            dato.append(txtNombre3.text.toString().trim()).append("|")
            dato.append(txtPrecio.text.toString().trim()).append("|")
            dato.append(txtDescripcion.text.toString())
            Menu.put(numero,dato.toString())
            println(Menu.toMap())
            Toast.makeText(this,"Pato guardado con exito", Toast.LENGTH_LONG).show()
        }else{
            validar()
        }
    }
    private fun validar(){
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
    fun cambioPantalla(view: View){
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }
}