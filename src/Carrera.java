import java.util.ArrayList;
import java.util.Random;

public class Carrera {
    private Competidor tortuga, liebre;
    private ArrayList<Competidor> competidores = new ArrayList<Competidor>();

    public static Random random = new Random();

    public Carrera() {
        tortuga = new Tortuga();
        liebre = new Liebre();

        competidores.add(tortuga);
        competidores.add(liebre);

        System.out.println("PUM!, que empiece la carrera!");
        ticTac();
    }

    public void ticTac() {
        long lastTime = System.nanoTime();
        final double nsCode = 1000000000.0 / 8.0;
        double delta = 0;

        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / nsCode;
            lastTime = now;

            while (delta >= 1.0) {
                imprimir();
                for (int i = 0; i < competidores.size(); i++) {
                    competidores.get(i).avanzar();
                }
                evaluar();
                delta--;
            }
        }
    }

    private void imprimir() {
        String escenario = "\n\n\n\n----------------------------------------------------------------------\n";

        for(int i=0; i<competidores.size(); i++){
            for(int j=0; j<70; j++){
                if(competidores.get(i).getPosicion() - 1 == j)
                    escenario += competidores.get(i).getNombre().charAt(0);
                else
                    escenario += " ";
            }
            escenario += "\n";
        }
        escenario += "----------------------------------------------------------------------\n";

        System.out.println(escenario);
    }

    private void evaluar() {
        int ganadores = 0;
        ArrayList<Integer> indexDeLosGanadores = new ArrayList<Integer>();

        for (int i = 0; i < competidores.size(); i++) {
            if(competidores.get(i).getPosicion() == 70){
                ganadores++;
                indexDeLosGanadores.add(i);
            }
        }

        if(ganadores == competidores.size()){
            System.out.println("Empate");
        }
        if (ganadores > 0){
            System.out.println("Los ganadores son:");
            for(int i : indexDeLosGanadores) {
                System.out.printf("\t• %s\n", competidores.get(i).getNombre());
            }
            System.exit(1);
        }
    }

}
