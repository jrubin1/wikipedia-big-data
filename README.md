# Wikipedia Big Data Analysis
## Technologies
- Hive - version 2.3.2
- Hadoop (HDFS, Yarn, MapReduce) - version 3.2.1
- Hive JDBC - version 3.1.2
- Scala - version 2.13.4
- sbt - version 1.4.6

## Features
- Wikipedia Analytics Dataset - pageviews and geoeditors data
- Data processing/analysis using Hive on Wikipedia Pageview data and Geoeditor data
- Focused analysis on Country (country field)/Language (wiki_db field) of page edits and page views
- Scala connection to Hive through JDBC
- Queries executed and output by Scala
- CLI allowing user to either execute select query of choice or execute all queries
- This project was accompanied by a slidedeck presentation of results as well as a high level over of the process used to achieve those results

## Datasets
- https://dumps.wikimedia.org/other/pageviews/readme.html
- https://dumps.wikimedia.org/other/geoeditors/readme.html

## Requirements
- JDK Version 8 or 11
- Scala and sbt
- docker-hive (Big Data Europe)

## Setup docker-hive
- First, clone docker-hive repo locally
>cd docker-hive \
>docker-compose up -d

## Instructions
1. Set up docker-hive
2. Load data into HDFS (can use curl to retrieve data if desired)
3. Create Hive tables with schema according to pageviews and geoeditors data format
4. Load data from HDFS into Hive
5. Run Scala program to execute analysis. On prompt, select desired analysis

## Compile
>sbt compile

## Run
>sbt run
