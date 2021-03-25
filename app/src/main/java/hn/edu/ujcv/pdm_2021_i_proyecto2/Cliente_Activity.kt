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
    var enviar = 0
    var nombres: ArrayList<String> = ArrayList()
    var mesas:ArrayList<String> = ArrayList()
    var menus:ArrayList<String> = ArrayList()
    var empleados:ArrayList<String> = ArrayList()
    var empleadosSel:ArrayList<String> = ArrayList()
    var clientesSel:ArrayList<String> = ArrayList()
    var pedidoSel:ArrayList<String> = ArrayList()

    private var adapter: RecyclerAdapter = RecyclerAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente_)
        txvBottom.setOnClickListener { guardaralumno() }
       imageRetroceder.setOnClickListener { enviardatos() }
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
            nombres.add(txtNombre.text.toString())
            Toast.makeText(this, "Cliente registrado con exito", Toast.LENGTH_LONG).show()
            println("nombres"+ this.nombres.toString())

        }else{
            validaciones()
        }

    }
    fun enviardatos(){
        val intent = Intent (this, MainActivity::class.java)
        enviar = 1
        //adapter.datos(valores)
        intent.putExtra("valor", enviar)
        intent.putExtra("valorescliente", nombres)

        startActivity(intent)
        println("ALUMNO activity"+ this.nombres.toString())
        println("ALUMNO enviando"+ this.enviar.toString())

    }

    fun datos(){
        var intent = intent
        menus = intent.getSerializableExtra("menu") as ArrayList<String>
        nombres = intent.getSerializableExtra("cliente") as ArrayList<String>
        mesas = intent.getSerializableExtra("mesa") as ArrayList<String>
        empleados = intent.getSerializableExtra("empleado") as ArrayList<String>
        empleadosSel = intent.getSerializableExtra("empelado_sel") as ArrayList<String>
        clientesSel = intent.getSerializableExtra("clientes_sel") as ArrayList<String>
        pedidoSel = intent.getSerializableExtra("pedido_sel") as ArrayList<String>
        println("Menu" + menus.toString() + "clientes" + nombres.toString() +
                "mesas"+ mesas.toString() + "empleados"+ empleados.toString()
                +"empleado selecionado"+empleadosSel.toString()+"clienteselecionado"+clientesSel.toString()+
                "pedido selecionado"+pedidoSel.toString())
    }

}