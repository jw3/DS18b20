organization := "com.rxthings.sensors"
name := "ds18b20"
version := "0.1-SNAPSHOT"
licenses +=("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.11.8"
scalacOptions += "-target:jvm-1.8"

resolvers += "jw3 at bintray" at "https://dl.bintray.com/jw3/maven"

libraryDependencies ++= {
  val akkaVersion = "2.4.4"
  val scalatestVersion = "3.0.0-M15"

  Seq(
    "com.rxthings" %% "webhooks" % "0.5",
    "com.github.jw3" %% "pigpio-scala" % "0.1-SNAPSHOT",

    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,

    "ch.qos.logback" % "logback-classic" % "1.1.7" % Runtime,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion % Runtime,

    "org.scalactic" %% "scalactic" % scalatestVersion % Test,
    "org.scalatest" %% "scalatest" % scalatestVersion % Test,
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % Test,
    "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test
  )
}

enablePlugins(JavaAppPackaging)
mainClass in Compile := Some("rxthings.sensors.Boot")
dockerRepository := Some("jwiii")
dockerBaseImage := "jwiii/arm-java:8"
dockerExposedPorts := Seq(8080)
