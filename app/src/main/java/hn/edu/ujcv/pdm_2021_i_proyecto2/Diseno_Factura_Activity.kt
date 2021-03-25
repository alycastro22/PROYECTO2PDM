package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import hn.edu.ujcv.pdm_2021_i_proyecto2.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_diseno_factura.*
import kotlinx.android.synthetic.main.activity_diseno_factura.imageRetroceder
import kotlinx.android.synthetic.main.activity_diseno_factura.spinnerClientes
import kotlinx.android.synthetic.main.activity_diseno_factura.txvRegistrar
import kotlinx.android.synthetic.main.activity_empleados_.*
import java.lang.StringBuilder

class Diseno_Factura_Activity : AppCompatActivity() {

    var empleados: ArrayList<String> = ArrayList()
    var pedido : ArrayList<String> = ArrayList()
    var factura : ArrayList<String> = ArrayList()
    var mesas:ArrayList<String> = ArrayList()
    var menus:ArrayList<String> = ArrayList()
    var clientes:ArrayList<String> = ArrayList()
    var empleadosSel:ArrayList<String> = ArrayList()
    var clientesSel:ArrayList<String> = ArrayList()
    var pedidoSel:ArrayList<String> = ArrayList()
    var clienteva:ArrayList<String> = ArrayList()
    var empleadova: ArrayList<String> = ArrayList()
    val valor = 5



    var dummyItem: DummyContent = DummyContent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diseno_factura)
        datos()
        agregarItemPedido()
        agregarItemEmpleado()
        agregarItemPago()
        agregarpedido()
        txvRegistrar.setOnClickListener { guardar() }
        imageRetroceder.setOnClickListener { cambioPantallaFactura() }
        enviara.setOnClickListener { enviar() }
        enviarf.setOnClickListener { enviarcorreo() }

    }

    private fun enviar() {
        val enviarFactura = Intent(this, FacturaActivityListActivity::class.java)
        dummyItem.enviarf(factura)
        startActivity(enviarFactura)
    }

    fun cambioPantallaFactura(){
        val cambio = Intent(this, MainActivity::class.java)
        cambio.putExtra("valor", valor)
        cambio.putExtra("menu", menus)
        cambio.putExtra("cliente", clientes)
        cambio.putExtra("mesa", mesas)
        cambio.putExtra("empleado", empleados)
        cambio.putExtra("empleado_sel", empleadova)
        cambio.putExtra("clientes_sel", clienteva)
        cambio.putExtra("pedido_sel", pedido)
        startActivity(cambio)
    }
    fun agregarItemPedido(){
        val spinnerC : Spinner = findViewById(R.id.spinnerClientes)
        val adapterC : ArrayAdapter<String> = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, clientesSel)
        adapterC.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerC.adapter = adapterC
    }
    fun agregarItemEmpleado(){
        val spinnerE : Spinner = findViewById(R.id.spinnerEmpleado1)
        val adapterE : ArrayAdapter<String> = ArrayAdapter(this,
        android.R.layout.simple_spinner_item, empleadosSel)
        adapterE.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerE.adapter = adapterE
    }
    fun agregarpedido(){
        val spinnerE : Spinner = findViewById(R.id.spinnerPedido)
        val adapterE : ArrayAdapter<String> = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, pedidoSel)
        adapterE.setDropDownViewResource(android.R.layout.simple_spinner_item)
        spinnerE.adapter = adapterE
    }
    private fun agregarItemPago() {
        val adapter : ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(this,
                R.array.pago, android.R.layout.simple_spinner_item)
        spinnerPago.adapter = adapter
    }

    fun guardar(){
        val dato = StringBuilder()
        dato.append(spinnerEmpleado1.selectedItem.toString().trim()).append("|")
        dato.append(spinnerPago.selectedItem.toString().trim()).append("|")
        dato.append(spinnerClientes.selectedItem.toString().trim()).append("|")
        dato.append(txttotalPagar.text.toString().trim())
        factura.add(dato.toString())
        println(factura.toString())
        Toast.makeText(this, "Factura agregada con exito", Toast.LENGTH_LONG).show()
        enviara.visibility = View.VISIBLE

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Enviar factura por Correo")
        builder.setMessage("¿Desea enviar factura por correo?")
        builder.setPositiveButton("Enviar", { dialogInterface: DialogInterface, i: Int ->
            txtcorreo.visibility = View.VISIBLE
            enviarf.visibility = View.VISIBLE

        })
        builder.setNegativeButton("No enviar", { dialogInterface: DialogInterface, i: Int ->
            Toast.makeText(this, "Factura agregada con exito", Toast.LENGTH_LONG)
        })
        builder.show()


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
        println("cliente pedido"+this.pedido.toString()+  "empleado pedido"+this.empleados.toString())
    }

    fun enviarcorreo(){

        var to = arrayOf(txtcorreo.text.toString(), "aramel08ramos@gmail.com", "nahomi.martinez@ujcv.edu.hn", "stephany.carbajal1@ujcv.edu.hn", "allisson.castro@ujcv.edu.hn")
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_EMAIL, to)
        intent.putExtra(Intent.EXTRA_SUBJECT, "FACTURA SAZÓN CATRACHO")
        intent.putExtra(Intent.EXTRA_TEXT,  "factura N1" + "\ncliente:" + "\n"+spinnerClientes.selectedItem.toString()+ "\n Orden:" + this.pedidoSel + "\n tipo de pago:" +  spinnerPago.selectedItem.toString() + "\n total:" +  txttotalPagar.text.toString() +
                "\n generada por:" + spinnerEmpleado1.selectedItem.toString())

        intent.setType("message/rfc822")
        startActivity(Intent.createChooser(intent, "Email"))
    }
}