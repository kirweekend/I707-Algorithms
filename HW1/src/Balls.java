
public class Balls {

   enum Color {green, red};
   
   public static void main (String[] param) {
      // for debugging
   }
   
   public static void reorder (Color[] balls) {

       int  m = 0;

       for (int i = 0; i < balls.length; i++) {
           if (balls[i] == Color.red)
               m++;
       }



       for (int i = 0; i < m; i++){
           balls[i] = Color.red;
       }

       for (int i = m ; i < balls.length; i++){
           balls[i] = Color.green;
       }
   }
}
      // TODO!!! Your program here
//       for (int i = 0; i < balls.length ; i++) {
//           if(green < red){
//               if (balls[i] == Color.green) {
//                   balls[balls.length-1] = balls[i];
//                   green++;
//               }
//
//           } else {
//               balls[i] = balls[red];
//               red--;
//
//
//           }
//
//       }
//
//
//
//   }
//}

//    private static void simple(Color[] balls) {
//        int i = 0, j;
//        for (Color ball : balls)
//            if (ball.ordinal() > 0) // not first, probably red
//                i++;
//        for (j = 0; j < i; j++)
//            balls[j] = Color.red;
//        for (i = j; i < balls.length; i++)
//            balls[i] = Color.green;
//    }
//
//}