package com.aplikasi.UASPCS

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aplikasi.UASPCS.adapter.LaporanAdapter
import com.aplikasi.UASPCS.adapter.SupplierAdapter
import com.aplikasi.UASPCS.adapter.TransaksiAdapter
import com.aplikasi.UASPCS.api.BaseRetrofit
import com.aplikasi.UASPCS.response.cart.Cart
import com.aplikasi.UASPCS.response.produk.ProdukResponse
import com.aplikasi.UASPCS.response.supplier.SupplierResponse
import com.aplikasi.UASPCS.response.transaksi.TransaksiResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.NumberFormat
import java.util.*

class SupplierFragment : Fragment() {

    private val api by lazy { BaseRetrofit().endpoint }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_supplier, container, false)
        getSupplier(view)
        return view
    }

    fun getSupplier(view: View) {
        val token = LoginActivity.sessionManager.getString("TOKEN")

        api.getSupplier(token.toString()).enqueue(object : Callback<SupplierResponse> {
            override fun onResponse(
                call: Call<SupplierResponse>,
                response: Response<SupplierResponse>
            ) {
                val rv = view.findViewById<RecyclerView>(R.id.rv_supplier)

                rv.setHasFixedSize(true)
                rv.layoutManager = LinearLayoutManager(activity)
                val rvAdapter = SupplierAdapter(response.body()!!.data.supplier)
                rv.adapter = rvAdapter
            }

            override fun onFailure(call: Call<SupplierResponse>, t: Throwable) {
                Log.e("ProdukError", t.toString())
            }

        })
    }

}