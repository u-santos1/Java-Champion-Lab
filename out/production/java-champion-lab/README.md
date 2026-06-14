#  Java Champion Lab

Este repositório é um laboratório prático (sandbox) projetado para masterizar o ecossistema Java moderno de forma modular e isolada. O objetivo é testar, errar e validar conceitos avançados de arquitetura e Inteligência Artificial de forma cirúrgica antes de integrá-los à API de produção (BackEnd API).

##  Estrutura do Repositório

O projeto está estritamente dividido em três módulos independentes para evitar acoplamento durante os estudos:

* **`01-java-core-lab`**: Foco em Java 17+ puro. Aplicação de Records, Pattern Matching, Lambdas e princípios SOLID. Nenhuma dependência de framework ou infraestrutura.
* **`02-backend-respeito-lab`**: O núcleo de infraestrutura corporativa. Implementação de Spring Boot 3, ambiente Dockerizado, PostgreSQL, Spring Security, JWT e padrão Repository. Sem Inteligência Artificial.
* **`03-spring-ai-rag-lab`**: O laboratório de Inteligência Artificial. Testes isolados com Spring AI, banco de dados vetorial (`pgvector`) e aplicação do padrão arquitetural corporativo RAG (Retrieval-Augmented Generation).

##  Segundo Cérebro (Contexto IA)

O arquivo `CONTEXTO_IA.md` na raiz deste projeto contém o prompt de injeção de contexto. Ele é utilizado para calibrar o escopo de assistentes de IA no início de qualquer nova sessão de desenvolvimento, garantindo respostas pragmáticas e alinhadas às regras de isolamento de cada módulo.

---
*Foco em pragmatismo, fundamentos sólidos e código que funciona.*