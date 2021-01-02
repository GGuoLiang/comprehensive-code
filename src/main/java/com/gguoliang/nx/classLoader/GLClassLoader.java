package com.gguoliang.nx.classLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @Author GGuoLiang
 * @Date 2020/12/16 9:36 下午
 * @Version 1.0
 */
public class GLClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classBytes = null;
            classBytes = loadClassBytes(name);
            Class<?> cl = defineClass(null, classBytes, 0, classBytes.length);
            if (cl == null) throw new ClassNotFoundException(name);
            return cl;
        }
        catch (IOException e) {
            throw new ClassNotFoundException(name);
        }
    }

    /**
     * Loads and decrypt the class file bytes.
     * @param name the class name
     * @return an array with the class file bytes
     */
    private byte[] loadClassBytes(String name) throws IOException {
//      String cname = name.replace('.', '/') ;
        byte[] bytes = Files.readAllBytes(Paths.get(name));
//      for (int i = 0; i < bytes.length; i++)
//         bytes[i] = (byte) (bytes[i] - key);
        return bytes;
    }


}
