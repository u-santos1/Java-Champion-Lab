package desafio3.desafio4;



import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.List;



record Barbeiro(String nome, String nivel){}
record ServicoFeito(String cliente, String tipoCorte, double valorPago, Barbeiro barbeiro, boolean pagoViaPix){}


public class TestadorDeStreams {

    public static void main(String[] args) {
        Barbeiro ze = new Barbeiro("Ze", "Senior");
        Barbeiro lucas = new Barbeiro("Lucas", "Junior");

        List<ServicoFeito> corteDoDia = List.of(
                new ServicoFeito("Joao", "Degrade", 45.0, ze, true),
        new ServicoFeito("João", "Degradê", 45.0, ze, true),
                new ServicoFeito("Marcos", "Corte Simples", 35.0, lucas, false),
                new ServicoFeito("Tiago", "Degradê + Barba", 70.0, ze, true),
                new ServicoFeito("Pedro", "Pezinho", 15.0, lucas, true),
                new ServicoFeito("Carlos", "Degradê", 45.0, ze, false)
        );


        long qtdPagosNoPix = corteDoDia.stream()
                .filter(ServicoFeito::pagoViaPix)
                .count();
        System.out.println("Cortes pagos via Pix: " + qtdPagosNoPix);

        double faturacaoZe = corteDoDia.stream()
                .filter(n -> n.barbeiro().nome().equals("Ze"))
                .mapToDouble(ServicoFeito::valorPago)
                .sum();
        System.out.printf("Faturação do Zé: R$ %.2f%n", faturacaoZe);

        List<String> nomesClientes = corteDoDia.stream()
                .map(ServicoFeito::cliente)
                .toList();
        System.out.println("Clientes do dia: " + nomesClientes);

        List<Double> valoresAltos =  corteDoDia.stream()
                .filter(n -> n.valorPago() > 40)
                .mapToDouble(ServicoFeito::valorPago)
                .boxed()
                        .toList();
        System.out.println("Cortes acima de R$ 40: " + valoresAltos);

        double totalDegrades = corteDoDia.stream()
                .filter(n -> n.tipoCorte().equals("Degradê"))
                .mapToDouble(ServicoFeito::valorPago)
                .sum();
        System.out.printf("Total arrecadado só com Degradês: R$ %.2f%n", totalDegrades);
    }
}