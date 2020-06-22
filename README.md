<p align=center>
  <strong>In development...</strong> <br>
  <img src="https://i.pinimg.com/564x/7e/a1/40/7ea1407c688380488dada8b19d41702f.jpg" />
</p>

## Simple preview start


### Dependency
Add dependency:
```xml
<dependency>
    <groupId>com.apploidx</groupId>
    <artifactId>kitsu-spring-boot-starter</artifactId>
    <version>LATEST</version>
</dependency>
```

> Be careful with using LATEST in production

I recommend to use stated version (instead of LATEST) from this list: [GitHub Packages](https://github.com/AppLoidx/kitsu-sdk-starter/packages/281508/versions)

### Use Autowired service

Create a simple controller that returns json from Kitsu API

```java
@RestController
public class AnimeController {

    private final KitsuClient kitsuClient;

    public AnimeController(KitsuClient kitsuClient) {
        this.kitsuClient = kitsuClient;
    }

    @GetMapping("/anime/{id}")
    public Anime getAnime(@PathVariable("id") int id) {
        return kitsuClient.fetchAnime(id);
    }

    @GetMapping("/episodes/{id}")
    public Episodes getEpisodes(@PathVariable("id") int id) {
        return kitsuClient.fetchEpisodes(id);
    }

    @GetMapping("/trending/anime")
    public List<Anime> getTrendingAnime() {
        return kitsuClient.fetchTrendingAnime();
    }
}
```
