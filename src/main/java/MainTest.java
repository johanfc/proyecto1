import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainTest {
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    private String nombre;

    public ArrayList<String> getDeberes() {
        return deberes;
    }

    private ArrayList<String> deberes;

    public MainTest(String nombre) {
        this.nombre = nombre;
        this.deberes = new ArrayList();
        loadDeberes();
    }

    private void loadDeberes() {

        this.deberes.add("Tendiò la cama ?");
        this.deberes.add("Revisò class room ?");
        this.deberes.add("Organizò la ropa en los cajones ?");
        this.deberes.add("Sacò el perro ?");

    }

    public void startTest(String[] respuestas) {
        System.out.println("Gracias, has respondido todas las preguntas.");
        //deberes.forEach(deber-> System.out.println(deber));
        Iterator<String> it = this.deberes.iterator();
        int indice = 0;//primer indice
        boolean flag = true; // primer booleano
        while (it.hasNext()) {//from hotfix1
            System.out.println(it.next() + " " + respuestas[indice]);
            if (respuestas[indice].equalsIgnoreCase("NO")) {
                flag = false;
                break;//hotfixes2 already solved
            }
            indice++;
        }
        if (!flag)
            System.out.println("Lo sentimos no puedes salir a la piscina ");
        else
            System.out.println("Felicitaciones te puedes ir a bañar");


        // TODO: 16/05/21 <code></code>


        // ** More complex example -- map strings to lists of Integer
        HashMap<String, List<Integer>> counts = new HashMap<String, List<Integer>>();
        List<Integer> evens = new ArrayList<Integer>();
        evens.add(2);
        evens.add(4);
        evens.add(6);
        counts.put("evens", evens);


    // Get the List<Integer> back out...
    List<Integer> evens2 = counts.get("evens");
        int sum = evens2.get(0) + evens2.get(1); // unboxing here, sum is 6

    }



    public static void main (String[] args){

        String name = "";
        int totalPreguntas = 4;
        String[] resp = new String[4];
        MainTest obj;
        BufferedReader bufR = new BufferedReader( new InputStreamReader(System.in) );
        try{
            System.out.println("Digite su nombre por favor");
            name = String.valueOf(bufR.readLine());
            obj = new MainTest(name);
            System.out.println("Hola "+name+ " Soy roby el robot que decidirà si puedes ir a la piscina," +
                    " te voy  a hacer una seria de preguntas, \n al terminar mi algoritmo de " +
                    " inteligencia artificial tomarà una decisiòn.");
            List<String> deberes = obj.getDeberes();
            Iterator it = deberes.iterator();
            int indice = 0;
            while(it.hasNext()){
                System.out.println(it.next());
                resp[indice] = String.valueOf(bufR.readLine());
                if ( resp[indice] == null && !resp[indice].equalsIgnoreCase("SI") &&
                        !resp[indice].equalsIgnoreCase("NO")
                ) {
                    System.out.println("Debes ingresar una respuesta valida SI o NO, " +
                            "tendras que iniciar de nuevo el test.");
                    break;
                }
                indice++;
            }
            obj.startTest(resp);

        }catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }




}
