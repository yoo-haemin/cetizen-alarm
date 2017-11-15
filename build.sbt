scalaVersion in ThisBuild := {
  //val dottyVersion = dottyLatestNightlyBuild.get //"0.4.0-RC1"
  //dottyVersion
  "2.12.4"
}

lazy val root = (project in file(".")).
  settings(
    name := "cetizen-scraper",
    version := "0.0.1",

    libraryDependencies ++= {
      val http4sVersion = "0.17.5"

      val scalaDep =
        "ch.qos.logback"             %  "logback-classic"     % "1.2.3"         ::
        "com.typesafe.scala-logging" %% "scala-logging"       % "3.7.2"         ::
        "com.lihaoyi"                %% "scalatags"           % "0.6.7"         ::
        "org.http4s"                 %% "http4s-dsl"          % http4sVersion   ::
        "org.http4s"                 %% "http4s-blaze-server" % http4sVersion   ::
        "org.http4s"                 %% "http4s-blaze-client" % http4sVersion   ::
        "com.lihaoyi"                %% "fastparse"           % "1.0.0"         ::
        "net.ruippeixotog"           %% "scala-scraper"       % "2.0.0"         ::
        "com.github.pureconfig"      %% "pureconfig"          % "0.8.0"         :: Nil //map (_.withDottyCompat())

      val javaDep = 
        "com.novocode"          %  "junit-interface"     % "0.11" % "test" :: Nil

      scalaDep ++ javaDep
    },

    scalacOptions ++= { 
      var list: Seq[String] = Nil

      //if (isDotty.value) list = list ++ Seq("-language:Scala2") else ()

      list
    }
  )
