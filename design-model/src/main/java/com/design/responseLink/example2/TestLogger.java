package com.design.responseLink.example2;

/**
 * @Author: w
 * @Date: 2021/5/24 8:53
 */
public class TestLogger {

    public static void main(String[] args) {
        Logger logger = initLogger();


        logger.logMessage(Logger.ERROR,"错误日志");
        logger.logMessage(Logger.DEBUG,"断点日志");
        logger.logMessage(Logger.INFO,"正常日志");
    }

    // 初始化记录器
    private static Logger initLogger() {
        // 创建记录器
        Logger infoLogger = new InfoLogger(Logger.INFO);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);
        Logger errorLogger = new ErrorLogger(Logger.ERROR);

        // 设置下一个记录器
        infoLogger.setNext(debugLogger);
        debugLogger.setNext(errorLogger);
        return infoLogger;
    }
}
