#Hands-on Spring Batch

##Hello world tasklet

Ce job contient une seule étape contituée de helloWorldTasklet, qui affichera un beau "Hello World" à l'aide du logger [Slf4j](http://www.slf4j.org/).
La description de ce job se trouve dans springbatch-job.xml.

Le but de l'exercice est de découvrir le composant [Tasklet](http://static.springsource.org/spring-batch/apidocs/org/springframework/batch/core/step/tasklet/Tasklet.html).
Vous devez :
1. Vérifier que les tests "HelloWorldJobTest" ne fonctionnent pas
2. Finaliser l'implémentation de HelloWorldTasklet
3. Vérifier que les tests fonctionnent à nouveau

<pre class="terminal">
% mvn clean package -pl 01-helloworld-tasklet
</pre>

Suivez les TODO.

