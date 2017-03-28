# Guild Wars 2 API Wrapper For Android<br/>
This is a yet-to-be-complete library for accessing the <a href="https://wiki.guildwars2.com/wiki/API:2">Guild Wars 2 API</a>.<br/>
<sup><sup><sup>Since I can find plenty on official <a href="https://wiki.guildwars2.com/wiki/API:List_of_wrappers">Wiki</a>, I did not 
plan to create a wrapper at all. I choose one that I am quite happy with, it works perfectly in debugging mode.However,
 once I'm running it not using debugging mode... My program just crash and burned... Horribly... I took me hours trying to figure out what is wrong and as it turns out it was neither the wrapper's fault nor my program's 
fault. It was my fault that I didn't realize Android does not have all of Java's build in library. This wrapper just so
happens to use one of the library that is not included in Android, extensively. Feeling so defeated that I don't ever dare to look for another wrapper that may or may not work for me. So I just sorta 
give up on looking and create a wrapper that is compatible with Android myself.<br/></sup></sup></sup>

## How To Use<br/>
*Note: when using this library in Android application make sure to require internet permission* <br/>
```xml
<uses-permission android:name="android.permission.INTERNET"/>
```
First of all, you need to get GuildWars2 object by calling:<br/>
```java
GuildWars2.getInstance();
```
#### API Wrapper Methods<br/>
<sup>*Note: almost all method throws ```GuildWars2Exception``` and/or ```IOException```. Former usually means invalid API 
key (or empty id list). Latter usually means network error.*</sup><br/>
Use get&#60;name&#62; methods to get the content synchronously. For instance, to get content of item <a href="https://api.guildwars2.com/v2/items?ids=12452,28445">12452 and 28445</a> synchronously:<br/>
```java
GuildWars2 api = GuildWars2.getInstance();
int[] ids = new int[]{12452, 28445};
List<Item> result = api.getItemInfo(ids);
//more amazing codes
```
Use &#60;name&#62;Processor methods to process you the content asynchronously. For instance, to process content of item <a href="https://api.guildwars2.com/v2/items?ids=12452,28445">12452 and 28445</a> asynchronously:<br/>
```java
GuildWars2 api = GuildWars2.getInstance();
int[] ids = new int[]{12452, 28445};
api.itemInfoProcessor(ids, new Callback<List<Item>>() {
  @Override
  public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
    //more amazing codes
  }
	
  @Override
  public void onFailure(Call<List<Item>> call, Throwable t) {
    //handle failure
  }
});
```

#### Content Model Classes<br/>
Each content model class follow the exact same format as the response you get when calling the corresponding API 
endpoint. Thus a good way to know what to expect from a model class is to go to the API wiki page and see what is in the 
response for that endpoint.<br/>
For example, the response for <a href="https://wiki.guildwars2.com/wiki/API:2/tokeninfo">/v2/tokeninfo</a>:
> id (string) - The API key that was requested.<br/>
> name (string) - The name given to the API key by the account owner. <strong>Warning</strong>: The value of this field is not escaped and may contain valid HTML, JavaScript, other code. Handle with care.<br/>
> permissions (array) - Array of strings describing which permissions the API key has. The array can contain any of:<br/>
> + account - Grants access to the /v2/account endpoint (This permission is required for all API keys).<br/>
> + builds - Grants access to view each character's equipped specializations and gear.<br/>
> + characters - Grants access to the /v2/characters endpoint.<br/>
> + guilds - Grants access to guild info under the /v2/guild/:id/ sub-endpoints.<br/>
> + inventories - Grants access to inventories in the /v2/characters, /v2/account/bank, and /v2/account/materials endpoints.<br/>
> + progression - Grants access to achievements, dungeon unlock status, mastery point assignments, and general PvE progress.<br/>
> + pvp - Grants access to the /v2/pvp sub-endpoints. (i.e. /v2/pvp/games, /v2/pvp/stats)<br/>
> + tradingpost - Grants access to the /v2/commerce/transactions endpoint.<br/>
> + unlocks - Grants access to the /v2/account/skins and /v2/account/dyes endpoints.<br/>
> + wallet - Grants access to the /v2/account/wallet endpoint.<br/>

The format for TokenInfo class is:<br/>
```java
public class TokenInfo {
  private String id;
  private String name;
  private String[] permissions;
  //getters
}
```

## Completed Endpoints<br/>
*List of Endpoints that is available in this library*<br/>
+ /v2/account<br/>
+ /v2/account/bank<br/>
+ /v2/account/inventory<br/>
+ /v2/account/materials<br/>
+ /v2/account/wallet<br/>
+ /v2/characters<br/>
    + only have return array of characters by name<br/>
+ /v2/characters/&#60;name&#62;/inventory<br/>
+ /v2/commerce/prices<br/>
+ /v2/commerce/transactions<br/>
+ /v2/currencies<br/>
+ /v2/items<br/>
+ /v2/itemstats<br/>
+ /v2/materials<br/>
+ /v2/skins<br/>
+ /v2/tokeninfo<br/>
+ /v2/worlds<br/>

## Download<br/>
Use this <a href="https://github.com/xhsun/gw2-wrapper/raw/master/GuildWars2.jar">link</a> to download GuildWars.jar, 
which is the jar file presented in the repository. It is compiled using Java 7 and I did not use try-with-resources in 
my code, which means it should be usable for Android API level 15 and up.<br/>
Or you can <a href="https://github.com/xhsun/gw2-wrapper.git">clone</a> the repository and compile your own jar file.
#### Location For Android project<br/>
After downloaded the jar file, make sure you save it in app/libs folder and while you are at it add `compile files('libs/GuildWars2.jar')` to your build.gradle<br/>

## Contributing<br/>
#### Issues<br/>
If you find anything that is not working as it should be, please don't hesitate to open an issue in the issue tracker.<br/>
When reporting an issue, it will help me a lot if you include what you've done that lead to the issue.<br/>

