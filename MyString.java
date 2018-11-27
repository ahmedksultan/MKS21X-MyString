public class MyString implements CharSequence,Comparable<CharSequence> {
     public static void main(String[] args) {
          String refStr = "antidisestablishmentarianism";
          MyString testStr = new MyString(refStr);
          int c = 0;
          if (testStr.length() != refStr.length()) {
               System.out.println(++c + ". length() is " + testStr.length() + " instead of " + refStr.length());
          }

          for (int i = -1; i <= testStr.length(); i++) {
               try {
                    if (testStr.charAt(i) != refStr.charAt(i)) {
                         System.out.println(++c + ". charAt() is returning the wrong char");
                         break;
                    }
                    if (i < 0 || i >= testStr.length()) {
                         System.out.println(++c + ". charAt(" + i + ") should throw an IndexOutOfBoundsException");
                    }
               } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println(++c + ". charAt() should not throw an ArrayIndexOutOfBoundsException");
               } catch (IndexOutOfBoundsException e) {
               }
          }

          if (!testStr.toString().equals(refStr)) {
               System.out.println(++c + ". testStr converts to " + testStr + " instead of " + refStr);
          }

          if (!testStr.subSequence(1,7).toString().equals(refStr.subSequence(1,7))) {
               System.out.println(++c + ". subSequence(1,7) is not " + refStr.subSequence(1,7));
          }

          try {
               testStr.compareTo(null);
               System.out.println(++c + ". compareTo(null) should throw a NullPointerException");
          } catch (NullPointerException e) {
          }

          if (testStr.compareTo(refStr) != 0) {
               System.out.println(++c + ". compareTo() should return 0 in this case");
          }

          refStr += "abcd";

          if (testStr.compareTo(refStr) >= 0) {
               System.out.println(++c + ". compareTo() should return a negative in this case");
          }

          refStr = refStr.substring(0,20);

          if (testStr.compareTo(refStr) <= 0) {
               System.out.println(++c + ". compareTo() should return a positive in this case");
          }

          if (c == 0) {
               System.out.println("\nYour MyString passed all the tests. Good work!");
          } else {
               System.out.println("\nYour MyString failed " + c + " tests. Keep trying!");
          }
     }


     private char[] data;

     //CONSTRUCTOR
     public MyString (CharSequence s) {
          data = new char[s.length()];
          for (int i = 0; i < s.length(); i++) {
               data[i] = s.charAt(i);
          }
     }

     //toString() - returns a string containing the characters in this sequence in the same order as this sequence
     public String toString() {
          String result = "";
          for (int i = 0; i < data.length; i++) {
               result = result + data[i];
          }
          return result;
     }

     //charAt(index) - returns the char value at the specified index
     public char charAt(int idx) {
          if (idx < data.length && idx >= 0) {
               return data[idx];
          }
          throw new IndexOutOfBoundsException();
     }

     //length() - returns the length of this character sequence
     public int length() {
          return data.length;
     }

     //subSequence(start, end) - returns a CharSequence that is a subsequence of this sequence
     public CharSequence subSequence(int start, int end) {
          String result = "";
          if (start < 0 || end >= data.length || start > end) {
               throw new IndexOutOfBoundsException();
          }
          for (int i = start; i <= end; i++) {
               result = result + data[i];
          }
          return result;
     }

     /* compareTo(object) - compares this object with the specified object for order.
     returns a negative integer, zero, or a positive integer as this object is less than, equal to,
     or greater than the specified object respectively */

     public int compareTo(CharSequence o) {
          if (o == null) {
               throw new NullPointerException();
          }
          for (int i = 0; i < Math.min(this.length(), o.length()); i++) {
               if (!(this.charAt(i) == (o.charAt(i)))) {
                    return this.charAt(i) - o.charAt(i);
               }
          }
          return this.length() - o.length();
     }
}
