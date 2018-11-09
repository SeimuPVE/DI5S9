cmake_minimum_required(VERSION 3.12)
project(BMP_with_lib)

set(CMAKE_CXX_STANDARD 14)

add_executable(BMP_with_lib
        lib/readme.txt
        platformio.ini src/main.cpp src/main.h)
