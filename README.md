# Description
This is the basic structure to secure your web application behind the spring security context using Oauth.
Configuration provided for two popular social media and Exterprise application authorization servers.
1. Google Authorization server
2. Okta authorization server

# Getting Started

1. Before using OAuth with your application, you must register your application with the service. This is done through a registration form in the “developer” or “API” portion of the service’s website,
2. Once your application is registered, the service will issue “client credentials” in the form of a client identifier and a client secret. The Client ID is a publicly exposed string that is used by the service API to identify the application, and is also used to build authorization URLs that are presented to users. The Client Secret is used to authenticate the identity of the application to the service API when the application requests to access a user’s account, and must be kept private between the application and the API.
3. After creating client credentials, update application-okta.yml /  application-google.yml with client id and secret
4. Run your application : http://localhost:8080
5. To use Google authorization server, update application.yml file property
      spring:
        profiles:
          active: google
6. To use Okta authorization server, update application.yml file property 
      spring:
         profiles:
          active: okta
7. You will be redirected to appropriate login form.
