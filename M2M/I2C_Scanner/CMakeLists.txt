cmake_minimum_required(VERSION 3.12)
project(I2C_Scanner)

set(CMAKE_CXX_STANDARD 14)

add_executable(I2C_Scanner
        lib/readme.txt
        src/main.ino
        platformio.ini)
