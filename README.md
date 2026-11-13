# Sistema de Gerenciamento de Vacinas 🐾

Aplicação web desenvolvida em Java para controle e cadastro de animais domésticos, tutores, raças e histórico de vacinação.

## 🛠️ Tecnologias Utilizadas

* **Java** (Jakarta/Java EE)
* **JSF (JavaServer Faces)** & **PrimeFaces** (Interface web)
* **JPA / EclipseLink** (Mapeamento objeto-relacional)
* **SQLite** (Banco de dados relacional)
* **Apache Tomcat 9** (Servidor de aplicação)
* **Maven** (Gerenciador de dependências)

---

## ⚙️ Como Configurar e Executar o Projeto

### 1. Pré-requisitos
* **JDK 8** ou superior instalado.
* **Apache Tomcat 9** configurado na sua IDE (IntelliJ IDEA, Eclipse ou NetBeans).
* **Maven** configurado.

### 2. Configuração do Banco de Dados (SQLite)
O projeto está configurado para utilizar um banco de dados local SQLite (`vacinas.db`).

1. Abra o arquivo `src/main/resources/META-INF/persistence.xml`.
2. Verifique a propriedade de conexão JDBC e ajuste o caminho conforme o seu sistema operacional, se necessário:
   ```xml
   <property name="javax.persistence.jdbc.url" value="jdbc:sqlite:C:/Users/seu-usuario/vacinas.db"/>
   ```
3. Caso o arquivo do banco esteja vazio, execute os scripts SQL de criação e inserção disponíveis na pasta do projeto (`inserts.sql`) para popular as tabelas iniciais (`animal`, `raca`, `tutor` e `vacina`).

### 3. Executando a Aplicação
1. Clone este repositório:
   ```bash
   git clone https://github.com
   ```
2. Importe o projeto como um **Projeto Maven** na sua IDE.
3. Aguarde o download das dependências do `pom.xml`.
4. Configure o artefato (`Vacinas:war exploded`) no **Tomcat 9** e inicie o servidor.
5. Acesse no navegador:
   ```text
   http://localhost:8080/Vacinas/
   ```

---

## 📋 Funcionalidades
* Cadastro e listagem de **Tutores**
* Cadastro e listagem de **Raças**
* Cadastro e listagem de **Animais** vinculados aos tutores
* Controle e registro de **Vacinas**
