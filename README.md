# outdoorSmartOven
Full stack project combining BE-java Spring, Ts-React and Dockers

My project is an IoT software for a smart outdoor oven. The goal is to connect the temperature controller of the oven to the user by creating a progressive web app and android app.

Back end: 
The software receives data from the oven controller board and use Kafka for data storage and data analysis.

Front end:
Usage of pre-programmed data and creation of new data by the user (creation of new recipes).
The user will be able to:
Create an account.
Use a cooking/smoking pre-programed process.
Create his own process (recipe) by entering data such as final meat internal temperature (R, MW, WD), oven temperature, cooking timer and marinade spray intervals.

Through the app the user will be able to start the cooking  process, receive reminders and updates about the cooking stage and stop/turn off the oven if desired.
In the future the option to share new recipes with the Carnivore Club community.

Technologies and frameworks

Back end: 
Java -Spring framework.
Tools: Kafka, JWT security and Junit testing.
Deploy technology: Docker.
Additional technologies: API's and RESTful web services.

Front end:
Js-Ts - React (Es6) Framework.
Tools: Redux (for local memory), Kafka and Redis.
Additional: Andoid studio to create the android App.
Js and CSS languages. 


