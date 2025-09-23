public class Main {
  static char[] map = new char[64];
  static {
    // creating map
    int i = 0;
    for (char ch = 'A'; ch <= 'Z'; ch++) {
      map[i++] = ch;
    }
    for (char ch = 'a'; ch <= 'z'; ch++) {
      map[i++] = ch;
    }
    for (char ch = '0'; ch <= '9'; ch++) {
      map[i++] = ch;
    }
    map[i++] = '+';
    map[i++] = '/';
  }
  public static void main(String[] args) {
    String str = "This is a sample string";
    String encoded = encode64(str);
    String decoded = decode64(encoded);
    System.out.println("Actual String: " + str);
    System.out.println("Encoded String: " + encoded);
    System.out.println("Decoded String: " + decoded);
  }
  public static String encode64(String str) {
    StringBuilder sb = new StringBuilder();
    int n = str.length();
    for (int i = 0; i < n; i += 3) {
      // Creating 24 bit chunk;
      int chunk = 0;
      for (int j = 0; j < 3; j++) {
        int b;
        if ((i + j) >= n) {
          b = 0;
        }
        else {
          b = str.charAt(i + j);
        }
        chunk <<= 8;
        chunk |= b;
      }
      int[] arr = new int[4];
      for (int j = 3; j >= 0; j--) {
        arr[j] = (int) (chunk & 63);
        chunk >>= 6;
      }
      for (int j = 0; j < 4; j++) {
        sb.append(map[arr[j]]);
      }
    }
    // fix padding
    
    int remain = n % 3;
    if (remain == 1) { 
        sb.setCharAt(sb.length() - 1, '=');
        sb.setCharAt(sb.length() - 2, '=');
    } else if (remain == 2) {
        sb.setCharAt(sb.length() - 1, '=');
    }
    return sb.toString();
  }
  // public static String decode64(String str) {
  //   StringBuilder sb = new StringBuilder();
  //   int n = str.length();
  //   for (int i = 0; i < n; i += 4) {
  //     // Taking each 4 chars from given string
  //     int chunk = 0; // let suppose a 24 bit chunk;
  //     for (int j = 0; j < 4; j++) {
  //       chunk <<= 6;
  //       chunk |= str.charAt(i + j);
  //     }
  //     // Getting chars from chunk
  //     char[] arr = new char[3];
  //     for (int j = 2; j >= 0; j--) {
  //       arr[j] = (char) (chunk & 255);
  //       chunk >>= 8;
  //     }
  //     for (int j = 0; j < 3; j++) {
  //       sb.append(arr[j]);
  //     }
  //   }
  //   return sb.toString();
  // }

  public static String decode64(String str) {
    StringBuilder sb = new StringBuilder();
    int n = str.length();

    for (int i = 0; i < n; i += 4) {
        int chunk = 0; // 24-bit chunk

        // Convert 4 Base64 chars to 6-bit values
        for (int j = 0; j < 4; j++) {
            char c = str.charAt(i + j);
            int val;
            if (c == '=') val = 0; // padding
            else if ('A' <= c && c <= 'Z') val = c - 'A';
            else if ('a' <= c && c <= 'z') val = c - 'a' + 26;
            else if ('0' <= c && c <= '9') val = c - '0' + 52;
            else if (c == '+') val = 62;
            else val = 63;
            

            chunk <<= 6;
            chunk |= val;
        }

        // getting prev 3 bytes chunk
        for (int j = 2; j >= 0; j--) {
            int b = (chunk >> (8 * j)) & 0xFF;
            sb.append((char) b);
        }
    }

    // Remove extra bytes added due to padding
    int pad = 0;
    if (str.endsWith("==")) pad = 2;
    else if (str.endsWith("=")) pad = 1;
    return sb.substring(0, sb.length() - pad);
}

}
