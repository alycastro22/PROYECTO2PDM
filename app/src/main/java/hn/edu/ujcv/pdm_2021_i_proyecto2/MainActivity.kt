package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.activity_main.*
import android.graphics.Color
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerAdapter = RecyclerAdapter()
    var valores : HashMap<Int,String> = hashMapOf()
    var nombres: ArrayList<String> = ArrayList()
    var platos: ArrayList<String> = ArrayList()
    var empleado : ArrayList<String> = ArrayList()
    var mesas : ArrayList<String> = ArrayList()
    var pedido : ArrayList<String> = ArrayList()


    var valor =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar2))

        collapsing_toolbar.title = "COMIDA HONDUREÑA"
        collapsing_toolbar.setContentScrimColor(Color.BLUE)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter
        println("ALUMNO adapter"+ this.valor.toString())
        val bundle = intent.extras
        var obtener =  bundle?.get("valor")
        println("Obtenido"+ obtener.toString())


        if (obtener==1){
            cliente()
        } else if (obtener==2) {
            menuc()
        }else if(obtener == 3){
            mesac()
        }else if(obtener == 4){
            empleadoc()
        }else if (obtener == 5){
            pedidoc()
        }

    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)


        }
    }
    fun cliente(){
        //valores.put(1,"hola")
        var intent   = intent
        nombres= intent.getSerializableExtra("valorescliente") as ArrayList<String>
        println("cliente obtener"+ this.valores.toString())

        adapter.datos(nombres)
    }
    fun menuc(){
        var intent   = intent
        nombres= intent.getSerializableExtra("cliente") as ArrayList<String>
        platos= intent.getSerializableExtra("plato") as ArrayList<String>
        println("Menu obtener"+ this.valores.toString())

        adapter.menu(nombres, platos)

    }
    fun mesac() {
        var intent = intent
        nombres= intent.getSerializableExtra("cliente") as ArrayList<String>
        platos= intent.getSerializableExtra("plato") as ArrayList<String>
        mesas = intent.getSerializableExtra("mesa") as ArrayList<String>
        println("Mesa obtner"+this.nombres.toString() + mesas.toString() + platos.toString())
        adapter.mesai(nombres, platos,mesas)
    }

     fun empleadoc() {
        var intent = intent
         nombres= intent.getSerializableExtra("cliente") as ArrayList<String>
         platos= intent.getSerializableExtra("plato") as ArrayList<String>
         mesas = intent.getSerializableExtra("mesa") as ArrayList<String>
         empleado = intent.getSerializableExtra("empleado") as ArrayList<String>
         println("Empleados obtner"+this.valores.toString())
         adapter.empleados(nombres, platos,mesas,empleado)
    }
    fun pedidoc(){
        var intent = intent
        nombres= intent.getSerializableExtra("cliente") as ArrayList<String>
        platos= intent.getSerializableExtra("plato") as ArrayList<String>
        mesas = intent.getSerializableExtra("mesa") as ArrayList<String>
        empleado = intent.getSerializableExtra("empleado") as ArrayList<String>
        pedido = intent.getSerializableExtra("pedido") as ArrayList<String>
        println("Pedido obtner"+this.valores.toString())
        adapter.pedido(nombres, platos,mesas,empleado, pedido)
    }
}