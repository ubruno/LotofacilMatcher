Primeiro rode o mvn clean install na raiz deste projeto, depois execute o jar que o maven gerou passando os 
parâmetros abaixo

Comando para rodar o arquivo:
java -jar <jar da aplicação> "<arquivo csv com os jogos>" <sequencia de numeros sorteados separados por espaço>

Um exemplo de como rodar:

java -jar LotofacilMatcher-1.0.0.jar "jogos.csv" 02 04 05 06 08 10 12 13 15 16 19 20 21 24 25

