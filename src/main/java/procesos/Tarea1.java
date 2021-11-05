package procesos;

class Tarea1 implements Runnable {
	   Chat m;
	   String[] s1 = { "Hola", "Que haces?", "pos na tampoco" };

	   public Tarea1(Chat m1) {
	      this.m = m1;
	      new Thread(this, "Question").start();
	   }

	   public void run() {
	   

	      for (int i = 0; i < s1.length; i++) {

	    	  m.Question(s1[i]);
	      }
	   }
	}

