package com.example.jogodavelha

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btClick(view: View){
        var btSelecionado = view as Button
        var cellID = 0

        when(btSelecionado.id){
            R.id.b1 -> cellID = 1
            R.id.b2 -> cellID = 2
            R.id.b3 -> cellID = 3
            R.id.b4 -> cellID = 4
            R.id.b5 -> cellID = 5
            R.id.b6 -> cellID = 6
            R.id.b7 -> cellID = 7
            R.id.b8 -> cellID = 8
            R.id.b9 -> cellID = 9
        }

        playGame(cellID,btSelecionado)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activeplayer = 1

    fun playGame(cellID:Int, btSelecionado:Button){
        if(activeplayer==1){
            btSelecionado.text = "X"
            btSelecionado.setTextColor(Color.WHITE)
            btSelecionado.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activeplayer = 2
        }else{
            btSelecionado.text = "O"
            btSelecionado.setTextColor(Color.WHITE)
            btSelecionado.setBackgroundColor(Color.RED)
            player2.add(cellID)
            activeplayer = 1
        }
        btSelecionado.isEnabled = false
        checkWinner()
    }

    fun checkWinner(){
        var winner = 0

        if((player1.contains(1) && player1.contains(2) && player1.contains(3)) ||
           (player1.contains(4) && player1.contains(5) && player1.contains(6)) ||
           (player1.contains(7) && player1.contains(8) && player1.contains(9)) ||
           (player1.contains(1) && player1.contains(4) && player1.contains(7)) ||
           (player1.contains(2) && player1.contains(5) && player1.contains(8)) ||
           (player1.contains(3) && player1.contains(6) && player1.contains(9)) ||
           (player1.contains(1) && player1.contains(5) && player1.contains(9)) ||
           (player1.contains(3) && player1.contains(5) && player1.contains(7))
           ){
            winner = 1
        }
        else if((player2.contains(1) && player2.contains(2) && player2.contains(3)) ||
            (player2.contains(4) && player2.contains(5) && player2.contains(6)) ||
            (player2.contains(7) && player2.contains(8) && player2.contains(9)) ||
            (player2.contains(1) && player2.contains(4) && player2.contains(7)) ||
            (player2.contains(2) && player2.contains(5) && player2.contains(8)) ||
            (player2.contains(3) && player2.contains(6) && player2.contains(9)) ||
            (player2.contains(1) && player2.contains(5) && player2.contains(9)) ||
            (player2.contains(3) && player2.contains(5) && player2.contains(7))
            ){
             winner = 2
        }

        if(winner!=0){
            if(winner==1)
                Toast.makeText(this,"Jogador 1 venceu",Toast.LENGTH_SHORT).show()
            else if(winner==2)
                Toast.makeText(this,"Jogador 2 venceu",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(this,"Empate",Toast.LENGTH_SHORT).show()
        }
    }
}