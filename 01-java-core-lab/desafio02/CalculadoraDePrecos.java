package desafio02;

public class CalculadoraDePrecos {
    record Servico(String nome, double preco){}
    record Cliente(String nome, String tipo){}

    public static double calcularValorComDesconto(String diaDaSemana, double valorBruto){

        double taxaMultiplicadora = switch (diaDaSemana.toLowerCase()){
            case "segunda", "terca" -> 0.8;
            case "quarta", "quinta", "sexta" -> 1.0;
            case "sabado", "domingo" -> 1.2;
            default -> throw new IllegalArgumentException("Dia da semana invalido: " + diaDaSemana);
        };
        return valorBruto * taxaMultiplicadora;
    }
    public static double calcularPrecoFinal(Cliente cliente, Servico servico){
        double taxaMulti = switch (cliente.tipo().toLowerCase()) {
            case "vip" -> 0.85;
            case "novo" -> 0.90;
            case "comum" -> 1.0;
            default -> throw new IllegalArgumentException("Cliente invalido " + cliente);
        };
        return servico.preco() * taxaMulti;
    }

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("wesley", "VIP");
        Cliente cliente2 = new Cliente("ana", "novo");
        Cliente cliente3 = new Cliente("tiago", "comum");
        Servico servico1 = new Servico("corte social" , 40);

        double valorCorte = 45.00;

        System.out.println("Valor do corte vip " + calcularPrecoFinal(cliente1, servico1));
        System.out.println("Valor do corte novo " + calcularPrecoFinal(cliente2, servico1));
        System.out.println("Valor do corte comum " + calcularPrecoFinal(cliente3, servico1));


        System.out.println("Corte na Terça-feira: R$ " + calcularValorComDesconto("terca", valorCorte));
        System.out.println("Corte na Sexta-feira: R$ " + calcularValorComDesconto("sexta", valorCorte));
        System.out.println("Corte no Sábado: R$ " + calcularValorComDesconto("sabado", valorCorte));


    }
}