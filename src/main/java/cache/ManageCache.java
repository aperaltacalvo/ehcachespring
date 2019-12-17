package cache;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

public class ManageCache {
    private static CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
            .withCache("preConfigured",
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                            ResourcePoolsBuilder.heap(100))
                            .build())
            .build(true);

    private static Cache<String, String> myCache = cacheManager.createCache("myCache",
            CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class,
                    ResourcePoolsBuilder.heap(100)).build());


    public static Cache getCacheInstance(){
        if (myCache == null){
            myCache = cacheManager.createCache("myCache",
                    CacheConfigurationBuilder.newCacheConfigurationBuilder(String.class, String.class,
                            ResourcePoolsBuilder.heap(100)).build());
        }
        return myCache;

    }

}
