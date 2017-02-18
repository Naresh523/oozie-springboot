package com.bigadataguide.services;

/**
 * Created by cloudera on 2/17/17.
 */
public interface OozieSubmitter {
    boolean submit(String path, String filename);
}
