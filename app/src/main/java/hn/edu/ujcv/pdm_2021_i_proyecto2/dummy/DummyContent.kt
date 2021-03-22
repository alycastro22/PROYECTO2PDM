package hn.edu.ujcv.pdm_2021_i_proyecto2.dummy

import android.widget.Toast
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object DummyContent {

    /**
     * An array of sample (dummy) items.
     */
    val ITEMS: MutableList<DummyItem> = ArrayList()

    /**
     * A map of sample (dummy) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, DummyItem> = HashMap()

    private val COUNT = 25
    var factura : ArrayList<String> = ArrayList()
    fun enviarf (factura: ArrayList<String>) {
        this.factura = factura
        println("Factura"+ factura.toString())

    }

    init {
        enviarf(factura)
        addItem(DummyItem("1", "Factura", factura.toString()))

    }

    private fun addItem(item: DummyItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }


    /**
     * A dummy item representing a piece of content.
     */
    data class DummyItem(val id: String, val content: String, var details: String) {
        override fun toString(): String = details
    }
}