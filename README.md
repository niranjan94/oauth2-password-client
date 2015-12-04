# OAuth2 Client - Password Grant

> This library is entirely based on the [android-oauth2-client](https://github.com/danielsz/android-oauth2-client) library by [Daniel Szmulewicz](https://github.com/danielsz) with minor modifications.

## Usage

Add JitPack repository in your root build.gradle at the end of repositories:
```gradle
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```

Add the dependency
```gradle
dependencies {
  compile 'com.github.niranjan94:oauth2-password-client:1.0'
}
```

And start using it in your code

```java
OAuth2Client client = new OAuth2Client("username", "password", "app-id", "app-secret", "site");
Token token = client.getAccessToken();

token.getResource(client, token, "/path/to/resource?name=value");
```
With this grant type, the client application doesn't need to store the username/password of the user. Those credentials are asked once and exchanged for an access token. This token can then be used to access protected resources. 

To check if a token has expired:

```java
token.isExpired();
```

To refresh a token:

```java
Token newToken = token.refresh(client);
```

A more involved example can be found [here](https://github.com/danielsz/oauth2-client).

### Assumptions

- Your OAuth server delivers access tokens bundled with refresh tokens.

## License

This software is released as open source under the LGPLv3 license. And all rights belong to [Daniel Szmulewicz](https://github.com/danielsz).