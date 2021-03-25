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
    var clientes:ArrayList<String> = ArrayList()
    var mesas:ArrayList<String> = ArrayList()
    var menus:ArrayList<String> = ArrayList()
    var empleados:ArrayList<String> = ArrayList()
    var valor =0
    var empleadosSel:ArrayList<String> = ArrayList()
    var clientesSel:ArrayList<String> = ArrayList()
    var pedidoSel:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mesa_)
        txvRegistrar.setOnClickListener { guardarMesa() }
        datos()
    }
    private fun guardarMesa(){
        if (txtCodigo.text.isNotEmpty() && txtDescripcion.text.isNotEmpty()){
            val dato = StringBuilder()
            numero+1
            dato.append(txtCodigo.text.toString().trim()).append("|")
            dato.append(txtDescripcion.text.toString().trim())
            Mesa.put(numero, dato.toString())
            println(Mesa.toMap())
            mesas.add(txtCodigo.text.toString())
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
        valor = 5
        cambio.putExtra("valor", valor)
        cambio.putExtra("menu", menus)
        cambio.putExtra("cliente", clientes)
        cambio.putExtra("mesa", mesas)
        cambio.putExtra("empleado", empleados)
        cambio.putExtra("empleado_sel", empleadosSel)
        cambio.putExtra("clientes_sel", clientesSel)
        cambio.putExtra("pedido_sel", pedidoSel)
        println("cliente + menu + mesa"+ clientes.toString() + menus.toString() + mesas.toString())
        startActivity(cambio)
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