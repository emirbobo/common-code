package lsy;

/**
 * Hello world!
 *
 */
public class App 
{
    Manager manager;

    public App()
    {
    }

    public static void main( String[] args )
    {
        App app = new App();
        app.run();
    }

    private void run() {
        manager = new Manager();
        manager.start();
    }
}
