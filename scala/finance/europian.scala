import java.lang.Math

object Random extends Random

def normal : double =  (-2 * Math.log(Random.nextDouble)) * Math.cos(2 * Math.PI * Random.nextDouble)

def process(r: double, sigma: double, dt: double, current: double,  strike: double, maturity: double, iteration: Int) = {
  var prices = Array[double][double]
  for (i <- 1 to iteration - 1) {
    
  }
}



