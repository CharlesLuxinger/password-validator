# PASSWORD VALIDATOR API
API to validate password rules.

## Repository
- [Docker Hub](https://hub.docker.com/r/charlesluxinger/nu-authorizer)

## Technologies
- [Git & Bash](https://git-scm.com/downloads)
- [Maven 3.8.1](https://maven.apache.org/download.cgi)
- [Java 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Kotlin 1.5.21](https://kotlinlang.org/)
- [Docker 20.10.7](https://www.docker.com/products/docker-desktop)
- [Docker Compose 1.29.2](https://docs.docker.com/compose/install/)


## Instructions
### - Running
1) Verify if there are dependencies installed `Docker` and `Docker Compose`, it is not necessary install `Java`, `Kotlin` and `Maven`
2) In project root directory verify if `run.sh` have run permission
   ```shell
    $ ls -la
   ```
   ```
    -rwxrwxr-x 1 user user 86 Jul 15 10:20 run.sh
   ```
   2.1) Set run permission
   ```shell
   $ chmod +x run.sh
   ```
3) In root project file execute:
   ```shell
    $ ./run.sh
    ```
   
4) The Api Swagger is available in:
   ```
   http://localhost:8080/api/v1
   ```

5) Endpoint test is available in:
   ```
   http://localhost:8080/api/v1/password
   ```

### - Testing
   ```shell
   $ curl -X POST 'http://localhost:8080/api/v1/password' -d '{"password":"AbTp9!fok"}' -H 'Content-type: application/json'
   ```
* Request body:
   ```
   {
       "password": "AbTp9!fok"
   }
   ```
* Success Response payload:
  ```
   {
       "isValid": true
   }
   ```