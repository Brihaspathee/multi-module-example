#!/bin/bash
echo "Hello I am inside the main script"
mvn clean package
cd customer_management
source docker_build.sh
cd ..
cd order_processing
source docker_build.sh
cd ..
cd product_management
source docker_build.sh
cd ..


