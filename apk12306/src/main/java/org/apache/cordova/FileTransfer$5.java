package org.apache.cordova;

class FileTransfer$5
  implements Runnable
{
  FileTransfer$5(FileTransfer paramFileTransfer, FileTransfer.RequestContext paramRequestContext) {}
  
  public void run()
  {
    synchronized (this.val$context)
    {
      FileTransfer.access$400(this.val$context.currentInputStream);
      FileTransfer.access$400(this.val$context.currentOutputStream);
      return;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\FileTransfer$5.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */