# Lab PayStationMain main program and rate strategies
## Team 03-libohova-zhou
### Requirements
------------------------------------------------------------------------------------------------
The requirements were to implement a main() program for Paystation which has a menu for the customer to interact with such as:

Deposit Coins, Display, Buy Ticket ,Cancel Empty(Admin), Change Rate Strategy (Admin)

The admin menu options to emtpy the Paystation or change the rate strategy. When there is a change in ratestrategy there will be a submenu that will show different city names with their respective rate strategies

The only coins that will be accepted are 5,10, and 25 cents. There will be a time shown on display when parking ticket is bought, prints a receipt/ when its canceled it will return the coins. 

There will also be ratestrategies for five clients

Linear1 for Alphatown , Progressive Rate for Betatown, Alternating 1 for GammaTown(weekdays: progressive + weekend:linear1), Linear2 rate for Deltatown(5c buy 1 minute), and Alernating 2 for Omegatown(weekedays:linear1 + weekend:free)

Lastly important to note is the alternating rate being a hybrid state dependeing on the day of the week. Linear1 rate applies for weekends and progressive applies for weekdays. To get the highest grade it is important to add for weekend rollover if a user enters a coin at 11:30 pm on Sunday, the first 30 min will be linear rate and any further will be progessive rate

### Teamwork
------------------------------------------------------------------------------------------------
We weren't picky on who did what and Steven picked Paystain main classes while Mario did RateStrategies. We split the work as much as possible with no rush and communicated through discord for any issues or concerns.Committed to Github and did pull requests to view each others code throughout the process

#### Steven worked on PayStation Main, AlternatingStrategy, WeekendRoll over, JUnit tests, UML, and ReadMe

#### Mario: I worked the Strategies so initilizaing RateStrategy then adding Linear, Progressive, Alternating, I typed part of the readMe and did part of the UML. Added JUnit test for Linear and Progressive



### Testing
------------------------------------------------------------------------------------------------
### UML Diagram
------------------------------------------------------------------------------------------------
