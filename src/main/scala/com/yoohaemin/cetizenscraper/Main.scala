package com.yoohaemin.cetizenscraper

import org.http4s._
import org.http4s.dsl._
import org.http4s.client.blaze._
import fs2.Task
import fs2.interop.cats._
import cats._
import cats.implicits._
import org.http4s.Uri

object Main {
  def main(args: Array[String]): Unit = {
    val httpClient = PooledHttp1Client()
    val ask = httpClient.expect[String]("")

    def hello(name: String): Task[String] = {
      val target = Uri.uri("http://localhost:8080/hello/") / name
      httpClient.expect[String](target)
    }
    val people = Vector("Michael", "Jessica", "Ashley", "Christopher")
    val greetingList = Task.parallelTraverse(people)(hello)

    val helloWorldService = HttpService {
      case GET -> Root / "hello" / name =>
        Ok(s"Hello, $name.")
    }

    println("Hello world!")
  }
}
