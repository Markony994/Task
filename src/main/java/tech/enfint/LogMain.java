package tech.enfint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogMain
{
    private static final Logger logger
            = LoggerFactory.getLogger(LogMain.class);

    public static void main(String[] args) {
        logger.info("Example log from {}", LogMain.class.getSimpleName());
    }

}
