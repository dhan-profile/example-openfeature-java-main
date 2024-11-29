# DevCycle OpenFeature Java Server SDK Example App

An example app built using the [DevCycle Java OpenFeature Provider](https://docs.devcycle.com/sdk/server-side-sdks/java-local/java-local-openfeature)

## Requirements

Java 17+

## Creating a Demo Feature
This example app requires that your project has a feature with the expected variables, as well as some simple targeting rules. 

#### ⇨ [Click here](https://app.devcycle.com/r/create?resource=feature&key=hello-togglebot) to automatically create the feature in your project ⇦

When you run the example app and switch your identity between users, you'll be able to see the feature's different variations.

## Running the Example
### Setup

* Create a `.env` file and set `DEVCYCLE_SERVER_SDK_KEY` to your Environment's SDK Key.\
You can find this under [Settings > Environments](https://app.devcycle.com/r/environments) on the DevCycle dashboard.
[Learn more about environments](https://docs.devcycle.com/essentials/environments).

### Development

`./gradlew bootRun`

Runs the app in the development mode.\
Requests may be sent to [http://localhost:8080](http://localhost:8080).

## Documentation
For more information about using the DevCycle Java Server SDK, see [the documentation](https://docs.devcycle.com/sdk/server-side-sdks/java/)

### Additional Links
These additional references should also help you:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/gradle-plugin/reference/html/#build-image)
* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
