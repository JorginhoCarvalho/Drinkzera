package com.example.jorge.drinkzera

import android.content.Context

interface MainContract {

    interface View{
        fun showMessage(msg: String)
        fun showList(bebidas: List<Bebida>)
        fun showBebida(bebida: Bebida)
        fun showLoading()
        fun hideLoading()


    }

    interface Presenter{
        fun onLoadList(context: Context)
        fun onGetByID(context: Context, id: String)
    }
}