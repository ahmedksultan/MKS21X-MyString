public class MyString implements CharSequence {
     //need to add ,Comparable<CharSequence> to class declaration
     public static void main(String[] args) {
          MyString test = new MyString("fortnite");
          System.out.println(test);
          System.out.println(test.length());
          System.out.println(test.charAt(2));
          System.out.println(test.subSequence(0, 3));
     }
     private char[] data;
     public MyString (CharSequence s) {
          data = new char[s.length()];
          for (int i = 0; i < s.length(); i++) {
               data[i] = s.charAt(i);
          }
     }

     public String toString() {
          String result = "";
          for (int i = 0; i < data.length; i++) {
               result = result + data[i];
          }
          return result;
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
}
