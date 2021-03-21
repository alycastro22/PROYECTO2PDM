package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_pedido_.*

class Pedido_Activity : AppCompatActivity() {
    var valores :  ArrayList<String> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pedido_)
        imageRetroceder.setOnClickListener { cambioPantalla() }
        datos()
    }


    fun cambioPantalla() {
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }

    fun datos(){
        var intent = intent
        valores= intent.getSerializableExtra("cliente") as ArrayList<String>
        println("cliente pedido"+this.valores.toString())
    }



}