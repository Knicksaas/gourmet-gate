package org.gourmetgate.gourmetgate.api;

import org.eclipse.scout.rt.platform.security.ICredentialVerifier;

import java.io.IOException;

public class GourmetGateCredentialVerifyer implements ICredentialVerifier {

  @Override
  public int verify(String username, char[] password) throws IOException {
    return ICredentialVerifier.AUTH_OK;
  }
}
