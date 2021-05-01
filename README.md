# weather service
Weather Information Service REST API

## Teck stack

- java 11
- mvn 3.2.x
- spring-boot 2.4.5
- Server : Embedded Tomcat

## install && excute

## Running the application locally

### Creating jar and running the jar file

```bash
$ git clone https://github.com/bincip/weatherservice.git

$ mvn clean
$ mvn install
```

This will generate  target folder and weatherservice-1.0.0.jar file inside the folder.

- Run the jar file with the command "java -jar weatherservice-1.0.0.jar".
- Application will start running on port 8080.

- Swagger auto generated API documentation URL : http://baseurl:port/swagger-ui.html#/ eg: http://localhost:8080/swagger-ui.html
- Open API documentaion available at : http://localhost:8080/v2/api-docs

### Creating docker image and run

```bash
$ git clone https://github.com/bincip/weatherservice.git

$ mvn clean
$ mvn install

$ docker build ./

$ docker images

$ docker run -it -p8080:8080 <image-id>
```
- Application will start running on port the tomcat configured port.
