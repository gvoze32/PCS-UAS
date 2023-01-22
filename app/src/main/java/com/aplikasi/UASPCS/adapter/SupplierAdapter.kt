package com.aplikasi.UASPCS.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.UASPCS.R
import com.aplikasi.UASPCS.response.supplier.Supplier
import java.text.NumberFormat
import java.util.*

class SupplierAdapter(val ListSupplier: List<Supplier>): RecyclerView.Adapter<SupplierAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_supplier, parent, false)
        return SupplierAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val supplier = ListSupplier[position]

        holder.nomorid.text = "#"+supplier.id.toString()
        holder.namaSupplier.text = supplier.namasupplier
    }

    override fun getItemCount(): Int {
        return ListSupplier.size
    }

    class  ViewHolder(itemView : View): RecyclerView.ViewHolder(itemView) {
        val nomorid = itemView.findViewById<TextView>(R.id.nomorid)
        val namaSupplier = itemView.findViewById<TextView>(R.id.namaSupplier) }
}