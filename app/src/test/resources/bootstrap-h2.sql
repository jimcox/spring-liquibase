-- Run the following script as sa

CREATE USER IF NOT EXISTS thedude PASSWORD 'secret';

ALTER USER thedude ADMIN TRUE;
CREATE SCHEMA IF NOT EXISTS demo AUTHORIZATION thedude;
