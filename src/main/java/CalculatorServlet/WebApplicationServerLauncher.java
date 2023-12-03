package CalculatorServlet;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class WebApplicationServerLauncher {
    private static final Logger logger = LoggerFactory.getLogger(WebApplicationServerLauncher.class);

    public static void main(String[] args) throws LifecycleException {
        String webAppDirLocation = "webapp/";
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8081);

        tomcat.addWebapp("/", new File(webAppDirLocation).getAbsolutePath());
        logger.info("configuring app with basedir: {}", new File("./" + webAppDirLocation).getAbsolutePath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
