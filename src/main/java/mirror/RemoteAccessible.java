package mirror;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by chaos on 2018/12/12 19:11
 * <p>
 * mail: 157688302@qq.com
 */
class RemoteAccessible {

    protected Class realClass;
    protected AccessibleObject refAccessible;

    protected void initRemote(Class realClass, AccessibleObject refAccessible) {
        this.realClass = realClass;
        this.refAccessible = refAccessible;
    }

    /**
     * Get field type or method return type
     *
     * @return
     */
    public Class type() {
        if (refAccessible instanceof Field) {
            return ((Field) refAccessible).getType();
        } else if (refAccessible instanceof Method) {
            return ((Method) refAccessible).getReturnType();
        } else {
            throw new UnsupportedOperationException("refAccessible type is " + refAccessible.getClass().getName() + " , not support method => type() ");
        }
    }

    boolean remoteCaller() {
        return RemoteCaller.isRemoteCaller(refAccessible);
    }

    IRemoteObject callRemote(Object ret) {
        if (ret == null) {
            //对于空对象不再进行包装
            return null;
        }
        return RemoteCaller.convertToRemote(refAccessible, ret.getClass(), ret);
    }

    static Object realObject(IRemoteObject remoteObject) {
        //step.1: remoteObject不包含真正的object，因为为了使用简单，object隐藏到了各个field中，所以先找到第一个有效的field.
        return RefCreater.findRealObject(remoteObject);
    }

}
