# WordCount Spark

## Présentation

* Ce projet contient l'implémentation du fameux exemple __WordCount__ basée sur le moteur d'analyse Apache Spark.

## Prérequis

* Installer Apache Hadoop sur votre machine
* Installer Apache Spark 3.1.1

## Utilisation

* Télécharger le fichier de données disponible sur ce lien [https://raw.githubusercontent.com/BigDataESEN/datasets/main/words.txt](https://raw.githubusercontent.com/BigDataESEN/datasets/main/words.txt)

* Envoyer le fichier `words.txt` à votre cluster hdfs.
  ```
  hdfs dfs -mkdir app
  hdfs dfs -put words.txt app/words.txt
  ```

* Placer le fichier `WordCount.sc` dans votre répertoire de travail, puis lancer la commande suivante :

  ```
  spark-shell -i WordCount.sc 
  ```

  Ce script calcule le nombre d'occurrences de chaque terme dans le fichier et affiche le résultat dans le terminal.
  
  ![screenshot](https://www.nassimbahri.ovh/docs/bigdata/documentations/spark/scala.png)

## Modification

* Pour changer le fichier à analyser, vous devez modifier la ligne suivante :

  ```
  val doument = sc.textFile("hdfs://localhost:9000/user/root/app/words.txt");
  ```

* Pour stocker le résultat de ce programme dans un répertoire au lieu de l'afficher sur le terminal, vous devez modifier la ligne suivante :

  ```
  freq.foreach(println);
  ```

  et la replacer par la ligne suivante : 
  
  ```
  freq.saveAsTextFile("hdfs://...");
  ```

  par exemple : on veut stocker le résultat dans un répertoire nommé `output`

  ```
  freq.saveAsTextFile("hdfs://localhost:9000/user/root/app/output");
  ```

  ![screenshot](https://www.nassimbahri.ovh/docs/bigdata/documentations/spark/c1.png)
  
  ![screenshot](https://www.nassimbahri.ovh/docs/bigdata/documentations/spark/c2.png)