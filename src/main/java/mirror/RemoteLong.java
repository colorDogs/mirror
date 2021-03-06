package mirror;

import java.lang.reflect.Field;

/**
 * Created by chaos on 2018/12/12 19:40
 * <p>
 * mail: 157688302@qq.com
 */
class RemoteLong  /* no need extends RemoteAccessible */ {

    protected Object that;
    protected Field field;

    public RemoteLong(Object that, Class cls, Field field) throws NoSuchFieldException {
        this.that = that;
        this.field = cls.getDeclaredField(RemoteCaller.getFeildName(field));
        this.field.setAccessible(true);
    }

    public long get() {
        try {
            return this.field.getLong(that);
        } catch (Exception e) {
            return 0;
        }
    }

    public void set(long value) {
        try {
            this.field.setLong(that, value);
        } catch (Exception e) {
            //Ignore
        }
    }
}
