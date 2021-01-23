import Utilities.printResultSet
import java.sql._

object Main extends App {
  var con: Connection = _

  try {
    val connectionString = "jdbc:hive2://localhost:10000/default"
    Class.forName("org.apache.hive.jdbc.HiveDriver")
    con = DriverManager.getConnection(connectionString, "", "")
    val statement = con.createStatement()
    var resultSet = statement.executeQuery(Input.getUserInput(statement))
    printResultSet(resultSet)
  } catch {
    case e: Exception => e.printStackTrace()
  }

  con.close();
}
