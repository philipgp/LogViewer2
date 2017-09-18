package org.logviewer.controller;

import org.logviewer.request.SyncRequest;
import org.logviewer.response.SyncResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by philip on 27/5/17.
 */
@RestController
public class SyncController {

    @Autowired
    SyncService syncService;


    @RequestMapping(value = "/sync",method = RequestMethod.POST)
    @ResponseBody
    public SyncResponse sync(@RequestBody  SyncRequest request){
        return syncService.sync(request);
    }
}
