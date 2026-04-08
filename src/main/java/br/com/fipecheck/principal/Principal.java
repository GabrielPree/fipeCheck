package br.com.fipecheck.principal;

import br.com.fipecheck.model.Dados;
import br.com.fipecheck.model.Modelos;
import br.com.fipecheck.model.Veiculo;
import br.com.fipecheck.service.FipeService;


import java.util.List;
import java.util.Scanner;

public class Principal {

    private final Scanner leitura = new Scanner(System.in);
    private final FipeService service = new FipeService();

    public void exibeMenu() {

        System.out.println("==================================");
        System.out.println("          FIPECHECK");
        System.out.println("==================================");

        String tipo = escolherTipoVeiculo();

        List<Dados> marcas = service.buscarMarcas(tipo);
        exibirLista("Marcas disponíveis:", marcas);

        System.out.print("\nDigite o código da marca: ");
        String codigoMarca = leitura.nextLine();

        Modelos modelos = service.buscarModelos(tipo, codigoMarca);

        System.out.println("\nModelos disponíveis:");
        modelos.modelos().forEach(m ->
                System.out.println(m.codigo() + " - " + m.nome())
        );

        System.out.print("\nDigite um trecho do nome do veículo: ");
        String nome = leitura.nextLine();

        List<Dados> filtrados = service.filtrarModelos(modelos, nome);

        if (filtrados.isEmpty()) {
            System.out.println("\nNenhum modelo encontrado.");
            return;
        }

        exibirLista("\nModelos encontrados:", filtrados);

        System.out.print("\nDigite o código do modelo: ");
        String codigoModelo = leitura.nextLine();

        List<Veiculo> veiculos = service.buscarVeiculosPorAnos(tipo, codigoMarca, codigoModelo);

        exibirVeiculos(veiculos);
    }

    private String escolherTipoVeiculo() {
        System.out.println("Escolha o tipo (carro, moto, caminhão): ");
        String tipo = leitura.nextLine().toLowerCase();

        if (tipo.contains("mot")) return "motos";
        if (tipo.contains("camin")) return "caminhoes";
        return "carros";
    }

    private void exibirLista(String titulo, List<Dados> lista) {
        System.out.println("\n" + titulo);
        lista.stream()
                .sorted((a, b) -> a.nome().compareToIgnoreCase(b.nome()))
                .forEach(item -> System.out.println(item.codigo() + " - " + item.nome()));
    }

    private void exibirVeiculos(List<Veiculo> veiculos) {

        System.out.println("\n==================================");
        System.out.println("     VEÍCULOS ENCONTRADOS");
        System.out.println("==================================");

        veiculos.stream()
                .sorted((a, b) -> a.ano().compareTo(b.ano()))
                .forEach(v -> {
                    System.out.println(v.ano() + " - " + v.modelo() + " - " + v.marca() + " - " + v.tipoCombustivel() + " - " + v.valor());
                });
    }
}