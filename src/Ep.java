import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Ep {

    static Map<Integer, Set<Integer>> map_adj = new HashMap<>();

    static Map<Integer, Integer> map_quant = new HashMap<>();

    // adicionar aresta
    static void ad(String a, String b) { // a e b ids
        Set<Integer> adj = map_adj.get(Integer.valueOf(a));
        if (adj == null) {
            adj = new HashSet<>();
        }
        adj.add(Integer.valueOf(b));
        map_adj.put(Integer.valueOf(a), adj);
    }

    static void quantidade_pessoas() {
        for (Map.Entry<Integer, Set<Integer>> entry : map_adj.entrySet()) {
            int key = entry.getValue().size(); // número de pessoas que essa pessoa encontra
            Integer val = map_quant.get(key);
            if (val == null) {
                val = 0;
            }
            map_quant.put(key, val + 1);
        }
    }

    static void printa_quantidade_pessoas() {
        for (Map.Entry<Integer, Integer> entry : map_quant.entrySet()) {
            int key = entry.getKey();
            int num_pessoas = entry.getValue();
            System.out.println(key + ", " + num_pessoas);
        }
    }

    static int arestas() { // nº de arestas
        int count = 0;

        for (Map.Entry<Integer, Set<Integer>> entry : map_adj.entrySet()) {
            count += entry.getValue().size();
        }
        return (count / 2);
    }

    static void ler_arquivo() {
        String nomeArquivo = "/Users/graph-processing/src/cenario1.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo));

        } catch(Exception e) {

        }
    }

    static void listaAdj() {
        String nomeArquivo = "/Users/graph-processing/src/cenario1.txt";

        BufferedReader reader = null;
        int l = 0;
        try {
            reader = new BufferedReader(new FileReader(nomeArquivo));
            reader.readLine();
            reader.readLine();
            String line = reader.readLine();

            while (line != null) {
                if (l > 1) {
                    String[] adj = line.split(" ");
                    ad(adj[0], adj[1]);
                    ad(adj[1], adj[0]);
                }
                l++;
                line = reader.readLine();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        listaAdj();
        int a = arestas();
        System.out.println("Arestas:" + a);

        quantidade_pessoas();
        printa_quantidade_pessoas();
    }
}