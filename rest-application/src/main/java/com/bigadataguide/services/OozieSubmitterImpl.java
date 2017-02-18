package com.bigadataguide.services;

import com.bigadataguide.configuration.HadoopAuthManager;
import com.bigadataguide.model.OozieConfig;
import com.bigadataguide.model.OozieConstants;
import org.apache.oozie.client.AuthOozieClient;
import org.apache.oozie.client.OozieClient;
import org.apache.oozie.client.WorkflowJob;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by cloudera on 2/17/17.
 */
@Component
public class OozieSubmitterImpl implements OozieSubmitter {

    private final OozieConfig oozieConfig;
    /*private final HadoopAuthManager hadoopAuthManager;*/

    public OozieSubmitterImpl(OozieConfig oozieConfig) {
        this.oozieConfig = oozieConfig;
        /*this.hadoopAuthManager = hadoopAuthManager;*/
    }

    /*On Kerberos Authentication did not take current authorizer*/
    /*@Override
    public boolean submit(final String path, final String filename) {
        return hadoopAuthManager.doPrivileged(() -> submitIt(path, filename));
    }*/

    @Override
    public boolean submit(final String path, final String filename) {

        AuthOozieClient oozieClient = new AuthOozieClient(OozieConstants.OOZIE_URL);
        oozieClient.setDebugMode(1);

        Properties prop = oozieClient.createConfiguration();

        prop.setProperty(OozieClient.APP_PATH, oozieConfig.getOozieApplicationPath());
        prop.setProperty(oozieClient.LIBPATH, oozieConfig.getOozieLibPath());
        prop.setProperty(oozieClient.USE_SYSTEM_LIBPATH, String.valueOf(oozieConfig.isOozieSystemLibPath()));
        prop.setProperty(oozieClient.RERUN_FAIL_NODES, String.valueOf(oozieConfig.isOozieWfRerunFailnodes()));

        /*Set Your Application Configuration*/
        prop.setProperty(OozieConstants.NAME_NODE, oozieConfig.getNameNode());
        prop.setProperty(OozieConstants.RESOURCE_MANAGER, oozieConfig.getResourceManager());
        prop.setProperty(OozieConstants.QUEUE_NAME, oozieConfig.getQueueName());
        prop.setProperty(OozieConstants.ROOT_DIR, oozieConfig.getRootDir());

        try {
            String jobId = oozieClient.run(prop);
            while (oozieClient.getJobInfo(jobId).getStatus() == WorkflowJob.Status.RUNNING) {
                try {
                    Thread.sleep(20*1000);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            if(oozieClient.getJobInfo(jobId).getStatus() == WorkflowJob.Status.SUSPENDED) {
                return false;
            }

            if(oozieClient.getJobInfo(jobId).getStatus() == WorkflowJob.Status.FAILED ||
                    oozieClient.getJobInfo(jobId).getStatus() == WorkflowJob.Status.KILLED) {
                return false;
            }

            System.out.println("Workflow job info:" +oozieClient.getJobInfo(jobId));

        } catch (Exception ex) {

        }

        return true;
    }
}
