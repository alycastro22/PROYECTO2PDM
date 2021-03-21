package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_mesa_.*
import java.lang.StringBuilder

class Mesa_Activity : AppCompatActivity() {
    private val Mesa : HashMap<Int, String> = hashMapOf()
    private var numero = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesa_)
        txvRegistrar.setOnClickListener { guardarMesa() }
    }
    private fun guardarMesa(){
        if (txtCodigo.text.isNotEmpty() && txtDescripcion.text.isNotEmpty()){
            val dato = StringBuilder()
            numero+1
            dato.append(txtCodigo.text.toString().trim()).append("|")
            dato.append(txtDescripcion.text.toString().trim())
            Mesa.put(numero, dato.toString())
            println(Mesa.toMap())
            Toast.makeText(this,"Mesa guardada con exito",Toast.LENGTH_LONG).show()
        }else{
            validar()
        }
    }
    fun validar(){
        if(txtCodigo.text.isEmpty()){
            Toast.makeText(this, "Ingrese el código de la mesa", Toast.LENGTH_LONG).show()
        }
        if (txtDescripcion.text.isEmpty()){
            Toast.makeText(this, "Ingrese la descripción de la mesa", Toast.LENGTH_LONG).show()
        }
    }
    fun cambioPantalla(view: View){
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }
}