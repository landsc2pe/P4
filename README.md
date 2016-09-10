best)
Volley, Retrofit2, Glide
   |        |        |
   +--------+--------+
            |
      okhttp, okhttp3


worst)
Volley    Retrofit2      Glide
  |           |            |
okhttp     okhttp       okhtttp


### chrome inspect
chrome://inspect
- https://developers.google.com/web/tools/chrome-devtools/debug/remote-debugging/remote-debugging?hl=en

### Builder pattern
- http://www.javaworld.com/article/2074938/core-java/too-many-parameters-in-java-methods-part-3-builder-pattern.html

### Creating abtraction by Okhttp3
#### Requests
- https://api.github.com/users/octocat/repos
- https://api.github.com/users/octocat/followers
- http://api-dev.github.com/users/octocat/followers
- http://api-qa.github.com/users/octocat/followers
- https://api.github.com/users/octocat/orgs
- https://api.github.com/repos/octocat/linguist
- https://www.reddit.com/top.json?limit=5
- http://finance.naver.com/item/main.nhn?code=066980


callback
Data Model(POJO) which is deserialized form json strong of xml or something.

interface Request {
    public void send(new Callback());
}

interface Callback {
    public void onResponse(T model);
    public void onError(Throwable t);
}

