val osName: SettingKey[String] = SettingKey[String]("osName")

osName := (System.getProperty("os.name") match {
  case name if name.startsWith("Linux") => "linux"
  case name if name.startsWith("Mac") => "mac"
  case name if name.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
})

libraryDependencies += "org.openjfx" % "javafx-base" % "11-ea+25" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-controls" % "11-ea+25" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-fxml" % "11-ea+25" classifier osName.value

libraryDependencies += "org.openjfx" % "javafx-graphics" % "11-ea+25" classifier osName.value

libraryDependencies += "org.scalafx" %% "scalafx" % "11-R16"

libraryDependencies += "org.scalafx" %% "scalafx-extras" % "0.3.0"
