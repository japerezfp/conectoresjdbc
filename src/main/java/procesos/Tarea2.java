package procesos;

class Tarea2 implements Runnable {
	   Chat m;
	   String[] s2 = { "Hola", "Nah aqu� ando, y t�?", "estamos bien XD" };

	   public Tarea2(Chat m2) {
	      this.m = m2;
	      new Thread(this, "Answer").start();
	   }

	   public void run() {
	    

	      for (int i = 0; i < s2.length; i++) {
	    	  m.Answer(s2[i]);
	      }
	   }
	}
