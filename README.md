# AppResidencia
Desafio para vaga de estagio na escola tecnica residencia

Foram usados nesse app as api's:

https://thecatapi.com

https://thedogapi.com

https://swapi.co 

Para consumir as Api's de gato e cachorro foi usado o ' HTTP Url Connection ' que é a maneira de abrir
requisições Http manualmente usando java.

Após abrir essa requisição foi usado a propria Classe ' JSON ' do android para converter
os dados recebidos da requisição e passalos para o app.

Para a Api de StarWars foi usado a biblioteca ' Retrofit ' que realiza a requisição HTTP de forma assincrona
junto a ela foi usado tambem a biblioteca ' Gson ' do google para realizar a conversão da resposta da requisição 
para uma classe java.

Todos os dados de gatos e cachorros vem da propria API, por meio da requisição, sem nenhum dado local.

As imagens de StarWars foram salva localmente, pois a Api só contem a descrição.


Link do video com app em funcionamento -> 



Retrofit -> https://square.github.io/retrofit/

Gson -> https://github.com/google/gson
