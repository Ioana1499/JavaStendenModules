# **Java 3** :: _Final Assignment 11_

[TOC]: # "Table of contents"

# Table of contents
- [Assignment](#assignment)
- [Use Cases](#use-cases)
- [Input](#input)
    - [Output](#output)
- [UML Class Diagram](#uml-class-diagram)
- [TestDesign](#testdesign)
- [TestData](#testdata)


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

After the data of a participant has been entered the total number of points
for that participant must be calculated.

After all participants are entered the winners of the various distances (name
and time) and the winner of the total ranking (lowest total number of points)
must be displayed.


## Use Cases
1. As a participant I want to see the results of races.
2. As a participant I want to see the results of the competition.
3. As a Participant Administrator I want to add participants to a competition.
3. As a Participant Administrator I want to remove to a competition.
5. As a referee I want to insert finish times to a competition so I can determine the winners.
   - the following time format should be used: `mmsshh`.


## Input

| **Input Code** | **0000**                                                            |
|:---------------|:--------------------------------------------------------------------|
| Name           | AddFinish                                                |
| Goal           | Create a new finish                                           |
| Explanation    | When the referee wants to add a finish time to a competition. |
| Frequency      | Between 0 and 24 times a competition.                                                  |
| Model          | Finish                                                        |
| **Screens**    | FinishInsertView                                              |
 

| **Input Code** | **0001**                                                 |
|:---------------|:---------------------------------------------------------|
| Name           | CreateNewParticipants                                    |
| Goal           | Create new Participants                                  |
| Explanation    | The competition needs participants to organize the event |
| Frequency      | every competition                                        |
| Model          | Participant                                              |
| **Screens**    | ParticipantCreateView                                    |


| **Input Code** | **0010**                                                         |
|:---------------|:-----------------------------------------------------------------|
| Name           | AddParticipant                                                   |
| Goal           | Adding new participant to an championship                        |
| Explanation    | This enables the addition of new participants to an championship |
| Frequency      | For every participant of a championship                          |
| Model          | Participant                                                |
| **Screens**    | ParticipantCreateView                                            |


#### Output


| **Output Code** | **0000**          |
|:----------------|:------------------|
| Name            | ShowRaceResult |
| Goal            | show winners of a race                 |
| Explanation     | In every race there are 0..24 participants, this page shows a leader board of finishes.  |
| Frecuenty       | At Leased Every race |
| Model           |             Finish, Race, Participant      |
| **Screens**     | RaceLeaderBoardView |



| **Output Code** | **0000**                 |
|:----------------|:-------------------------|
| Name            | ShowCompetitionResult |
| Goal            | show winners of a competition                 |
| Explanation     | In every race there are 0..\* races, this page shows a leader board of the finishes of every race.  |
| Frecuenty       | At Leased every competition. |
| Model           |             Finish, Competition, Participant, Race      |
| **Screens**     | RaceLeaderBoardView |


## UML Class Diagram
![ClassDiagram_ICU.png](../../Chapter10/Resources/ClassDiagram_ICU_v0.6.png)


## TestDesign
~

## TestData
~

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
