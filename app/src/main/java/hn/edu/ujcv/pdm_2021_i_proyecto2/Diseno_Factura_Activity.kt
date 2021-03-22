package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Diseno_Factura_Activity : AppCompatActivity() {

    var clientes: ArrayList<String> = ArrayList()
    var menu: ArrayList<String> = ArrayList()
    var mesa: ArrayList<String> = ArrayList()
    var empleados: ArrayList<String> = ArrayList()
    var pedido : ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseno_factura)
        datos()
    }
    fun cambioPantalla(view: View){
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }

    fun datos(){
        var intent = intent

        pedido = intent.getSerializableExtra("pedido") as ArrayList<String>
        empleados = intent.getSerializableExtra("empleado") as ArrayList<String>
        println("cliente pedido"+this.pedido.toString()+  "empleado pedido"+this.empleados.toString())
    }
}