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
	private val bo = 1232
	
	constructor()
	{
		this.mod = 103
		this.number = getRand()
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
			sq--;
		}
		return true
	}
	
	fun getNextQuestion()
	{
		this.number = ( this.number + 12345*152+1)%mod
		this.answer = setAnswer()
	}
	
	private fun getRand(): Int
	{
		return Random().nextInt(bo)	
	}
		
}
