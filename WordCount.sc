val doument = sc.textFile("hdfs://localhost:9000/user/root/app/words.txt");
val words = doument.flatMap(line => line.split(" "));
val counts = words.map(word => (word, 1));
val freq = counts.reduceByKey((a, b) => a + b);
freq.foreach(println);