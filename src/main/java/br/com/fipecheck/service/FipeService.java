package br.com.fipecheck.service;

import br.com.fipecheck.model.Dados;
import br.com.fipecheck.model.Modelos;
import br.com.fipecheck.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FipeService {

    private final ConsumoAPI consumo = new ConsumoAPI();
    private final ConverteDados conversor = new ConverteDados();

    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    public List<Dados> buscarMarcas(String tipo) {
        String json = consumo.obterDados(BASE_URL + tipo + "/marcas");
        return conversor.obterLista(json, Dados.class);
    }

    public Modelos buscarModelos(String tipo, String codigoMarca) {
        String url = String.format("%s%s/marcas/%s/modelos", BASE_URL, tipo, codigoMarca);
        String json = consumo.obterDados(url);
        return conversor.obterDados(json, Modelos.class);
    }

    public List<Dados> filtrarModelos(Modelos modelos, String nome) {
        return modelos.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Veiculo> buscarVeiculosPorAnos(String tipo, String codigoMarca, String codigoModelo) {

        String urlAnos = String.format("%s%s/marcas/%s/modelos/%s/anos",
                BASE_URL, tipo, codigoMarca, codigoModelo);

        String json = consumo.obterDados(urlAnos);

        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (Dados ano : anos) {
            String urlFinal = String.format("%s%s/marcas/%s/modelos/%s/anos/%s",
                    BASE_URL, tipo, codigoMarca, codigoModelo, ano.codigo());

            String jsonVeiculo = consumo.obterDados(urlFinal);
            Veiculo veiculo = conversor.obterDados(jsonVeiculo, Veiculo.class);
            veiculos.add(veiculo);
        }

        return veiculos;
    }
}