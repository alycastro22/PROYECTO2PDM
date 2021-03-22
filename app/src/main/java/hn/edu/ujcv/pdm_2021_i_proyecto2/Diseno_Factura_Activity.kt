package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_diseno_factura.*
import java.lang.StringBuilder

class Diseno_Factura_Activity : AppCompatActivity() {

    var empleados: ArrayList<String> = ArrayList()
    var pedido : ArrayList<String> = ArrayList()
    var factura : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseno_factura)
        datos()
        agregarItemPedido()
        agregarItemEmpleado()
        txvRegistrar.setOnClickListener { guardar() }
        imageRetroceder.setOnClickListener { cambioPantallaFactura() }
        enviara.setOnClickListener { enviar() }
    }

    private fun enviar() {
        val enviarFactura = Intent(this, FacturaActivityListActivity::class.java)
        startActivity(enviarFactura)
    }

    fun cambioPantallaFactura(){
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }
    fun agregarItemPedido(){
        val spinnerC : Spinner = findViewById(R.id.spinnerClientes)
        val adapterC : ArrayAdapter<String> = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, pedido)
        adapterC.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerC.adapter = adapterC
    }
    fun agregarItemEmpleado(){
        val spinnerE : Spinner = findViewById(R.id.spinnerEmpleado1)
        val adapterE : ArrayAdapter<String> = ArrayAdapter(this,
        android.R.layout.simple_spinner_item, empleados)
        adapterE.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerE.adapter = adapterE
    }

    fun guardar(){
        val dato = StringBuilder()
        dato.append(spinnerEmpleado1.selectedItem.toString().trim()).append("|")
        dato.append(spinnerClientes.selectedItem.toString().trim())
        factura.add(dato.toString())
        println(factura.toString())
        Toast.makeText(this, "Factura agregada con exito", Toast.LENGTH_LONG).show()
        enviara.visibility = View.VISIBLE
    }

    fun datos(){
        var intent = intent
        pedido = intent.getSerializableExtra("pedido") as ArrayList<String>
        empleados = intent.getSerializableExtra("empleado") as ArrayList<String>
        println("cliente pedido"+this.pedido.toString()+  "empleado pedido"+this.empleados.toString())
    }
}