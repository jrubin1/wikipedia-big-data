import java.sql._

object Main extends App {
  var con: Connection = _

  try {
    val connectionString = "jdbc:hive2://localhost:10000/default"
    Class.forName("org.apache.hive.jdbc.HiveDriver")
    con = DriverManager.getConnection(connectionString, "", "")

    val statement = con.createStatement()
    var resultSet = statement.executeQuery("select * from pokes")

    while (resultSet.next) {
      val foo = resultSet.getInt("foo")
      val bar = resultSet.getString("bar")
      println(foo + " " + bar)
    }
  } catch {
    case e: Exception => e.printStackTrace()
  }

  con.close();
}
