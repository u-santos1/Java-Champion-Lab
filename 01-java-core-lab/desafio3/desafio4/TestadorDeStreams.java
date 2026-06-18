package desafio3.desafio4;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 1. Records no singular, pois representam uma única entidade
record Venda(String vendedor, String produto, double valor, boolean paga) {}
record Produto(String nome, double preco) {}
record Produtos(String nome, double preco, int qtd){}

// 2. Classe com inicial maiúscula
public class TestadorDeStreams {

    public static void main(String[] args) {

        // --- TESTE 1: Somatório com Filtros Múltiplos ---
        List<Venda> vendas = List.of(
                new Venda("Ana", "Notebook", 3500.0, true),
                new Venda("Bob", "Mouse", 89.0, false),
                new Venda("Ana", "Monitor", 1200.0, true),
                new Venda("Carlos", "Teclado", 350.0, true)
        );

        double totalAna = vendas.stream()
                .filter(v -> v.vendedor().equals("Ana"))
                .filter(Venda::paga) // Uso perfeito de Method Reference
                .mapToDouble(Venda::valor)
                .sum();
        System.out.printf("Total Ana: R$ %.2f%n\n", totalAna);


        // --- TESTE 2: Filtragem de Números ---
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7);

        List<Integer> pares = nums.stream()
                .filter(n -> n % 2 == 0)
                .toList(); // Atualizado para o padrão Java 16+ (dispensa o Collectors)

        System.out.println("Números Pares: " + pares + "\n");


        // --- TESTE 3: Iteração com forEach ---
        List<Produto> produtos = List.of(
                new Produto("Notebook", 3500.0),
                new Produto("Mouse", 89.0),
                new Produto("Monitor", 1200.0)
        );

        System.out.println("Produtos acima de R$ 500:");
        produtos.stream()
                .filter(p -> p.preco() > 500)
                .forEach(p -> System.out.println("- " + p.nome()));
        System.out.println();


        // --- TESTE 4: Encadeamento de Regras de Texto ---
        List<String> nomes = List.of("Ana", "Alberto", "Bruna", "Beatriz", "Carlos");

        System.out.println("Nomes que começam com 'A' e têm mais de 3 letras:");
        nomes.stream()
                .filter(n -> n.startsWith("A"))
                .filter(n -> n.length() > 3)
                .forEach(System.out::println);
// --- TESTE 5: Transformação com map() ---
        List<String> maiusculos = nomes.stream()
                .map(String::toUpperCase)
                .toList(); // Padrão Java 16+
        System.out.println("Nomes em maiúsculo: " + maiusculos);

        List<String> nomesDosProdutos = produtos.stream()
                .map(Produto::nome)
                .toList(); // Padrão Java 16+
        System.out.println("Apenas os nomes dos produtos: " + nomesDosProdutos);

        // --- TESTE 6: Trabalhando com tipos primitivos para performance ---
        List<String> palavras = List.of("Java", "Stream", "Lambda");

        int[] tamanhos = palavras.stream()
                .mapToInt(String::length)
                .toArray();
        System.out.println("Tamanho de cada palavra: " + Arrays.toString(tamanhos));

        // --- TESTE 7: Cenário do Mundo Real (Carrinho de Compras) ---
        // Alterado para um Record local chamado ItemCarrinho para manter o singular
        record ItemCarrinho(String nome, double preco, int qtd) {}

        List<ItemCarrinho> carrinho = List.of(
                new ItemCarrinho("Notebook", 3500.0, 1),
                new ItemCarrinho("Mouse", 89.0, 2)
        );

        double totalCarrinho = carrinho.stream()
                .mapToDouble(p -> p.preco() * p.qtd())
                .sum();
        System.out.printf("Total do Carrinho: R$ %.2f%n", totalCarrinho);

    }
}