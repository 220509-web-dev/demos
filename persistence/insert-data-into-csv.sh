#!/bin/bash

read -p "Question text: " qText
read -p "Answer text: " aText

id=$(tail -n 1 data.csv | cut -d',' -f1)
id=$(expr $id + 1)

echo "$id,$qText,$aText" >> data.csv
