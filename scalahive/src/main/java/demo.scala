
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}


object demo {
  def main(args: Array[String]): Unit = {


    val spark = SparkSession
      .builder()
      .enableHiveSupport()
      .appName("Spark Hive")
      .master("local[2]")
      .getOrCreate()
    spark.sql("show tables").printSchema()
   /* spark.sql("show tables").rdd.foreach(row => {
      println("row.size:" + row.size + "  " + row.getString(1))
    })
    var sqlrdd=spark.sql("show tables");
   sqlrdd.rdd.flatMap{name=>name.toString().split(",")}.foreach(row => {
      println(row.trim.toString)
    })*/
  }

  def mapTest() {
    val conf = new SparkConf()
      .setAppName("map")
      .setMaster("local")
    val sc = new SparkContext(conf)
    val numbers = Array(1, 2, 3, 4, 5)
    val numberRDD = sc.parallelize(numbers, 1)
    val multipleNumberRDD = numberRDD.map { number => number * 3 }
    multipleNumberRDD.foreach { num => println(num) }

  }
}