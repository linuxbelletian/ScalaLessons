package com.hand

/**
  * Class Composition with Mixins
  * */

object Lesson2 {

  def main(args: Array[String]): Unit = {
    val d = new SubSubclassC()
    d.sayHello
  }
}

abstract class SupperClass {
  val message: String
}

class SubclassA extends SupperClass {
  val message = "SubclassA"
}

class SubclassB extends SupperClass {
  val message = "SubclassB"
}

trait SayHello extends SupperClass {
  def sayHello = println(message)
}

class SubSubclassC extends SubclassA with SayHello


