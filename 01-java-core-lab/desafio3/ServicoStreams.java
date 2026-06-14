package desafio3;

import java.util.Comparator;
import java.util.List;


record Servico(String nome, double preco) {}

public class ServicoStreams {

    public static void main(String[] args) {
        List<Servico> servicos = List.of(
                new Servico("Corte Social",  45.00),
                new Servico("Corte + Barba", 70.00),
                new Servico("Hidratação",    55.00),
                new Servico("Pigmentação",  120.00),
                new Servico("Sobrancelha",   25.00)
        );

        servicos.stream()
                .filter(s -> s.preco() > 50)
                .sorted(Comparator.comparingDouble(Servico::preco))
                .forEach(s -> System.out.printf("%-20s | R$ %.2f%n", s.nome(), s.preco()));
    }
}

