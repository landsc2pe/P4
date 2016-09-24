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
#### Requests (100 이상)
Query paramters 가 변경될 수 있다.
Header 가 변경될 수 있다.
##### GET 요청(40이상)
- https://api.github.com/users/octocat/repos
- https://api.github.com/users/octocat/followers
- https://api.github.com/users/octocat/orgs
- https://api.github.com/repos/octocat/linguist
- http://api-qa.github.com/users/octocat/followers
- http://api-dev.github.com/users/octocat/followers
- http://api.github-rest.com/profile?key1=value1&key2=valkue2
- http://api-qa.github-rest.com/profile?key1=value1&key2=valkue2
- http://api-dev.github-rest.com/profile?key1=value1&key2=valkue2
- https://www.reddit.com/top.json?limit=5
- http://finance.naver.com/item/main.nhn?code=066980
...
##### POST 요청(40이상)
- https://api.github.com/users/octocat/repos
- https://api.github.com/users/octocat/followers
- http://api-dev.github.com/users/octocat/followers
- http://api-qa.github.com/users/octocat/followers
- https://api.github.com/users/octocat/orgs
- https://api.github.com/repos/octocat/linguist
- https://www.reddit.com/top.json?limit=5
- http://finance.naver.com/item/main.nhn?code=066980
...
##### PUT 요청(40이상)
- https://api.github.com/users/octocat/repos
- https://api.github.com/users/octocat/followers
- http://api-dev.github.com/users/octocat/followers
- http://api-qa.github.com/users/octocat/followers
- https://api.github.com/users/octocat/orgs
- https://api.github.com/repos/octocat/linguist
- https://www.reddit.com/top.json?limit=5
- http://finance.naver.com/item/main.nhn?code=066980
...
##### DELETE 요청(40이상)
- https://api.github.com/users/octocat/repos
- https://api.github.com/users/octocat/followers
- http://api-dev.github.com/users/octocat/followers
- http://api-qa.github.com/users/octocat/followers
- https://api.github.com/users/octocat/orgs
- https://api.github.com/repos/octocat/linguist
- https://www.reddit.com/top.json?limit=5
- http://finance.naver.com/item/main.nhn?code=066980
...


callback
Data Model(POJO) which is deserialized form json strong of xml or something.

interface Request {
    public void send(new Callback());
}

interface Callback {
    public void onResponse(T model);
    public void onError(Throwable t);
}

### data-binding, mvvm
- https://developer.android.com/topic/libraries/data-binding/index.html
- https://blog.stylingandroid.com/data-binding-part-1/

### SOLID
- https://realm.io/news/donn-felker-solid-part-1/
- https://scotch.io/bar-talk/s-o-l-i-d-the-first-five-principles-of-object-oriented-design

### Google Drive Rest API
- https://developers.google.com/drive/v3/reference/
- Files section.
- Rest API : https://www.googleapis.com/drive/v3, http://api-qa.googleapis.com/drive/v3, http://api-dev.googleapis.com/drive/v3

### written by Jake Wharton
- https://realm.io/news/360andev-jake-wharton-java-hidden-costs-android/?utm_source=reddit.com&utm_medium=cpc&utm_campaign=java-hidden-costs