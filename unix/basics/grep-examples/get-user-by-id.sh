#!/bin/bash

ID=$1

if [ $ID -gt 0 ]; then
  sh parser.sh ./mock-data.csv | grep -A7 "Id: $ID$";
else
  >&2 echo "Invalid id provided! Cannot be less than 1!"
fi
