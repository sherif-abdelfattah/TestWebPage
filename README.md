# TestWebPage
Java code to test https proxy settings based on Java HttpURLConnection class.
The code can actually connect to any URL, but will only respond to https.proxyUser and https.ProxyPassword system properties.

### Usage:
$ java -jar \<java-options\> testwebpage.jar \<URL\>
```
 sherif@Turin ~ $ java -Dhttps.proxyHost=127.0.0.1 -Dhttps.proxyPort=3128 -Dhttps.proxyUser=user -Dhttps.proxyPassword=user  -Djdk.http.auth.tunneling.disabledSchemes -jar testwebpage.jar https://api.github.com
```

### Sample output:
```
  Proxy Settings:user:user
  Request Method:GET https://api.github.com
  Status : [200 OK]
  Transfer-Encoding : [chunked]
  null : [HTTP/1.1 200 OK]
  Server : [GitHub.com]
  Access-Control-Allow-Origin : [*]
  X-Content-Type-Options : [nosniff]
  X-RateLimit-Reset : [1528459370]
  Date : [Fri, 08 Jun 2018 11:02:50 GMT]
  X-Runtime-rack : [0.012204]
  Referrer-Policy : [origin-when-cross-origin, strict-origin-when-cross-origin]
  X-Frame-Options : [deny]
  Strict-Transport-Security : [max-age=31536000; includeSubdomains; preload]
  Access-Control-Expose-Headers : [ETag, Link, Retry-After, X-GitHub-OTP, X-RateLimit-Limit, X-RateLimit-Remaining, X-RateLimit-Reset, X-OAuth-Scopes, X-Accepted-OAuth-Scopes, X-Poll-Interval]
  X-RateLimit-Remaining : [59]
  Cache-Control : [public, max-age=60, s-maxage=60]
  X-GitHub-Media-Type : [unknown, github.v3]
  ETag : [W/"49e64b1cbd451de9cb767f02caf40375"]
  Content-Security-Policy : [default-src 'none']
  Content-Encoding : [gzip]
  Vary : [Accept]
  X-RateLimit-Limit : [60]
  X-XSS-Protection : [1; mode=block]
  X-GitHub-Request-Id : [DF52:5106:3868B85:7AE4C9C:5B1A625A]
  Content-Type : [application/json; charset=utf-8]
  Response:OK
  Is using proxy:true
  sun.net.www.protocol.https.DelegateHttpsURLConnection:https://api.github.com
  Done Ok
```


