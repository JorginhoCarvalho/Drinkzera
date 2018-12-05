package com.example.jorge.drinkzera

import android.content.Context
import kotlinx.android.synthetic.main.bebida_item_lista.view.*
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.request.RequestOptions

class BebidaAdapter(val context: Context, val bebidas: List<Bebida>)
    : RecyclerView.Adapter<BebidaAdapter.ViewHolder>() {

    var clickListener: ((index: Int) -> Unit)? = null

    fun setOnItemClickListener(clique: ((index: Int) -> Unit)){
        this.clickListener = clique
    }

    //método responsável por inflar as views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.bebida_item_lista, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return bebidas.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(context, bebidas[position], clickListener)
    }

    //referência para a view de cada item da lista
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(context: Context, bebida: Bebida, clickListener: ((index: Int) -> Unit)?) {
            itemView.tvNome.text = bebida.strDrink

            val thumbnail = GlideApp.with(context)
                    .load(R.drawable.baseline_local_bar_black_18)
                    .apply(RequestOptions().circleCrop())

            GlideApp.with(context)
                    .load(bebida.strDrinkThumb)
                    .thumbnail(thumbnail)
                    .centerCrop()
                    .apply(RequestOptions().circleCrop())
                    .into(itemView.imgFoto)



            if (clickListener != null) {
                itemView.setOnClickListener {
                    clickListener.invoke(adapterPosition)
                }
            }

        }

    }
}