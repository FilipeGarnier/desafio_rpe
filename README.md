# Desafio Técnico: Desenvolvedor Java Sênior

O desafio é focado no processo de cadastro para novos portadores de cartão e consumo dos dados registrados, para isso segue abaixo a especificação dos serviços necessários e suas funcionalidades.

## Produto Service

 - Cadastro via endpoint na API;
 - Busca por id via endpoint na API;
 - Não precisa adicionar autenticação;
 - Testes unitários;
 - Dados necessários:
   - Id
   - Descricão
   - Status (ATIVO,CANCELADO)
   - Data de Criação
   - Data da última atualização

## Cartão Service

 - Cadastro via SQS com id do produto válido;
 - Não precisa adicionar autenticação;
 - Busca por portador via endpoint na API que traz os dados de cartão e produto;
 - Consumo do endpoint do Produto Service deve ter cache;
 - Dados necessários:
   - Id
   - Número
   - Senha
   - Status (ATIVO, BLOQUEADO, CANCELADO)
   - Id do portador
   - Nome personalizado do portador
   - Id do produto
   - Data de Criação
   - Data da última atualização

Para todos os serviços devem ser feitos testes unitários, deploy com Docker Compose e documentação. A documentação deve conter informações suficientes para que os outros desenvolvedores entendam quais dados são registrados, como subir o serviço, decisões técnicas, conceitos usados e como o serviço se encaixa dentro do fluxo de cadastro. 

## Produto Service

 - Uso de autenticação com JWT;
 - Cadastro completo de clientes (portador e cartão) via Endpoint e envio dos dados de cartão para o Cartão Service via SQS;
 - Busca por id via endpoint que traz os dados do portador, cartão e produto;
 - Dados necessários:
   - Id
   - Nome
   - CPF
   - Status (ATIVO, BLOQUEADO, CANCELADO)
   - Data de nascimento
   - Data de Criação
   - Data da última atualização

## Especificação técnica

- Java 17
- Maven 3+
- Spring boot 2.6.7
- Postgres
- Redis
- AWS SQS via Localstack
- Docker
- Docker Compose
- Swagger

