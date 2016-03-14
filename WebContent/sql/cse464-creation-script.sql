USE `HMS` ; -- NOTE: Change this to the database schema that you are using!

-- -----------------------------------------------------
-- Table `Users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Users` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `FirstName` VARCHAR(45) NULL,
  `LastName` VARCHAR(45) NULL,
  `AddressLine1` VARCHAR(45) NULL,
  `AddressLine2` VARCHAR(45) NULL,
  `City` VARCHAR(45) NULL,
  `State` VARCHAR(45) NULL,
  `PostalCode` VARCHAR(45) NULL,
  `Type` TINYINT(1) NULL,
  `Status` TINYINT(2) NULL COMMENT 'Use this column to set the state of the user if needed. Optional.',
  `Username` VARCHAR(255) NOT NULL,
  `Password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hotels`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hotels` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(1024) NOT NULL,
  `City` VARCHAR(1024) NOT NULL,
  `State` VARCHAR(1024) NULL,
  `OwnerUserId` INT NULL,
  `Description` LONGTEXT NULL,
  `NearestPoints` LONGTEXT NULL,
  `Address` MEDIUMTEXT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC),
  INDEX `FK_Hotels_Users_idx` (`OwnerUserId` ASC),
  CONSTRAINT `FK_Hotels_Users`
    FOREIGN KEY (`OwnerUserId`)
    REFERENCES `Users` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Amenities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Amenities` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(1024) NOT NULL,
  `Description` LONGTEXT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelAmenities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelAmenities` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `HotelId` INT NULL,
  `AmenityId` INT NULL,
  `Value` TINYINT(1) NULL,
  PRIMARY KEY (`Id`),
  INDEX `FK_HoteAmenities_Amenities_idx` (`AmenityId` ASC),
  INDEX `FK_HotelAmenities_Hotel_idx` (`HotelId` ASC),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC),
  CONSTRAINT `FK_HotelAmenities_Hotel`
    FOREIGN KEY (`HotelId`)
    REFERENCES `Hotels` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_HoteAmenities_Amenities`
    FOREIGN KEY (`AmenityId`)
    REFERENCES `Amenities` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelReservations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelReservations` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `HotelId` INT NULL,
  `CheckInDate` DATE NULL,
  `CheckOutDate` DATE NULL,
  `NumberOfRooms` INT NULL,
  `ReservationNumber` CHAR(12) NULL DEFAULT '000000000000',
  `UserId` INT NULL,
  `TransactionId` INT NULL,
  `Status` INT NULL,
  `Notes` LONGTEXT NULL,
  `RoomTypeId` INT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC),
  INDEX `FK_HotelReservations_Hotel_idx` (`HotelId` ASC),
  INDEX `FK_HotelReservation_Users_idx` (`UserId` ASC),
  CONSTRAINT `FK_HotelReservations_Hotel`
    FOREIGN KEY (`HotelId`)
    REFERENCES `Hotels` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_HotelReservation_Users`
    FOREIGN KEY (`UserId`)
    REFERENCES `Users` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_HotelReservation_TransactionId`
    FOREIGN KEY (`TransactionId`)
    REFERENCES `Transactions` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CreditCards`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CreditCards` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `CardholderName` VARCHAR(255) NOT NULL,
  `CreditCardNumber` CHAR(20) NULL,
  `Balance` FLOAT NULL,
  `CardNickname` VARCHAR(45) NULL,
  `UserId` INT NULL,
  `CVV` CHAR(3) NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC),
  INDEX `FK_Accounts_Users_idx` (`UserId` ASC),
  CONSTRAINT `FK_Accounts_Users`
    FOREIGN KEY (`UserId`)
    REFERENCES `Users` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelRoomType`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelRoomType` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `RoomType` VARCHAR(255) NULL,
  `Description` VARCHAR(255) NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelRooms`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelRooms` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `RoomTypeId` INT NULL,
  `HoteId` INT NULL,
  `AvailableNumber` INT NULL,
  `PricePerNight` FLOAT NULL,
  `StartDate` DATETIME NULL,
  `EndDate` DATETIME NULL,
  PRIMARY KEY (`Id`),
  INDEX `FK_HotelRooms_Hotels_idx` (`HoteId` ASC),
  INDEX `FK_HotemRooms_RoomTypes_idx` (`RoomTypeId` ASC),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC),
  CONSTRAINT `FK_HotelRooms_Hotels`
    FOREIGN KEY (`HoteId`)
    REFERENCES `Hotels` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_HotemRooms_RoomTypes`
    FOREIGN KEY (`RoomTypeId`)
    REFERENCES `HotelRoomType` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `HotelReviews`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `HotelReviews` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `ReviewerName` VARCHAR(255) NULL,
  `ReviewDate` DATETIME NULL,
  `Rating` TINYINT(1) NULL,
  `Review` LONGTEXT NULL,
  `HotelId` INT NULL,
  PRIMARY KEY (`Id`),
  INDEX `FK_HotelReviews_Hotels_idx` (`HotelId` ASC),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC),
  CONSTRAINT `FK_HotelReviews_Hotels`
    FOREIGN KEY (`HotelId`)
    REFERENCES `Hotels` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Transactions`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `Transactions` (
  `Id` INT NOT NULL AUTO_INCREMENT, 
  `CustomerUserId` INT NOT NULL, 
  `OwnerUserId` INT NOT NULL, 
  `CustomerCreditCardId` INT NOT NULL, 
  `OwnerCreditCardId` INT NOT NULL,
  `Amount` FLOAT NOT NULL, 
  `Status` TINYINT(1), 
  `CancelledReservation` TINYINT(1),
  PRIMARY KEY (`Id`),
  
  CONSTRAINT `FK_CustomerUserId` 
    FOREIGN KEY (`CustomerUserId`) 
    REFERENCES `Users` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_OwnerUserId` 
    FOREIGN KEY (`OwnerUserId`) 
    REFERENCES `Users` (`Id`)
    ON DELETE NO ACTION	
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CustomerCreditCardId` 
    FOREIGN KEY (`CustomerCreditCardId`) 
    REFERENCES `CreditCards` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_OwnerCreditCardId` 
    FOREIGN KEY (`OwnerCreditCardId`) 
    REFERENCES `CreditCards` (`Id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;
