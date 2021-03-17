package hn.edu.ujcv.pdm_2021_i_proyecto2

import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val titles = arrayOf("Registrar Cliente",
        "Menu", "Registrar Mesa", "Empleado",
        "Realizar Pedido", "Realizar Factura")

    private val details = arrayOf("Item detalle 1", "Item detalle 2",
        "Item detalle 3", "Item detalle 4",
        "Item detalle 5", "Item detalle 6")

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

            /*itemView.setOnClickListener { v: View  ->
                var position: Int = getItemViewType()

                when (position){
                    0 -> return ClientesFragment()
                    1 -> return EmpleadosFragment()
                    2 -> return MenuFragment()
                    3 -> return MesaFragment()
                    4 -> return PedidoFragment()

                    else -> return@setOnClickListener.

                }

              /*  Snackbar.make(v, "Click en item $position",
                    Snackbar.LENGTH_LONG).setAction("Action", null).show()*/



            }*/
        }
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

