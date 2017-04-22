package main.dbsub;

import java.sql.SQLException;

/**
 * Created by Dora on 4/21/2017.
 */
public class GeneateDBImpl implements IGenerateDB {

    private final String CREATE_DATABASE = "CREATE DATABASE IF NOT EXISTS " + Database.DATABASE_NAME;

    private final String CREATE_TABLE_ACCOUNT = "CREATE TABLE IF NOT EXISTS account (" +
            "idAccount INT NOT NULL AUTO_INCREMENT," +
            "username VARCHAR(50) NOT NULL," +
            "password VARCHAR(50) NOT NULL," +
            "status VARCHAR(20) NOT NULL," +
            "userRole VARCHAR(50) NOT NULL," +
            "accountStatus VARCHAR(50) NOT NULL," +
            "PRIMARY KEY (idAccount)" +
            ")";

    private final String CREATE_TABLE_ADDRESS = "CREATE TABLE IF NOT EXISTS address (" +
            "idAddress INT NOT NULL AUTO_INCREMENT," +
            "zip VARCHAR(10) NULL," +
            "street VARCHAR(255) NULL," +
            "city VARCHAR(100) NULL," +
            "state VARCHAR(100) NULL," +
            "country VARCHAR(100) NULL," +
            "PRIMARY KEY (idAddress)" +
            ")";
    private final String[] generateTableScripts = new String[]{
            "CREATE TABLE IF NOT EXISTS account (" +
                    "idAccount INT NOT NULL AUTO_INCREMENT," +
                    "username VARCHAR(50) NOT NULL," +
                    "password VARCHAR(50) NOT NULL," +
                    "status VARCHAR(20) NOT NULL," +
                    "userRole VARCHAR(50) NOT NULL," +
                    "accountStatus VARCHAR(50) NOT NULL," +
                    "PRIMARY KEY (idAccount)" +
                    ")Engine=InnoDB",

            "CREATE TABLE IF NOT EXISTS address (" +
                    "idAddress INT NOT NULL AUTO_INCREMENT," +
                    "zip VARCHAR(10) NULL," +
                    "street VARCHAR(255) NULL," +
                    "city VARCHAR(100) NULL," +
                    "state VARCHAR(100) NULL," +
                    "country VARCHAR(100) NULL," +
                    "PRIMARY KEY (idAddress)" +
                    ")Engine=InnoDB",

            "CREATE TABLE IF NOT EXISTS employee (" +
                    "idEmployee INT NOT NULL AUTO_INCREMENT," +
                    "firstName VARCHAR(100) NULL," +
                    "middleName VARCHAR(100) NULL," +
                    "lastName VARCHAR(100) NULL," +
                    "email VARCHAR(100) NULL," +
                    "DOB DATE NULL," +
                    "SSN VARCHAR(50) NULL," +
                    "idAddress INT NULL," +
                    "phone1 VARCHAR(20) NULL," +
                    "phone2 VARCHAR(20) NULL," +
                    "status VARCHAR(20) NOT NULL," +
                    "PRIMARY KEY (idEmployee)," +
                    "FOREIGN KEY (idAddress) REFERENCES address(idAddress)" +
                    "   ON DELETE SET NULL" +
                    "   ON UPDATE CASCADE" +
                    ")Engine=InnoDB",

            "CREATE TABLE IF NOT EXISTS roomtype (" +
                    "idRoomType INT NOT NULL AUTO_INCREMENT," +
                    "description VARCHAR(255) NULL," +
                    "maxCapacity INT NULL," +
                    "status VARCHAR(20) NOT NULL," +
                    "PRIMARY KEY (idRoomType)" +
                    ")Engine=InnoDB",

            "CREATE TABLE IF NOT EXISTS room (" +
                    "idRoom INT NOT NULL AUTO_INCREMENT," +
                    "roomName VARCHAR(100) NULL," +
                    "roomNumber VARCHAR(20) NULL," +
                    "roomStatus VARCHAR(20) NOT NULL," +
                    "floor INT NOT NULL," +
                    "description VARCHAR(255) NULL," +
                    "idRoomType INT NULL," +
                    "maxQuest INT NULL," +
                    "status VARCHAR(20) NOT NULL," +
                    "price FLOAT NULL," +
                    "PRIMARY KEY (idRoom)," +
                    "FOREIGN KEY (idRoomType) REFERENCES roomtype(idRoomType)" +
                    "   ON DELETE SET NULL" +
                    "   ON UPDATE CASCADE" +
                    ")Engine=InnoDB",

            "CREATE TABLE IF NOT EXISTS facility (" +
                    "idFacility INT NOT NULL AUTO_INCREMENT," +
                    "description VARCHAR(255) NULL," +
                    "quantity INT NULL," +
                    "status VARCHAR(20) NOT NULL," +
                    "idRoom INT NULL," +
                    "PRIMARY KEY (idFacility)," +
                    "FOREIGN KEY (idRoom) REFERENCES room(idRoom)" +
                    "   ON DELETE SET NULL" +
                    "   ON UPDATE CASCADE" +
                    ")Engine=InnoDB",

            "CREATE TABLE IF NOT EXISTS guest (" +
                    "idGuest INT NOT NULL AUTO_INCREMENT," +
                    "firstName VARCHAR(100) NULL," +
                    "middleName VARCHAR(100) NULL," +
                    "lastName VARCHAR(100) NULL," +
                    "idCard VARCHAR(50) NULL," +
                    "passport VARCHAR(50) NULL," +
                    "idAddress INT NULL," +
                    "phone VARCHAR(20) NULL," +
                    "PRIMARY KEY (idGuest)," +
                    "FOREIGN KEY (idAddress) REFERENCES address(idAddress)" +
                    "   ON DELETE SET NULL" +
                    "   ON UPDATE CASCADE" +
                    ")Engine=InnoDB",

            "CREATE TABLE IF NOT EXISTS reservation (" +
                    "idReservation INT NOT NULL AUTO_INCREMENT," +
                    "checkInDate DATE NOT NULL," +
                    "checkOutDate DATE NOT NULL," +
                    "bookedDate DATE NOT NULL," +
                    "idGuest INT NULL," +
                    "idRoom INT NULL," +
                    "reservationStatus VARCHAR(20) NOT NULL," +
                    "PRIMARY KEY (idReservation)," +
                    "FOREIGN KEY (idGuest) REFERENCES guest(idGuest)" +
                    "   ON DELETE SET NULL" +
                    "   ON UPDATE CASCADE," +
                    "FOREIGN KEY (idRoom) REFERENCES room(idRoom)" +
                    "   ON DELETE SET NULL" +
                    "   ON UPDATE CASCADE"+
                    ")Engine=InnoDB",

            "CREATE TABLE IF NOT EXISTS reservationhistory (" +
                    "idReservationHistory INT NOT NULL AUTO_INCREMENT," +
                    "idReservation INT NULL," +
                    "idAccount INT NULL," +
                    "actionStatus VARCHAR(20) NOT NULL," +
                    "modifiedState VARCHAR(20) NOT NULL," +
                    "PRIMARY KEY (idReservationHistory)," +
                    "FOREIGN KEY (idReservation) REFERENCES reservation(idReservation)" +
                    "   ON DELETE SET NULL" +
                    "   ON UPDATE CASCADE," +
                    "FOREIGN KEY (idAccount) REFERENCES account(idAccount)" +
                    "   ON DELETE SET NULL" +
                    "   ON UPDATE CASCADE" +
                    ")Engine=InnoDB",

            "CREATE TABLE IF NOT EXISTS package (" +
                    "idPackage INT NOT NULL AUTO_INCREMENT," +
                    "name VARCHAR(100) NULL," +
                    "price FLOAT NULL," +
                    "idReservation INT NULL," +
                    "PRIMARY KEY (idPackage)," +
                    "FOREIGN KEY (idReservation) REFERENCES reservation(idReservation)" +
                    "   ON DELETE SET NULL" +
                    "   ON UPDATE CASCADE" +
                    ")Engine=InnoDB",

    };

    private IDatabase iDatabase = null;

    public GeneateDBImpl() {
        iDatabase = Database.getInstance();
    }

    @Override
    public void generateDB() {
        try {
            this.iDatabase.openConnectionForGenerateDB();
            this.iDatabase.executeUpdateWithConnectionOn(CREATE_DATABASE);
            for (int i = 0; i < generateTableScripts.length; i++) {
                this.iDatabase.executeUpdate(generateTableScripts[i]);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.iDatabase.closeConnection();
        }

    }
}
