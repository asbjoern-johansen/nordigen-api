# nordigen-api

Java interface implementation of the Nordigen REST api: https://ob.nordigen.com/api/v2

The Nordigen API connects to your users’ bank accounts and access account information from bank PSD2 APIs

## Prerequisites

Create an account with https://nordigen.com/ to use this API

## Creating an API instance
```    
//Set the API factory implementation
//Provide the secretId and secretKey from your Nordigen https://ob.nordigen.com/user-secrets/
NordigenApiFactory.setFactory(
    new NordigenApiFactory() {
        @Override
        protected NordigenApi create() {
            return new NordigenRestApi("secretId", "secretKey");
        }
    }
);

//Get a new instance of the Nordigen API
NordigenApi nordigenApi = NordigenApiFactory.getApi();
```
## GitHub repository
* https://github.com/asbjoern-johansen/nordigen-api

## Alternatives
* https://github.com/simonhauck/unofficial-nordigen-api-java
