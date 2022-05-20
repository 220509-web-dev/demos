-- creates a new user with the username 'wezley' and password 'revature'
-- this user can use the credentials to connect to the database
create user wezley 
with password 'revature';

-- use this command to drop a created user
drop user wezley;

-- grants the specified user the ability to connect/access the specified schema
-- as well as the ability to create objects (tables, views, etc.) in that schema
grant all privileges 
on schema quizzard_app 
to wezley;

-- grants the specified user the ability to insert, select, update, and delete 
-- commands on all the tables in the specified schema
grant select, insert, update, delete
on all tables in schema quizzard_app 
to wezley;

-- granted privileges can be revoked as well
revoke select, insert, update, delete
on all tables in schema quizzard_app 
from wezley;

-- you can grant a user permission to as many or as few commands as you'd like
grant select 
on all tables in schema quizzard_app 
to wezley;
