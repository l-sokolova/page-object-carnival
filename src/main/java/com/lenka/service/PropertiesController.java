package com.lenka.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;

public class PropertiesController {

    private final Properties properties = new Properties();
    private static PropertiesController instance = null;

    private PropertiesController() {
        try {
            this.loadProperties("environment/data.properties");
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load configuration file", e);
        }
    }

    public static String getProperty(String propertyName) {
        if (instance == null) {
            instance = new PropertiesController();
        }
        return System.getProperty(propertyName, instance.properties.getProperty(propertyName));
    }

    private void loadProperties(String resource) throws IOException {
        InputStream inputStream = PropertiesController.class.getClassLoader().getResourceAsStream(resource);
        if (inputStream == null) {
            throw new IOException("Unable to open stream for resource " + resource);
        } else {
            Properties props = new Properties();
            props.load(inputStream);
            inputStream.close();
            Iterator i = props.stringPropertyNames().iterator();

            while(i.hasNext()) {
                String propertyName = (String)i.next();
                if (propertyName.startsWith("+")) {
                    this.loadProperties(propertyName.substring(1));
                }
            }

            this.properties.putAll(props);
        }
    }
}
