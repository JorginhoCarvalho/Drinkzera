package com.example.jorge.drinkzera

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainPresenter(val view: MainContract.View): MainContract.Presenter {

    override fun onLoadList(context: Context){

        val bebidaService = RetrofitInicializer().createBebidaService()

        val call = bebidaService.getTodasBebidas()

        call.enqueue(object: Callback<BebidasList>{

            override fun onFailure(call: Call<BebidasList>?, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet.")
            }

            override fun onResponse(call: Call<BebidasList>?, response: Response<BebidasList>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showList(response.body()!!.bebidas)
                }else{
                    view.showMessage("Bar fechado.")
                }
            }
        })

    }

    override fun onGetByID(context: Context, id: String){

        view.showLoading()

        val bebidaService = RetrofitInicializer().createBebidaService()
        val call = bebidaService.getBebidaID(id)

        call.enqueue(object : Callback<Bebida> {
            override fun onFailure(call: Call<Bebida>, t: Throwable) {
                view.hideLoading()
                view.showMessage("Falha na conexão. Verifique o acesso a internet")
            }

            override fun onResponse(call: Call<Bebida>, response: Response<Bebida>) {
                view.hideLoading()
                if(response.body() != null){
                    view.showBebida(response.body()!!.copy())
                }else {
                    view.showMessage("Não foi encontrado")
                }
            }
        })

    }
}