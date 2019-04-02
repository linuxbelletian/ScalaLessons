package com.hand

/**
  * Unified Types
  * */
case class Lesson1(topic: String, section: Int)

object Lesson1 {
  def main(args: Array[String]): Unit = {
    val any: Any = "String"

    val anyList: Seq[Any] = Seq()

    val anys: Seq[Any] = anyList.+:("hello").+:(1).+:('c').+:(false)

    val anyVals: Seq[AnyVal] = Seq(1L, 1, 'c', false, 1.toByte)

    val anyRefs: Seq[AnyRef] = Seq("String", Lesson1("Hello", 3) )

    println(anys)
  }

  def apply(topic: String, section: Int): Lesson1 = new Lesson1(topic, section)

  def unapply(arg: Lesson1): Option[(String, Int)] = Option(arg.topic, arg.section)
}