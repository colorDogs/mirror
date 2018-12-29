package mirror;

import java.lang.reflect.Field;

/**
 * Created by lamer on 2018/12/30 01:11
 * <p>
 * mail: 157688302@qq.com
 */
class RemoteObject<T> extends RemoteAccessible {
    protected Object that;
    protected Field field;

    public RemoteObject(Object that, Class<?> cls, Field field) throws NoSuchFieldException {
        initRemote(cls, field);
        this.that = that;
        this.field = cls.getDeclaredField(field.getName());
        this.field.setAccessible(true);
    }

    public T get() {
        try {
            Object ret = this.field.get(that);
            if (remoteCaller()) {
                ret = callRemote(ret);
            }
            return (T) ret;
        } catch (Exception e) {
            return null;
        }
    }

    public void set(T value) {
        try {
            this.field.set(that, value);
        } catch (Exception e) {
            //Ignore
        }
    }
}