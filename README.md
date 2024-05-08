# Solomon
A simple Spring Boot app for assessing code reviews.

## Running the app
It is not strictly necessary to run the app to perform the code review. However,
you may do so if it makes it easier for you to understand the code.

 1. Clone the git repository
 2. Make sure JDK 17+ is available on your `PATH`:
```
java -version
```
 3. From the repository root, run the app with Gradle:
```
./gradlew bootRun
```
 4. Access the REST endpoints with your browser or a tool like `curl`
   * [http://localhost:8080/hello](http://localhost:8080/hello)
   * [http://localhost:8080/customers](http://localhost:8080/customers)
   * [http://localhost:8080/customers/1](http://localhost:8080/customers/1)
   * [http://localhost:8080/customers/1/orders](http://localhost:8080/customers/1/orders)
   * [http://localhost:8080/orders](http://localhost:8080/orders)
