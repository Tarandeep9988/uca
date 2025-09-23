public class Base64 {
  public static void main(String[] args) {
    String text = "Tarandeep Singh1982394u";
    System.out.println("Actual: " + text);
    String encoded = encoder(text);
    System.out.println("Encoded: " + encoded);
    System.out.println("Decoded: " + decode(encoded));
  }

  private static char[] encoderMap;
  static {
    encoderMap = new char[64]; // (A–Z, a–z, 0–9, +, /)
    int i = 0;
    for (char ch = 'A'; ch <= 'Z'; ch++) encoderMap[i++] = ch;
    for (char ch = 'a'; ch <= 'z'; ch++) encoderMap[i++] = ch;
    for (char ch = '0'; ch <= '9'; ch++) encoderMap[i++] = ch;
    encoderMap[i++] = '+';
    encoderMap[i++] = '/';
  }
  public static String encoder(String input) {
    int inLen = input.length();
    int outLen = 4 * ((inLen + 2) / 3); // 4 + (ceil of inLen / 3);
    char[] output = new char[outLen];
    int k = 0;

    for (int i = 0; i < inLen; i += 3) {
      // Grouping 3 - 3 chars
      int bits = 0;
      for (int j = 0; j < 3; j++) {
        bits <<= 8; // moving 8 bits left
        if (i + j < inLen) {
          bits |= input.charAt(i + j);
        }
      }

      for (int j = 0; j < 4; j++) {
        char ch = encoderMap[bits & 0x3F];
        bits >>= 6;
        output[k + 3 - j] = ch;
      }
      k += 4;
    }
    // Applying padding
    if (inLen % 3 == 1) {
      output[outLen - 1] = output[outLen - 2] = '=';
    }
    else if (inLen % 3 == 2) {
      output[outLen - 1] = '=';
    }

    return new String(output);
  }
  public static String decode(String input) {
    int inLen = input.length();
    int outLen = (inLen / 4) * 3;
    if (input.charAt(inLen - 1) == '=') outLen--;
    if (input.charAt(inLen - 2) == '=') outLen--;

    char[] output = new char[outLen];
    int k = 0;
    for (int i = 0; i < inLen; i += 4) {
      int bits = 0;
      for (int j = 0; j < 4; j++) {
        bits <<= 6;
        char ch = input.charAt(i + j);
        
        int val;
        if (ch >= 'A' && ch <= 'Z') val = ch - 'A';
        else if (ch >= 'a' && ch <= 'z') val = ch - 'a' + 26;
        else if (ch >= '0' && ch <= '9') val = ch - '0' + 52;
        else if (ch == '+') val = 62;
        else if (ch == '/') val = 63;
        else val = 0;

        bits |= val;

      }
      for (int j = 2; j >= 0; j--) {
        if (k + j < outLen) {
          output[k + j] = (char)(bits & 0xFF);
        }
        bits >>= 8;
      }
      k += 3;
    }

    return new String(output);
  }
}
