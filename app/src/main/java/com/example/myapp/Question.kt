package com.example.myapp

/**
 * Created by rohitramaswamy on 11/07/17.
 */
class Question
{
	var number=1
	var answer = false
	var mod = 1
	
	constructor()
	{
		this.mod = 103
		this.number = ((12345*152+1) % mod).toInt()
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
}
