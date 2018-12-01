module Tests

open System
open Xunit
open ChronicalCalibration

[<Fact>]
let ``should sum up 2 frequencies`` () =
    let actual = determineFrequency ["2"; "5"]
    Assert.Equal(7L, actual)
    
    
[<Fact>]
let ``should sum up a negative frequence`` () =
    let actual = determineFrequency ["2"; "-5"]
    Assert.Equal(-3L, actual)
    
    
[<Fact>]
let ``should sum up negative frequencies`` () =
    let actual = determineFrequency ["-2"; "-5"]
    Assert.Equal(-7L, actual)
    
[<Fact>]
let ``should sum up multiple frequencies`` () =
    let actual = determineFrequency ["-2"; "7"; "9"; "-98"; "-5"]
    Assert.Equal(-89L, actual)
