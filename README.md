University project for JavaEE stuff
================================================================================

We use

 * maven
 * jaxws
 * jaxb
 * spring
 * hibernate
 * gwt

Milestone 2
================================================================================

Instrcutions

 * create a tunnel to our DB
 * run "mvn clean package" to create the one jar file
 * run web service with "java -jar target/mydoodle-0.1.one-jar.jar"
 * ignore the warnings (http://stackoverflow.com/questions/3662659/one-jar-remove-verbose-warning-information-on-application-load/3908716#3908716)
 * remove the "@Ignore" statements from "src/test/java/de/uniluebeck/itm/ep5/poll/service/PollWebServiceClientTest.java" and run "mvn test" to test the client automatically
 * or test it with curl (see below)

Additional Info
================================================================================

To test service with curl use the following commands, but make sure you change
the data in the test files. In any case, change the IDs in the vote.xml,
because option IDs are random!

	curl -H "Accept: text/xml" -H "Content-Type: text/xml;charset=UTF-8" -v -d @src/test/resources/poll.xml http://localhost:8080/poll/getPoll
	curl -H "Accept: text/xml" -H "Content-Type: text/xml;charset=UTF-8" -v -d @src/test/resources/polls.xml http://localhost:8080/poll/getPolls
	curl -H "Accept: text/xml" -H "Content-Type: text/xml;charset=UTF-8" -v -d @src/test/resources/vote.xml http://localhost:8080/poll/voteForOptions
