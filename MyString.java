public class MyString implements CharSequence,Comparable<CharSequence> {
     public static void main(String[] args) {
          MyString test = new MyString("fortnite");
          System.out.println(test);
          System.out.println(test.length()); //8
          System.out.println(test.charAt(2)); //r
          System.out.println(test.subSequence(0, 3)); //fort
          System.out.println(test.compareTo("epic")); //4
          System.out.println(test.compareTo("doublefortnite")); //-6
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
          int diff = 0;
          if (o == null) {
               throw new NullPointerException();
          }
          diff = this.length() - o.length();
          return diff;
     }
}
