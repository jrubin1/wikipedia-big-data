# Josh's Project 1
## Data Manipulation/Analysis using Hive
- Wikipedia Analytics Dataset - pageviews and geoeditors data
- 11 hive queries providing various insights about pageview data and geoeditor data
- Scala connection to Hive through JDBC
- Queries executed and output by Scala

## Requirements
- JDK Version 8 or 11
- Scala and SBT
- docker-hive (big data Europe)

## Compile
>sbt compile

## Setup docker-hive
- First, clone docker-hive repo locally
>cd docker-hive \
>docker-compose up -d

## Run
>sbt run
