package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.content.Intent
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView

import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.adapter.FragmentViewHolder

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    var data: HashMap<Int, String> =  hashMapOf()

    fun datos (clientes: HashMap<Int, String>) {
        this.data = clientes
        println("Recycler dato"+ data.toString())
    }

    private val titles = arrayOf("Clientes",
        "Menu", "Mesa", "Empleados",
        "Pedido", "Factura")

    private val details = arrayOf("Registrar Clientes", "Registrar Menu",
        "Registrar Mesa", "Registrar Empleado",
        "Registrar Pedido", "Realizar Factura")

    private val images = intArrayOf(R.drawable.cliente,
        R.drawable.menu, R.drawable.mesa1,
        R.drawable.empleados1, R.drawable.pedidos,
        R.drawable.factura2)

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cardview_layout, viewGroup, false)
        return ViewHolder(v)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
       

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_tittle)
            itemDetail = itemView.findViewById(R.id.item_details)

            itemView.setOnClickListener { v: View? ->
                var position: Int = adapterPosition
                //Toast.makeText(itemView.context, "Seleccionaste el item #${position}", Toast.LENGTH_LONG).show()
                when (position){
                    0 -> { IrAClientes(itemView)}
                    1 -> { IrAMenu(itemView)}
                    2 -> { IrAMesa(itemView)}
                    3 -> { IrAEmpleado(itemView)}
                    4 -> { IrAPedido(itemView)}
                    5 -> { IrAFactura(itemView)}

                    /**2 -> return MenuFragment()
                    3 -> return MesaFragment()
                    4 -> return PedidoFragment()**/

                    else -> return@setOnClickListener

                }
                    /*Snackbar.make(v, "Click en item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()*/

            }
        }
    }

    private fun IrAFactura(itemView: View) {
        val intent = Intent(itemView.context, Diseno_Factura_Activity::class.java)
        startActivity(itemView.context, intent, null)
    }

    private fun IrAPedido(itemView: View) {
        val intent = Intent(itemView.context, Pedido_Activity::class.java)
        intent.putExtra("cliente", data)
        startActivity(itemView.context, intent, null)
    }

    private fun IrAEmpleado(itemView: View) {
        val intent = Intent(itemView.context, Empleados_Activity::class.java)
        startActivity(itemView.context, intent, null)

    }

    private fun IrAMesa(itemView: View) {
        val intent = Intent(itemView.context, Mesa_Activity::class.java)
        startActivity(itemView.context, intent, null)
    }

    private fun IrAMenu(itemView: View) {
        val intent = Intent(itemView.context, Menu_Activity::class.java)
        startActivity(itemView.context, intent, null)
    }

    private fun IrAClientes(itemView: View) {
        val intent = Intent(itemView.context, Cliente_Activity::class.java)
        startActivity(itemView.context, intent,null)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
    }

    override fun getItemCount(): Int {
        return titles.size
    }

}

