import java.sql._

object Utilities {
  def executeAllQueries(statement: Statement) : Unit = {
    for (i <- 1 until 10) {
      printResultSet(statement.executeQuery(Queries.queries(i)))
    }
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
}
