# Wikipedia Big Data Analysis
## Project Description
This is a Scala application that uses Hive to process and conduct analysis on the Wikipedia Analytics Dataset- including Wikipedia Pageview data and Geoeditor data. 

## Technologies
- Hive - version 2.3.2
- Hadoop (HDFS, Yarn, MapReduce) - version 3.2.1
- Hive JDBC - version 3.1.2
- Scala - version 2.13.4
- sbt - version 1.4.6

## Features
Current:
- Wikipedia Analytics Dataset - pageviews and geoeditors data
- Data processing/analysis using Hive on Wikipedia Pageview data and Geoeditor data
- Focused analysis on Country (country field)/Language (wiki_db field) of page edits and page views
- Scala connection to Hive through JDBC
- Queries executed and output by Scala
- CLI allowing user to either execute select query of choice or execute all queries
- This project was accompanied by a slidedeck presentation of results as well as a high level over of the process used to achieve those results

To-do:
- Performance analysis of partitioning and bucketing including timed execution of queries
- Expansion to include more Wikipedia Datasets (Clickstream or others)

## Datasets
- https://dumps.wikimedia.org/other/pageviews/readme.html
- https://dumps.wikimedia.org/other/geoeditors/readme.html

## Getting Started
1. Navigate to desired folder location to clone docker-hive
2. Execute the following shell commands
```
  $ git clone https://github.com/jrubin1/scala-hive.git
  $ cd docker-hive
  $ docker-compose up -d
  $ docker-compose exec hive-server bash
  # cd hive
  # curl https://dumps.wikimedia.org/other/geoeditors/geoeditors-monthly-2020-12.tsv —-output geoeditors.tsv
  # curl https://dumps.wikimedia.org/other/pageviews/2020/2020-11/pageviews-20201101-000000.gz —-output pageviews.gz
  # gunzip pageviews.gz
  # /opt/hive/bin/beeline -u jdbc:hive2://localhost:10000
  > CREATE TABLE geoeditors (wiki_db string, country string, activity_level string, lower_bound int, upper_bound int) row format delimited fields terminated by ‘\t’ lines terminated by ‘\n’;
  > LOAD DATA LOCAL INPATH '/opt/hive/geoeditors.tsv’ OVERWRITE INTO TABLE geoeditors;
  > CREATE TABLE pageviews (domain_code string, page_title string, count_views int, total_response_size int) row format delimited fields terminated by ‘ ’ lines terminated by ‘\n’;
  > LOAD DATA LOCAL INPATH '/opt/hive/pageviews’ OVERWRITE INTO TABLE pageviews;
```
3. Navigate to desired folder location to clone wikipedia-big-data
4. Execute the following shell command
```
  $ git clone https://github.com/jrubin1/wikipedia-big-data.git
```

## Usage
1. Execute the following shell commands
```
  $ cd wikipedia-big-data
  $ sbt run
```
2. Once prompted, choose to execute desired query or to execute all queries

![Menu Image] (./images/image.png)
