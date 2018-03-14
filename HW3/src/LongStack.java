
import java.util.LinkedList;
import java.util.StringTokenizer;

public class LongStack {


   public static void main (String[] argum) {
      // TODO!!! Your tests here!
   }
   private LinkedList<Long> stack;

   LongStack() {
      stack = new LinkedList<Long>();
   }

   @Override
   public Object clone() throws CloneNotSupportedException {
      LongStack lifo = new LongStack();
      lifo.stack = (LinkedList<Long>) stack.clone();
      return lifo;
   }

   public boolean stEmpty() {
      return stack.isEmpty();
   }

   public void push (long a) {
      stack.push(a);
   }

   public long pop() {
      if (stEmpty()){
         throw new IndexOutOfBoundsException(" Stack underflow");
      }
      return stack.pop();
   }

   public void op (String s) {
      if (s.equals("+")) {
         this.stack.push(this.stack.pop() + this.stack.pop());
      } else if (s.equals("-")) {
         long r1 = this.pop();
         long r2 = this.pop();
         this.stack.push(r2 - r1);
      } else if (s.equals("*")) {
         this.stack.push(this.stack.pop() * this.stack.pop());
      } else if (s.equals("/")) {
         long r1 = this.pop();
         long r2 = this.pop();
         this.stack.push(r2 / r1);
      } else if(s.equals(" ") | s.equals("\t")) {
         return;
      } else {
         throw new RuntimeException("Invalid operation");
      }
   }


   public long tos() {
      if (stEmpty()){
         throw new IndexOutOfBoundsException(" Stack underflow");
      }
      return stack.peek();
   }

   @Override
   public boolean equals (Object o) {
      return stack.equals(((LongStack)o).stack);
   }

   @Override
   public String toString() {
      StringBuffer lifo = new StringBuffer();
      for (int i = stack.size() - 1; i >= 0; i--) {
         lifo.append(stack.get(i));
         if (i > 0)
            lifo.append(' ');
      }
      return lifo.toString();
   }

   public static long interpret (String pol) {
      if (pol.trim().isEmpty() || pol == null) {
         throw new RuntimeException ("\nError, empty string (" + pol + ")");
      }

      LongStack ls = new LongStack();
      StringTokenizer token = new StringTokenizer(pol, " \t");
      String values;
      int i = 1;
      int counter = token.countTokens();

      while (token.hasMoreTokens()) {
         values = (String) token.nextElement();

         if (values.equals("+") || values.equals("-") || values.equals("*") || values.equals("/"))
            ls.op(values);

         else {
            if (counter == i && i > 2)
               throw new RuntimeException("\nError, wrong input (" + pol + ")");
            try {
               long a = Long.parseLong(values);
               ls.push(a);
            }
            catch(NumberFormatException e) {
               throw new RuntimeException("\nError, wrong input (" + pol + ")");
            }
         }

         i++;
      }

      return ls.tos();
   }
}

//Reference:
//https://git.wut.ee/i231/home3/src/master/src/LongStack.java