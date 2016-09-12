package net.sqlcipher.database;

public class DatabaseObjectNotClosedException
  extends RuntimeException
{
  private static final String s = "Application did not close the cursor or database object that was opened here";
  
  public DatabaseObjectNotClosedException()
  {
    super("Application did not close the cursor or database object that was opened here");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\net\sqlcipher\database\DatabaseObjectNotClosedException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */