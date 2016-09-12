package com.ta.utdid2.core.persistent;

import com.bangcle.andjni.JniLib;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

class XmlUtils
{
  static
  {
    JniLib.a(XmlUtils.class, 1072);
  }
  
  public static final native void beginDocument(XmlPullParser paramXmlPullParser, String paramString)
    throws XmlPullParserException, IOException;
  
  public static final native boolean convertValueToBoolean(CharSequence paramCharSequence, boolean paramBoolean);
  
  public static final native int convertValueToInt(CharSequence paramCharSequence, int paramInt);
  
  public static final native int convertValueToList(CharSequence paramCharSequence, String[] paramArrayOfString, int paramInt);
  
  public static final native int convertValueToUnsignedInt(String paramString, int paramInt);
  
  public static final native void nextElement(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException;
  
  public static final native int parseUnsignedIntAttribute(CharSequence paramCharSequence);
  
  public static final native ArrayList readListXml(InputStream paramInputStream)
    throws XmlPullParserException, IOException;
  
  public static final native HashMap readMapXml(InputStream paramInputStream)
    throws XmlPullParserException, IOException;
  
  public static final native int[] readThisIntArrayXml(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
    throws XmlPullParserException, IOException;
  
  public static final native ArrayList readThisListXml(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
    throws XmlPullParserException, IOException;
  
  public static final native HashMap readThisMapXml(XmlPullParser paramXmlPullParser, String paramString, String[] paramArrayOfString)
    throws XmlPullParserException, IOException;
  
  private static final native Object readThisValueXml(XmlPullParser paramXmlPullParser, String[] paramArrayOfString)
    throws XmlPullParserException, IOException;
  
  public static final native Object readValueXml(XmlPullParser paramXmlPullParser, String[] paramArrayOfString)
    throws XmlPullParserException, IOException;
  
  public static native void skipCurrentTag(XmlPullParser paramXmlPullParser)
    throws XmlPullParserException, IOException;
  
  public static final native void writeByteArrayXml(byte[] paramArrayOfByte, String paramString, XmlSerializer paramXmlSerializer)
    throws XmlPullParserException, IOException;
  
  public static final native void writeIntArrayXml(int[] paramArrayOfInt, String paramString, XmlSerializer paramXmlSerializer)
    throws XmlPullParserException, IOException;
  
  public static final native void writeListXml(List paramList, OutputStream paramOutputStream)
    throws XmlPullParserException, IOException;
  
  public static final native void writeListXml(List paramList, String paramString, XmlSerializer paramXmlSerializer)
    throws XmlPullParserException, IOException;
  
  public static final native void writeMapXml(Map paramMap, OutputStream paramOutputStream)
    throws XmlPullParserException, IOException;
  
  public static final native void writeMapXml(Map paramMap, String paramString, XmlSerializer paramXmlSerializer)
    throws XmlPullParserException, IOException;
  
  public static final native void writeValueXml(Object paramObject, String paramString, XmlSerializer paramXmlSerializer)
    throws XmlPullParserException, IOException;
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\ta\utdid2\core\persistent\XmlUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */