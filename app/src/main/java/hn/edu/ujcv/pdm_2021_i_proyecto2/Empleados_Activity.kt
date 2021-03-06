package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_empleados_.*
import java.lang.StringBuilder

class Empleados_Activity : AppCompatActivity() {

    private val Empleado : ArrayList<String> = arrayListOf()
    var clientes : ArrayList<String> = ArrayList()
    var mesas : ArrayList<String> = ArrayList()
    var menus : ArrayList<String> = ArrayList()
    var empleados : ArrayList<String> = ArrayList()
    var valor =0
    var empleadosSel:ArrayList<String> = ArrayList()
    var clientesSel:ArrayList<String> = ArrayList()
    var pedidoSel:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empleados_)
        inicializador()
        datos()
        txvRegistrar.setOnClickListener { guardarempleado() }
        imageRetroceder.setOnClickListener{cambioPantalla()}
    }

    fun cambioPantalla(){
            valor=5
        val cambio = Intent(this, MainActivity::class.java)
            cambio.putExtra("valor", valor)
            cambio.putExtra("menu", menus)
            cambio.putExtra("cliente", clientes)
            cambio.putExtra("mesa", mesas)
            cambio.putExtra("empleado", empleados)
            cambio.putExtra("empleado_sel", empleadosSel)
            cambio.putExtra("clientes_sel", clientesSel)
            cambio.putExtra("pedido_sel", pedidoSel)


            startActivity(cambio)
    }

    private fun inicializador() {
        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,
        R.array.puestos, android.R.layout.simple_spinner_item)
        spinnerClientes.adapter = adapter
    }

    private fun guardarempleado(){
        if(txtCodigo.text.isNotEmpty() && txtNombre3.text.isNotEmpty()){
            val dato = StringBuilder()
            dato.append(txtCodigo.text.toString().trim()).append("|")
            dato.append(txtNombre3.text.toString().trim()).append("|")
            dato.append(spinnerClientes.selectedItem.toString().trim())
            Empleado.add(dato.toString())
            empleados.add(txtNombre3.text.toString())
            println(Empleado.toString() + "Datos de empleado")
            Toast.makeText(this, "Empleado registrado con exito",Toast.LENGTH_LONG).show()
        }else{
            validar()

        }
    }

    private fun validar(){
        if (txtCodigo.text.isEmpty()){
            Toast.makeText(this, "Ingrese el c??digo del empleado", Toast.LENGTH_LONG).show()
        }
        if (txtNombre3.text.isEmpty()){
            Toast.makeText(this, "Ingrese el nombre del empleado", Toast.LENGTH_LONG).show()
        }
    }
    fun datos(){
        var intent = intent
        menus = intent.getSerializableExtra("menu") as ArrayList<String>
        clientes = intent.getSerializableExtra("cliente") as ArrayList<String>
        mesas = intent.getSerializableExtra("mesa") as ArrayList<String>
        empleados = intent.getSerializableExtra("empleado") as ArrayList<String>
        empleadosSel = intent.getSerializableExtra("empleado_sel") as ArrayList<String>
        clientesSel = intent.getSerializableExtra("clientes_sel") as ArrayList<String>
        pedidoSel = intent.getSerializableExtra("pedido_sel") as ArrayList<String>
        println("Menu" + menus.toString() + "clientes" + clientes.toString() +
        "mesas"+ mesas.toString() + "empleados"+ empleados.toString()
        +"empleado selecionado"+empleadosSel.toString()+"clienteselecionado"+clientesSel.toString()+
                "pedido selecionado"+pedidoSel.toString())
    }
}