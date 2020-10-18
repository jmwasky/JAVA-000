import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class findClass (String name) throws ClassNotFoundException {

        String classPath = name + ".xlass";
        InputStream classInputStream = this.getClass().getResourceAsStream(classPath);
        try {
            byte[] classSourceBytes = new byte[classInputStream.available()];
            classInputStream.read(classSourceBytes);
            byte[] decodeBytes = decode(classSourceBytes);
            Class clazz = defineClass(name, decodeBytes, 0, decodeBytes.length);
            return clazz;
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, NoSuchMethodException, InvocationTargetException {
        Object obj = new MyClassLoader().findClass("Hello").newInstance();
        Method hello = obj.getClass().getMethod("hello", null);
        hello.invoke(obj);

    }
    public byte[] decode (byte[] bytes) {
        int length = bytes.length;
        byte[] decodeBytes = new byte[length];
        for (int i = 0; i < length; i++) {
            byte source = bytes[i];
            byte decode = (byte) (- source + 255);
            decodeBytes[i] = decode;
        }
        return decodeBytes;
    }
}