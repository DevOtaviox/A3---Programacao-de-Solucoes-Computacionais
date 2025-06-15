
# 📦 Projeto de Banco de Dados – Controle de Estoque com Fornecedores e Pedidos

## 📋 Descrição Geral

Este projeto consiste na modelagem e criação de um banco de dados relacional para o gerenciamento de **estoque de produtos**, **fornecedores**, **pedidos de saída**, **reposição de estoque** e **relatórios de movimentação**. O objetivo é oferecer uma solução prática para o controle de entradas e saídas de mercadorias em uma empresa.

---

## 🛠 Estrutura do Banco de Dados

O banco de dados foi projetado utilizando o **MySQL**, com foco na integridade referencial e organização das informações.

---

### 📑 Tabelas Criadas

#### 1. **Fornecedor**
Responsável por armazenar os dados dos fornecedores.

| Campo           | Tipo          | Restrições              |
|-----------------|---------------|-------------------------|
| id_fornecedor   | INT           | Chave Primária (AUTO_INCREMENT) |
| nome            | VARCHAR(100)  | NOT NULL               |
| contato         | VARCHAR(100)  | NOT NULL               |

---

#### 2. **Produto**
Armazena informações sobre os produtos disponíveis no estoque.

| Campo               | Tipo          | Restrições              |
|---------------------|---------------|-------------------------|
| id_produto          | INT           | Chave Primária (AUTO_INCREMENT) |
| nome                | VARCHAR(100)  | NOT NULL               |
| imagem              | TEXT          | Opcional               |
| quantidade_estoque  | INT           | DEFAULT 0              |
| estoque_minimo      | INT           | DEFAULT 0              |
| id_fornecedor       | INT           | Foreign Key (Fornecedor) |

---

#### 3. **Pedido**
Representa a saída de produtos do estoque através de pedidos.

| Campo        | Tipo                  | Restrições              |
|--------------|-----------------------|-------------------------|
| id_pedido    | INT                   | Chave Primária (AUTO_INCREMENT) |
| data_pedido  | DATE                  | NOT NULL (Default: data atual) |
| status       | ENUM('aberto','fechado') | NOT NULL (Default: 'aberto') |

---

#### 4. **Item_Pedido**
Armazena os produtos de cada pedido.

| Campo         | Tipo          | Restrições              |
|---------------|---------------|-------------------------|
| id_item_pedido | INT          | Chave Primária (AUTO_INCREMENT) |
| id_pedido     | INT           | Foreign Key (Pedido)    |
| id_produto    | INT           | Foreign Key (Produto)   |
| quantidade    | INT           | NOT NULL               |

---

#### 5. **Reposicao**
Controla as entradas de novos produtos ao estoque.

| Campo              | Tipo          | Restrições              |
|--------------------|---------------|-------------------------|
| id_reposicao       | INT           | Chave Primária (AUTO_INCREMENT) |
| data_reposicao     | DATE          | NOT NULL (Default: data atual) |
| id_produto         | INT           | Foreign Key (Produto)   |
| quantidade_reposta | INT           | NOT NULL               |

---

#### 6. **Relatorio**
Histórico de movimentações no estoque, tanto entradas quanto saídas.

| Campo        | Tipo                  | Restrições              |
|--------------|-----------------------|-------------------------|
| id_relatorio | INT                   | Chave Primária (AUTO_INCREMENT) |
| data         | DATE                  | NOT NULL (Default: data atual) |
| tipo         | ENUM('entrada','saida') | NOT NULL              |
| descricao    | TEXT                  | NOT NULL               |

---

## 🔗 Relacionamentos Entre Tabelas (Modelo Conceitual)

- **Produto** tem um fornecedor (chave estrangeira: `id_fornecedor`).
- **Item_Pedido** faz a ligação entre **Pedido** e **Produto**.
- **Reposicao** também está ligada ao **Produto**.
- **Relatorio** registra as movimentações de estoque, podendo ser vinculado a entradas (reposição) ou saídas (pedidos).

---

## 🎯 Objetivos do Projeto

- Controlar o estoque de forma eficiente.
- Registrar entradas e saídas de produtos.
- Manter histórico de fornecedores.
- Acompanhar pedidos de saída.
- Gerar relatórios de movimentações de estoque.

---

## ✅ Tecnologias Utilizadas

- **Sistema Gerenciador de Banco de Dados:** MySQL
- **Modelo de Dados:** Relacional
- **Linguagem SQL:** Para criação de tabelas e manipulação dos dados.

---

## 👨‍💻 Possíveis Expansões Futuras

- Implementação de **Triggers** para atualização automática de estoque.
- Criação de **Views** para facilitar consultas.
- Integração com um sistema web ou aplicativo de gestão de estoque.

---

## 📅 Data de Criação

Junho de 2025

