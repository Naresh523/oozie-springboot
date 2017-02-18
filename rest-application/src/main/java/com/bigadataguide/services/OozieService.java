package com.bigadataguide.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cloudera on 2/18/17.
 */
@Service
public class OozieService {

    private final OozieSubmitter oozieSubmitter ;

    @Autowired
    public OozieService(OozieSubmitter oozieSubmitter) {
        this.oozieSubmitter = oozieSubmitter;
    }

    /*Call Your oozie submitter method to run oozie workflow */
    /*boolean success = oozieSubmitter.submit("", "");*/
}
