package mirror;

import java.lang.reflect.Field;

/**
 * Created by lamer on 2018/12/30 01:11
 * <p>
 * mail: 157688302@qq.com
 */
public class RefStaticLong extends RemoteLong {

    public RefStaticLong(Class cls, Field field) throws NoSuchFieldException {
        super(null, cls, field);
    }
}