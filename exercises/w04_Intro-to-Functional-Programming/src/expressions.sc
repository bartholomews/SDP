
// EXPRESSIONS

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

exp1("sunny", 100)
exp1("partly cloudy", 10)

exp2("sunny", 100)
exp2("partly cloudy", 10)


exp3("partly cloudy", 10)
assert(true) = exp3("sunny", 100)

assert(exp3("partly cloudy", 3000))

toCelsius(32)
toCelsius(1231)
toFarenheit(0)
toFarenheit(666)