# Getting Started

### Prerequisites
To run this code, you would need Java 8, Gradle and Docker installed on your machine. Please refer to the official documentation links below

* [How do I intall Java](https://java.com/en/download/help/download_options.xml)
* [Official Gradle documentation](https://docs.gradle.org)
* [Official Docker documentation](https://docs.docker.com/get-docker/)

### Steps to run the code
* Clone the project from github.com. Open terminal and enter command:  
    ``git clone https://github.com/snigdhamajumdar/nyc-cab-demo.git``
* cd into the project directory
* Import the sql file containing the db set up and copy it into the same directory as the project(if not present)
* Create dockerized mysql container (NOTE: Following steps take a while to execute):  
    * Open a new tab on the terminal and start a mysql container on docker using command below:   
        ``docker run --name docker-mysql -it -p 3306:3306 --env="MYSQL_ROOT_PASSWORD=root" --env="MYSQL_PASSWORD=root" --env="MYSQL_DATABASE=test" mysql``
    * Open a new tab on the terminal and Import data from the sql file  
        ``docker exec -i docker-mysql mysql -uroot -proot test < ny_cab_data_cab_trip_data_full.sql;``
* Open a new tab on terminal and build the project using gradle  
    ``./gradlew clean build``        
* Open a new tab on terminal and Create docker image of the application  
    ``docker build -f Dockerfile -t spring-boot-docker .``  
* Run the Dockerized app while linking it to mysql  
    ``docker run -t --name spring-boot-docker --link docker-mysql:mysql -p 8080:8080 spring-boot-docker``
* For testing the trip count functionality, type following curl command on terminal  
  ``curl -d '{"cabIdList" : ["B1D2DCC51A1C8DE4F6C985B00DFA6CC7", "BCEB2F048FCA6F2DB11E275E6B892E15", "AC75A3C9F78D23C2A6486E80C865BA4C"], "pickUpDate" : "2013-12-31", "skipCache":false}' -H 'Content-Type: application/json' -X POST http://localhost:8080/trip/countAll``
* For testing the clear cache functionality, type following curl command on terminal:
    ``curl -X "DELETE" http://localhost:8080/admin/application/cache``


