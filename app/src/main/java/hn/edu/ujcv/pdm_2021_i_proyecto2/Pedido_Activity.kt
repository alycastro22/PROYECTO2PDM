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
       // iniciabilizador()
    }

    fun iniciabilizador(){
        val spinnerC : Spinner = spinnerClientes
        val spinnerM : Spinner = spinnerVariosMenus
        val spinnerE : Spinner = spinnerEmpleado1

        val adapterCliente : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, clientes.size, android.R.layout.simple_spinner_item)
        spinnerC.adapter = adapterCliente

        val adapterMenu : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this, menus.size, android.R.layout.simple_spinner_item)
        spinnerM.adapter = adapterMenu


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