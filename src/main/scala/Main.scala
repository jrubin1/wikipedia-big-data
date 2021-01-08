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

    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select * from pageviews order by count_views desc limit 20")
    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select * from pageviews where domain_code = \"en\" order by count_views desc limit 20")
    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select * from pageviews where domain_code = \"de\" order by count_views desc limit 20")
    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select * from pageviews where domain_code = \"es\" order by count_views desc limit 20")
    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select domain_code, sum(count_views) as total_views from pageviews group by domain_code order by total_views desc limit 20")
    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select * from pageviews order by count_views limit 20")
    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select wiki_db, sum(upper_bound) as upper_bound_sum from geoeditors group by wiki_db order by upper_bound_sum desc limit 20")
    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select wiki_db, sum((upper_bound + lower_bound) / 2) as avg_sum from geoeditors group by wiki_db order by avg_sum desc limit 20")
    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select * from geoeditors where wiki_db = \"enwiki\" order by upper_bound desc limit 20")
    printResultSet(resultSet)
    println("\n\n\n")
    resultSet = statement.executeQuery("select * from geoeditors where wiki_db = \"eswiki\" order by upper_bound desc limit 20")
    printResultSet(resultSet)

  } catch {
    case e: Exception => e.printStackTrace()
  }

  def printResultSet(resultSet: ResultSet): Unit = {
    //https://stackoverflow.com/questions/24229442/print-the-data-in-resultset-along-with-column-names
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

  con.close();
}
