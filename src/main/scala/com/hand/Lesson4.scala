package com.hand
/**
  * Curring and implicit parameters
  * */
class Lesson4 {

}

object Lesson4 {
  def main(args: Array[String]): Unit = {
    import Y.X._
    println(f)
  }
}

object Y {
  implicit val n: Int = 17
  trait T {
    implicit val i: Int = 17
    implicit def t: T   = ???
  }
  object X extends T {
    implicit val n: Int = 42
    implicit val s: String = "hello, world\n"
    def f(implicit s: String) = implicitly[String] * implicitly[Int]
    override def t: T = ???
//    def g = implicitly[T]
  }
}


// 隐式范围
trait T
object T { implicit val t: T = new T { } }


class A(val n: Int) {
  def +(other: A) = new A(n + other.n)
}
object A {
  implicit def fromInt(n: Int) = new A(n)
}




abstract class Monoid[A] {
  def add(x: A, y: A): A
  def unit: A
}

object ImplicitTest {
  implicit val stringMonoid: Monoid[String] = new Monoid[String] {
    def add(x: String, y: String): String = x concat y
    def unit: String = ""
  }

  implicit val intMonoid: Monoid[Int] = new Monoid[Int] {
    def add(x: Int, y: Int): Int = x + y
    def unit: Int = 0
  }

  def sum[A](xs: List[A])(implicit m: Monoid[A]): A =
    if (xs.isEmpty) m.unit
    else m.add(xs.head, sum(xs.tail))

  def main(args: Array[String]): Unit = {
    println(sum(List(1, 2, 3)))       // uses intMonoid implicitly
    println(sum(List("a", "b", "c"))) // uses stringMonoid implicitly
  }
}