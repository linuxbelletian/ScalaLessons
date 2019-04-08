package object p1 { implicit val s: String = "hello, world" }

package object p { implicit val s: String = "hello, world" }
package p1 {
  object X { def f = implicitly[String] }
}

//package  c {
//  object X { def f = implicitly[String] }
//}

