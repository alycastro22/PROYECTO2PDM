package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_empleados_.*
import java.lang.StringBuilder

class Empleados_Activity : AppCompatActivity() {

    private val Empleado : ArrayList<String> = arrayListOf()
    var valores:ArrayList<String> = ArrayList()
    var valor =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleados_)
        inicializador()
        txvRegistrar.setOnClickListener { guardarempleado() }
    }

    fun cambioPantallaEmpleados(view: View){
            valor=2
            val cambio = Intent(this, MainActivity::class.java)
            cambio.putExtra("valor", valor)
            cambio.putExtra("cliente", valores)
            startActivity(cambio)
    }

    private fun inicializador() {
        val spinner : Spinner = spinnerPuesto
        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,
        R.array.puestos, android.R.layout.simple_spinner_item)
        spinner.adapter = adapter
    }

    private fun guardarempleado(){
        if(txtCodigo.text.isNotEmpty() && txtNombre3.text.isNotEmpty()){
            val dato = StringBuilder()
            dato.append(txtCodigo.text.toString().trim()).append("|")
            dato.append(txtNombre3.text.toString().trim())
            Empleado.add(dato.toString())
            Toast.makeText(this, "Empleado registrado con exito",Toast.LENGTH_LONG).show()
        }else{
            validar()
        }
    }

    private fun validar(){
        if (txtCodigo.text.isEmpty()){
            Toast.makeText(this, "Ingrese el código del empleado", Toast.LENGTH_LONG).show()
        }
        if (txtNombre3.text.isEmpty()){
            Toast.makeText(this, "Ingrese el nombre del empleado", Toast.LENGTH_LONG).show()
        }
    }
    fun datos(){
        var intent = intent
        valores= intent.getSerializableExtra("empleado") as ArrayList<String>
        println("cliente pedido"+this.valores.toString())
    }
}