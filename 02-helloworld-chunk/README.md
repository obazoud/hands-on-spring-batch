#Hands-on Spring Batch

##Hello world chunk

Ce job contient une seule étape contenant une [Tasklet orienté chunk](http://static.springsource.org/spring-batch/reference/html-single/index.html#chunkOrientedProcessing)
* un [ItemReader](http://static.springsource.org/spring-batch/apidocs/org/springframework/batch/item/ItemReader.html)
* un [ItemProcessor](http://static.springsource.org/spring-batch/apidocs/org/springframework/batch/item/ItemProcessor.html)
* un [ItemWriter](http://static.springsource.org/spring-batch/apidocs/org/springframework/batch/item/ItemWriter.html)

Le but de l'exercice est d'implémenter un chunk.
Vous allez implémenter les 3 composants.

1. Vérifier que les tests ne fonctionnent pas
2. L'implémentation de HelloWorldReader doit dépiler la liste de noms et renvoyer l'élément courant, une fois la liste vide, renvoyer null 
3. Implémenter HelloWorldProcessor
* Vous devez filter les données, exclure les items contenant le caractère 'o'
* Le processor doit renvoyer 'hello ' + le prénom
4. Implémenter HelloWorldWriter:
5. Vérifier que les tests fonctionnent à nouveau

<pre class="terminal">
% mvn clean package -pl 02-helloworld-chunk
</pre>

Suivez les TODO.

