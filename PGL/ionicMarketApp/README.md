# ionicMarketApp

This app is a project from class wich represents a market of primed mods from the game Warframe (still in development).
The app is connected to a spring server (you have to change your IP each time It changes). 
In this app is implemented a CRUD.

This APP is connected to FirstAPISpringMySQL. 

##### Something that I didn´t learn from class

- All methods are asynchronous.
- It was used a ngOnInit() method to show the list of mods.
- Each item in the list has It´s own icons where you can interact with them (modify, delete, increase/decrease quantity).
- It was used ToastController to show the user if the modify/delete has been done correctly or if the user write something wrong.
- The use of regular expressions to check if the user write a number on the name.
- Each time the user does anything of the CRUD the view of the list refresh and It will refresh only what the user was watching, ergo, 
    if the user used the filter It will refresh only that view.





