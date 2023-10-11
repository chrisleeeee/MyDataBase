package org.example.Components;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.example.model.FindColumnInfo;

import java.util.ArrayList;
import java.util.List;

public class SparkReader {

    private static SparkReader instance;
    private final SparkConf conf;

    private final JavaSparkContext sparkContext;

    private SparkReader() {
        this.conf = new SparkConf().setAppName("SparkReader").setMaster("local[*]");
        this.sparkContext = new JavaSparkContext(this.conf);
    }

    public static SparkReader getInstance() {
        if (instance == null) {
            synchronized (SparkReader.class) {
                if (instance == null) {
                    instance = new SparkReader();
                }
            }
        }
        return instance;
    }

    public void readTableData(String tablePath,
                              List<Integer> index, List<String> dataType) {
        // selected Columns, Column Name, Column index, Column Data Type
//        List<Integer> index = List.of(1, 3);
//        List<String> dataType = List.of("string(20)", "float");
        JavaRDD<String> javaRDD = sparkContext.textFile(tablePath);
        JavaRDD<List<Object>> map = javaRDD.filter(record -> record.charAt(0) == '1').map(record -> {
            String[] split = record.split("\t");
            List<Object> data = new ArrayList<>();
            for(int i = 0; i < index.size(); i ++) {
                if(dataType.get(i).equals("int")) {
                    data.add(Integer.parseInt(split[index.get(i)]));
                } else if(dataType.get(i).equals("float")) {
                    data.add(Double.parseDouble(split[index.get(i)]));
                } else if(dataType.get(i).startsWith("string")) {
                    data.add(split[index.get(i)]);
                }
            }
            return data;
        });

        map.collect().forEach(System.out::println);


    }
}
