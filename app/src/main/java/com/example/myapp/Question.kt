package com.example.myapp

import java.util.*

/**
 * Created by rohitramaswamy on 11/07/17.
 */
class Question
{
	var number=1
	var answer = false
	private var mod = 1
	private val bound = 1234
	
	constructor()
	{
		this.mod = 103
		this.number = getRandomNumber()
	}
	
	fun setAnswer(): Boolean
	{
		var sq =  (Math.sqrt(number.toDouble())).toInt()
		while(sq>=2)
		{
			if(number%sq==0)
			{
				return false
			}
			sq--
		}
		return true
	}
	
	fun getNextQuestion()
	{
		this.number = getRandomNumber()
		this.answer = setAnswer()
	}

	private fun getRandomNumber(): Int
	{
		return  Random().nextInt(bound)
	}
}