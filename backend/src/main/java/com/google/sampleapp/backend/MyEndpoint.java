/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.google.sampleapp.backend;

import com.example.JokeClass;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.sampleapp.google.com",
                ownerName = "backend.sampleapp.google.com",
                packagePath = ""
        )
)
public class MyEndpoint {

        /** A simple endpoint method to provide a joke */
        @ApiMethod(name = "getJoke")
        public MyBean getJoke(){
            MyBean response = new MyBean();
            response.setData(JokeClass.jokes);

            return response;
        }


    }



