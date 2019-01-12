package cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class guavaTest {

    @Test
    public void TestLoadingCache() throws Exception{
        LoadingCache<String,String> cahceBuilder=CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>(){
                    @Override
                    public String load(String key) throws Exception {
                        String strProValue="hello "+key+"!";
                        return strProValue;
                    }

                });

        System.out.println("jerry value:"+cahceBuilder.get("jerry")); // 1st get will access the load method
        System.out.println("jerry value:"+cahceBuilder.get("jerry")); // 2nd get will directly return
        cahceBuilder.put("harry", "ssdded");                          // put the value in the cache
        System.out.println("harry value:"+cahceBuilder.get("harry")); // get will directly return
    }

    @Test
    public void testcallableCache()throws Exception{
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(1000).build();
        String resultVal = cache.get("jerry", new Callable<String>() {
            public String call() {
                String strProValue="hello "+"jerry"+"!";
                return strProValue;
            }
        });
        System.out.println("jerry value : " + resultVal);

        resultVal = cache.get("jerry", () -> {
            String strProValue="hello "+"jerry2"+"!";
            return strProValue;
        });
        System.out.println("jerry2 value : " + resultVal);
    }
}
