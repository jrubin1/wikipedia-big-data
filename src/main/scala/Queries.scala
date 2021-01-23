import scala.collection.mutable.HashMap

object Queries {
  var queries = HashMap(
    1->"select * from geoeditors order by upper_bound desc limit 20",
    2->"select * from pageviews order by count_views desc limit 20",
    3->"select * from pageviews where domain_code = \"en\" order by count_views desc limit 20",
    4->"select * from pageviews where domain_code = \"de\" order by count_views desc limit 20",
    5->"select * from pageviews where domain_code = \"es\" order by count_views desc limit 20",
    6->"select domain_code, sum(count_views) as total_views from pageviews group by domain_code order by total_views desc limit 20",
    7->"select * from pageviews order by count_views limit 20",
    8->"select wiki_db, sum(upper_bound) as upper_bound_sum from geoeditors group by wiki_db order by upper_bound_sum desc limit 20",
    9->"select wiki_db, sum((upper_bound + lower_bound) / 2) as avg_sum from geoeditors group by wiki_db order by avg_sum desc limit 20",
    10->"select * from geoeditors where wiki_db = \"enwiki\" order by upper_bound desc limit 20",
    11->"select * from geoeditors where wiki_db = \"eswiki\" order by upper_bound desc limit 20"
  )
}
