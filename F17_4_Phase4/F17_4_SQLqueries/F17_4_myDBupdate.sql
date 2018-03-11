----------------------------------TABLE UPDATES---------------------------------

---Query to add new doctor---
INSERT INTO DOCTOR_INFO 
    VALUES('MAC81','AKD^924','MARGE','CONNER','82003.00','FAMILY PRACTICE','7931830485',TO_DATE('2017-12-05','YYYY-MM-DD'),'01:00','MAC81');

---Query to add new registration staff---
INSERT INTO RECEPTIONIST_INFO 
    VALUES('LEX10','VBS^262','LEXIE','MATHERSON','25210.00');
    
---Query to add new patient---
INSERT INTO PATIENT_INFO 
    VALUES('JEB','RAWLINS','MALE','2149301828','LADYBIRD','BEAUMONT','TEXAS','77707','891940177','100016','RABIES VACCINE','20','NO',NULL,NULL,NULL,NULL,'MAC81','KYL44','DEB78','JMS09');
INSERT INTO REGISTRATION_DETAILS
    VALUES('RABIES VACCINE', 'FAMILY PRACTICE', 105, 'OWN VEHICLE', '891940177', '100016');
INSERT INTO DIAGNOSIS_DETAILS
    VALUES('12136', 'VACCINE', '50.00', 'RABIES', '891940177', '100016');
INSERT INTO TREATMENT_DETAILS 
    VALUES(TO_DATE('2017-12-05','YYYY-MM-DD'),'MAC81','891940177','100016'); 
    
---Update nurse username---
UPDATE
    NURSE_INFO
SET
    NRS_UNAME = 'REB88'
WHERE
    NURSE_INFO.FIRST_NAME = 'REBECCA' AND NURSE_INFO.LAST_NAME = 'MARTINEZ';
    
---Update patient's doctor---
UPDATE
    PATIENT_INFO
SET
    P_FK_DOC_UNAME = 'MAC81'
WHERE
    PID = '100006';

---Query to update doctor phone number---
UPDATE	
    DOCTOR_INFO
SET 	
    PHONE# = '9381939177'
WHERE	
    DOC_UNAME = 'RAM32';

---Query to increase all nurse salary by 4%---
UPDATE	
    NURSE_INFO
SET	
    SALARY = SALARY * 1.04;

---Query to increase dermatology doctor salary by 20%---
UPDATE
    DOCTOR_INFO
SET
    SALARY = SALARY * 1.20
WHERE
    SPECIALTY = 'DERMATOLOGY';

---Deleting an doctor---
DELETE FROM
    DOCTOR_INFO
WHERE
    DOC_UNAME = 'JAS15';


