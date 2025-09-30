
# Lumina 📚✨
**Lumina – Sua varinha é um livro, sua magia é o conhecimento.**
Aplicação de console em **Java** para gerenciar um e-commerce/livraria focada em livros físicos e audiobooks.
 
---
 
## 🚀 Funcionalidades
- **CRUD de livros**
  - Cadastrar, listar todos, buscar por **ID**, **título**, **autor** e **categoria**
  - Atualizar **preço** e (para livros físicos) **estoque**
  - Deletar livro
- **Categorias**
  - `1` = **Audiobook** (estoque sempre `0`, com **duração** `java.time.Duration`)
  - `2` = **Livro Físico** (tem **peso** e **estoque**)
- **Vendas**
  - Registrar venda por **ID do livro** e **quantidade**
  - Baixa automática do estoque para livros físicos
  - **Histórico de vendas** com total faturado
 
---
 
## 🗂 Estrutura do projeto
```
src/
└─ lumina/
   ├─ Menu.java
   ├─ util/
   │  └─ Cores.java
   ├─ controller/
   │  └─ LivroController.java
   ├─ repository/
   │  └─ LivroRepository.java
   └─ model/
      ├─ Livros.java           (classe base abstrata)
      ├─ LivroFisico.java      (peso, estoque)
      ├─ Audiobook.java        (Duration)
      └─ Venda.java            (histórico de vendas)
```
 
---
 
## 🧰 Requisitos
- **JDK 17+** (testado com JDK 23)
- (Opcional) IDE como **Eclipse** ou **IntelliJ**
 
---
 
## ▶️ Como executar
 
### Opção 1 — IDE
1. Importe o projeto como **Java Project**
2. Defina **`lumina.Menu`** como classe principal
3. Rode
 
### Opção 2 — Terminal
 
**Linux/macOS**
```bash
find src -name "*.java" > sources.txt
javac -d out @sources.txt
java -cp out lumina.Menu
```
 
**Windows (PowerShell/CMD)**
```bat
dir /s /b src\*.java > sources.txt
javac -d out @sources.txt
java -cp out lumina.Menu
```
 
---
 
## 🕹 Uso (Menu)
1. **Cadastrar Livro**
   - `1` Audiobook → informar **duração** (horas/minutos). Estoque sempre 0.
   - `2` Livro Físico → informar **estoque** e **peso (g)**.
2. **Listar todos os Livros**
3. **Listar por Categoria** (`1` Audiobook, `2` Livro Físico)
4. **Buscar por ID**
5. **Atualizar Dados do Livro**
   - Preço (aceita vírgula ou ponto)
   - Estoque (somente para livros físicos)
6. **Apagar Livro**
7. **Procurar por Título** (case-insensitive)
8. **Procurar por Autor** (case-insensitive)
9. **Registrar venda de Livro** (ID + quantidade)
10. **Histórico de Vendas** (lista vendas e total faturado)
 
---
 
## 🔍 Principais classes
 
### `Livros` (abstrata)
- Campos: `id`, `nome`, `categoria (int)`, `autor`, `preco (Float)`, `estoque (int)`
- `visualizar()` imprime os dados do livro (categoria como texto)
 
### `LivroFisico`
- Extende `Livros`
- Campos extras: `peso (int)`
- Participa de controle de **estoque** e **baixa em venda**
 
### `Audiobook`
- Extende `Livros`
- Campo extra: `duracao (Duration)`
- **Não** controla estoque (sempre 0)
 
### `Venda`
- Guarda `id` da venda, `idLivro`, `titulo`, `quantidade`, `precoUnitario`, `total`, `dataHora`
- `visualizar()` imprime o comprovante da venda
 
### `LivroController` (implementa `LivroRepository`)
- CRUD em memória (Lista)
- Filtros por título/autor/categoria
- `qntEstoque(int)` define a mesma quantidade para **todos os livros físicos**
- `registrarVenda(int idLivro, int quantidade)` / `venda(int idLivro)` (1 unidade)
- Histórico: `historico(int)` e/ou `listarHistoricoVendas()`
 
---
 
## 🧪 Fluxo rápido para testar
1) **Cadastrar** (1 audiobook e 1 físico com estoque)  
2) **Listar todos**  
3) **Registrar venda** (livro físico, quantidade > 0)  
4) **Histórico de Vendas**  
5) **Atualizar** preço/estoque e listar novamente
 
---
 
## 🛠 Dicas e resolução de problemas
- **“Opção inválida!” e mesmo assim executa algo**: use `continue` após validar a opção para não cair no `switch`.
- **Erro de formatação** (`IllegalFormatConversionException`): use `%s` (String), `%d` (int), `%.2f` (float/double).
- **`'var' is not allowed here'`**: use tipos explícitos (`Livros livro : lista`) ou ajuste a linguagem da IDE (Java 10+).
 
---
 
## 📌 Roadmap (ideias futuras)
- Persistência (Arquivo/SQLite/JPA)
- `enum` para Categoria (em vez de `int`)
- Relatórios por período (faturamento diário/mensal)
- Descontos/cupom em venda
- Testes unitários (JUnit)
 
---
 
## 📄 Licença
MIT — sinta-se à vontade para usar e adaptar.
 
---
 
## 🙌 Autoria
Projeto desenvolvido por **Rafaela Lemes – Dev Full Stack**  
GitHub: `github.com/lemesdemorais`
