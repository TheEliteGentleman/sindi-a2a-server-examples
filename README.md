# sindi-a2a-server-examples
The Jakarta EE A2A server example that you try out.

## Prerequisites
- Java 25 and higher.
- Maven 3.9.14 and higher.
- Gemini API key.

This examples can be run with either:
- GlassFish Embedded, or
- OpenLiberty

There are 2 A2A agents that you can play with, each on their Maven sub module:
- `content-editor-agent`, or
- `content-writer-agent`.

Each of the module will contain a CDI producer class `ChatModelProducer`. Add your Gemini API key where it's dictated on the code.


## Building this example:
First, go into the code, build this project example:

```
mvn clean install -e
```

## Running the example using GlassFish Embedded
First, select the example project:
- `content-editor-agent`, or
- `content-writer-agent`.

Once the build completes, `cd target/dependencies`.

Then run the following command (will be using Windows like command, but for *nix or Apple OSes, you know what to do.
This example runs `content-writer-agent` A2A agent. The command is a Windows based command, running on Command Prompt:

```
java -Djavax.net.ssl.trustStore="%JAVA_HOME%\lib\security\cacerts" -jar glassfish-embedded-all.jar ..\..\content-writer-agent\target\content-writer-agent.war
```

Full example:

```
D:\<user-account>\...\sindi-a2a-server-examples\target\dependencies>java -Djavax.net.ssl.trustStore="%JAVA_HOME%\lib\security\cacerts" -jar glassfish-embedded-all.jar ..\..\content-writer-agent\target\content-writer-agent.war
```

Once running, go to the `sindi-a2a-client-example` project and run the `A2AClientExample` class and view the result.

