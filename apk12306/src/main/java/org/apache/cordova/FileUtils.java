package org.apache.cordova;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore.Images.Media;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.channels.FileChannel;
import java.util.concurrent.ExecutorService;
import org.apache.commons.codec.binary.Base64;
import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
import org.apache.cordova.api.PluginResult.Status;
import org.apache.cordova.file.EncodingException;
import org.apache.cordova.file.FileExistsException;
import org.apache.cordova.file.InvalidModificationException;
import org.apache.cordova.file.NoModificationAllowedException;
import org.apache.cordova.file.TypeMismatchException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FileUtils
  extends CordovaPlugin
{
  public static int ABORT_ERR = 0;
  public static int APPLICATION = 3;
  public static int ENCODING_ERR = 0;
  public static int INVALID_MODIFICATION_ERR = 0;
  public static int INVALID_STATE_ERR = 0;
  private static final String LOG_TAG = "FileUtils";
  public static int NOT_FOUND_ERR = 1;
  public static int NOT_READABLE_ERR;
  public static int NO_MODIFICATION_ALLOWED_ERR;
  public static int PATH_EXISTS_ERR;
  public static int PERSISTENT;
  public static int QUOTA_EXCEEDED_ERR;
  public static int RESOURCE;
  public static int SECURITY_ERR = 2;
  public static int SYNTAX_ERR;
  public static int TEMPORARY;
  public static int TYPE_MISMATCH_ERR;
  
  static
  {
    ABORT_ERR = 3;
    NOT_READABLE_ERR = 4;
    ENCODING_ERR = 5;
    NO_MODIFICATION_ALLOWED_ERR = 6;
    INVALID_STATE_ERR = 7;
    SYNTAX_ERR = 8;
    INVALID_MODIFICATION_ERR = 9;
    QUOTA_EXCEEDED_ERR = 10;
    TYPE_MISMATCH_ERR = 11;
    PATH_EXISTS_ERR = 12;
    TEMPORARY = 0;
    PERSISTENT = 1;
    RESOURCE = 2;
  }
  
  private boolean atRootDirectory(String paramString)
  {
    paramString = FileHelper.getRealPath(paramString, this.cordova);
    if ((paramString.equals(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + this.cordova.getActivity().getPackageName() + "/cache")) || (paramString.equals(Environment.getExternalStorageDirectory().getAbsolutePath())) || (paramString.equals("/data/data/" + this.cordova.getActivity().getPackageName()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void copyAction(File paramFile1, File paramFile2)
    throws FileNotFoundException, IOException
  {
    paramFile1 = new FileInputStream(paramFile1);
    paramFile2 = new FileOutputStream(paramFile2);
    FileChannel localFileChannel1 = paramFile1.getChannel();
    FileChannel localFileChannel2 = paramFile2.getChannel();
    try
    {
      localFileChannel1.transferTo(0L, localFileChannel1.size(), localFileChannel2);
      return;
    }
    finally
    {
      paramFile1.close();
      paramFile2.close();
      localFileChannel1.close();
      localFileChannel2.close();
    }
  }
  
  private JSONObject copyDirectory(File paramFile1, File paramFile2)
    throws JSONException, IOException, NoModificationAllowedException, InvalidModificationException
  {
    if ((paramFile2.exists()) && (paramFile2.isFile())) {
      throw new InvalidModificationException("Can't rename a file to a directory");
    }
    if (isCopyOnItself(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath())) {
      throw new InvalidModificationException("Can't copy itself into itself");
    }
    if ((!paramFile2.exists()) && (!paramFile2.mkdir())) {
      throw new NoModificationAllowedException("Couldn't create the destination directory");
    }
    paramFile1 = paramFile1.listFiles();
    int j = paramFile1.length;
    int i = 0;
    if (i < j)
    {
      File localFile = paramFile1[i];
      if (localFile.isDirectory()) {
        copyDirectory(localFile, paramFile2);
      }
      for (;;)
      {
        i++;
        break;
        copyFile(localFile, new File(paramFile2.getAbsoluteFile() + File.separator + localFile.getName()));
      }
    }
    return getEntry(paramFile2);
  }
  
  private JSONObject copyFile(File paramFile1, File paramFile2)
    throws IOException, InvalidModificationException, JSONException
  {
    if ((paramFile2.exists()) && (paramFile2.isDirectory())) {
      throw new InvalidModificationException("Can't rename a file to a directory");
    }
    copyAction(paramFile1, paramFile2);
    return getEntry(paramFile2);
  }
  
  private File createDestination(String paramString, File paramFile1, File paramFile2)
  {
    String str;
    if (!"null".equals(paramString))
    {
      str = paramString;
      if (!"".equals(paramString)) {}
    }
    else
    {
      str = null;
    }
    if (str != null) {}
    for (paramString = new File(paramFile2.getAbsolutePath() + File.separator + str);; paramString = new File(paramFile2.getAbsolutePath() + File.separator + paramFile1.getName())) {
      return paramString;
    }
  }
  
  private File createFileObject(String paramString)
  {
    return new File(FileHelper.getRealPath(paramString, this.cordova));
  }
  
  private File createFileObject(String paramString1, String paramString2)
  {
    if (paramString2.startsWith("/")) {}
    for (paramString1 = new File(paramString2);; paramString1 = new File(paramString1 + File.separator + paramString2))
    {
      return paramString1;
      paramString1 = FileHelper.getRealPath(paramString1, this.cordova);
    }
  }
  
  public static JSONObject getEntry(File paramFile)
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("isFile", paramFile.isFile());
    localJSONObject.put("isDirectory", paramFile.isDirectory());
    localJSONObject.put("name", paramFile.getName());
    localJSONObject.put("fullPath", "file://" + paramFile.getAbsolutePath());
    return localJSONObject;
  }
  
  private JSONObject getEntry(String paramString)
    throws JSONException
  {
    return getEntry(new File(paramString));
  }
  
  private JSONObject getFile(String paramString1, String paramString2, JSONObject paramJSONObject, boolean paramBoolean)
    throws FileExistsException, IOException, TypeMismatchException, EncodingException, JSONException
  {
    int i = 0;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJSONObject != null)
    {
      boolean bool3 = paramJSONObject.optBoolean("create");
      i = bool3;
      bool1 = bool2;
      if (bool3)
      {
        bool1 = paramJSONObject.optBoolean("exclusive");
        i = bool3;
      }
    }
    if (paramString2.contains(":")) {
      throw new EncodingException("This file has a : in it's name");
    }
    paramString1 = createFileObject(paramString1, paramString2);
    if (i != 0)
    {
      if ((bool1) && (paramString1.exists())) {
        throw new FileExistsException("create/exclusive fails");
      }
      if (paramBoolean) {
        paramString1.mkdir();
      }
      while (!paramString1.exists())
      {
        throw new FileExistsException("create fails");
        paramString1.createNewFile();
      }
    }
    if (!paramString1.exists()) {
      throw new FileNotFoundException("path does not exist");
    }
    if (paramBoolean)
    {
      if (paramString1.isFile()) {
        throw new TypeMismatchException("path doesn't exist or is file");
      }
    }
    else if (paramString1.isDirectory()) {
      throw new TypeMismatchException("path doesn't exist or is directory");
    }
    return getEntry(paramString1);
  }
  
  private JSONObject getFileMetadata(String paramString)
    throws FileNotFoundException, JSONException
  {
    File localFile = createFileObject(paramString);
    if (!localFile.exists()) {
      throw new FileNotFoundException("File: " + paramString + " does not exist.");
    }
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("size", localFile.length());
    localJSONObject.put("type", FileHelper.getMimeType(paramString, this.cordova));
    localJSONObject.put("name", localFile.getName());
    localJSONObject.put("fullPath", paramString);
    localJSONObject.put("lastModifiedDate", localFile.lastModified());
    return localJSONObject;
  }
  
  private long getMetadata(String paramString)
    throws FileNotFoundException
  {
    paramString = createFileObject(paramString);
    if (!paramString.exists()) {
      throw new FileNotFoundException("Failed to find file in getMetadata");
    }
    return paramString.lastModified();
  }
  
  private JSONObject getParent(String paramString)
    throws JSONException
  {
    paramString = FileHelper.getRealPath(paramString, this.cordova);
    if (atRootDirectory(paramString)) {}
    for (paramString = getEntry(paramString);; paramString = getEntry(new File(paramString).getParent())) {
      return paramString;
    }
  }
  
  private boolean isCopyOnItself(String paramString1, String paramString2)
  {
    if ((paramString2.startsWith(paramString1)) && (paramString2.indexOf(File.separator, paramString1.length() - 1) != -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private JSONObject moveDirectory(File paramFile1, File paramFile2)
    throws IOException, JSONException, InvalidModificationException, NoModificationAllowedException, FileExistsException
  {
    if ((paramFile2.exists()) && (paramFile2.isFile())) {
      throw new InvalidModificationException("Can't rename a file to a directory");
    }
    if (isCopyOnItself(paramFile1.getAbsolutePath(), paramFile2.getAbsolutePath())) {
      throw new InvalidModificationException("Can't move itself into itself");
    }
    if ((paramFile2.exists()) && (paramFile2.list().length > 0)) {
      throw new InvalidModificationException("directory is not empty");
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      copyDirectory(paramFile1, paramFile2);
      if (paramFile2.exists()) {
        removeDirRecursively(paramFile1);
      }
    }
    else
    {
      return getEntry(paramFile2);
    }
    throw new IOException("moved failed");
  }
  
  private JSONObject moveFile(File paramFile1, File paramFile2)
    throws IOException, JSONException, InvalidModificationException
  {
    if ((paramFile2.exists()) && (paramFile2.isDirectory())) {
      throw new InvalidModificationException("Can't rename a file to a directory");
    }
    if (!paramFile1.renameTo(paramFile2))
    {
      copyAction(paramFile1, paramFile2);
      if (paramFile2.exists()) {
        paramFile1.delete();
      }
    }
    else
    {
      return getEntry(paramFile2);
    }
    throw new IOException("moved failed");
  }
  
  private void notifyDelete(String paramString)
  {
    paramString = FileHelper.getRealPath(paramString, this.cordova);
    try
    {
      this.cordova.getActivity().getContentResolver().delete(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_data = ?", new String[] { paramString });
      return;
    }
    catch (UnsupportedOperationException paramString)
    {
      for (;;) {}
    }
  }
  
  private byte[] readAsBinaryHelper(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    int j = paramInt2 - paramInt1;
    byte[] arrayOfByte = new byte[j];
    paramString = FileHelper.getInputStreamFromUriString(paramString, this.cordova);
    int k = 0;
    int i = k;
    paramInt2 = j;
    if (paramInt1 > 0)
    {
      paramString.skip(paramInt1);
      paramInt2 = j;
      i = k;
    }
    while (paramInt2 > 0)
    {
      i = paramString.read(arrayOfByte, i, paramInt2);
      if (i < 0) {
        break;
      }
      paramInt2 -= i;
    }
    return arrayOfByte;
  }
  
  private JSONArray readEntries(String paramString)
    throws FileNotFoundException, JSONException
  {
    Object localObject = createFileObject(paramString);
    if (!((File)localObject).exists()) {
      throw new FileNotFoundException();
    }
    paramString = new JSONArray();
    if (((File)localObject).isDirectory())
    {
      localObject = ((File)localObject).listFiles();
      for (int i = 0; i < localObject.length; i++) {
        if (localObject[i].canRead()) {
          paramString.put(getEntry(localObject[i]));
        }
      }
    }
    return paramString;
  }
  
  private boolean remove(String paramString)
    throws NoModificationAllowedException, InvalidModificationException
  {
    File localFile = createFileObject(paramString);
    if (atRootDirectory(paramString)) {
      throw new NoModificationAllowedException("You can't delete the root directory");
    }
    if ((localFile.isDirectory()) && (localFile.list().length > 0)) {
      throw new InvalidModificationException("You can't delete a directory that is not empty.");
    }
    return localFile.delete();
  }
  
  private boolean removeDirRecursively(File paramFile)
    throws FileExistsException
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      for (int i = 0; i < j; i++) {
        removeDirRecursively(arrayOfFile[i]);
      }
    }
    if (!paramFile.delete()) {
      throw new FileExistsException("could not delete: " + paramFile.getName());
    }
    return true;
  }
  
  private boolean removeRecursively(String paramString)
    throws FileExistsException
  {
    File localFile = createFileObject(paramString);
    if (atRootDirectory(paramString)) {}
    for (boolean bool = false;; bool = removeDirRecursively(localFile)) {
      return bool;
    }
  }
  
  private JSONObject requestFileSystem(int paramInt)
    throws IOException, JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramInt == TEMPORARY)
    {
      localJSONObject.put("name", "temporary");
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + this.cordova.getActivity().getPackageName() + "/cache/").mkdirs();
        localJSONObject.put("root", getEntry(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + this.cordova.getActivity().getPackageName() + "/cache/"));
      }
    }
    for (;;)
    {
      return localJSONObject;
      new File("/data/data/" + this.cordova.getActivity().getPackageName() + "/cache/").mkdirs();
      localJSONObject.put("root", getEntry("/data/data/" + this.cordova.getActivity().getPackageName() + "/cache/"));
      continue;
      if (paramInt != PERSISTENT) {
        break;
      }
      localJSONObject.put("name", "persistent");
      if (Environment.getExternalStorageState().equals("mounted")) {
        localJSONObject.put("root", getEntry(Environment.getExternalStorageDirectory()));
      } else {
        localJSONObject.put("root", getEntry("/data/data/" + this.cordova.getActivity().getPackageName()));
      }
    }
    throw new IOException("No filesystem of type requested");
  }
  
  private JSONObject resolveLocalFileSystemURI(String paramString)
    throws IOException, JSONException
  {
    paramString = URLDecoder.decode(paramString, "UTF-8");
    int i;
    if (paramString.startsWith("content:"))
    {
      paramString = this.cordova.getActivity().managedQuery(Uri.parse(paramString), new String[] { "_data" }, null, null, null);
      i = paramString.getColumnIndexOrThrow("_data");
      paramString.moveToFirst();
      paramString = new File(paramString.getString(i));
    }
    while (!paramString.exists())
    {
      throw new FileNotFoundException();
      new URL(paramString);
      if (paramString.startsWith("file://"))
      {
        i = paramString.indexOf("?");
        if (i < 0) {
          paramString = new File(paramString.substring(7, paramString.length()));
        } else {
          paramString = new File(paramString.substring(7, i));
        }
      }
      else
      {
        paramString = new File(paramString);
      }
    }
    if (!paramString.canRead()) {
      throw new IOException();
    }
    return getEntry(paramString);
  }
  
  private JSONObject transferTo(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws JSONException, NoModificationAllowedException, IOException, InvalidModificationException, EncodingException, FileExistsException
  {
    String str = FileHelper.getRealPath(paramString1, this.cordova);
    Object localObject = FileHelper.getRealPath(paramString2, this.cordova);
    if ((paramString3 != null) && (paramString3.contains(":"))) {
      throw new EncodingException("Bad file name");
    }
    paramString2 = new File(str);
    if (!paramString2.exists()) {
      throw new FileNotFoundException("The source does not exist");
    }
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {
      throw new FileNotFoundException("The source does not exist");
    }
    paramString3 = createDestination(paramString3, paramString2, (File)localObject);
    if (paramString2.getAbsolutePath().equals(paramString3.getAbsolutePath())) {
      throw new InvalidModificationException("Can't copy a file onto itself");
    }
    if (paramString2.isDirectory()) {
      if (paramBoolean) {
        paramString2 = moveDirectory(paramString2, paramString3);
      }
    }
    for (;;)
    {
      return paramString2;
      paramString2 = copyDirectory(paramString2, paramString3);
      continue;
      if (paramBoolean)
      {
        paramString3 = moveFile(paramString2, paramString3);
        paramString2 = paramString3;
        if (paramString1.startsWith("content://"))
        {
          notifyDelete(paramString1);
          paramString2 = paramString3;
        }
      }
      else
      {
        paramString2 = copyFile(paramString2, paramString3);
      }
    }
  }
  
  /* Error */
  private long truncateFile(String paramString, long paramLong)
    throws FileNotFoundException, IOException, NoModificationAllowedException
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 504
    //   4: invokevirtual 241	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   7: ifeq +14 -> 21
    //   10: new 170	org/apache/cordova/file/NoModificationAllowedException
    //   13: dup
    //   14: ldc_w 510
    //   17: invokespecial 196	org/apache/cordova/file/NoModificationAllowedException:<init>	(Ljava/lang/String;)V
    //   20: athrow
    //   21: new 512	java/io/RandomAccessFile
    //   24: dup
    //   25: aload_1
    //   26: aload_0
    //   27: getfield 81	org/apache/cordova/FileUtils:cordova	Lorg/apache/cordova/api/CordovaInterface;
    //   30: invokestatic 87	org/apache/cordova/FileHelper:getRealPath	(Ljava/lang/String;Lorg/apache/cordova/api/CordovaInterface;)Ljava/lang/String;
    //   33: ldc_w 514
    //   36: invokespecial 517	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: astore_1
    //   40: aload_1
    //   41: invokevirtual 518	java/io/RandomAccessFile:length	()J
    //   44: lload_2
    //   45: lcmp
    //   46: iflt +18 -> 64
    //   49: aload_1
    //   50: invokevirtual 519	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   53: lload_2
    //   54: invokevirtual 523	java/nio/channels/FileChannel:truncate	(J)Ljava/nio/channels/FileChannel;
    //   57: pop
    //   58: aload_1
    //   59: invokevirtual 524	java/io/RandomAccessFile:close	()V
    //   62: lload_2
    //   63: lreturn
    //   64: aload_1
    //   65: invokevirtual 518	java/io/RandomAccessFile:length	()J
    //   68: lstore_2
    //   69: goto -11 -> 58
    //   72: astore 4
    //   74: aload_1
    //   75: invokevirtual 524	java/io/RandomAccessFile:close	()V
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	FileUtils
    //   0	81	1	paramString	String
    //   0	81	2	paramLong	long
    //   72	7	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	58	72	finally
    //   64	69	72	finally
  }
  
  public boolean execute(String paramString, JSONArray paramJSONArray, CallbackContext paramCallbackContext)
    throws JSONException
  {
    try
    {
      if (paramString.equals("testSaveLocationExists"))
      {
        bool = DirectoryManager.testSaveLocationExists();
        paramString = new org/apache/cordova/api/PluginResult;
        paramString.<init>(PluginResult.Status.OK, bool);
        paramCallbackContext.sendPluginResult(paramString);
      }
      for (;;)
      {
        bool = true;
        return bool;
        if (!paramString.equals("getFreeDiskSpace")) {
          break;
        }
        l = DirectoryManager.getFreeDiskSpace(false);
        paramString = new org/apache/cordova/api/PluginResult;
        paramString.<init>(PluginResult.Status.OK, (float)l);
        paramCallbackContext.sendPluginResult(paramString);
      }
    }
    catch (FileNotFoundException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(NOT_FOUND_ERR);
        continue;
        if (!paramString.equals("testFileExists")) {
          break;
        }
        bool = DirectoryManager.testFileExists(paramJSONArray.getString(0));
        paramString = new org/apache/cordova/api/PluginResult;
        paramString.<init>(PluginResult.Status.OK, bool);
        paramCallbackContext.sendPluginResult(paramString);
      }
    }
    catch (FileExistsException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(PATH_EXISTS_ERR);
        continue;
        if (!paramString.equals("testDirectoryExists")) {
          break;
        }
        bool = DirectoryManager.testFileExists(paramJSONArray.getString(0));
        paramString = new org/apache/cordova/api/PluginResult;
        paramString.<init>(PluginResult.Status.OK, bool);
        paramCallbackContext.sendPluginResult(paramString);
      }
    }
    catch (NoModificationAllowedException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(NO_MODIFICATION_ALLOWED_ERR);
        continue;
        if (!paramString.equals("readAsText")) {
          break;
        }
        paramString = paramJSONArray.getString(1);
        j = paramJSONArray.getInt(2);
        i = paramJSONArray.getInt(3);
        readFileAs(paramJSONArray.getString(0), j, i, paramCallbackContext, paramString, 1);
      }
    }
    catch (InvalidModificationException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(INVALID_MODIFICATION_ERR);
        continue;
        if (!paramString.equals("readAsDataURL")) {
          break;
        }
        j = paramJSONArray.getInt(1);
        i = paramJSONArray.getInt(2);
        readFileAs(paramJSONArray.getString(0), j, i, paramCallbackContext, null, -1);
      }
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(ENCODING_ERR);
        continue;
        if (!paramString.equals("readAsArrayBuffer")) {
          break;
        }
        j = paramJSONArray.getInt(1);
        i = paramJSONArray.getInt(2);
        readFileAs(paramJSONArray.getString(0), j, i, paramCallbackContext, null, 6);
      }
    }
    catch (IOException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(INVALID_MODIFICATION_ERR);
        continue;
        if (!paramString.equals("readAsBinaryString")) {
          break;
        }
        int j = paramJSONArray.getInt(1);
        int i = paramJSONArray.getInt(2);
        readFileAs(paramJSONArray.getString(0), j, i, paramCallbackContext, null, 7);
      }
    }
    catch (EncodingException paramString)
    {
      for (;;)
      {
        paramCallbackContext.error(ENCODING_ERR);
        continue;
        if (!paramString.equals("write")) {
          break;
        }
        l = write(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getInt(2));
        paramString = new org/apache/cordova/api/PluginResult;
        paramString.<init>(PluginResult.Status.OK, (float)l);
        paramCallbackContext.sendPluginResult(paramString);
      }
    }
    catch (TypeMismatchException paramString)
    {
      for (;;)
      {
        boolean bool;
        long l;
        paramCallbackContext.error(TYPE_MISMATCH_ERR);
        continue;
        if (paramString.equals("truncate"))
        {
          l = truncateFile(paramJSONArray.getString(0), paramJSONArray.getLong(1));
          paramString = new org/apache/cordova/api/PluginResult;
          paramString.<init>(PluginResult.Status.OK, (float)l);
          paramCallbackContext.sendPluginResult(paramString);
        }
        else if (paramString.equals("requestFileSystem"))
        {
          l = paramJSONArray.optLong(1);
          if ((l != 0L) && (l > DirectoryManager.getFreeDiskSpace(true) * 1024L))
          {
            paramString = new org/apache/cordova/api/PluginResult;
            paramString.<init>(PluginResult.Status.ERROR, QUOTA_EXCEEDED_ERR);
            paramCallbackContext.sendPluginResult(paramString);
          }
          else
          {
            paramCallbackContext.success(requestFileSystem(paramJSONArray.getInt(0)));
          }
        }
        else if (paramString.equals("resolveLocalFileSystemURI"))
        {
          paramCallbackContext.success(resolveLocalFileSystemURI(paramJSONArray.getString(0)));
        }
        else if (paramString.equals("getMetadata"))
        {
          paramString = new org/apache/cordova/api/PluginResult;
          paramString.<init>(PluginResult.Status.OK, (float)getMetadata(paramJSONArray.getString(0)));
          paramCallbackContext.sendPluginResult(paramString);
        }
        else if (paramString.equals("getFileMetadata"))
        {
          paramCallbackContext.success(getFileMetadata(paramJSONArray.getString(0)));
        }
        else if (paramString.equals("getParent"))
        {
          paramCallbackContext.success(getParent(paramJSONArray.getString(0)));
        }
        else if (paramString.equals("getDirectory"))
        {
          paramCallbackContext.success(getFile(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.optJSONObject(2), true));
        }
        else if (paramString.equals("getFile"))
        {
          paramCallbackContext.success(getFile(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.optJSONObject(2), false));
        }
        else if (paramString.equals("remove"))
        {
          if (remove(paramJSONArray.getString(0)))
          {
            notifyDelete(paramJSONArray.getString(0));
            paramCallbackContext.success();
          }
          else
          {
            paramCallbackContext.error(NO_MODIFICATION_ALLOWED_ERR);
          }
        }
        else if (paramString.equals("removeRecursively"))
        {
          if (removeRecursively(paramJSONArray.getString(0))) {
            paramCallbackContext.success();
          } else {
            paramCallbackContext.error(NO_MODIFICATION_ALLOWED_ERR);
          }
        }
        else if (paramString.equals("moveTo"))
        {
          paramCallbackContext.success(transferTo(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getString(2), true));
        }
        else if (paramString.equals("copyTo"))
        {
          paramCallbackContext.success(transferTo(paramJSONArray.getString(0), paramJSONArray.getString(1), paramJSONArray.getString(2), false));
        }
        else if (paramString.equals("readEntries"))
        {
          paramCallbackContext.success(readEntries(paramJSONArray.getString(0)));
        }
        else
        {
          bool = false;
        }
      }
    }
  }
  
  public void readFileAs(final String paramString1, final int paramInt1, final int paramInt2, final CallbackContext paramCallbackContext, final String paramString2, final int paramInt3)
  {
    this.cordova.getThreadPool().execute(new Runnable()
    {
      public void run()
      {
        for (;;)
        {
          try
          {
            localObject1 = FileUtils.this.readAsBinaryHelper(paramString1, paramInt1, paramInt2);
            switch (paramInt3)
            {
            default: 
              localObject2 = FileHelper.getMimeType(paramString1, FileUtils.this.cordova);
              localObject1 = Base64.encodeBase64((byte[])localObject1);
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>();
              localObject2 = ((StringBuilder)localObject3).append("data:").append((String)localObject2).append(";base64,");
              localObject3 = new java/lang/String;
              ((String)localObject3).<init>((byte[])localObject1, "US-ASCII");
              localObject2 = (String)localObject3;
              localObject1 = new org/apache/cordova/api/PluginResult;
              ((PluginResult)localObject1).<init>(PluginResult.Status.OK, (String)localObject2);
              paramCallbackContext.sendPluginResult((PluginResult)localObject1);
              return;
            }
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            Object localObject1;
            Object localObject2;
            Object localObject3;
            paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, FileUtils.NOT_FOUND_ERR));
            continue;
          }
          catch (IOException localIOException)
          {
            Log.d("FileUtils", localIOException.getLocalizedMessage());
            paramCallbackContext.sendPluginResult(new PluginResult(PluginResult.Status.IO_EXCEPTION, FileUtils.NOT_READABLE_ERR));
            continue;
          }
          localObject2 = PluginResult.Status.OK;
          localObject3 = new java/lang/String;
          ((String)localObject3).<init>((byte[])localObject1, paramString2);
          localObject1 = new PluginResult((PluginResult.Status)localObject2, (String)localObject3);
          continue;
          localObject1 = new PluginResult(PluginResult.Status.OK, (byte[])localObject1);
          continue;
          localObject1 = new PluginResult(PluginResult.Status.OK, (byte[])localObject1, true);
        }
      }
    });
  }
  
  public long write(String paramString1, String paramString2, int paramInt)
    throws FileNotFoundException, IOException, NoModificationAllowedException
  {
    if (paramString1.startsWith("content://")) {
      throw new NoModificationAllowedException("Couldn't write to file given its content URI");
    }
    Object localObject = FileHelper.getRealPath(paramString1, this.cordova);
    boolean bool = false;
    if (paramInt > 0)
    {
      truncateFile((String)localObject, paramInt);
      bool = true;
    }
    paramString2 = paramString2.getBytes();
    paramString1 = new ByteArrayInputStream(paramString2);
    localObject = new FileOutputStream((String)localObject, bool);
    byte[] arrayOfByte = new byte[paramString2.length];
    paramString1.read(arrayOfByte, 0, arrayOfByte.length);
    ((FileOutputStream)localObject).write(arrayOfByte, 0, paramString2.length);
    ((FileOutputStream)localObject).flush();
    ((FileOutputStream)localObject).close();
    return paramString2.length;
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\cordova\FileUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */