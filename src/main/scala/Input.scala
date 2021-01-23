import java.sql.Statement

object Input {
  def getUserInput(statement: Statement): String = {
    println("Choose a query to execute.")
    println("1. select * from geoeditors order by upper_bound desc limit 20")
    println("2. select * from pageviews order by count_views desc limit 20")
    println("3. select * from pageviews where domain_code = \"en\" order by count_views desc limit 20")
    println("4. select * from pageviews where domain_code = \"de\" order by count_views desc limit 20")
    println("5. select * from pageviews where domain_code = \"es\" order by count_views desc limit 20")
    println("6. select domain_code, sum(count_views) as total_views from pageviews group by domain_code order by total_views desc limit 20")
    println("7. select * from pageviews order by count_views limit 20")
    println("8. select wiki_db, sum(upper_bound) as upper_bound_sum from geoeditors group by wiki_db order by upper_bound_sum desc limit 20")
    println("9. select wiki_db, sum((upper_bound + lower_bound) / 2) as avg_sum from geoeditors group by wiki_db order by avg_sum desc limit 20")
    println("10. select * from geoeditors where wiki_db = \"enwiki\" order by upper_bound desc limit 20")
    println("11. select * from geoeditors where wiki_db = \"eswiki\" order by upper_bound desc limit 20")
    println("12. Run all queries.")

    do {
      var input = scala.io.StdIn.readInt()
      if (input >= 1 && input <= 11) {
        return Queries.queries(input)
      } else if (input == 12) {
        Utilities.executeAllQueries(statement)
        return Queries.queries(11)
      } else {
          println("Please enter a number between 1 and 11.")
      }
    } while (true)
    return ""
  }
}
