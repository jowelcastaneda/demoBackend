# dppr

One Paragraph of project description goes here

## Integrate to Cloud Config Server

This application is configured to load it's configuration data from the internal Spring Cloud Config Server. 
The configuration server loads it's data from gitlab repositories under the [SpringCloudConfig](http://gitlab.ad.corelogic.asia/SpringCloudConfig) group.
 
### Create configuration repository
 
 1. Execute script to create a new repository.
 
     ```bash
    ./scripts/create-config-repo.sh ADMIN_USER_PASSWORD GITLAB_ACCT_ACCESS_TOKEN GITLAB_USERNAMES
    ```
    _ADMIN_USER_PASSWORD_ - username and password of config server admin user. Formatted as follows :- username:password
    _GITLAB_ACCT_ACCESS_TOKEN_ - Your users gitlab account access token.
    _GITLAB_USERNAMES_ - Comma separated list of usernames to associate to the new repoistory
    
    This will create the following gitlab repository: http://gitlab.ad.corelogic.asia/SpringCloudConfig/dppr-config this is where you
     will find instructions on encrypting config values.
    

2. Configure Developer Machine
    Developers will need to add the following environment variable in order for the application to have access to
    the config server from their local environment.

    ```
    CONFIG_SERVER_URI=http://ava:$PASSWORD@configserver-dev.apps.ad.corelogic.asia
    ```
 
 ## Getting Started
 
 These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
 
 ### Prerequisites
 
 What things you need to install the software and how to install them
 
 ```
 Give examples
 ```
 
 ### Installing
 
 A step by step series of examples that tell you how to get a development env running
 
 Say what the step will be
 
 ```
 Give the example
 ```
 
 And repeat
 
 ```
 until finished
 ```
 
 End with an example of getting some data out of the system or using it for a little demo
 
 ## Running the tests
 
 Explain how to run the automated tests for this system
 
 ### Break down into end to end tests
 
 Explain what these tests test and why
 
 ```
 Give an example
 ```
 
 ### And coding style tests
 
 Explain what these tests test and why
 
 ```
 Give an example
 ```
 
 ## Deployment
 
 Add additional notes about how to deploy this on a live system
 
 ## Built With
 
 * [SpringBoot](https://spring.io/projects/spring-boot) - The web framework used
 * [Maven](https://maven.apache.org/) - Dependency Management


 
 