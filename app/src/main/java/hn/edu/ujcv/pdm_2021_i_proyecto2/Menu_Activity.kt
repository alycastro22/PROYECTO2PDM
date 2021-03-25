package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu_.*
import java.lang.StringBuilder

class Menu_Activity : AppCompatActivity() {
    private var Menu : ArrayList<String> = ArrayList()
    var valor =0

    var platillos:ArrayList<String> = ArrayList()
    var valores:ArrayList<String> = ArrayList()
    var clientes:ArrayList<String> = ArrayList()
    var empleados:ArrayList<String> = ArrayList()
    var mesas: ArrayList<String> = ArrayList()
    var empleadosSel:ArrayList<String> = ArrayList()
    var clientesSel:ArrayList<String> = ArrayList()
    var pedidoSel:ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_)
        datos()
        txvRegistrar.setOnClickListener{ guardarMenu() }
    }
    private fun guardarMenu(){
        if(txtCodigo.text.isNotEmpty() && txtNombre3.text.isNotEmpty() && txtPrecio.text.isNotEmpty() && txtDescripcion.text.isNotEmpty()){
            val dato = StringBuilder()
            dato.append(txtCodigo.text.toString().trim()).append("|")
            dato.append(txtNombre3.text.toString().trim()).append("|")
            dato.append(txtPrecio.text.toString().trim()).append("|")
            dato.append(txtDescripcion.text.toString())
            Menu.add(dato.toString())
            platillos.add(txtNombre3.text.toString())
            Toast.makeText(this,"Plato guardado con exito", Toast.LENGTH_LONG).show()
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
    fun datos(){
        var intent = intent
        platillos = intent.getSerializableExtra("menu") as ArrayList<String>
        clientes = intent.getSerializableExtra("cliente") as ArrayList<String>
        mesas = intent.getSerializableExtra("mesa") as ArrayList<String>
        empleados = intent.getSerializableExtra("empleado") as ArrayList<String>
        empleadosSel = intent.getSerializableExtra("empleado_sel") as ArrayList<String>
        clientesSel = intent.getSerializableExtra("clientes_sel") as ArrayList<String>
        pedidoSel = intent.getSerializableExtra("pedido_sel") as ArrayList<String>
        println("Menu" + platillos.toString() + "clientes" + clientes.toString() +
                "mesas"+ mesas.toString() + "empleados"+ empleados.toString()
                +"empleado selecionado"+empleadosSel.toString()+"clienteselecionado"+clientesSel.toString()+
                "pedido selecionado"+pedidoSel.toString())
    }
    fun cambioPantalla(view: View){
        valor=5
        val cambio = Intent(this, MainActivity::class.java)
        cambio.putExtra("valor", valor)
        cambio.putExtra("menu", platillos)
        cambio.putExtra("cliente", clientes)
        cambio.putExtra("mesa", mesas)
        cambio.putExtra("empleado", empleados)
        cambio.putExtra("empleado_sel", empleadosSel)
        cambio.putExtra("clientes_sel", clientesSel)
        cambio.putExtra("pedido_sel", pedidoSel)

        startActivity(cambio)
    }
}