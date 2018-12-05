package com.example.jorge.drinkzera

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ProgressBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detalhes_bebida.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
    }

    override fun showList(bebidas: List<Bebida>) {

        val adapter = BebidaAdapter(this, bebidas)
        adapter.setOnItemClickListener {index ->
            val detalhes = Intent(this, detalhes_bebidaActivity::class.java)
            detalhes.putExtra(detalhes_bebidaActivity.BEBIDA, bebidas[index])
            startActivity(detalhes)
        }

        rvBebidas.adapter = adapter
        rvBebidas.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val presenter: MainContract.Presenter = MainPresenter(this)
        presenter.onLoadList(this)
    }

    override fun showLoading() {
        pbLoad.visibility = ProgressBar.VISIBLE
    }

    override fun hideLoading() {
        pbLoad.visibility = ProgressBar.INVISIBLE
    }
}
