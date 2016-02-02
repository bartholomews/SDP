// Classes & Objects

// 1. ======================================================

val range = Range    // object is created but cannot print
// print(range.step) // the step value as it's not set:
                     // need to specify value parameters
                     // int start, int end, int step

val range2 = Range(1,10,2)  // this one does compile
println (range2.step)       // successfully

// 2. ======================================================

var s1 = "Sally"
var s2 = "Sally"
s1.equals(s2)
println(s1 + " and " + s2 + " are equal")

// 3. ======================================================

