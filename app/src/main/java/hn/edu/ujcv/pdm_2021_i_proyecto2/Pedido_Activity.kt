package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Pedido_Activity : AppCompatActivity() {
    var valores : HashMap<Int,String> = hashMapOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido_)
        datos()
    }


    fun cambioPantalla(view: View) {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }

    fun datos(){
        var intent = intent
        valores= intent.getSerializableExtra("cliente") as HashMap<Int, String>
        println("cliente pedido"+this.valores.toString())
    }



}