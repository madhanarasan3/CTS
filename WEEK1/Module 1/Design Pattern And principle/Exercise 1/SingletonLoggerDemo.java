public class SingletonLoggerDemo { 
 
 
    static class Logger { 
        private static volatile Logger instance; 
 
        private Logger() { 
            System.out.println("Logger instance created"); 
        } 
 
        public static Logger getInstance() { 
            if (instance == null) { 
                synchronized (Logger.class) { 
                    if (instance == null) { 
                        instance = new Logger(); 
                    } 
                } 
            } 
            return instance; 
        } 
 
        public void log(String message) { 
            System.out.println("[LOG] " + message); 
        } 
    } 
 
    public static void main(String[] args) { 
        System.out.println("Demonstrating Singleton Logger Pattern"); 
 
        Logger logger1 = Logger.getInstance(); 
        Logger logger2 = Logger.getInstance(); 
 
        logger1.log("First log message"); 
        logger2.log("Second log message"); 
 
        System.out.println("Same instance? " + (logger1 == logger2)); 
 
        Runnable task = () -> { 
            Logger threadLogger = Logger.getInstance(); 
            threadLogger.log("Message from " + Thread.currentThread().getName()); 
        }; 
 
        Thread thread1 = new Thread(task, "Thread-1"); 
        Thread thread2 = new Thread(task, "Thread-2"); 
 
        thread1.start(); 
        thread2.start(); 
 
        try { 
            thread1.join(); 
            thread2.join(); 
        } catch (InterruptedException e) { 
            e.printStackTrace(); 
        } 
 
        System.out.println("Demo complete"); 
    } 
} 