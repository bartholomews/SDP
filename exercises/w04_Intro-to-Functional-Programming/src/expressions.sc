
// Expressions

def exp1(sun: String, temp: Double): Boolean = {
  sun.equals("sunny") && temp > 80
}

def exp2(sun:String, temp: Double): Boolean = {
  (sun.equals("sunny") || sun.equals("partly cloudy")) && temp > 80
}

def exp3(sun: String, temp: Double) = {
  (sun.equals("sunny") || sun.equals("partlyCloudy")
    && (temp > 80 || temp < 20))
}

def toCelsius(f: Double): Double = {
  (f - 32) * (5 / 9.0)
}

def toFarenheit(c: Double) = {
  c * (9.0 / 5) + 32
}

val sunny90 = exp1("sunny", 90)
assert(sunny90)

val rain90 = exp1("rain", 90)
assert(!rain90)

val cloudy90 = exp2("partly cloudy", 90)
assert(cloudy90)

val cloudy80 = exp2("partly cloudy", 80)
assert(!cloudy80)

val rain10 = exp3("rain", 10)
assert(!rain10)

val sunny5 = exp3("sunny", 5)
assert(sunny5)

val f32 = toCelsius(32)
assert(f32 == 0, "32F != " + f32 + "C")

val c0 = toFarenheit(0)
assert(c0 == 32, "0C != " + c0 + "F")
