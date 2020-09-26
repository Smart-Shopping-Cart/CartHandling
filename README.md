# SmartCart #

this document describe our CartHandling server.

our team:
- Eden Dery
- Aviv Mund
- Yonatan Shemesh 
- Aviram Piletzki

# Discription #
The CartHandling is a server that written in Java, the server holds all the relevant database (carts, users, active clients and more).
The server knows how to receive requests from the app and knows how to give appropriate response using the relevant information it holds.
The server also knows how to receive messages from an recognition server written in Python that gives it updates on new products that have entered to active carts.
The role of the server is to maintain the database so that it is always up-to-date and correct, and to respond to the application to all its relevant requests.
The requests that the server knows to support are in the swagger we wrote.
 
#### Tecnologies ####
- `Maven`
- `Spring`
- `SpringBoot`

