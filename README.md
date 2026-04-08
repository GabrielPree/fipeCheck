<p align="center">
  <img src="/src/main/java/br/com/fipecheck/fipecheck.png" width="750"/>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-red.svg"/>
  <img src="https://img.shields.io/badge/SpringBoot-3.x-brightgreen.svg"/>
  <img src="https://img.shields.io/badge/API-REST-blue.svg"/>
  <img src="https://img.shields.io/badge/Data-Tabela%20FIPE-informational.svg"/>
  <img src="https://img.shields.io/badge/Format-JSON-orange.svg"/>
  <img src="https://img.shields.io/badge/Build-Maven-C71A36.svg"/>
  <img src="https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow.svg"/>
</p>

O **FipeCheck** é uma aplicação desenvolvida em Java para consulta de valores de veículos utilizando a tabela FIPE.
O sistema permite buscar informações por **tipo de veículo, marca, modelo e ano**, retornando os preços atualizados de forma simples e eficiente.

---

## Funcionalidades

 Consulta de veículos por:
  * Tipo (carro, moto ou caminhão)
  * Marca
  * Modelo
  * Ano
*  Listagem de modelos disponíveis por marca
*  Filtro de modelos por nome (busca parcial)
*  Exibição dos valores atualizados da FIPE
*  Consumo de API externa com tratamento de dados JSON

---

##  Tecnologias utilizadas

*  Java 25
*  Spring Boot
*  API REST (Tabela FIPE)
*  Jackson (JSON)
*  Programação orientada a objetos
*  Stream API

---

##  API utilizada

Este projeto utiliza a API pública da tabela FIPE:

https://deividfortuna.github.io/fipe/

---

## Conceitos aplicados

* Consumo de API REST
* Manipulação de JSON
* Arquitetura em camadas (model, service, principal)
* Separação de responsabilidades (SRP)
* Boas práticas de código (Clean Code)
* Uso de records no Java

---

## Como executar o projeto

1. Clone o repositório:

```bash
git clone https://github.com/seu-usuario/fipecheck.git
```

2. Acesse a pasta:

```bash
cd fipecheck
```

3. Execute o projeto:

```bash
./mvnw spring-boot:run
```

ou rode pela sua IDE (IntelliJ, Eclipse, VS Code)

---

## Exemplo de uso

```text
==================================
          FIPECHECK
==================================

Escolha o tipo (carro, moto, caminhão):
carro

Marcas disponíveis:
1 - Acura
2 - Agrale
...

Digite o código da marca:
41

Modelos disponíveis:
1697 - 3000 GT SL 3.0
...

Digite um trecho do nome:
pajero

Modelos encontrados:
7198 - Pajero 3.2 4x4 T.I. Dies. 5p Aut
...

Digite o código do modelo:
1773

==================================
     VEÍCULOS ENCONTRADOS
==================================
2003 - Pajero TR4 2.0/ 2.0 Flex 16V 4x4 Mec. - Mitsubishi - Gasolina - R$ 35.665,00
2004 - Pajero TR4 2.0/ 2.0 Flex 16V 4x4 Mec. - Mitsubishi - Gasolina - R$ 36.557,00
...
```

---

## Melhorias futuras

* Interface gráfica (JavaFX ou Web)
* Cache de requisições para otimização
* Histórico de consultas
* Exportação de resultados (CSV ou PDF)

---

## Autor

### Gabriel Preé
Estudante de Análise e Desenvolvimento de Sistemas

Projeto desenvolvido com foco em integração com API REST, manipulação de dados e aplicação de boas práticas de desenvolvimento em Java.

---

## Licença

Este projeto está sob a licença MIT.
Uso livre para fins educacionais e profissionais.
