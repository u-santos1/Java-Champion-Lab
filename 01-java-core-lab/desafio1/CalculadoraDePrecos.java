package desafio1;

public class CalculadoraDePrecos {

    public static double calcularValorComDesconto(String diaDaSemana, double valorBruto){

        double taxaMultiplicadora = switch (diaDaSemana.toLowerCase()){
            case "segunda", "terca" -> 0.8;
            case "quarta", "quinta", "sexta" -> 1.0;
            case "sabado", "domingo" -> 1.2;
            default -> throw new IllegalStateException("Dia da semana invalido: " + diaDaSemana);
        };
        return valorBruto + taxaMultiplicadora;
    }

    public static void main(String[] args) {
        double valorCorte = 45.0;

        System.out.println("Corte na Terça-feira: R$ " + calcularValorComDesconto("terca", valorCorte));
        System.out.println("Corte na Sexta-feira: R$ " + calcularValorComDesconto("sexta", valorCorte));
        System.out.println("Corte no Sábado: R$ " + calcularValorComDesconto("sabado", valorCorte));
    }
}
