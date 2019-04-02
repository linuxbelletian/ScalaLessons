package com.hand

/**
  *
  * function is first
  * */
object Lesson3 {
  def main(args: Array[String]): Unit = {
    val nums = Seq(1,2,3,4,5,6)
    // function is parameter of function or method
    val takeFunction = nums.map(x => x * 2)

    val takeFuntionShortForm = nums.map(_ * 2)

    val hello = returnAfunction("hello world!")
    hello()
  }

  def returnAfunction(hello: String): () => Unit = {
    val say: ()=> Unit = () => {println(hello)}
    say
  }
}

object SalaryRaiser {

  def smallPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * 1.1)

  def greatPromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    salaries.map(salary => salary * salary)
}


object SalaryRaiser2 {

  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def bigPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)
}



