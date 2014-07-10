/*
 * PhoneGap is available under *either* the terms of the modified BSD license *or* the
 * MIT License (2008). See http://opensource.org/licenses/alphabetical for full text.
 *
 * Copyright (c) 2005-2010, Nitobi Software Inc.
 * Copyright (c) 2011, IBM Corporation
 */

package com.phonegap.plugins.databasepath;

import java.io.IOException;
import java.net.URLConnection;

import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.net.Uri;
import android.content.Context;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;


public class DatabasePath extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        try {
            if (action.equals("getDatabasePath")) {
		//String databasePath = this.cordova.getActivity().getApplicationContext().getDir("database", Context.MODE_PRIVATE).getPath();
                String databasePath = this.cordova.getActivity().getDatabasePath("ClinidataPHR_DB").getAbsolutePath();
                callbackContext.success(databasePath);
                return true;
            }
        } catch (RuntimeException e) {  // KLUDGE for Activity Not Found
            e.printStackTrace();
            callbackContext.error(e.getMessage());
        }
        return false;
    }

}
