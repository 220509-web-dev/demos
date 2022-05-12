#!/bin/bash

exec < $1 # this line is for convenience, so we don't have to constantly refer to the file passed as an arg
read header # reads/skips the first line of the file (the data from that line is stored in a var named 'header')

# Creates a looping structure that allows us to iterate over the contents of the file
# while reading each line and storing data in the specified variable names
while IFS="," read -r id fname lname email gndr dob un pw
do
  echo "Id: $id"
  echo "First name: $fname"
  echo "Last name: $lname"
  echo "Email address: $email"
  echo "Gender: $gndr"
  echo "Date of birth: $dob"
  echo "Username: $un"
  echo "Password: $pw"
  printf "\n"
done
