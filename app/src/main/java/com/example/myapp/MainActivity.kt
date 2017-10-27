package com.example.myapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse


class MainActivity : AppCompatActivity()
{
	private val ques = Question()
	private var score: Long = 0
	private val GITHUB_URL: String = "https://github.com/roh-7"
	
	override fun onCreate(savedInstanceState: Bundle?)
	{
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		loadQuestion()
		// eliminating use of findViewById using synthetic.
		trueButton.setOnClickListener { checkAnswer(true) }
		falseButton.setOnClickListener { checkAnswer(false) }
		nextButton.setOnClickListener {
			ques.getNextQuestion()
			loadQuestion()
		}
        resetButton.setOnClickListener { reset() }
	}
	
	override fun onCreateOptionsMenu(menu: Menu?): Boolean
	{
		menuInflater.inflate(R.menu.options_menu,menu)
		return true
	}
	
	override fun onOptionsItemSelected(item: MenuItem?): Boolean
	{
		val id = item!!.itemId
		
		if(id==R.id.share_options)
		{
			browse(GITHUB_URL)
			
			return true
		}
		
		return super.onOptionsItemSelected(item)
	}
	
	private fun loadQuestion()
	{
        setScoreViewText()
        questionTextView.text = "Is " + ques.number + " a prime number ?"
	}
	
	private fun checkAnswer(x: Boolean)
	{
		if (x == ques.answer)
		{
			score++
            answer_text.text = "Thats correct"
			ques.getNextQuestion()
			loadQuestion()
		}
		else
		{
            answer_text.text = "Wrong answer"
			ques.getNextQuestion()
			loadQuestion()
		}
	}

    private fun reset()
    {
        score = 0
        setScoreViewText()
    }

    private fun setScoreViewText()
    {
        scoreView.text = "Your score is: " + score
    }
}
