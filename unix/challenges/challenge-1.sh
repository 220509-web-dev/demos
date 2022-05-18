#!/bin/bash

# Print welcome menu and display menu options
printf "Welcome to Quizzard!\nPlease select from the following options:\n"
echo "1) Register"
echo "2) Login"
echo "3) Exit"

# Get user menu selection and determine which option they picked
read selection

if [ $selection = "1" ]; then

  # Prompt the user for registration data and print it out to data.csv
  echo "Please provide us with some basic information to complete your registration:"
  read -p "First name: " first
  read -p "Last name: " last
  read -p "Email address: " email
  read -p "Username: " username
  read -p "Password: " password

  echo "$first,$last,$email,$username,$password" >> data.csv

elif [ $selection = "2" ]; then

  # Prompt the user for credentials
  echo "Please provide your username and password to login to your account"
  read -p "Username: " un
  read -p "Password: " pw

  # Read each line of data.csv and see if there are any records with matching credentials
  while IFS="," read -r f l e u p; do
    if [ $u = $un ] && [ $p = $pw ]; then
      echo "Record found: $f,$l,$e,$u,$p"
      exit 0
    fi
  done < data.csv

  echo "No record found using provided credentials!"
  exit 1

elif [ $selection = "3" ]; then
  echo "Closing application"
  exit 0
else
  echo "Invalid selection!"
fi
