# Time Combination API 

## Problem Statement:
Given input has a time format of HH:MM:SS where HH is for hours (24 format), MM is for minutes and SS is for seconds.
Write a method where it calculates the amount of times where only 2 digits appear in every possible combination in a specific time range. 

 For example: if start time is 16:15:00 and end time is 17:00:00 then all expected combinations having only 2 similar digits are
16:16:11 and 16:16:16.

##Solution:
In my approach, I used stream to iterate through different possible combinations and then verified whether the combination has only 2 digits or not.


## Requirements

+ Java 11,Maven

```bash
java -version

java version "11.0.6" 2020-01-14 LTS
Java(TM) SE Runtime Environment 18.9 (build 11.0.6+8-LTS)
Java HotSpot(TM) 64-Bit Server VM 18.9 (build 11.0.6+8-LTS, mixed mode)

```
```bash
Note: I have created a main method so that user can run the generated jar to verify the output
```
## To create a build

```bash
mvn clean install
```

## Run the jar (from the given path) .

```bash
java -jar <Jar path>

```

### Example

```bash
## With valid inputTimes
java -jar target/time-combination-api-1.0-SNAPSHOT.jar
```

#### Output
```bash
0 [main] INFO com.backend.TimeRangeApplication  - Enter the Start Time in HH:mm:ss format
16:15:00
17025 [main] INFO com.backend.TimeRangeApplication  - Enter the End Time in HH:mm:ss format
17:00:00
26333 [main] INFO com.backend.TimeRangeApplication  - Possible count of two digits in a given time range is : 2



```
```bash
## With invalid inputTimes
java -jar target/time-combination-api-1.0-SNAPSHOT.jar
```

#### Output
```bash
D:\dev\time-combination-api>java -jar target/time-combination-api-1.0-SNAPSHOT.jar
0 [main] INFO com.backend.TimeRangeApplication  - Enter the Start Time in HH:mm:ss format
00:57:60
22174 [main] INFO com.backend.TimeRangeApplication  - Enter the End Time in HH:mm:ss format
01:00:00
Exception in thread "main" com.backend.exception.InvalidTimeException: Invalid time format in '00:57:60'.
 Please enter time within range of 00:00:00 -23:59:59
        at com.backend.timer.TimeValidator.validateInputTime(TimeValidator.java:29)



```
#### To Execute TestCases
```bash
Run "TestForAllClasses.java" to verify all the test scenario
```

