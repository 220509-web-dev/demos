-- Single line SQL comment

/*
  Multi
  line
  SQL
  comments
*/

-- establish a 'namespace' for related DB entities to exist within
create schema quizzard_app;

-- convenience command that will help us to reference the schema created above
set search_path to quizzard_app; 

create table user_roles (
  id    int generated always as identity primary key,
  name  varchar unique not null
);

create table app_users (
  id            int generated always as identity,
  first_name    varchar not null,
  last_name     varchar not null,
  email         varchar unique not null,
  username      varchar unique not null check (length(username) >= 4),
  role_id       int,

  constraint app_users_pk
  primary key (id)
);

alter table app_users
add column password varchar not null check (length(password) >= 8);

alter table app_users
add foreign key (role_id)
references user_roles(id);

create table categories (
  id    int generated always as identity primary key,
  name  varchar unique not null
);

create table flashcards (
  id                int generated always as identity primary key,
  question_text     varchar not null,
  answer_text       varchar not null,
  difficulty        int default 1 check (difficulty > 0 and difficulty <= 10),
  creator_id        int,
  category_id       int,

  constraint flashcard_creator_fk
  foreign key (creator_id)
  references app_users(id),

  constraint flashcard_category_fk
  foreign key (category_id)
  references categories(id)
);

create table study_decks (
  id             int generated always as identity primary key,
  name           varchar not null,
  owner_id       int,
  category_id    int,

  constraint study_deck_owner_fk
  foreign key (owner_id)
  references app_users(id),

  constraint study_deck_category_fk
  foreign key (category_id)
  references categories(id)
);

create table study_deck_cards (
  deck_id    int,
  card_id    int,

  constraint study_deck_cards_pk
  primary key (deck_id, card_id),

  constraint study_deck_fk
  foreign key (deck_id)
  references study_decks(id),

  constraint deck_card_fk
  foreign key (card_id)
  references flashcards(id)
);
