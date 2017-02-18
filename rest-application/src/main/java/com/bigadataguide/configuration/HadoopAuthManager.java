package com.bigadataguide.configuration;

import java.security.PrivilegedAction;

/**
 * Created by cloudera on 2/18/17.
 */
public interface HadoopAuthManager {
    void checkAuth();

    <T> T doPrivileged(PrivilegedAction<T> var1);
}
