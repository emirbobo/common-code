package org.webrtc.videoengine;

import android.opengl.GLSurfaceView.EGLConfigChooser;
import android.util.Log;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;

class ViEAndroidGLES20$ConfigChooser
  implements GLSurfaceView.EGLConfigChooser
{
  private static int EGL_OPENGL_ES2_BIT = 4;
  private static int[] s_configAttribs2 = { 12324, 4, 12323, 4, 12322, 4, 12352, EGL_OPENGL_ES2_BIT, 12344 };
  protected int mAlphaSize;
  protected int mBlueSize;
  protected int mDepthSize;
  protected int mGreenSize;
  protected int mRedSize;
  protected int mStencilSize;
  private int[] mValue = new int[1];
  
  public ViEAndroidGLES20$ConfigChooser(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    this.mRedSize = paramInt1;
    this.mGreenSize = paramInt2;
    this.mBlueSize = paramInt3;
    this.mAlphaSize = paramInt4;
    this.mDepthSize = paramInt5;
    this.mStencilSize = paramInt6;
  }
  
  private int findConfigAttrib(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig, int paramInt1, int paramInt2)
  {
    if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, paramInt1, this.mValue)) {
      paramInt2 = this.mValue[0];
    }
    return paramInt2;
  }
  
  private void printConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig paramEGLConfig)
  {
    int[] arrayOfInt1 = new int[33];
    int[] tmp8_6 = arrayOfInt1;
    tmp8_6[0] = '〠';
    int[] tmp14_8 = tmp8_6;
    tmp14_8[1] = '〡';
    int[] tmp20_14 = tmp14_8;
    tmp20_14[2] = '〢';
    int[] tmp26_20 = tmp20_14;
    tmp26_20[3] = '〣';
    int[] tmp32_26 = tmp26_20;
    tmp32_26[4] = '〤';
    int[] tmp38_32 = tmp32_26;
    tmp38_32[5] = '〥';
    int[] tmp44_38 = tmp38_32;
    tmp44_38[6] = '〦';
    int[] tmp51_44 = tmp44_38;
    tmp51_44[7] = '〧';
    int[] tmp58_51 = tmp51_44;
    tmp58_51[8] = '〨';
    int[] tmp65_58 = tmp58_51;
    tmp65_58[9] = '〩';
    int[] tmp72_65 = tmp65_58;
    tmp72_65[10] = '〪';
    int[] tmp79_72 = tmp72_65;
    tmp79_72[11] = '〫';
    int[] tmp86_79 = tmp79_72;
    tmp86_79[12] = '〬';
    int[] tmp93_86 = tmp86_79;
    tmp93_86[13] = '〭';
    int[] tmp100_93 = tmp93_86;
    tmp100_93[14] = '〮';
    int[] tmp107_100 = tmp100_93;
    tmp107_100[15] = '〯';
    int[] tmp114_107 = tmp107_100;
    tmp114_107[16] = '〰';
    int[] tmp121_114 = tmp114_107;
    tmp121_114[17] = '〱';
    int[] tmp128_121 = tmp121_114;
    tmp128_121[18] = '〲';
    int[] tmp135_128 = tmp128_121;
    tmp135_128[19] = '〳';
    int[] tmp142_135 = tmp135_128;
    tmp142_135[20] = '〴';
    int[] tmp149_142 = tmp142_135;
    tmp149_142[21] = '〷';
    int[] tmp156_149 = tmp149_142;
    tmp156_149[22] = '〶';
    int[] tmp163_156 = tmp156_149;
    tmp163_156[23] = '〵';
    int[] tmp170_163 = tmp163_156;
    tmp170_163[24] = '〹';
    int[] tmp177_170 = tmp170_163;
    tmp177_170[25] = '〺';
    int[] tmp184_177 = tmp177_170;
    tmp184_177[26] = '〻';
    int[] tmp191_184 = tmp184_177;
    tmp191_184[27] = '〼';
    int[] tmp198_191 = tmp191_184;
    tmp198_191[28] = '〽';
    int[] tmp205_198 = tmp198_191;
    tmp205_198[29] = '〾';
    int[] tmp212_205 = tmp205_198;
    tmp212_205[30] = '〿';
    int[] tmp219_212 = tmp212_205;
    tmp219_212[31] = '぀';
    int[] tmp226_219 = tmp219_212;
    tmp226_219[32] = 'あ';
    tmp226_219;
    int[] arrayOfInt2 = new int[1];
    int i = 0;
    if (i < arrayOfInt1.length)
    {
      int j = arrayOfInt1[i];
      String str = new String[] { "EGL_BUFFER_SIZE", "EGL_ALPHA_SIZE", "EGL_BLUE_SIZE", "EGL_GREEN_SIZE", "EGL_RED_SIZE", "EGL_DEPTH_SIZE", "EGL_STENCIL_SIZE", "EGL_CONFIG_CAVEAT", "EGL_CONFIG_ID", "EGL_LEVEL", "EGL_MAX_PBUFFER_HEIGHT", "EGL_MAX_PBUFFER_PIXELS", "EGL_MAX_PBUFFER_WIDTH", "EGL_NATIVE_RENDERABLE", "EGL_NATIVE_VISUAL_ID", "EGL_NATIVE_VISUAL_TYPE", "EGL_PRESERVED_RESOURCES", "EGL_SAMPLES", "EGL_SAMPLE_BUFFERS", "EGL_SURFACE_TYPE", "EGL_TRANSPARENT_TYPE", "EGL_TRANSPARENT_RED_VALUE", "EGL_TRANSPARENT_GREEN_VALUE", "EGL_TRANSPARENT_BLUE_VALUE", "EGL_BIND_TO_TEXTURE_RGB", "EGL_BIND_TO_TEXTURE_RGBA", "EGL_MIN_SWAP_INTERVAL", "EGL_MAX_SWAP_INTERVAL", "EGL_LUMINANCE_SIZE", "EGL_ALPHA_MASK_SIZE", "EGL_COLOR_BUFFER_TYPE", "EGL_RENDERABLE_TYPE", "EGL_CONFORMANT" }[i];
      if (paramEGL10.eglGetConfigAttrib(paramEGLDisplay, paramEGLConfig, j, arrayOfInt2)) {
        Log.w(ViEAndroidGLES20.access$100(), String.format("  %s: %d\n", new Object[] { str, Integer.valueOf(arrayOfInt2[0]) }));
      }
      for (;;)
      {
        i++;
        break;
        while (paramEGL10.eglGetError() != 12288) {}
      }
    }
  }
  
  private void printConfigs(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int j = paramArrayOfEGLConfig.length;
    Log.w(ViEAndroidGLES20.access$100(), String.format("%d configurations", new Object[] { Integer.valueOf(j) }));
    for (int i = 0; i < j; i++)
    {
      Log.w(ViEAndroidGLES20.access$100(), String.format("Configuration %d:\n", new Object[] { Integer.valueOf(i) }));
      printConfig(paramEGL10, paramEGLDisplay, paramArrayOfEGLConfig[i]);
    }
  }
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay)
  {
    int[] arrayOfInt = new int[1];
    paramEGL10.eglChooseConfig(paramEGLDisplay, s_configAttribs2, null, 0, arrayOfInt);
    int i = arrayOfInt[0];
    if (i <= 0) {
      throw new IllegalArgumentException("No configs match configSpec");
    }
    EGLConfig[] arrayOfEGLConfig = new EGLConfig[i];
    paramEGL10.eglChooseConfig(paramEGLDisplay, s_configAttribs2, arrayOfEGLConfig, i, arrayOfInt);
    return chooseConfig(paramEGL10, paramEGLDisplay, arrayOfEGLConfig);
  }
  
  public EGLConfig chooseConfig(EGL10 paramEGL10, EGLDisplay paramEGLDisplay, EGLConfig[] paramArrayOfEGLConfig)
  {
    int j = paramArrayOfEGLConfig.length;
    int i = 0;
    EGLConfig localEGLConfig;
    if (i < j)
    {
      localEGLConfig = paramArrayOfEGLConfig[i];
      int m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12325, 0);
      int k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12326, 0);
      if ((m >= this.mDepthSize) && (k >= this.mStencilSize))
      {
        k = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12324, 0);
        m = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12323, 0);
        int n = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12322, 0);
        int i1 = findConfigAttrib(paramEGL10, paramEGLDisplay, localEGLConfig, 12321, 0);
        if ((k != this.mRedSize) || (m != this.mGreenSize) || (n != this.mBlueSize) || (i1 != this.mAlphaSize)) {}
      }
    }
    for (paramEGL10 = localEGLConfig;; paramEGL10 = null)
    {
      return paramEGL10;
      i++;
      break;
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\webrtc\videoengine\ViEAndroidGLES20$ConfigChooser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */