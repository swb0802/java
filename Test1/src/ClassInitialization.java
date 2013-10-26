import java.util.Random;


class Initable {
	static final int staticFinal = 47;
	static final int staticFinal2 = ClassInitialization.rand.nextInt(1000);
	
	static {
		System.out.println("Initializing Initable");
	}
}

class Initable2 {
	static int staticNonFinal = 147;
	
	static {
		System.out.println("Initialzing Initable2");
	}
}

class Initable3 {
	static int staticNonFinal = 74;
	
	static {
		System.out.println("Initialzing Initable3");
	}
}

class Initable4 {
	static final int staticFinal = 374;
	
	static {
		System.out.println("Initialzing Initable4");
	}
}

public class ClassInitialization {

	public static Random rand = new Random(47);
	
	public static void main(String args[]) throws Exception
	{
		Class initable = Initable.class;
		System.out.println("After creating Initable ref");
		System.out.println(Initable.staticFinal);
		System.out.println(Initable.staticFinal2);
		
		System.out.println(Initable2.staticNonFinal);
		
		Class initable3 = Class.forName("Initable3");
		System.out.println("After creating Initable3 ref");
		System.out.println(Initable3.staticNonFinal);
		
		Class initable4 = Class.forName("Initable4");
		System.out.println("After creating Initable4 ref");
		System.out.println(Initable4.staticFinal);

		
	}
	
}
