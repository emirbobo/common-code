package org.apache.commons.codec.language;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;

public class DoubleMetaphone
  implements StringEncoder
{
  private static final String[] ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER = { "ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER" };
  private static final String[] L_R_N_M_B_H_F_V_W_SPACE;
  private static final String[] L_T_K_S_N_M_B_Z = { "L", "T", "K", "S", "N", "M", "B", "Z" };
  private static final String[] SILENT_START = { "GN", "KN", "PN", "WR", "PS" };
  private static final String VOWELS = "AEIOUY";
  private int maxCodeLen = 4;
  
  static
  {
    L_R_N_M_B_H_F_V_W_SPACE = new String[] { "L", "R", "N", "M", "B", "H", "F", "V", "W", " " };
  }
  
  private String cleanInput(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      String str = paramString.trim();
      paramString = (String)localObject;
      if (str.length() != 0) {
        paramString = str.toUpperCase(Locale.ENGLISH);
      }
    }
  }
  
  private boolean conditionC0(String paramString, int paramInt)
  {
    boolean bool2 = false;
    boolean bool1;
    if (contains(paramString, paramInt, 4, "CHIA")) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (paramInt > 1)
      {
        bool1 = bool2;
        if (!isVowel(charAt(paramString, paramInt - 2)))
        {
          bool1 = bool2;
          if (contains(paramString, paramInt - 1, 3, "ACH"))
          {
            int i = charAt(paramString, paramInt + 2);
            if ((i == 73) || (i == 69))
            {
              bool1 = bool2;
              if (!contains(paramString, paramInt - 2, 6, "BACHER", "MACHER")) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
  }
  
  private boolean conditionCH0(String paramString, int paramInt)
  {
    boolean bool;
    if (paramInt != 0) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if ((!contains(paramString, paramInt + 1, 5, "HARAC", "HARIS")) && (!contains(paramString, paramInt + 1, 3, "HOR", "HYM", "HIA", "HEM"))) {
        bool = false;
      } else if (contains(paramString, 0, 5, "CHORE")) {
        bool = false;
      } else {
        bool = true;
      }
    }
  }
  
  private boolean conditionCH1(String paramString, int paramInt)
  {
    if ((contains(paramString, 0, 4, "VAN ", "VON ")) || (contains(paramString, 0, 3, "SCH")) || (contains(paramString, paramInt - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) || (contains(paramString, paramInt + 2, 1, "T", "S")) || (((contains(paramString, paramInt - 1, 1, "A", "O", "U", "E")) || (paramInt == 0)) && ((contains(paramString, paramInt + 2, 1, L_R_N_M_B_H_F_V_W_SPACE)) || (paramInt + 1 == paramString.length() - 1)))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean conditionL0(String paramString, int paramInt)
  {
    boolean bool;
    if ((paramInt == paramString.length() - 3) && (contains(paramString, paramInt - 1, 4, "ILLO", "ILLA", "ALLE"))) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      if (((contains(paramString, paramString.length() - 2, 2, "AS", "OS")) || (contains(paramString, paramString.length() - 1, 1, "A", "O"))) && (contains(paramString, paramInt - 1, 4, "ALLE"))) {
        bool = true;
      } else {
        bool = false;
      }
    }
  }
  
  private boolean conditionM0(String paramString, int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if (charAt(paramString, paramInt + 1) == 'M') {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if (contains(paramString, paramInt - 1, 3, "UMB"))
      {
        bool1 = bool2;
        if (paramInt + 1 != paramString.length() - 1)
        {
          bool1 = bool2;
          if (contains(paramString, paramInt + 2, 2, "ER")) {}
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, paramString5 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, paramString5, paramString6 });
  }
  
  private static boolean contains(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    return contains(paramString1, paramInt1, paramInt2, new String[] { paramString2, paramString3, paramString4, paramString5, paramString6, paramString7 });
  }
  
  protected static boolean contains(String paramString, int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt1 >= 0)
    {
      bool1 = bool2;
      if (paramInt1 + paramInt2 <= paramString.length()) {
        paramString = paramString.substring(paramInt1, paramInt1 + paramInt2);
      }
    }
    for (paramInt1 = 0;; paramInt1++)
    {
      bool1 = bool2;
      if (paramInt1 < paramArrayOfString.length)
      {
        if (paramString.equals(paramArrayOfString[paramInt1])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
    }
  }
  
  private int handleAEIOUY(DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (paramInt == 0) {
      paramDoubleMetaphoneResult.append('A');
    }
    return paramInt + 1;
  }
  
  private int handleC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (conditionC0(paramString, paramInt))
    {
      paramDoubleMetaphoneResult.append('K');
      paramInt += 2;
    }
    for (;;)
    {
      return paramInt;
      if ((paramInt == 0) && (contains(paramString, paramInt, 6, "CAESAR")))
      {
        paramDoubleMetaphoneResult.append('S');
        paramInt += 2;
      }
      else if (contains(paramString, paramInt, 2, "CH"))
      {
        paramInt = handleCH(paramString, paramDoubleMetaphoneResult, paramInt);
      }
      else if ((contains(paramString, paramInt, 2, "CZ")) && (!contains(paramString, paramInt - 2, 4, "WICZ")))
      {
        paramDoubleMetaphoneResult.append('S', 'X');
        paramInt += 2;
      }
      else if (contains(paramString, paramInt + 1, 3, "CIA"))
      {
        paramDoubleMetaphoneResult.append('X');
        paramInt += 3;
      }
      else if ((contains(paramString, paramInt, 2, "CC")) && ((paramInt != 1) || (charAt(paramString, 0) != 'M')))
      {
        paramInt = handleCC(paramString, paramDoubleMetaphoneResult, paramInt);
      }
      else if (contains(paramString, paramInt, 2, "CK", "CG", "CQ"))
      {
        paramDoubleMetaphoneResult.append('K');
        paramInt += 2;
      }
      else
      {
        if (contains(paramString, paramInt, 2, "CI", "CE", "CY"))
        {
          if (contains(paramString, paramInt, 3, "CIO", "CIE", "CIA")) {
            paramDoubleMetaphoneResult.append('S', 'X');
          }
          for (;;)
          {
            paramInt += 2;
            break;
            paramDoubleMetaphoneResult.append('S');
          }
        }
        paramDoubleMetaphoneResult.append('K');
        if (contains(paramString, paramInt + 1, 2, " C", " Q", " G")) {
          paramInt += 3;
        } else if ((contains(paramString, paramInt + 1, 1, "C", "K", "Q")) && (!contains(paramString, paramInt + 1, 2, "CE", "CI"))) {
          paramInt += 2;
        } else {
          paramInt++;
        }
      }
    }
  }
  
  private int handleCC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if ((contains(paramString, paramInt + 2, 1, "I", "E", "H")) && (!contains(paramString, paramInt + 2, 2, "HU"))) {
      if (((paramInt == 1) && (charAt(paramString, paramInt - 1) == 'A')) || (contains(paramString, paramInt - 1, 5, "UCCEE", "UCCES")))
      {
        paramDoubleMetaphoneResult.append("KS");
        paramInt += 3;
      }
    }
    for (;;)
    {
      return paramInt;
      paramDoubleMetaphoneResult.append('X');
      break;
      paramDoubleMetaphoneResult.append('K');
      paramInt += 2;
    }
  }
  
  private int handleCH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if ((paramInt > 0) && (contains(paramString, paramInt, 4, "CHAE")))
    {
      paramDoubleMetaphoneResult.append('K', 'X');
      paramInt += 2;
    }
    for (;;)
    {
      return paramInt;
      if (conditionCH0(paramString, paramInt))
      {
        paramDoubleMetaphoneResult.append('K');
        paramInt += 2;
      }
      else
      {
        if (!conditionCH1(paramString, paramInt)) {
          break;
        }
        paramDoubleMetaphoneResult.append('K');
        paramInt += 2;
      }
    }
    if (paramInt > 0) {
      if (contains(paramString, 0, 2, "MC")) {
        paramDoubleMetaphoneResult.append('K');
      }
    }
    for (;;)
    {
      paramInt += 2;
      break;
      paramDoubleMetaphoneResult.append('X', 'K');
      continue;
      paramDoubleMetaphoneResult.append('X');
    }
  }
  
  private int handleD(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (contains(paramString, paramInt, 2, "DG")) {
      if (contains(paramString, paramInt + 2, 1, "I", "E", "Y"))
      {
        paramDoubleMetaphoneResult.append('J');
        paramInt += 3;
      }
    }
    for (;;)
    {
      return paramInt;
      paramDoubleMetaphoneResult.append("TK");
      paramInt += 2;
      continue;
      if (contains(paramString, paramInt, 2, "DT", "DD"))
      {
        paramDoubleMetaphoneResult.append('T');
        paramInt += 2;
      }
      else
      {
        paramDoubleMetaphoneResult.append('T');
        paramInt++;
      }
    }
  }
  
  private int handleG(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if (charAt(paramString, paramInt + 1) == 'H') {
      paramInt = handleGH(paramString, paramDoubleMetaphoneResult, paramInt);
    }
    for (;;)
    {
      return paramInt;
      if (charAt(paramString, paramInt + 1) == 'N')
      {
        if ((paramInt == 1) && (isVowel(charAt(paramString, 0))) && (!paramBoolean)) {
          paramDoubleMetaphoneResult.append("KN", "N");
        }
        for (;;)
        {
          paramInt += 2;
          break;
          if ((!contains(paramString, paramInt + 2, 2, "EY")) && (charAt(paramString, paramInt + 1) != 'Y') && (!paramBoolean)) {
            paramDoubleMetaphoneResult.append("N", "KN");
          } else {
            paramDoubleMetaphoneResult.append("KN");
          }
        }
      }
      if ((contains(paramString, paramInt + 1, 2, "LI")) && (!paramBoolean))
      {
        paramDoubleMetaphoneResult.append("KL", "L");
        paramInt += 2;
      }
      else if ((paramInt == 0) && ((charAt(paramString, paramInt + 1) == 'Y') || (contains(paramString, paramInt + 1, 2, ES_EP_EB_EL_EY_IB_IL_IN_IE_EI_ER))))
      {
        paramDoubleMetaphoneResult.append('K', 'J');
        paramInt += 2;
      }
      else if (((contains(paramString, paramInt + 1, 2, "ER")) || (charAt(paramString, paramInt + 1) == 'Y')) && (!contains(paramString, 0, 6, "DANGER", "RANGER", "MANGER")) && (!contains(paramString, paramInt - 1, 1, "E", "I")) && (!contains(paramString, paramInt - 1, 3, "RGY", "OGY")))
      {
        paramDoubleMetaphoneResult.append('K', 'J');
        paramInt += 2;
      }
      else
      {
        if ((contains(paramString, paramInt + 1, 1, "E", "I", "Y")) || (contains(paramString, paramInt - 1, 4, "AGGI", "OGGI")))
        {
          if ((contains(paramString, 0, 4, "VAN ", "VON ")) || (contains(paramString, 0, 3, "SCH")) || (contains(paramString, paramInt + 1, 2, "ET"))) {
            paramDoubleMetaphoneResult.append('K');
          }
          for (;;)
          {
            paramInt += 2;
            break;
            if (contains(paramString, paramInt + 1, 3, "IER")) {
              paramDoubleMetaphoneResult.append('J');
            } else {
              paramDoubleMetaphoneResult.append('J', 'K');
            }
          }
        }
        if (charAt(paramString, paramInt + 1) == 'G')
        {
          paramInt += 2;
          paramDoubleMetaphoneResult.append('K');
        }
        else
        {
          paramInt++;
          paramDoubleMetaphoneResult.append('K');
        }
      }
    }
  }
  
  private int handleGH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if ((paramInt > 0) && (!isVowel(charAt(paramString, paramInt - 1))))
    {
      paramDoubleMetaphoneResult.append('K');
      paramInt += 2;
    }
    for (;;)
    {
      return paramInt;
      if (paramInt == 0)
      {
        if (charAt(paramString, paramInt + 2) == 'I') {
          paramDoubleMetaphoneResult.append('J');
        }
        for (;;)
        {
          paramInt += 2;
          break;
          paramDoubleMetaphoneResult.append('K');
        }
      }
      if (((paramInt <= 1) || (!contains(paramString, paramInt - 2, 1, "B", "H", "D"))) && ((paramInt <= 2) || (!contains(paramString, paramInt - 3, 1, "B", "H", "D"))) && ((paramInt <= 3) || (!contains(paramString, paramInt - 4, 1, "B", "H")))) {
        break;
      }
      paramInt += 2;
    }
    if ((paramInt > 2) && (charAt(paramString, paramInt - 1) == 'U') && (contains(paramString, paramInt - 3, 1, "C", "G", "L", "R", "T"))) {
      paramDoubleMetaphoneResult.append('F');
    }
    for (;;)
    {
      paramInt += 2;
      break;
      if ((paramInt > 0) && (charAt(paramString, paramInt - 1) != 'I')) {
        paramDoubleMetaphoneResult.append('K');
      }
    }
  }
  
  private int handleH(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (((paramInt == 0) || (isVowel(charAt(paramString, paramInt - 1)))) && (isVowel(charAt(paramString, paramInt + 1))))
    {
      paramDoubleMetaphoneResult.append('H');
      paramInt += 2;
    }
    for (;;)
    {
      return paramInt;
      paramInt++;
    }
  }
  
  private int handleJ(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if ((contains(paramString, paramInt, 4, "JOSE")) || (contains(paramString, 0, 4, "SAN "))) {
      if (((paramInt == 0) && (charAt(paramString, paramInt + 4) == ' ')) || (paramString.length() == 4) || (contains(paramString, 0, 4, "SAN ")))
      {
        paramDoubleMetaphoneResult.append('H');
        paramInt++;
      }
    }
    for (;;)
    {
      return paramInt;
      paramDoubleMetaphoneResult.append('J', 'H');
      break;
      if ((paramInt == 0) && (!contains(paramString, paramInt, 4, "JOSE"))) {
        paramDoubleMetaphoneResult.append('J', 'A');
      }
      for (;;)
      {
        if (charAt(paramString, paramInt + 1) != 'J') {
          break label244;
        }
        paramInt += 2;
        break;
        if ((isVowel(charAt(paramString, paramInt - 1))) && (!paramBoolean) && ((charAt(paramString, paramInt + 1) == 'A') || (charAt(paramString, paramInt + 1) == 'O'))) {
          paramDoubleMetaphoneResult.append('J', 'H');
        } else if (paramInt == paramString.length() - 1) {
          paramDoubleMetaphoneResult.append('J', ' ');
        } else if ((!contains(paramString, paramInt + 1, 1, L_T_K_S_N_M_B_Z)) && (!contains(paramString, paramInt - 1, 1, "S", "K", "L"))) {
          paramDoubleMetaphoneResult.append('J');
        }
      }
      label244:
      paramInt++;
    }
  }
  
  private int handleL(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (charAt(paramString, paramInt + 1) == 'L') {
      if (conditionL0(paramString, paramInt))
      {
        paramDoubleMetaphoneResult.appendPrimary('L');
        paramInt += 2;
      }
    }
    for (;;)
    {
      return paramInt;
      paramDoubleMetaphoneResult.append('L');
      break;
      paramInt++;
      paramDoubleMetaphoneResult.append('L');
    }
  }
  
  private int handleP(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (charAt(paramString, paramInt + 1) == 'H')
    {
      paramDoubleMetaphoneResult.append('F');
      paramInt += 2;
      return paramInt;
    }
    paramDoubleMetaphoneResult.append('P');
    if (contains(paramString, paramInt + 1, 1, "P", "B")) {
      paramInt += 2;
    }
    for (;;)
    {
      break;
      paramInt++;
    }
  }
  
  private int handleR(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if ((paramInt == paramString.length() - 1) && (!paramBoolean) && (contains(paramString, paramInt - 2, 2, "IE")) && (!contains(paramString, paramInt - 4, 2, "ME", "MA")))
    {
      paramDoubleMetaphoneResult.appendAlternate('R');
      if (charAt(paramString, paramInt + 1) != 'R') {
        break label78;
      }
      paramInt += 2;
    }
    for (;;)
    {
      return paramInt;
      paramDoubleMetaphoneResult.append('R');
      break;
      label78:
      paramInt++;
    }
  }
  
  private int handleS(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if (contains(paramString, paramInt - 1, 3, "ISL", "YSL")) {
      paramInt++;
    }
    for (;;)
    {
      return paramInt;
      if ((paramInt == 0) && (contains(paramString, paramInt, 5, "SUGAR")))
      {
        paramDoubleMetaphoneResult.append('X', 'S');
        paramInt++;
      }
      else
      {
        if (contains(paramString, paramInt, 2, "SH"))
        {
          if (contains(paramString, paramInt + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
            paramDoubleMetaphoneResult.append('S');
          }
          for (;;)
          {
            paramInt += 2;
            break;
            paramDoubleMetaphoneResult.append('X');
          }
        }
        if ((contains(paramString, paramInt, 3, "SIO", "SIA")) || (contains(paramString, paramInt, 4, "SIAN")))
        {
          if (paramBoolean) {
            paramDoubleMetaphoneResult.append('S');
          }
          for (;;)
          {
            paramInt += 3;
            break;
            paramDoubleMetaphoneResult.append('S', 'X');
          }
        }
        if (((paramInt == 0) && (contains(paramString, paramInt + 1, 1, "M", "N", "L", "W"))) || (contains(paramString, paramInt + 1, 1, "Z")))
        {
          paramDoubleMetaphoneResult.append('S', 'X');
          if (contains(paramString, paramInt + 1, 1, "Z")) {
            paramInt += 2;
          }
          for (;;)
          {
            break;
            paramInt++;
          }
        }
        if (!contains(paramString, paramInt, 2, "SC")) {
          break;
        }
        paramInt = handleSC(paramString, paramDoubleMetaphoneResult, paramInt);
      }
    }
    if ((paramInt == paramString.length() - 1) && (contains(paramString, paramInt - 2, 2, "AI", "OI")))
    {
      paramDoubleMetaphoneResult.appendAlternate('S');
      label288:
      if (!contains(paramString, paramInt + 1, 1, "S", "Z")) {
        break label318;
      }
      paramInt += 2;
    }
    for (;;)
    {
      break;
      paramDoubleMetaphoneResult.append('S');
      break label288;
      label318:
      paramInt++;
    }
  }
  
  private int handleSC(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (charAt(paramString, paramInt + 2) == 'H') {
      if (contains(paramString, paramInt + 3, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
        if (contains(paramString, paramInt + 3, 2, "ER", "EN")) {
          paramDoubleMetaphoneResult.append("X", "SK");
        }
      }
    }
    for (;;)
    {
      return paramInt + 3;
      paramDoubleMetaphoneResult.append("SK");
      continue;
      if ((paramInt == 0) && (!isVowel(charAt(paramString, 3))) && (charAt(paramString, 3) != 'W'))
      {
        paramDoubleMetaphoneResult.append('X', 'S');
      }
      else
      {
        paramDoubleMetaphoneResult.append('X');
        continue;
        if (contains(paramString, paramInt + 2, 1, "I", "E", "Y")) {
          paramDoubleMetaphoneResult.append('S');
        } else {
          paramDoubleMetaphoneResult.append("SK");
        }
      }
    }
  }
  
  private int handleT(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (contains(paramString, paramInt, 4, "TION"))
    {
      paramDoubleMetaphoneResult.append('X');
      paramInt += 3;
    }
    for (;;)
    {
      return paramInt;
      if (!contains(paramString, paramInt, 3, "TIA", "TCH")) {
        break;
      }
      paramDoubleMetaphoneResult.append('X');
      paramInt += 3;
    }
    if ((contains(paramString, paramInt, 2, "TH")) || (contains(paramString, paramInt, 3, "TTH")))
    {
      if ((contains(paramString, paramInt + 2, 2, "OM", "AM")) || (contains(paramString, 0, 4, "VAN ", "VON ")) || (contains(paramString, 0, 3, "SCH"))) {
        paramDoubleMetaphoneResult.append('T');
      }
      for (;;)
      {
        paramInt += 2;
        break;
        paramDoubleMetaphoneResult.append('0', 'T');
      }
    }
    paramDoubleMetaphoneResult.append('T');
    if (contains(paramString, paramInt + 1, 1, "T", "D")) {
      paramInt += 2;
    }
    for (;;)
    {
      break;
      paramInt++;
    }
  }
  
  private int handleW(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (contains(paramString, paramInt, 2, "WR"))
    {
      paramDoubleMetaphoneResult.append('R');
      paramInt += 2;
    }
    for (;;)
    {
      return paramInt;
      if ((paramInt == 0) && ((isVowel(charAt(paramString, paramInt + 1))) || (contains(paramString, paramInt, 2, "WH"))))
      {
        if (isVowel(charAt(paramString, paramInt + 1))) {
          paramDoubleMetaphoneResult.append('A', 'F');
        }
        for (;;)
        {
          paramInt++;
          break;
          paramDoubleMetaphoneResult.append('A');
        }
      }
      if (((paramInt == paramString.length() - 1) && (isVowel(charAt(paramString, paramInt - 1)))) || (contains(paramString, paramInt - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY")) || (contains(paramString, 0, 3, "SCH")))
      {
        paramDoubleMetaphoneResult.appendAlternate('F');
        paramInt++;
      }
      else if (contains(paramString, paramInt, 4, "WICZ", "WITZ"))
      {
        paramDoubleMetaphoneResult.append("TS", "FX");
        paramInt += 4;
      }
      else
      {
        paramInt++;
      }
    }
  }
  
  private int handleX(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt)
  {
    if (paramInt == 0)
    {
      paramDoubleMetaphoneResult.append('S');
      paramInt++;
      return paramInt;
    }
    if ((paramInt != paramString.length() - 1) || ((!contains(paramString, paramInt - 3, 3, "IAU", "EAU")) && (!contains(paramString, paramInt - 2, 2, "AU", "OU")))) {
      paramDoubleMetaphoneResult.append("KS");
    }
    if (contains(paramString, paramInt + 1, 1, "C", "X")) {
      paramInt += 2;
    }
    for (;;)
    {
      break;
      paramInt++;
    }
  }
  
  private int handleZ(String paramString, DoubleMetaphoneResult paramDoubleMetaphoneResult, int paramInt, boolean paramBoolean)
  {
    if (charAt(paramString, paramInt + 1) == 'H')
    {
      paramDoubleMetaphoneResult.append('J');
      paramInt += 2;
      return paramInt;
    }
    if ((contains(paramString, paramInt + 1, 2, "ZO", "ZI", "ZA")) || ((paramBoolean) && (paramInt > 0) && (charAt(paramString, paramInt - 1) != 'T')))
    {
      paramDoubleMetaphoneResult.append("S", "TS");
      label75:
      if (charAt(paramString, paramInt + 1) != 'Z') {
        break label103;
      }
      paramInt += 2;
    }
    for (;;)
    {
      break;
      paramDoubleMetaphoneResult.append('S');
      break label75;
      label103:
      paramInt++;
    }
  }
  
  private boolean isSilentStart(String paramString)
  {
    boolean bool2 = false;
    for (int i = 0;; i++)
    {
      boolean bool1 = bool2;
      if (i < SILENT_START.length)
      {
        if (paramString.startsWith(SILENT_START[i])) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
    }
  }
  
  private boolean isSlavoGermanic(String paramString)
  {
    if ((paramString.indexOf('W') > -1) || (paramString.indexOf('K') > -1) || (paramString.indexOf("CZ") > -1) || (paramString.indexOf("WITZ") > -1)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean isVowel(char paramChar)
  {
    if ("AEIOUY".indexOf(paramChar) != -1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  protected char charAt(String paramString, int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= paramString.length())) {
      paramInt = 0;
    }
    int j;
    for (int i = paramInt;; j = paramInt)
    {
      return i;
      paramInt = paramString.charAt(paramInt);
    }
  }
  
  public String doubleMetaphone(String paramString)
  {
    return doubleMetaphone(paramString, false);
  }
  
  public String doubleMetaphone(String paramString, boolean paramBoolean)
  {
    paramString = cleanInput(paramString);
    if (paramString == null) {
      paramString = null;
    }
    for (;;)
    {
      return paramString;
      boolean bool = isSlavoGermanic(paramString);
      int i;
      DoubleMetaphoneResult localDoubleMetaphoneResult;
      if (isSilentStart(paramString))
      {
        i = 1;
        localDoubleMetaphoneResult = new DoubleMetaphoneResult(getMaxCodeLen());
      }
      for (;;)
      {
        if ((localDoubleMetaphoneResult.isComplete()) || (i > paramString.length() - 1)) {
          break label738;
        }
        switch (paramString.charAt(i))
        {
        default: 
          i++;
          continue;
          i = 0;
          break;
        case 'A': 
        case 'E': 
        case 'I': 
        case 'O': 
        case 'U': 
        case 'Y': 
          i = handleAEIOUY(localDoubleMetaphoneResult, i);
          break;
        case 'B': 
          localDoubleMetaphoneResult.append('P');
          if (charAt(paramString, i + 1) == 'B') {
            i += 2;
          }
          for (;;)
          {
            break;
            i++;
          }
        case 'Ç': 
          localDoubleMetaphoneResult.append('S');
          i++;
          break;
        case 'C': 
          i = handleC(paramString, localDoubleMetaphoneResult, i);
          break;
        case 'D': 
          i = handleD(paramString, localDoubleMetaphoneResult, i);
          break;
        case 'F': 
          localDoubleMetaphoneResult.append('F');
          if (charAt(paramString, i + 1) == 'F') {
            i += 2;
          }
          for (;;)
          {
            break;
            i++;
          }
        case 'G': 
          i = handleG(paramString, localDoubleMetaphoneResult, i, bool);
          break;
        case 'H': 
          i = handleH(paramString, localDoubleMetaphoneResult, i);
          break;
        case 'J': 
          i = handleJ(paramString, localDoubleMetaphoneResult, i, bool);
          break;
        case 'K': 
          localDoubleMetaphoneResult.append('K');
          if (charAt(paramString, i + 1) == 'K') {
            i += 2;
          }
          for (;;)
          {
            break;
            i++;
          }
        case 'L': 
          i = handleL(paramString, localDoubleMetaphoneResult, i);
          break;
        case 'M': 
          localDoubleMetaphoneResult.append('M');
          if (conditionM0(paramString, i)) {
            i += 2;
          }
          for (;;)
          {
            break;
            i++;
          }
        case 'N': 
          localDoubleMetaphoneResult.append('N');
          if (charAt(paramString, i + 1) == 'N') {
            i += 2;
          }
          for (;;)
          {
            break;
            i++;
          }
        case 'Ñ': 
          localDoubleMetaphoneResult.append('N');
          i++;
          break;
        case 'P': 
          i = handleP(paramString, localDoubleMetaphoneResult, i);
          break;
        case 'Q': 
          localDoubleMetaphoneResult.append('K');
          if (charAt(paramString, i + 1) == 'Q') {
            i += 2;
          }
          for (;;)
          {
            break;
            i++;
          }
        case 'R': 
          i = handleR(paramString, localDoubleMetaphoneResult, i, bool);
          break;
        case 'S': 
          i = handleS(paramString, localDoubleMetaphoneResult, i, bool);
          break;
        case 'T': 
          i = handleT(paramString, localDoubleMetaphoneResult, i);
          break;
        case 'V': 
          localDoubleMetaphoneResult.append('F');
          if (charAt(paramString, i + 1) == 'V') {
            i += 2;
          }
          for (;;)
          {
            break;
            i++;
          }
        case 'W': 
          i = handleW(paramString, localDoubleMetaphoneResult, i);
          break;
        case 'X': 
          i = handleX(paramString, localDoubleMetaphoneResult, i);
          break;
        case 'Z': 
          i = handleZ(paramString, localDoubleMetaphoneResult, i, bool);
        }
      }
      label738:
      if (paramBoolean) {
        paramString = localDoubleMetaphoneResult.getAlternate();
      } else {
        paramString = localDoubleMetaphoneResult.getPrimary();
      }
    }
  }
  
  public Object encode(Object paramObject)
    throws EncoderException
  {
    if (!(paramObject instanceof String)) {
      throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }
    return doubleMetaphone((String)paramObject);
  }
  
  public String encode(String paramString)
  {
    return doubleMetaphone(paramString);
  }
  
  public int getMaxCodeLen()
  {
    return this.maxCodeLen;
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2)
  {
    return isDoubleMetaphoneEqual(paramString1, paramString2, false);
  }
  
  public boolean isDoubleMetaphoneEqual(String paramString1, String paramString2, boolean paramBoolean)
  {
    return doubleMetaphone(paramString1, paramBoolean).equals(doubleMetaphone(paramString2, paramBoolean));
  }
  
  public void setMaxCodeLen(int paramInt)
  {
    this.maxCodeLen = paramInt;
  }
  
  public class DoubleMetaphoneResult
  {
    private StringBuffer alternate = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
    private int maxLength;
    private StringBuffer primary = new StringBuffer(DoubleMetaphone.this.getMaxCodeLen());
    
    public DoubleMetaphoneResult(int paramInt)
    {
      this.maxLength = paramInt;
    }
    
    public void append(char paramChar)
    {
      appendPrimary(paramChar);
      appendAlternate(paramChar);
    }
    
    public void append(char paramChar1, char paramChar2)
    {
      appendPrimary(paramChar1);
      appendAlternate(paramChar2);
    }
    
    public void append(String paramString)
    {
      appendPrimary(paramString);
      appendAlternate(paramString);
    }
    
    public void append(String paramString1, String paramString2)
    {
      appendPrimary(paramString1);
      appendAlternate(paramString2);
    }
    
    public void appendAlternate(char paramChar)
    {
      if (this.alternate.length() < this.maxLength) {
        this.alternate.append(paramChar);
      }
    }
    
    public void appendAlternate(String paramString)
    {
      int i = this.maxLength - this.alternate.length();
      if (paramString.length() <= i) {
        this.alternate.append(paramString);
      }
      for (;;)
      {
        return;
        this.alternate.append(paramString.substring(0, i));
      }
    }
    
    public void appendPrimary(char paramChar)
    {
      if (this.primary.length() < this.maxLength) {
        this.primary.append(paramChar);
      }
    }
    
    public void appendPrimary(String paramString)
    {
      int i = this.maxLength - this.primary.length();
      if (paramString.length() <= i) {
        this.primary.append(paramString);
      }
      for (;;)
      {
        return;
        this.primary.append(paramString.substring(0, i));
      }
    }
    
    public String getAlternate()
    {
      return this.alternate.toString();
    }
    
    public String getPrimary()
    {
      return this.primary.toString();
    }
    
    public boolean isComplete()
    {
      if ((this.primary.length() >= this.maxLength) && (this.alternate.length() >= this.maxLength)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\org\apache\commons\codec\language\DoubleMetaphone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */