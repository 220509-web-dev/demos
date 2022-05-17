set search_path to quizzard_app;

-- Create some base user roles
insert into user_roles (name) values ('ADMIN'), ('BASIC_USER'), ('PREMIUM_USER');

-- Create a new Quizzard user
insert into app_users (first_name, last_name, email, username, password, role_id)
values ('Tester', 'McTesterson', 'tester@revature.com', 'tester99', 'p4$$W0RD', 1);

-- Create some categories for flashcards
insert into categories (name) 
values ('UNIX'), ('Bash'), ('SQL');

-- Create some flashcards made by the newly created user
insert into flashcards (question_text, answer_text, difficulty, creator_id, category_id)
values 
  ('What does the ls command do?', 'Lists the contents of a directory', 1, 1, 1),
  ('What does the cd command do?', 'Navigates to another directory', 1, 1, 1),
  ('What does . refer to in a UNIX shell?', 'The current directory', 1, 1, 1),
  ('What does .. refer to in a UNIX shell?', 'The parent directory of the current directory', 1, 1, 1),
  ('What does ~ refer to in a UNIX shell?', E'The current user\'s home directory', 1, 1, 1),
  ('What does / refer to in a UNIX shell?', 'The root directory of the machine', 1, 1, 1),
  ('What is nano?', 'A terminal-based text editor', 2, 1, 1),
  ('How can you read only the last line of a file using tail?', 'tail -n 1 <file>', 3, 1, 1),
  ('What operator do you use to redirect output from one command as input to a subsequent command?', 'a pipe |', 2, 1, 1),
  ('What operator is used to redirect the standard input of a command?', '<', 1, 1, 1),
  ('What is the difference between > and >> in a UNIX shell?', '> is used to redirect output from a command to a file for overwriting. >> is used similarly, but will append to the file', 2, 1, 1),
  ('What does BASH stand for?', 'Bourne Again SHell', 1, 1, 2),
  ('What should be the first line of a good shell script?', 'A shebang followed by the path to the shell that should be used to run the script', 1, 1, 2),
  ('How can you access the third argument passed to a shell script?', '$3', 1, 1, 2),
  ('How can you access all of the arguments passed to a shell script easily?', '$*', 4, 1, 2),
  ('What are some types of conditional structures we can use in Bash?', 'if and case statements', 3, 1, 2),
  ('What are some types of looping structures we can use in Bash?', 'for and while loops', 3, 1, 2),
  ('Which is better for working with special characters: echo or printf?', 'printf', 3, 1, 2),
  ('What does SQL stand for?', 'Structured Query Language', 1, 1, 3),
  ('What are some keywords associated with DCL?', 'CREATE, DROP, ALTER, and TRUNCATE', 1, 1, 3),
  ('What are some keywords associated with DML?', 'INSERT, UPDATE, DELETE, and SELECT', 1, 1, 3),
  ('What are some keywords associated with DQL?', 'SELECT', 1, 1, 3),
  ('What are some keywords associated with DCL?', 'GRANT and REVOKE', 2, 1, 3),
  ('What are some keywords associated with TCL?', 'COMMIT, SAVEPOINT, and ROLLBACK', 1, 1, 3),
  ('What are some keywords associated with DML?', 'CREATE, DROP, ALTER, and TRUNCATE', 1, 1, 3),
  ('What are common constraints that are be applied tables and their columns?', 'UNIQUE, NOT NULL, CHECK, DEFAULT, PRIMARY KEY, FOREIGN KEY, and CREATE INDEX', 4, 1, 3);
	
-- Create study decks belonging to the new user
insert into study_decks (name, owner_id)
values 
  ('Tester UNIX Study Set', 1),
  ('Tester Bash Study Set', 1),
  ('Tester SQL Study Set', 1);

-- Add the new flashcards to the newly created study deck
insert into study_deck_cards 
values
  (1, 1), (1, 2), (1, 3), (1, 4), (1, 5), 
  (1, 6), (1, 7), (1, 8), (1, 9), (1, 10), 
  (1, 11), 
    
  (2, 12), (2, 13), (2, 14), (2, 15), (2, 16), 
  (2, 17), (2, 18), 
    
  (3, 19), (3, 20), (3, 21), (3, 22),  (3, 23), 
  (3, 24), (3, 25), (3, 26);
   
-- Get user by username
select * from app_users where username = 'tester99';

-- Get user by email
select * from app_users where email = 'tester@revature.com';

-- Get user by username and password 
select * from app_users where username = 'tester99' and password = 'p4$$W0RD';

-- Get flashcards where the rated difficult is greater than 1
select * from flashcards where difficulty > 1;


-- Get flashcards belonging to user with id 1 and sort them by their difficulty.
select * 
from flashcards
where creator_id = 1
order by difficulty; -- asc (ascending is implicity, use desc for descending order)
 






