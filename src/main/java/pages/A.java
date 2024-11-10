package pages;

public class A {
        void m1(String x){
            System.out.println("One");
        }
    }
    class B extends A {
        public void m1(String x){
            System.out.println("Two");
            super.m1(null);
        }
        void m4(){
            System.out.println("riya loose");
        }

        void m6(){
            System.out.println("riya wins");
        }
    }
    class Test{
        public static void main(String[] args){
         // A a = new B();
          //  a.m1(null);
            //((B) a).m6();

}}
