#!/bin/bash

welcome() {
  printf "Welcome to Quizzard!\nPlease select from the following options:\n"

  echo "1) Register"
  echo "2) Login"
  echo "3) Exit"
}

register() {
  echo "Please provide us with some basic information to complete your registration"
  read -p "First name: " firstname
  read -p "Last name: " lastname
  read -p "Email address: " email
  read -p "Username: " username
  read -p "Password: " password
  echo "$firstname,$lastname,$email,$username,$password" >> data.csv
}

login() {
  echo "Please provide your username and password to login to your account"
  read -p "Username: " username
  read -p "Password: " password

  exec < data.csv
  read header
  while IFS="," read -r first last email user pass; do
    if [ $user = $username ] && [ $pass = $password ]; then
      echo "Record found: $f,$l,$e,$u,$p"
      exit 0
    fi
  done

  echo "No record found with provided credentials!"

}

################

validSel=1
while [ $validSel -eq 1 ]; do

  welcome
  read selection

  if [ $selection = "1" ]; then
    validSel=0
    register
  elif [ $selection = "2" ]; then
    validSel=0
    login
  elif [ $selection = "3" ]; then
    echo "Exiting application"
    validSel=0
    exit 0
  else
    echo "Invalid selection, please try again."
  fi
done

