import mysql.connector
from mysql.connector import errorcode

db_connection = mysql.connector.connect(host='localhost', user='root', password='Oicueio1!@#$', database='supermercado')



db_connection.close()