-- a query involving multiple joins
-- what it does: 
--   grabs flashcard id, question, answer, and difficulty
--   grabs name of each flashcard's category 
--   grabs the username of the flashcard's creator
--   where the flashcard's category id is = 2

select 
  f.id,
  f.question_text,
  f.answer_text,
  f.difficulty,
  c.name as category,
  au.username as creator
from flashcards f
join categories c 
on f.category_id = c.id
join app_users au 
on f.creator_id = au.id
where f.category_id = 2;

-- what is the average difficulty of all the flashcards in the database?
select 
  avg(difficulty)
from flashcards f;

-- Count the number of flashcards in each category
select count(*), c.name
from flashcards f 
join categories c 
on f.category_id = c.id
group by c.name;

-- Get the average flashcard difficulty of each category
-- and round the displayed average to 2 decimal places
select 
  round(avg(difficulty), 2) as average_difficulty, 
  c.name 
from flashcards f 
join categories c 
on f.category_id = c.id 
group by c.name;

-- Get the max flashcard difficulty of each category
select 
  max(difficulty) as max_difficulty,
  c.name
from flashcards f 
join categories c 
on f.category_id = c.id 
group by c.name;
