package mirror;

import java.lang.reflect.Field;

/**
 * Created by chaos on 2018/12/12 19:41
 * <p>
 * mail: 157688302@qq.com
 */
public class RefStaticLong extends RemoteLong {

    public RefStaticLong(Class cls, Field field) throws NoSuchFieldException {
        super(null, cls, field);
    }
}
