# Linked-List-Syncronization

## Autor:
- Alexandre Dantas dos Santos

## Objetivos
- Considere uma lista simplesmente encadeada cujo acesso é compartilhado por três tipos de threads: o tipo B realiza operações de busca sobre a lista, o tipo I realiza operações de inserção de itens no final da lista e o tipo R realiza operações de remoção de itens a partir de qualquer posição da lista. Threads do tipo B meramente realizam operações de leitura sobre a lista e, portanto, podem ser executadas de forma simultânea com as outras. Por sua vez, as operações de
inserção realizadas pelas threads do tipo I devem ser mutuamente exclusivas a fim de impedir que duas threads estejam inserindo itens no final da lista ao mesmo tempo. Por fim, no máximo uma thread do tipo R pode acessar a lista por vez para
realizar remoção de itens e essa operação deve ser mutuamente exclusiva com relação às demais (busca e inserção).

## Metodologia
- O projeto foi desenvolvido na Linguagem de Programação Java através da IDE Eclipse (JAVA 11).
- A solução proposta foi baseada no uso de bloqueios, fazendo uso de ReentrantReadWriteLock e ReentrantLock do Java.

## Execução
- Para iniciar a aplicação executar o arquivo Main.Java presente nas pastas /bin/core.

## Comandos para execução
- Na pasta raiz do projeto acessar a pasta bin: **cd bin**.
- Executar a aplicação informando os argumentos necessários: **Java core.Main**.
- Outra forma de executar o projeto é através da IDE Eclipse. Para testar, basta importar o projeto para a IDE e executá-lo diretamente através da aplicação.


