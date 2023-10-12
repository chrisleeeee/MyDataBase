package org.example.Components;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.example.model.ColumnInfo;
import org.example.model.conditions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        JavaRDD<String> javaRDD = sparkContext.textFile(tablePath);
        JavaRDD<List<Object>> map = javaRDD.filter(record -> record.charAt(0) == '1').zipWithIndex().map(record -> {
            long rowIndex = record._2();
            String[] split = record._1().split("\t");
            List<Object> data = new ArrayList<>();
            data.add(rowIndex);
            for (int i = 0; i < index.size(); i++) {
                if (dataType.get(i).equals("int")) {
                    data.add(Integer.parseInt(split[index.get(i)]));
                } else if (dataType.get(i).equals("float")) {
                    data.add(Double.parseDouble(split[index.get(i)]));
                } else if (dataType.get(i).startsWith("string")) {
                    data.add(split[index.get(i)]);
                }
            }
            return data;
        });
        map.collect().forEach(System.out::println);
    }

    public void readTableDataWithCondition(String tablePath,
                                           List<Integer> indexes,
                                           List<String> dataTypes,
                                           Map<String, ColumnInfo> allColumnsInfo, ConditionNode condition) {
        JavaRDD<String> javaRDD = sparkContext.textFile(tablePath);
        List<Integer> allIndexes = new ArrayList<>();
        List<String> allTypes = new ArrayList<>();
        for (String s : allColumnsInfo.keySet()) {
            allIndexes.add(allColumnsInfo.get(s).getIndex());
            allTypes.add(allColumnsInfo.get(s).getType());
        }

        JavaRDD<List<Object>> allColumnsData = javaRDD
                .filter(record -> record.charAt(0) == '1')
                .zipWithIndex()
                .map(record -> {
                    long rowIndex = record._2();
                    String[] split = record._1().split("\t");
                    List<Object> data = new ArrayList<>();
                    data.add(rowIndex);
                    for (int i = 0; i < allIndexes.size(); i++) {
                        if (allTypes.get(i).equals("int")) {
                            data.add(Integer.parseInt(split[allIndexes.get(i)]));
                        } else if (allTypes.get(i).equals("float")) {
                            data.add(Double.parseDouble(split[allIndexes.get(i)]));
                        } else if (allTypes.get(i).startsWith("string")) {
                            data.add(split[allIndexes.get(i)]);
                        }
                    }
                    return data;
                });

        if (condition instanceof ConditionExpression expression) {
            // only one condition
            JavaRDD<List<Object>> filteredCondition = filterRDD(expression,
                    allColumnsInfo,
                    allColumnsData,
                    indexes,
                    dataTypes);
            filteredCondition.collect().forEach(System.out::println);
        } else if (condition instanceof LogicalConditionNode logicalExpression) {
            JavaRDD<List<Object>> filteredConditions = filterManyConditions(logicalExpression,
                    allColumnsInfo,
                    allColumnsData,
                    indexes,
                    dataTypes);
            filteredConditions.collect().forEach(System.out::println);
        }
    }

    private JavaRDD<List<Object>> filterManyConditions(ConditionNode conditionNode,
                                                       Map<String, ColumnInfo> allColumnsInfo,
                                                       JavaRDD<List<Object>> allColumnsData,
                                                       List<Integer> indexes,
                                                       List<String> dataTypes) {
        if (conditionNode instanceof ConditionExpression expression) {
            JavaRDD<List<Object>> filteredData = filterRDD(expression,
                    allColumnsInfo,
                    allColumnsData,
                    indexes,
                    dataTypes);
            return filteredData;
        } else {
            LogicalConditionNode logicalConditionNode = (LogicalConditionNode) conditionNode;
            JavaRDD<List<Object>> leftRDD = filterManyConditions(logicalConditionNode.getLeft(), allColumnsInfo, allColumnsData, indexes, dataTypes);
            JavaRDD<List<Object>> rightRDD = filterManyConditions(logicalConditionNode.getRight(), allColumnsInfo, allColumnsData, indexes, dataTypes);
            if (logicalConditionNode.getOperator().equals(LogicalOperator.AND)) {
                return leftRDD.intersection(rightRDD);
            } else {
                return leftRDD.union(rightRDD);
            }
        }
    }


    private JavaRDD<List<Object>> filterRDD(ConditionExpression expression,
                                            Map<String, ColumnInfo> allColumnsInfo,
                                            JavaRDD<List<Object>> allColumnsData,
                                            List<Integer> indexes,
                                            List<String> dataTypes) {
        String columnName = expression.getColumnName();
        int columnIndex = allColumnsInfo.get(columnName).getIndex();
        String columnDataType = allColumnsInfo.get(columnName).getType();
        String value = expression.getValue();
        ComparisonOperator comparator = expression.getComparator();
        allColumnsData = allColumnsData.filter(record -> {
            if (columnDataType.equals("int")) {
                Integer origin = (Integer) record.get(columnIndex);
                Integer target = Integer.parseInt(value);
                switch (comparator) {
                    case EQ -> {
                        return origin == target;
                    }
                    case GT -> {
                        return origin > target;
                    }
                    case GTE -> {
                        return origin >= target;
                    }
                    case LT -> {
                        return origin < target;
                    }
                    case LTE -> {
                        return origin <= target;
                    }
                    case NEQ -> {
                        return origin != target;
                    }
                }
                return false;
            } else if (columnDataType.equals("float")) {
                Double origin = (Double) record.get(columnIndex);
                Double target = Double.parseDouble(value);
                switch (comparator) {
                    case EQ -> {
                        return origin == target;
                    }
                    case GT -> {
                        return origin > target;
                    }
                    case GTE -> {
                        return origin >= target;
                    }
                    case LT -> {
                        return origin < target;
                    }
                    case LTE -> {
                        return origin <= target;
                    }
                    case NEQ -> {
                        return origin != target;
                    }
                }
                return false;
            } else {
                String org = (String) record.get(columnIndex);
                boolean res = org.equals(value.substring(1, value.length() - 1));
                switch (comparator) {
                    case EQ -> {
                        return res;
                    }
                    case NEQ -> {
                        return !res;
                    }
                }
                return false;
            }
        });
        JavaRDD<List<Object>> map = allColumnsData.map(record -> {
            List<Object> data = new ArrayList<>();
            for (int i = 0; i < indexes.size(); i++) {
                if (dataTypes.get(i).equals("int")) {
                    data.add(record.get(indexes.get(i)));
                } else if (dataTypes.get(i).equals("float")) {
                    data.add(record.get(indexes.get(i)));
                } else if (dataTypes.get(i).startsWith("string")) {
                    data.add(record.get(indexes.get(i)));
                }
            }
            return data;
        });
        return map;
    }


}
