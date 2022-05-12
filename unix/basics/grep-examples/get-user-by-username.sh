#!/bin/bash

sh parser.sh ./mock-data.csv | grep -A1 -B6 "Username: $1$";
