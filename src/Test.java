
public class Test {

	public static void main(String[] args) {

		String[] commande = new String[3];
		String argument = "";
		argument = argument + "a:Processus(1,b,c)";
		argument = argument + ";";
		argument = argument + "b:Processus(2,a,c)";
		argument = argument + ";";
		argument = argument + "c:Processus(3,a,b)";
		commande[0] = "-cp";
		commande[1] = "jade.boot";
		commande[2] = argument;
		jade.Boot.main(commande);

	}

}
