# Lab PayStationMain main program and rate strategies
## Team 03-libohova-zhou
### Requirements
------------------------------------------------------------------------------------------------
The requirements for this project were to generate a main menu that served as a text interface for individuals 
interacting with the paystation. We needed to implement several choices for this menu (deposit coins, display time, buy
ticket, cancel transaction, empty, and change rate strategy). 

For changing the rate strategy we also need to generate a submenu that offered the different rate options as well as 
requiring an input for the date on the alternating classes. 

In terms of the rate strategies we needed to implement five that broke down into three distinct categories, linear, 
progressive, and a combination of the two depending on the day of the week. 

We chose the compositional model because it allowed us to have the same template for the Paystation 
interface while simply changing an object for the ratestrategy. This allows us flexibility with 
applying the same program to different towns with different rate strategies. The advantage with this model is the code
does not become bloated with unused code when applied to different towns. There also is less bloat than a massive if 
else statement and becomes easier to debug as it is more modular. The disadvantage with the process is the lack of speed 
if we need to replicate the original project quickly. Compositional model requires more planning to determine the spread
of responsibility among the different classes and objects. 

We implemented all the functions as required in the assignment and wrote several tests for their functionality. 
### Teamwork
------------------------------------------------------------------------------------------------
Steven worked on the Paystation main and alternating strategies while Mario implemented RateStrategies. We split the 
work as much as possible with no rush and communicated through discord for any issues or concerns. Committed to Github 
and did pull requests to view each other's code throughout the process. Mario wrote up the readme for requirements and 
teamwork while Steven completed the testing section. Tests were split depending on who developed the original code for 
the functionality of the program. There were revisions on code once we say certain implementations not working as intended.

#### Steven worked on PayStation Main, AlternatingStrategy, WeekendRoll over, JUnit tests, UML, and ReadMe

#### Mario: I worked the Strategies so initializing RateStrategy then adding Linear, Progressive, Alternating, I typed part of the readMe and did part of the UML. Added JUnit test for Linear and Progressive



### Testing
------------------------------------------------------------------------------------------------
Testing was mainly done with JUnit Testing as it seemed more convenient. It was separated into tests for the Paystation 
and a separate class that tested rate strategy implementations. For the rate strategies that simply required an input 
the testing was automated. For the main functions which required keyboard inputs I did the testing manually since I was
unfamiliar with sending keys during automated testing. 

The calendar class was originally baked into the alternating strategies but it was difficult to debug whether the dates
were being set correctly. There was an issue using LocalDateTime in terms of picking a day for weekend rollover since as
far as my research went there was no way to set it to every Monday for example. 

Testing for rate strategies were written before the code since those are simple arithmetic checks however testing for 
the main or calendar was a bit more difficult since which those were subject to change as we developed. Generally the 
individual who implemented the code also wrote tests for it. 


### UML Diagram
------------------------------------------------------------------------------------------------
