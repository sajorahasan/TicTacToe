package com.sajorahasan.tictactoe

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game.*
import java.util.*

class GameActivity : AppCompatActivity() {

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var activePlayer = 1
    var num: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (intent != null) {
            num = intent.getIntExtra("type", 1)
            Toast.makeText(this, num.toString(), Toast.LENGTH_SHORT).show();
        }

    }

    protected fun btnOnClick(view: View) {
        val btnSelected = view as Button
        var cellID = 0

        when (btnSelected.id) {
            R.id.btn1 -> cellID = 1
            R.id.btn2 -> cellID = 2
            R.id.btn3 -> cellID = 3
            R.id.btn4 -> cellID = 4
            R.id.btn5 -> cellID = 5
            R.id.btn6 -> cellID = 6
            R.id.btn7 -> cellID = 7
            R.id.btn8 -> cellID = 8
            R.id.btn9 -> cellID = 9
        }

        if (num == 1) {
            playGame(cellID, btnSelected)
        } else if (num == 2) {
            playGameWithRobot(cellID, btnSelected)
        }
    }

    fun playGame(cellID: Int, btnSelected: Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activePlayer = 2
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellID)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
        checkWinner()
    }

    fun playGameWithRobot(cellID: Int, btnSelected: Button) {
        if (activePlayer == 1) {
            btnSelected.text = "X"
            btnSelected.setBackgroundResource(R.color.green)
            player1.add(cellID)
            activePlayer = 2
            autoPlay()
        } else {
            btnSelected.text = "O"
            btnSelected.setBackgroundResource(R.color.blue)
            player2.add(cellID)
            activePlayer = 1
        }
        btnSelected.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }

        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        // column 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }

        // column 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }

        // column 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if (winner != -1) {
            if (winner == 1) {
                Toast.makeText(this, "Congratulation, Player 1 is the winner!!!", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Congratulation, Player 2 is the winner!!!", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun autoPlay() {
        var emptyCells = ArrayList<Int>()
        for (cellID in 1..9) {
            if (!(player1.contains(cellID) || player2.contains(cellID))) {
                emptyCells.add(cellID)
            }
        }

        val rand = Random()
        val randomIndex = rand.nextInt(emptyCells.size)
        val cellID = emptyCells[randomIndex]

        var btnSelected: Button?

        when (cellID) {
            1 -> btnSelected = btn1
            2 -> btnSelected = btn2
            3 -> btnSelected = btn3
            4 -> btnSelected = btn4
            5 -> btnSelected = btn5
            6 -> btnSelected = btn6
            7 -> btnSelected = btn7
            8 -> btnSelected = btn8
            9 -> btnSelected = btn9
            else -> {
                btnSelected = btn1
            }
        }

        playGame(cellID, btnSelected)
    }

}
