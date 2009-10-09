#!/bin/bash
MACHINE_TYPE=`uname -m`
if [ ${MACHINE_TYPE} == 'x86_64' ]; then
    echo Executing 64 bit version
    LD_LIBRARY_PATH=linux64 java -jar ttt.jar
else
    echo Executing 32 bit version
    LD_LIBRARY_PATH=linux32 java -jar ttt.jar
fi
