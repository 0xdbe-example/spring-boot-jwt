# Spring Boot JWT

This project is a Spring Boot application that uses ``spring-boot-starter-oauth2-resource-server`` to configure access control by JWT.

## Install

- Setup env vars (example using Auth0)

````
export AUTHO_TENANT=dev-1zstk7h6
export OAUTH2_ISSUER_URI=https://${AUTHO_TENANT}.eu.auth0.com/
export OAUTH2_JWKS_URI=https://${AUTHO_TENANT}.eu.auth0.com/.well-known/jwks.json
````

- Run

````
./gradlew bootRun
````

## Usage

- Get token using, by example, client Credential flow

````
export JWT=$(curl --request POST \
  --url https://${AUTHO_TENANT}.eu.auth0.com/oauth/token \
  --header 'content-type: application/json' \
  --data '{"client_id":"${CLIENT_ID}","client_secret":"${CLIENT_SECRET}","audience":"${AUDIENCE}","grant_type":"client_credentials"}' | \
  jq -r '.access_token')
````

- Get API with Token

````
curl -H "Authorization: Bearer $JWT" http://localhost:8080 | jq
````

- Get API without Token (return HTTP 401)

````
curl -v http://localhost:8080 | jq
````
