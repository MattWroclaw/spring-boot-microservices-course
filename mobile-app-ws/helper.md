1.  In project directory `mvn install`. This will compile, run tests and do `.jar` file. 
2. Springboot has already Tomcat embeded. 
3. When do `ls` there is a folder `target` that has `jar` file.  mobile-app-ws-0.0.1-SNAPSHOT.jar
4. Running jar `java -jar  mobile-app-ws-0.0.1-SNAPSHOT.jar` It will deploy the app to the embeded Tomcat
5. `mvn clean` removes the whole `\target` folder