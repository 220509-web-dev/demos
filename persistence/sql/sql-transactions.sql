# Transactions
- Relational databases like SQL are very structured
  - The property of every single record is known
  - The relationships between records is well established
- The way we interact with these databases is also well structured
  - **Transactions** are the main way in which we communicate with a relational database
- A transaction is a SQL statement or series of SQL statements
  - A transactions might read, write, update, delete or do any combination to our tables

- Commited Data
  - Data that has been physically saved
    - Data that is 100% accepted as truth in the database
    - If power were to be shut off to the DB it would still exist
- With Transactions we often have statements that must be successful for follwing statements to make sense
- ACID Properties
  - **Atomic**
    - If a single SQL statement in a transaction fails 
    - EVERYTHING gets rolled back
    - All or nothing
    - Either every SQL statement is applied and saved or none of it
  - **Consistent**
    - Your database moves via qunatum leaps
    - Their is no commited midway point in a transaction
  - **Isolated**
    - In reality a databases might have dozens to thousands of transactions going on at the same time
      - It becomes near impossible to keep queries up to date with the latest information
      - 
  - **Durable**
    - Transaction fail gracelly.
    - A failing statement does not corrupt data or result in data loss


An inconsistency occurs when a single transactions works with data that *changes* over the course of a transaction
- Repeatable Read
```mermaid

    sequenceDiagram
        Transaction1 ->> EmployeeTable: Query Get all users (10 users total)
        Transaction2 ->> EmployeeTable: Add A new User
        Transaction1 ->> EmployeeTable: Query Get all users (11 users total)
 
```
- In Software there is always pros and cons
  - We could make transactions run in serial
    - One transaction at a time. 
    - This would prevent inconsistency issues from EVER occuring
    - This would be very slow
- We can trade off consistency for running transactions in parallel

Consistency Levels
- Read Uncommited
  - Not supported by most databases
  - Transactions can do ANYTHING at any time
  - **Dirty Reads** reading data that has not been committed
- Read Commited
  - Data is always commited when read
  - Might get outdated during the transaction
- Repeatable read
  - Any Data available at the begining of the data is available at the end
- Serial
  - Transaction run after each other impossible to be inconsistent


```sql

create table bank_account(
	account_id serial primary key,
	holder varchar(100),
	balance int check  (balance > 0)
);

select * from bank_account;

insert into bank_account values (default, 'Ranieri', 100000);

insert into bank_account values (default, 'Jim', 20000); -- jim is not saved physically in the database until he is committed
commit; -- Will commit/apply any  pending inserts/updates/changes to the database

rollback; -- go back to the last commit


-- Jim wants to transfer  $15,000  to Ranieri 
update bank_account set balance = 15000 + (select balance from bank_account where account_id = 1)  where account_id = 1;
update bank_account set balance = -15000 + (select balance from bank_account where account_id = 2)  where account_id = 2;

drop table bank_account;

create table loan(
	loan_id serial primary key,
	holder varchar(100),
	principal int,
	interest int
);


insert into loan values (default, 'Jim', 100000, 5);
insert into loan values (default, 'mark', 200000, 15);
insert into loan values (default, 'Laura', 1500, 2);
insert into loan values (default, 'Kevin', 2500, 3);
commit;

-- set operators allow us to stack tables vertically
-- helpful for when you have data in 2 tables that you want to treat query together but are inconvient to get via joins
select holder from loan
union all
select holder from bank_account;
-- unlike joins there are no predicates
-- The column has to be the same datatype and be the same amout of colums
select holder, account_id from bank_account 
union all
select holder, interest from loan;

-- Sub Queries or nested queries within queries
select * from loan where principal >= 10000

select holder from (select * from loan where principal >= 10000) as dummy;

```