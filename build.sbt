enablePlugins(HivemindPlugin)

import com.amazonaws.regions.{Region, Regions}
import sbt._
import sbt.Keys._

name := "zio-experiment"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full)

libraryDependencies ++= {
  val circeVersion = "0.12.1"
  val zioVersion   = "1.0.0-RC18"
  Seq(
    "dev.zio"  %% "zio-test"      % zioVersion,
    "dev.zio"  %% "zio-test-sbt"  % zioVersion,
    "io.circe" %% "circe-core"    % circeVersion,
    "io.circe" %% "circe-generic" % circeVersion,
    "io.circe" %% "circe-parser"  % circeVersion,
    "io.circe" %% "circe-literal" % circeVersion
  )
}
testFrameworks := Seq(new TestFramework("zio.test.sbt.ZTestFramework"))

(compile in Compile) := ((compile in Compile) dependsOn scalafmtCheckAll).value
