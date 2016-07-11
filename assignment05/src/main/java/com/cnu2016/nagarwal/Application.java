package com.cnu2016.nagarwal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

@SpringBootApplication
public class Application {

    public static void main( String[] args ){

//        String fileName = "/Users/niteshagarwal002/git_repos/cnu2016/assignment04/target/maven-archiver/application.properties";
//        InputStream propertyFile = null;
//        Properties properties = new Properties();
//
//        try
//        {
//            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//            URL propertyFileUrl = classLoader.getResource(fileName);
//            if (propertyFileUrl != null)
//            {
//                propertyFile = propertyFileUrl.openStream();
//
//                if (propertyFile != null)
//                {
//                    if (fileName.toUpperCase().endsWith(".XML"))
//                    {
//                        properties.loadFromXML(propertyFile);
//                    }
//                    else
//                    {
//                        properties.load(propertyFile);
//                    }
//                }
//                else
//                {
//                    System.err.println("The property file [" + fileName + "] could not " +
//                            "be opened for reading.");
//                }
//            }
//            else
//            {
//                System.err.println("The property file [" + fileName + "] could not " +
//                        "be found in the classpath.");
//            }
//        }
//        catch (IOException e)
//        {
//            System.err.println ("The property file [" + fileName + "] could not " +
//                    "be loaded. The error is: " + e.toString());
//        }
//        finally
//        {
//            if (propertyFile != null)
//            {
//                try
//                {
//                    propertyFile.close();
//                }
//                catch (IOException e)
//                {
//                    e.printStackTrace();
//                }
//            }
//        }

        SpringApplication.run(Application.class);
    }
}