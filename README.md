
-- DATA
The application builds on a hsqldb in file mode. To start that db, use following command:
Database command:
java -classpath hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/demodb --dbname.0 testdb

If the DB has not already been created, this will setup the db
To connect to the database, the h2 manager can be used. Go to the installation folder and run the runManager

Driver
org.hsqldb.jdbc.JDBCDriver
url
jdbc:hsqldb:hsql://localhost/testdb

Spring JPA will initialize the database to match the JPA annotation in the application.