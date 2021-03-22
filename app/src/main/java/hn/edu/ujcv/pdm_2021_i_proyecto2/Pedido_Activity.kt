package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_pedido_.*

class Pedido_Activity : AppCompatActivity() {
    var clientes:ArrayList<String> = ArrayList()
    var mesas:ArrayList<String> = ArrayList()
    var menus:ArrayList<String> = ArrayList()
    var empleados:ArrayList<String> = ArrayList()
    var pedido:ArrayList<String> = ArrayList()
    var valor =0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido_)
        datos()
        imageRetroceder.setOnClickListener { cambioPantalla() }
        agregarItemsClientes()
       // iniciabilizador()
    }

    fun agregarItemsClientes(){
        val spinner : Spinner = findViewById(R.id.spinnerClientes)
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,
        android.R.layout.simple_spinner_item, clientes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter
    }
    fun guardarpedido(){

    }
    fun cambioPantalla() {
        valor=5
        val cambio = Intent(this, MainActivity::class.java)
        cambio.putExtra("valor", valor)
        cambio.putExtra("plato", menus)
        cambio.putExtra("cliente", clientes)
        cambio.putExtra("empleado", empleados)
        cambio.putExtra("pedido", pedido)
        startActivity(cambio)
    }

    fun datos(){
        var intent = intent
        menus = intent.getSerializableExtra("menu") as ArrayList<String>
        clientes= intent.getSerializableExtra("cliente") as ArrayList<String>
        mesas = intent.getSerializableExtra("mesa") as ArrayList<String>
        empleados = intent.getSerializableExtra("empleado") as ArrayList<String>
        println("cliente pedido"+this.clientes.toString()+ "menu pedido"+this.menus.toString() + "empleado pedido"+this.empleados.toString())
    }



}