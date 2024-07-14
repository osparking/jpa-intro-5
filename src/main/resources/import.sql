insert into CUSTOMER(ID, CUST_NAME) VALUES (100, '최영미');
insert into CUSTOMER(ID, CUST_NAME) VALUES (101, '김정국');
insert into CUSTOMER(ID, CUST_NAME) VALUES (102, '안성기');

insert into SOAP_ORDER(ORDER_ID, SOAP_COUNT, CUSTOMER_ID) values(1, 5, 100);
insert into SOAP_ORDER(ORDER_ID, SOAP_COUNT, CUSTOMER_ID) values(3, 10, 100);
insert into SOAP_ORDER(ORDER_ID, SOAP_COUNT, CUSTOMER_ID) values(2, 3, 101);
insert into SOAP_ORDER(ORDER_ID, SOAP_COUNT, CUSTOMER_ID) values(4, 7, 101);
insert into SOAP_ORDER(ORDER_ID, SOAP_COUNT, CUSTOMER_ID) values(5, 1, 101);
