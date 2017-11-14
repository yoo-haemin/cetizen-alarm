package com.yoohaemin

import fs2.Strategy

package object cetizenscraper {
  // fs2 `Async` needs an implicit `Strategy`
  implicit val strategy = Strategy.fromExecutionContext(scala.concurrent.ExecutionContext.Implicits.global)

}
