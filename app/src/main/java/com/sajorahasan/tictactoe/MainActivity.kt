package com.sajorahasan.tictactoe

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnOnClick(view: View) {
        val btnSelected = view as Button
        when (btnSelected.id) {
            R.id.btnPlayWithFriend -> {
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra("type", 1)
                startActivity(intent)
            }
            R.id.btnPlaywithRobot -> {
                val intent = Intent(this, GameActivity::class.java)
                intent.putExtra("type", 2)
                startActivity(intent)
            }
        }
    }

}
