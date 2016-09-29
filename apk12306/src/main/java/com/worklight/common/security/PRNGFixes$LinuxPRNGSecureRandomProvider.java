package com.worklight.common.security;

import java.security.Provider;

class PRNGFixes$LinuxPRNGSecureRandomProvider
  extends Provider
{
  public PRNGFixes$LinuxPRNGSecureRandomProvider()
  {
    super("LinuxPRNG", 1.0D, "A Linux-specific random number provider that uses /dev/urandom");
    put("SecureRandom.SHA1PRNG", PRNGFixes.LinuxPRNGSecureRandom.class.getName());
    put("SecureRandom.SHA1PRNG ImplementedIn", "Software");
  }
}


/* Location:              E:\soft\ApkIDE\Worksrc\com.MobileTicket\!\com\worklight\common\security\PRNGFixes$LinuxPRNGSecureRandomProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */