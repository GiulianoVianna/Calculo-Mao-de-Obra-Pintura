# 🎨 Protótipo: Cálculo - Mão de Obra de Pintura

Bem-vindo ao **Cálculo - Mão de Obra de Pintura**! Esta é uma aplicação JavaFX desenvolvida para ajudar pintores e empresas de pintura a calcular o custo de pintura com base nas medidas fornecidas pelo usuário. 🚀

https://github.com/GiulianoVianna/Calculo-Mao-de-Obra-Pintura/assets/101942554/10d5ad6d-cb0f-4683-9b1e-b799faa54425

![image](https://github.com/GiulianoVianna/Calculo-Mao-de-Obra-Pintura/assets/101942554/1249e8ff-673e-44cb-bd11-449ad43cb5ee)

## 🛠️ Requisitos

- **Java SE 21**: Certifique-se de ter o Java Development Kit (JDK) 21 instalado.
- **JavaFX SDK 21.0.3**: Faça o download do SDK do JavaFX correspondente.

## 📥 Instalação

### 1. Clonar o Repositório

Primeiro, clone o repositório para a sua máquina local:

```sh
git clone https://github.com/GiulianoVianna/Calculo-Mao-de-Obra-Pintura.git
```

### 2. Configurar o Ambiente de Desenvolvimento

#### a. Adicionar o JavaFX SDK ao seu Projeto

Certifique-se de que o JavaFX SDK está configurado no seu ambiente de desenvolvimento (IDE). No IntelliJ IDEA, por exemplo, você pode adicionar o SDK do JavaFX nas configurações do projeto.

### 3. Executar a Aplicação

Para executar a aplicação, use o seguinte comando na linha de comando (certifique-se de estar no diretório raiz do projeto):

```sh
java --module-path /path/to/javafx-sdk-21.0.3/lib --add-modules javafx.controls,javafx.fxml -cp . application.Main
```

## 📝 Uso da Aplicação

### Interface Principal

Ao abrir a aplicação, você verá a interface principal, onde pode inserir as medidas e o preço por metro quadrado.

### 🖋️ Passo a Passo para Calcular o Custo de Pintura

1. **Inserir Largura**: Digite a largura da área a ser pintada no campo "Largura".
2. **Inserir Altura**: Digite a altura da área a ser pintada no campo "Altura".
3. **Inserir Preço por Metro Quadrado**: Digite o preço por metro quadrado no campo "Preço por m²".
4. **Salvar**: Clique no botão "Salvar" para adicionar os dados à tabela e calcular o preço total.
5. **Limpar**: Clique no botão "Limpar" para resetar todos os campos e começar um novo cálculo.

### 📊 Tabela de Resultados

Os dados inseridos serão exibidos em uma tabela na interface principal. A tabela mostrará a largura, altura, preço por metro quadrado e o valor total calculado para cada entrada.

### 📈 Atualização do Valor Total

A aplicação calcula e exibe o valor total de todas as áreas adicionadas, facilitando a visualização do custo total do projeto de pintura.

### 🔄 Exemplos de Uso

#### Exemplo 1: Calcular o Custo para uma Parede

- **Largura**: 5 metros
- **Altura**: 3 metros
- **Preço por m²**: R$ 20,00

Ao clicar em "Salvar", a aplicação calculará a área (5m x 3m = 15m²) e o custo total (15m² x R$ 20,00 = R$ 300,00) e exibirá esses dados na tabela.

#### Exemplo 2: Calcular o Custo para Múltiplas Paredes

Repita os passos acima para cada parede adicional, e a aplicação manterá um registro de cada cálculo na tabela, atualizando o valor total automaticamente.

## 🛠️ Tecnologias Utilizadas

- **Java SE 21**
- **JavaFX SDK 21.0.3**

## 📄 Licença

Este projeto está licenciado sob os termos da licença MIT.

---

Feito com ❤️ por [Giuliano Vianna].
