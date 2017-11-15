package com.yoohaemin.cetizenscraper

import fs2.{Stream, Task}
import org.http4s.HttpService
import org.http4s.dsl._
import org.http4s.server.blaze._
import org.http4s.util.StreamApp

object Main extends StreamApp {
  val searchService = HttpService {
    case GET -> Root / "search" / uri =>
      Ok(s"Will search for $uri")
  }

  override def stream(args: List[String]): Stream[Task, Nothing] = {
    BlazeBuilder
      .bindHttp(8080, "localhost")
      .mountService(searchService, "/")
      .serve
  }
}
