package com.bigadataguide.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by cloudera on 2/17/17.
 */
@Component
public class OozieConfig {

    @Value("${namenode}")
    private String nameNode;

    @Value("${resourcemanager}")
    private String resourceManager;

    @Value("${queuename}")
    private String queueName;

    @Value("${master}")
    private String master;

    @Value("${rootdir}")
    private String rootDir;

    @Value("${oozie.wf.application.path}")
    private String oozieApplicationPath;

    @Value("${oozie.libpath}")
    private String oozieLibPath;

    @Value("${oozie.use.system.libpath}")
    private boolean oozieSystemLibPath;

    @Value("${oozie.wf.rerun.failnodes}")
    private boolean oozieWfRerunFailnodes;


    public String getNameNode() {
        return nameNode;
    }

    public void setNameNode(String nameNode) {
        this.nameNode = nameNode;
    }

    public String getResourceManager() {
        return resourceManager;
    }

    public void setResourceManager(String resourceManager) {
        this.resourceManager = resourceManager;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

    public String getOozieApplicationPath() {
        return oozieApplicationPath;
    }

    public void setOozieApplicationPath(String oozieApplicationPath) {
        this.oozieApplicationPath = oozieApplicationPath;
    }

    public String getOozieLibPath() {
        return oozieLibPath;
    }

    public void setOozieLibPath(String oozieLibPath) {
        this.oozieLibPath = oozieLibPath;
    }

    public boolean isOozieSystemLibPath() {
        return oozieSystemLibPath;
    }

    public void setOozieSystemLibPath(boolean oozieSystemLibPath) {
        this.oozieSystemLibPath = oozieSystemLibPath;
    }

    public boolean isOozieWfRerunFailnodes() {
        return oozieWfRerunFailnodes;
    }

    public void setOozieWfRerunFailnodes(boolean oozieWfRerunFailnodes) {
        this.oozieWfRerunFailnodes = oozieWfRerunFailnodes;
    }
}
