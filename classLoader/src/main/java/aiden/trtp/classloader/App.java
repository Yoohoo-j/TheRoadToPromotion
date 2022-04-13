package aiden.trtp.classloader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println("---------");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println("自定义加载类路径");
//        System.out.println(AXClassLoader.class.getClassLoader());
    }
}
