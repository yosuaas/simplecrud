CREATE SCHEMA IF NOT EXISTS employee;

CREATE TABLE employee.m_employee
(
	"ID" uuid NOT NULL,
    "NIK" varchar(16) NULL,
	"NAME" varchar(255) NULL,
	"ADDRESS" varchar(255) NULL,
	"DOB" timestamp NULL,
    "CREATED_DATE" timestamp NULL,
    "LAST_UPDATE" timestamp NULL,
	CONSTRAINT m_employee_pkey PRIMARY KEY ("ID")
);