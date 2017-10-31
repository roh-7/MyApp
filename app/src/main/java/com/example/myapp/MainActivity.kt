package com.example.myapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.browse

class MainActivity : AppCompatActivity()
{
	val ques = Question()
	var score: Long = 0
	val GITHUB_URL: String = "https://github.com/roh-7"
	
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
	}
	
	override fun onCreateOptionsMenu(menu: Menu?): Boolean
	{
		menuInflater.inflate(R.menu.options_menu,menu)
		return true;
	}
	
	override fun onOptionsItemSelected(item: MenuItem?): Boolean
	{
		val id = item!!.getItemId()
		
		if(id==R.id.share_options)
		{
			browse(GITHUB_URL)
			
			return true
		}
		
		return super.onOptionsItemSelected(item)
	}
	
	fun loadQuestion()
	{
		scoreView.setText("Your score is: " + score)
		questionTextView.setText("Is " + ques.number + " a prime number ?")
	}
	
	fun checkAnswer(x: Boolean)
	{
		if (x == ques.answer)
		{
			score++
			answer_text.setText("Thats correct")
			ques.getNextQuestion()
			loadQuestion()
		}
		else
		{
			answer_text.setText("Wrong answer")
			ques.getNextQuestion()
			loadQuestion()
		}
	}
	
}
