# StudyTracker - Sistema de Gerenciamento de Estudos 📖

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Supabase](https://img.shields.io/badge/Supabase-3ECF8E?style=for-the-badge&logo=supabase&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Render](https://img.shields.io/badge/Render-%46E3B7.svg?style=for-the-badge&logo=render&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)



---

## 🧭 Visão Geral

O **Study Tracker** é uma aplicação focada no acompanhamento e na gestão detalhada do progresso acadêmico do usuário. A ferramenta permite que o estudante organize sua jornada de aprendizado através de categorias, cursos, módulos e aulas. 

Por meio de uma interface robusta baseada em Java e Spring Boot, o sistema não apenas registra o conteúdo, mas monitora rigorosamente o progresso individual, garantindo a integridade dos dados e a persistência de sessões de estudo detalhadas.

---

## 🚀 Funcionalidades Principais

- 🔒 **Autenticação Segura:** Login e Cadastro de usuários com JWT (JSON Web Token).
- 📖 **Organização Hierárquica:** Gestão completa de aprendizado organizada por Categorias, Cursos, Módulos e Aulas.
- 🖥️ **Monitoramento de Progresso:** Registro rigoroso de aulas concluídas com data e hora, impedindo duplicidade através de restrições de integridade no banco de dados.
- ⏰ **Sessões de Estudo:** Lançamento de horas estudadas com campo para notas personalizadas, permitindo um histórico detalhado da evolução acadêmica.
- 🧪 **Interface de Testes (Swagger):** Documentação interativa configurada com exemplos reais, facilitando o teste imediato de todos os endpoints da API.
- 🚧 **Infraestrutura Moderna:** Aplicação totalmente conteinerizada com Docker e versionamento de banco de dados via Flyway, pronta para deploys escaláveis na nuvem.
- 🛡️ **Segurança de Dados:** Senhas criptografadas (BCrypt) e uso de Constraints (Unique e Foreign Keys) para garantir que cada registro de progresso esteja vinculado corretamente ao usuário e ao conteúdo.

---

## 🛠️ Tecnologias Utilizadas

### 🌐 Frontend (Em desenvolvimento)

### ⚙️ Backend
- **Java 21**
- **Spring Boot 3**
- **Spring Security**: Autenticação e Autorização
- **Spring Data JPA**: Persistência de dados
- **MapStruct**: Mapeamento inteligente de DTOs
- **Maven**: Gerenciamento de dependências e build do Projeto

### 🗄️ Banco de Dados
- **PostgreSQL**: Banco de dados relacional robusto hospedado no Supabase.
- **Flyway**: Versionamento automatizado do esquema do banco de dados (Migrations).

### 🚧 Infraestrutura 
- **Docker**: Conteinerização da API para padronização de ambientes.
- **Render**: Plataforma para hosting da API e deploy contínuo (CI/CD).
- **Swagger**: Documentação interativa para testes e integração.
---

## 🧩 Arquitetura

O projeto segue o padrão em camadas (**Layered Architecture**) para garantir desacoplamento e fácil manutenção:

1. **Controller:** Exposição dos endpoints REST (`/courses`, `/lessons`, `/auth`).
2. **Service:** Regras de negócio, validações e cálculos.
3. **Repository:** Camada de acesso a dados (JPA/Hibernate).
4. **Security:** Filtros de segurança (JWT).
5. **DTO**: Evitando a exposição direta das entidades do banco e melhorando a segurança da API.

<div align="center">
  <img src="https://github.com/user-attachments/assets/e454e284-8610-4de0-8308-2c018f5e98c1" alt="Arquitetura do StudyTracker" width="400">
</div>

---

## 🧪 Teste agora mesmo: (Por estar em uma hospedagem gratuita, o primeiro carregamento da API pode levar cerca de 1 minuto para iniciar)

A API está online e pronta para testes através da documentação interativa: 
https://studytracker-8uxv.onrender.com/swagger-ui/index.html

---
## 💾 Instalação e Execução

### Pré-requisitos
- Docker e Docker compose instalados 
- Java 21 (se for rodar via IDE)

### 1. Clone o repositório
```bash
git clone https://github.com/hanrrysantos/studytracker.git
cd studytracker
```
### 2. Execute via Docker
```bash
docker-compose up -d
```

## 💾 Estrutura de Dados

<div align="center">
<img src="https://github.com/user-attachments/assets/e7624981-56a7-4cb4-9120-e215db75e2f2" alt="Diagrama de Banco de Dados StudyTracker" width="700">
</div>

---

## 🧠 Autor

**Hanrry** Desenvolvedor Backend Java em formação | Foco em Spring Boot e Arquitetura de Software

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/hanrrysantos)
[![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/hanrrysantos)

---

## 📜 Licença

Este projeto é de uso livre para fins de estudo e portfólio.
