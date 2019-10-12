# FirstAPISpringMySQL

This API store and provide information for the market of primed mods of the game Warframe. In this API is implemented a CRUD.
It uses spring with hibernate to connect to a MySQL database.

This api is used by ionicMarketApp. 

##### Something that I didn´t learn from class

- There is a searcher filter, ergo, It shows all mods that constains n number or characters in their names.
- The update method is transactional, so if there is a problem with the database while the request is procesing It won´t change anything.

Postman: https://documenter.getpostman.com/view/8800421/SVtR2qLa
