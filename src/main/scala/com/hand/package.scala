
//package object p { implicit val s: String = "hello, world" }

package p {
  package q {
    object Y {
      implicit val s: String = "bye"
    }
    object X {
      import Y._
      def f = implicitly[String]
    }
  }
}

object hello {
  def main(args: Array[String]): Unit = {
    import p.q.X
    println(X)
  }
}