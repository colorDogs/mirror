package mirror;


import java.lang.reflect.Field;

public class RefInt extends RemoteInt {

    public RefInt(Class cls, Field field) throws NoSuchFieldException {
        super(null, cls, field);
    }

    @Override
    public int get() {
        throw RefCreater.createNotSupportException();
    }

    @Override
    public void set(int intValue) {
        throw RefCreater.createNotSupportException();
    }

    public int get(Object object) {
        try {
            return this.field.getInt(object);
        } catch (Exception e) {
            return 0;
        }
    }

    public void set(Object obj, int intValue) {
        try {
            this.field.setInt(obj, intValue);
        } catch (Exception e) {
            //Ignore
        }
    }
}