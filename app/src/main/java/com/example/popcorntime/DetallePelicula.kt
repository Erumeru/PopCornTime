package com.example.popcorntime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detalle_pelicula.buy_tickets
import kotlinx.android.synthetic.main.activity_detalle_pelicula.iv_pelicula_imagen
import kotlinx.android.synthetic.main.activity_detalle_pelicula.seatsLeft
import kotlinx.android.synthetic.main.activity_detalle_pelicula.tv_nombre_pelicula
import kotlinx.android.synthetic.main.activity_detalle_pelicula.tv_pelicula_desc

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle=intent.extras

        var ns=0
        var id=-1
        var title=""
        if(bundle !=null){

            ns=bundle.getInt("numberSeats")
            title=bundle.getString("titulo")!!
            iv_pelicula_imagen.setImageResource(bundle.getInt("header"))
            tv_nombre_pelicula.setText(bundle.getString("nombre")) //quiza sea titulo
            tv_pelicula_desc.setText(bundle.getString("sinopsis"))
            seatsLeft.setText("$ns seats available")
            id=bundle.getInt("pos")
        }
        if(ns==0){
            buy_tickets.isActivated=false
        }else{
            buy_tickets.setOnClickListener{
                val intent: Intent =Intent(this, SeatSelection::class.java)
                intent.putExtra("movie",id)
                intent.putExtra("name", title)
            }
        }
    }
}