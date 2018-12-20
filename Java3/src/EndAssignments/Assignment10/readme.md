<!--
  - Author: Joris Rietveld <jorisrietveld@gmail.com>
  - Date: 19-12-2018 17:23
  - Licence: Creative Commons - Attribution-ShareAlike 4.0 International
-->

# **Java 3** :: _Final Assignment 11_

[TOC]: # "Table of contents"

## Table of contents
- [**Java 3** :: _Final Assignment 11_](#java-3--final-assignment-11)
    - [Assignment](#assignment)
    - [User Stories & Constraints](#user-stories--constraints)
    - [Input & Output](#input--output)
    - [UML Diagrams](#uml-diagrams)
        - [Use Case](#use-case)
        - [Class Diagram](#class-diagram)


## Assignment
At an all-round skating championship the following distances are skated in
succession: 500 metres, 5000 metres, 1500 metres and 10000 metres. Each time is
accurately registered in hundredths of seconds. The times achieved on the
various distances are converted to points by converting each time to a 500
metres time. The skater with the lowest total number of points may call himself
champion.

An Applet or GUI must be developed for which the following information can be
entered for an unknown number of participants (max. 24):

- Name
- Time 500 metres
- Time 5000 metres
- Time 1500 metres
- Time 10000 metres

(all times as one number in the format: `mmsshh` a time of 1 min 55.48 seconds
is entered as 15548)

- After the data of a participant has been entered the total number of points
for that participant must be calculated.

- After all participants are entered the winners of the various distances (name
and time) and the winner of the total ranking (lowest total number of points)
must be displayed.


## User Stories & Constraints
1. As a person I want to see the results of races.
2. As a person I want to see the results of the championship.

3. As a participant I want to see the results of the race I skated.
4. As a participant I want to see myself in the leader board of the competition I
  raced in.

5. As a ISU employee I want to be able to open the application so I can
  perform the job I have at the championship.
6. As a ISU employee I want to have access to a list of all the championships.
7. As a ISU employee I want to have access to a list of all the races in a
  competition class.

8. As a referee of a race I want to persist the finish time of participants in
   the following format: `mmsshh`.
9. As a referee I want to disqualify participators when they perform a Illegal
   action.


## Input & Output

| Input Code |    |
|:-----------|:---|
|            |    |

## UML Diagrams


### Use Case


### Class Diagram



<hr>

[![Author Joris Rietveld](https://img.shields.io/badge/Author-Joris%20Rietveld-blue.svg)](https://github.com/jorisrietveld)
[![License: CC BY-SA 4.0](https://img.shields.io/badge/License-CC%20BY--SA%204.0-lightgrey.svg)](https://creativecommons.org/licenses/by-sa/4.0/)

:bangbang: I did not write and therefore do not own the text under the heading:
**Assignment**. This is the educational assignment I received from the teachers
@[NHLStenden](https://www.nhlstenden.com). The rest of the documentation is
licensed under a <a rel="license"
href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons
Attribution-ShareAlike 4.0 International License</a>. All the source code (java
& kotlin files) in in this project are licenced under
[GPLv3 Licence](../../../../Java2/LICENCE).
