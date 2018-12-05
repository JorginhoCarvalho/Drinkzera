package com.example.jorge.drinkzera

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalhes_bebida.*

class detalhes_bebidaActivity : AppCompatActivity() {

    companion object {
        public const val BEBIDA: String = "Bebida" //para putExtra entre activities

    }

    var bebida: Bebida? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes_bebida)

        bebida = intent.getSerializableExtra(BEBIDA) as Bebida?
        if(bebida != null){
            carregaDados()
        }
    }

    private fun carregaDados() {
        tvNome.text = bebida?.strDrink
        if(bebida?.strIngredient1 != null)
            tvIngredientes1.text = bebida?.strMeasure1 + " " + bebida?.strIngredient1
        if(bebida?.strIngredient2 != null)
            tvIngredientes2.text = bebida?.strMeasure2 + " " + bebida?.strIngredient2
        if(bebida?.strIngredient3 != null)
            tvIngredientes3.text = bebida?.strMeasure3 + " " + bebida?.strIngredient3
        if(bebida?.strIngredient4 != null)
            tvIngredientes4.text = bebida?.strMeasure4 + " " + bebida?.strIngredient4

        tvPreparo.text = bebida?.strInstructions

        GlideApp.with(this)
                .load(bebida?.strDrinkThumb)
                .placeholder(R.drawable.baseline_local_bar_black_18)
                .centerCrop()
                .into(imgFoto)
    }

}
