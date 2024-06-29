## 💻 Sistema de Gerenciamento de Pedidos 🍕

### ✨ Funcionalidades Principais

* **Gestão de Clientes 👥**:
    * Cadastro, consulta, edição e exclusão de clientes.
    * Controle de limite de crédito e limite disponível.
    * Visualização do histórico de pedidos.
* **Gestão de Vendedores 👔**:
    * Cadastro, consulta, edição e exclusão de vendedores.
    * Definição da taxa de comissão individual.
    * Visualização do histórico de pedidos.
* **Gerenciamento de Pedidos 📦**:
    * Criação de novos pedidos, associando clientes e vendedores.
    * Consulta, edição e exclusão de pedidos.
    * Cálculo automático do valor total do pedido.
    * Controle de estoque dos produtos.
* **Gerenciamento de Produtos 🍕**:
    * Cadastro, consulta, edição e exclusão de produtos.
    * Controle de estoque, nome, código e preço.
* **Relatórios Simplificados 📊**:
    * Total de vendas por produto.
    * Ranking dos produtos mais vendidos (Top 5).
    * Ranking dos clientes que mais gastaram (Top 3).
* **Funcionalidade de Busca Eficaz 🔍**:
    * Busca de clientes por CPF ou nome.
    * Busca de vendedores por CPF ou nome.
    * Busca de produtos por código ou nome.
    * Busca de pedidos por número do pedido ou CPF do cliente.

### 🚀 Tecnologias Utilizadas

* **Linguagem de Programação:** Java
* **IDE:** NetBeans 8.2
* **Banco de Dados:** Oracle
* **Framework:** -
* **Bibliotecas:**  Swing (GUI)

### 📂 Estrutura do Projeto

O projeto está organizado nos seguintes pacotes:

* **fatec.poo.model:** Contém as classes de modelo do sistema (Cliente, Vendedor, Pedido, Produto).
* **fatec.poo.view:** Contém as classes responsáveis pela interface gráfica do usuário (GUI).
* **fatec.poo.control:** Contém as classes DAO (Data Access Object) para persistência de dados e outras classes de controle.

### 🛠️ Como Executar o Projeto

1. Faça o download ou clone este repositório.
2. Importe o projeto na sua IDE (NetBeans 8.2 recomendado).
3. Configure a conexão com o banco de dados Oracle.
4. Execute o script SQL (script.sql) para criar as tabelas no banco de dados.
5. Compile e execute a classe principal do projeto (localizada no pacote fatec.poo.view).
