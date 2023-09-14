import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IOException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        URLClassLoader firstLoader = new URLClassLoader(
                new URL[] { new File("jruby-core-9.4.3.0-complete.jar").toURI().toURL() },
                Thread.currentThread().getContextClassLoader());
        URLClassLoader secondLoader = new URLClassLoader(
                new URL[] { new File("jruby-core-9.4.3.0-complete.jar").toURI().toURL() },
                Thread.currentThread().getContextClassLoader());

        Class<?> b1 = firstLoader.loadClass("org.jruby.ir.targets.indy.Bootstrap");
        Class<?> b2 = secondLoader.loadClass("org.jruby.ir.targets.indy.Bootstrap");
        System.out.println(b1);
        System.out.println(b2);


        Object b1i = b1.getDeclaredConstructor().newInstance();
        Object b2i = b2.getDeclaredConstructor().newInstance();
        System.out.println(b1i);
        System.out.println(b2i);
        firstLoader.close();
        secondLoader.close();
    }
}