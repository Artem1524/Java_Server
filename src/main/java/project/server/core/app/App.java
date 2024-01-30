package project.server.core.app;

public interface App extends AutoCloseable {
    void connectToDatabase();
    void run();
    void closeDatabaseConnection();
}
