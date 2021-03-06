

-- change this to your team id
use FTP125;

-- comment this line for the very first time
drop table if exists EMPLOYEE;

-- create the table
CREATE TABLE EMPLOYEE (
EMP_ID INT PRIMARY KEY, 
EMP_NAME VARCHAR(50), 
PH_NO bigint, 
EMP_EMAIL VARCHAR(40), 
DEPT_NO INT, 
LEAVE_BALANCE INT, 
MANAGER_ID INT, 
FOREIGN KEY(MANAGER_ID ) REFERENCES EMPLOYEE(EMP_ID)
);


CREATE TABLE LEAVE_DETAILS (
LEAVE_ID INT PRIMARY KEY AUTO_INCREMENT, 
LEAVE_TYPE ENUM('EL','LOP','SICK_LEAVE'), 
START_DATE DATE,
END_DATE DATE,
NO_OF_DAYS INT, 
LEAVE_STATUS ENUM('PENDING','APPROVED','DENIED'), 
REASON VARCHAR(50), 
MANAGER_COMMENTS VARCHAR(50), 
EMP_ID INT, 
FOREIGN KEY(EMP_ID ) REFERENCES EMPLOYEE(EMP_ID)
);

--for sqlite database creation
CREATE TABLE LEAVE_DETAILS (
LEAVE_ID INT PRIMARY KEY AUTO_INCREMENT, 
LEAVE_TYPE ENUM('EL','LOP','SICK_LEAVE'), 
START_DATE DATE,
END_DATE DATE,
NO_OF_DAYS INT, 
LEAVE_STATUS ENUM('PENDING','APPROVED','DENIED'), 
REASON VARCHAR(50), 
MANAGER_COMMENTS VARCHAR(50), 
EMP_ID INT, 
FOREIGN KEY(EMP_ID ) REFERENCES EMPLOYEE(EMP_ID)
);