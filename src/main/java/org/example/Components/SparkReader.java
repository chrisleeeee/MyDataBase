package org.example.Components;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.example.model.ColumnInfo;
import org.example.model.conditions.*;

import java.io.*;
import java.util.*;

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
        JavaRDD<List<Object>> map = javaRDD.zipWithIndex().filter(record -> record._1.charAt(0) == '1').map(record -> {
            long rowIndex = record._2();
            String[] split = record._1().split("\t");
            List<Object> data = new ArrayList<>();
            data.add(rowIndex);
            for (int i = 0; i < index.size(); i++) {
                if (dataType.get(i).equals("int")) {
                    data.add(Integer.parseInt(split[index.get(i)]));
                } else if (dataType.get(i).equals("float")) {
                    data.add(Double.parseDouble(split[index.get(i)]));
                } else if (dataType.get(i).startsWith("s") || dataType.get(i).startsWith("S")) {
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
                .zipWithIndex()
                .filter(record -> record._1.charAt(0) == '1')
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
                        } else if (allTypes.get(i).startsWith("s") || allTypes.get(i).startsWith("S")) {
                            data.add(split[allIndexes.get(i)]);
                        }
                    }
                    return data;
                });
        if(condition == null) {
            JavaRDD<List<Object>> rdd = allColumnsData.map(record -> {
                List<Object> displayData = new ArrayList<>();
                for (int i = 0; i < indexes.size(); i++) {
                    displayData.add(record.get(indexes.get(i)));
                }
                return displayData;
            });
            rdd.collect().forEach(System.out::println);

        }
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

    public void deleteTableDataWithCondition(String tablePath,
                                             Integer columnIndex,
                                             String dataType,
                                             String value,
                                             ComparisonOperator comparator) {
        JavaRDD<String> rawData = sparkContext.textFile(tablePath);
        JavaPairRDD<String, Long> filter = rawData.zipWithIndex()
                .filter(record -> record._1().charAt(0) == '1')
                .filter(record -> {
                    String[] split = record._1().split("\t");
                    String targetData = split[columnIndex];
                    if (dataType.equalsIgnoreCase("int")) {
                        int res = Integer.parseInt(targetData);
                        int parseValue = Integer.parseInt(value);
                        switch (comparator) {
                            case EQ -> {
                                return res == parseValue;
                            }
                            case NEQ -> {
                                return res != parseValue;
                            }
                            case LT -> {
                                return res < parseValue;
                            }
                            case LTE -> {
                                return res <= parseValue;
                            }
                            case GT -> {
                                return res > parseValue;
                            }
                            case GTE -> {
                                return res >= parseValue;
                            }
                        }
                    } else if (dataType.equalsIgnoreCase("float")) {
                        double res = Double.parseDouble(targetData);
                        double parseValue = Double.parseDouble(value);
                        switch (comparator) {
                            case EQ -> {
                                return res == parseValue;
                            }
                            case NEQ -> {
                                return res != parseValue;
                            }
                            case LT -> {
                                return res < parseValue;
                            }
                            case LTE -> {
                                return res <= parseValue;
                            }
                            case GT -> {
                                return res > parseValue;
                            }
                            case GTE -> {
                                return res >= parseValue;
                            }
                        }
                    } else {
                        String dValue = value.substring(1, value.length() - 1);
                        System.out.println(Objects.equals(split[columnIndex], dValue));
                        switch (comparator) {
                            case EQ -> {
                                return Objects.equals(split[columnIndex], dValue);
                            }
                            case NEQ -> {
                                return !Objects.equals(split[columnIndex], dValue);
                            }
                        }
                    }
                    return false;
                });
        List<Long> rowsToDelete = filter.map(record -> record._2()).collect();
        deleteRows(rowsToDelete, tablePath);
    }

    private void deleteRows(List<Long> rowsToDelete, String tablePath) {
        System.out.println(rowsToDelete);
        try (BufferedReader br = new BufferedReader(new FileReader(tablePath));
             BufferedWriter bw = new BufferedWriter(new FileWriter("temp_file.txt"))) {

            String line;
            long currentLine = 0;

            while ((line = br.readLine()) != null) {
                currentLine++;
                if (!rowsToDelete.contains(currentLine - 1)) { // Convert to 0-based index
                    bw.write(line);
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Replace the original file with the temporary file
        File originalFile = new File(tablePath);
        System.out.println(originalFile.delete());
        File tempFile = new File("temp_file.txt");
        if (tempFile.renameTo(originalFile)) {
            System.out.println("Lines removed successfully.");
        } else {
            System.out.println("Failed to remove lines.");
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
        String columnName = expression.getColumnName().getColumnName();
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
                } else if (dataTypes.get(i).startsWith("string") || dataTypes.get(i).startsWith("String")) {
                    data.add(record.get(indexes.get(i)));
                }
            }
            return data;
        });
        return map;
    }


    public void deleteTableDataWithConditionList(ConditionNode conditionNode,
                                                 String filePath,
                                                 Map<String, ColumnInfo> columns) {
        JavaRDD<List<Object>> tableData = sparkContext.textFile(filePath)
                .zipWithIndex()
                .filter(record -> record._1.charAt(0) == '1')
                .map(record -> {
                    List<Object> data = new ArrayList<>();
                    data.add(record._2);
                    String[] split = record._1().split("\t");
                    data.addAll(Arrays.asList(split).subList(1, split.length));
                    return data;
                });
        JavaRDD<Long> rowsToDelete = getRowsToDelete(conditionNode, filePath, columns, tableData);
        List<Long> rowsList = rowsToDelete.collect();
        deleteRows(rowsList, filePath);

    }

    private JavaRDD<Long> getRowsToDelete(ConditionNode conditionNode,
                                          String filePath,
                                          Map<String, ColumnInfo> columns,
                                          JavaRDD<List<Object>> tableData) {
        if (conditionNode instanceof ConditionExpression expression) {
            String columnName = expression.getColumnName().getColumnName();
            String value = expression.getValue();
            ComparisonOperator comparator = expression.getComparator();
            int columnIndex = columns.get(columnName).getIndex();
            String type = columns.get(columnName).getType();
            JavaRDD<Long> map = tableData.filter(record -> {
                Object object = record.get(columnIndex);
                if (type.equalsIgnoreCase("int")) {
                    int orgData = (int) object;
                    int parseValue = Integer.parseInt(value);
                    switch (comparator) {
                        case EQ -> {
                            return orgData == parseValue;
                        }
                        case NEQ -> {
                            return orgData != parseValue;
                        }
                        case LT -> {
                            return orgData < parseValue;
                        }
                        case LTE -> {
                            return orgData <= parseValue;
                        }
                        case GT -> {
                            return orgData > parseValue;
                        }
                        case GTE -> {
                            return orgData >= parseValue;
                        }
                    }
                } else if (type.equalsIgnoreCase("float")) {
                    double orgData = (double) object;
                    double parseValue = Double.parseDouble(value);
                    switch (comparator) {
                        case EQ -> {
                            return orgData == parseValue;
                        }
                        case NEQ -> {
                            return orgData != parseValue;
                        }
                        case LT -> {
                            return orgData < parseValue;
                        }
                        case LTE -> {
                            return orgData <= parseValue;
                        }
                        case GT -> {
                            return orgData > parseValue;
                        }
                        case GTE -> {
                            return orgData >= parseValue;
                        }
                    }
                } else {
                    String orgData = (String) object;
                    final boolean equals = Objects.equals(orgData, value.substring(1, value.length() - 1));
                    switch (comparator) {
                        case EQ -> {
                            return equals;
                        }
                        case NEQ -> {
                            return !equals;
                        }
                    }
                }
                return false;
            }).map(record -> {
                Object index = record.get(0);
                return (Long) index;
            });
            return map;
        } else {
            LogicalConditionNode logicalConditionNode = (LogicalConditionNode) conditionNode;
            JavaRDD<Long> leftIndex = getRowsToDelete(logicalConditionNode.getLeft(), filePath, columns, tableData);
            JavaRDD<Long> rightIndex = getRowsToDelete(logicalConditionNode.getRight(), filePath, columns, tableData);
            LogicalOperator operator = logicalConditionNode.getOperator();
            if (operator.equals(LogicalOperator.OR)) {
                return leftIndex.union(rightIndex);
            } else {
                return leftIndex.intersection(rightIndex);
            }
        }
    }

    public List<Long> updateTableWithCondition(String filePath,
                                               List<Integer> index,
                                               List<String> value,
                                               ConditionNode condition,
                                               Map<String, ColumnInfo> columnsInfo) {

        List<Integer> allIndexes = new ArrayList<>();
        List<String> allTypes = new ArrayList<>();
        for (String s : columnsInfo.keySet()) {
            allIndexes.add(columnsInfo.get(s).getIndex());
            allTypes.add(columnsInfo.get(s).getType());
        }

        JavaRDD<List<Object>> allColumnsData = sparkContext.textFile(filePath)
                .zipWithIndex()
                .filter(record -> record._1.charAt(0) == '1')
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
                        } else if (allTypes.get(i).startsWith("s") || allTypes.get(i).startsWith("S")) {
                            data.add(split[allIndexes.get(i)]);
                        }
                    }
                    return data;
                });
        JavaRDD<Long> rowsToUpdate = getRowsToDelete(condition, filePath, columnsInfo, allColumnsData);
        List<Long> rowList = rowsToUpdate.collect();
        return rowList;
    }


}
