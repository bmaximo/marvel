# Desafio Backend - Marvel

## Instruções para executar o projeto
- Faça o download do projeto clicando no botão 'Code' e em 'Download Zip', ou clicando [aqui](https://github.com/bmaximo/marvel/archive/refs/heads/master.zip);
- Extraia o projeto no seu computador;
- Em seu terminal acesse o caminho da pasta onde você extraiu os arquivos;
- Execute o comando 'mvnw spring-boot:run' ou 'mvnw.cmd spring-boot:run' caso esteja utilizando o cmd do windows como terminal, assim ele irá baixar as dependencias do projeto;
- Para execurtar os testes basta digitar no seu terminal o comando 'mvnw test' ou 'mvnw.cmd test';
- Quando o o build do projeto estiver pronto os endpoits podem ser acessado por http://localhost:8080 + endpoint

### Enpoints
* `/v1/public/characters`
* `/v1/public/characters/{characterId}`
* `/v1/public/characters/{characterId}/comics`
* `/v1/public/characters/{characterId}/events`
* `/v1/public/characters/{characterId}/series`
* `/v1/public/characters/{characterId}/stories`

#### Acesso online
Caso deseje acessar a api pela internet, basta acessor pelo link https://marvel-backend-challenge.herokuapp.com + o endpoint desejado.
