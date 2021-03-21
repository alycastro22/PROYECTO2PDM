package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Diseno_Factura_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseno_factura)
    }
    fun cambioPantalla(view: View){
        val cambio = Intent(this, MainActivity::class.java)
        startActivity(cambio)
    }
}