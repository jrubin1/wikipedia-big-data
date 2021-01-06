//import Main.resultSet

import java.sql._

object Main extends App {
  var con: Connection = _

  try {
    val connectionString = "jdbc:hive2://localhost:10000/default"
    Class.forName("org.apache.hive.jdbc.HiveDriver")
    con = DriverManager.getConnection(connectionString, "", "")

    val statement = con.createStatement()
    var resultSet = statement.executeQuery("select * from geoeditors order by upper_bound desc limit 20")

//    while (resultSet.next) {
//      val foo = resultSet.getString("wiki_db")
//      val bar = resultSet.getString("country")
//      val bar = resultSet.getString("country")
//      val bar = resultSet.getString("country")
//      val bar = resultSet.getString("country")
//      println(foo + " " + bar)
//    }

    printResultSet(resultSet)
  } catch {
    case e: Exception => e.printStackTrace()
  }

  def printResultSet(resultSet: ResultSet): Unit = {
    val rsmd = resultSet.getMetaData
    val columnsNumber = rsmd.getColumnCount
    while (resultSet.next) {
      for (i <- 1 to columnsNumber) {
        if (i > 1) System.out.print(",  ")
        val columnValue = resultSet.getString(i)
        System.out.print(columnValue + " " + rsmd.getColumnName(i))
      }
      System.out.println("")
    }
  }

  import java.sql.ResultSetMetaData

//  val resultSet = statement.executeQuery("SELECT * from foo")
//  val rsmd = resultSet.getMetaData
//  val columnsNumber = rsmd.getColumnCount
//  while ( {
//    resultSet.next
//  }) {
//    for (i <- 1 to columnsNumber) {
//      if (i > 1) System.out.print(",  ")
//      val columnValue = resultSet.getString(i)
//      System.out.print(columnValue + " " + rsmd.getColumnName(i))
//    }
//    System.out.println("")
//  }

  con.close();
}
