package application.services;

import cache.ManageCache;
import com.sun.tools.classfile.Opcode;
import org.ehcache.Cache;
import org.springframework.web.bind.annotation.*;


@RestController
public class CacheService {



    @RequestMapping("/text/{key}")
    public String getData(@PathVariable("key") String key) {

        return "La cache tiene los siguientes datos: "+ManageCache.getCacheInstance().get(key);
    }
    @RequestMapping("/text/{key}/{value}")
    public String createData(@PathVariable("key") String key, @PathVariable("value") String value) {
        ManageCache.getCacheInstance().put(key, value);
        return "Inserción finalizada. La cache ahora tiene los siguientes datos: "+ManageCache.getCacheInstance().get(key);
    }

}
