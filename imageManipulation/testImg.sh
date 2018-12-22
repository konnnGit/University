#!/bin/bash


directory=$1 #1st argmnt
referenceDimention=$2 #2nd argmnt
if   [ -z $directory  ]; then 
 echo you forgot the 1st argument, exiting...
 exit 0
  fi
  if   [ -z $referenceDimention  ]; then 
 echo you forgot the 2nd argument, exiting...
 exit 0
  fi
for filename in $directory*.jpg; 
do
 width=$(identify  -format  "%w"  $filename)
 height=$(identify  -format  "%h"  $filename)
 echo filename is $filename :
 echo the width is $width
 echo the height is $height
 
 if   [ $width -lt $referenceDimention ]; then 
 echo "that is NOT" due to width
  fi
 if   [ $height -lt $referenceDimention ]; then 
 echo "that is NOT" due to height
  fi
 done
 exit 0
