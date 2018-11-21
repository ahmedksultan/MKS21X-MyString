public class MyString implements CharSequence,Comparable<CharSequence>{
     private char[] data;
     public MyString (CharSequence s) {
          data = new char[s.length()];
     }

     public String toString() {

     }
     //charAt() - takes index, prints character at that index
     public char charAt(int idx) {
          if (idx < data.length && idx >= 0) {
               return data[idx];
          }
          throw new IndexOutOfBoundsException();
     }
     //length() - returns length of CharSequence
     public int length() {
          return data.length;
     }
}
