package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_empleados_.*
import kotlinx.android.synthetic.main.activity_pedido_.*
import kotlinx.android.synthetic.main.activity_pedido_.imageRetroceder
import kotlinx.android.synthetic.main.activity_pedido_.spinnerClientes
import java.lang.StringBuilder

class Pedido_Activity : AppCompatActivity() {
    var clientes:ArrayList<String> = ArrayList()
    var mesas:ArrayList<String> = ArrayList()
    var menus:ArrayList<String> = ArrayList()
    var empleados:ArrayList<String> = ArrayList()
    var pedido:ArrayList<String> = ArrayList()
    var valor =0
    var empleadosSel:ArrayList<String> = ArrayList()
    var clientesSel:ArrayList<String> = ArrayList()
    var pedidoSel:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido_)
        datos()
        agregarItemsClientes()
        agregarItemsEmpleado()
        agregarItemsMenu()
        imageRetroceder.setOnClickListener { cambioPantalla() }
        txvRegistrarP.setOnClickListener { guardarpedido() }

       // iniciabilizador()
    }

    fun agregarItemsClientes(){
        val spinner : Spinner = findViewById(R.id.spinnerClientes)
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,
        android.R.layout.simple_spinner_item, clientes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter
    }
    fun agregarItemsEmpleado(){
        val spinner : Spinner = findViewById(R.id.spinnerEmpleado1)
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, empleados)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter
    }
    fun agregarItemsMenu(){
        val spinner : Spinner = findViewById(R.id.spinnerVariosMenus)
        val adapter : ArrayAdapter<String> = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, menus)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinner.adapter = adapter
    }
    fun guardarpedido(){

        val dato = StringBuilder()
        dato.append(spinnerClientes.selectedItem.toString().trim()).append("|")
        dato.append(spinnerVariosMenus.selectedItem.toString().trim()).append("|")
        dato.append(spinnerEmpleado1.selectedItem.toString().trim())
        pedido.add(dato.toString())
        println(pedido.toString() + "Datos de pedido")
        Toast.makeText(this, "Pedido registrado con exito", Toast.LENGTH_LONG).show()

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
        empleadosSel = intent.getSerializableExtra("empelado_sel") as ArrayList<String>
        clientesSel = intent.getSerializableExtra("clientes_sel") as ArrayList<String>
        pedidoSel = intent.getSerializableExtra("pedido_sel") as ArrayList<String>
        println("Menu" + menus.toString() + "clientes" + clientes.toString() +
                "mesas"+ mesas.toString() + "empleados"+ empleados.toString()
                +"empleado selecionado"+empleadosSel.toString()+"clienteselecionado"+clientesSel.toString()+
                "pedido selecionado"+pedidoSel.toString())
    }



}