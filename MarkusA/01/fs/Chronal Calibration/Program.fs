module ChronicalCalibration

open System
open System.IO
open System.Reflection

let determineFrequency frequencies =
    frequencies
    |> Seq.map int64
    |> Seq.sum




[<EntryPoint>]
let main argv =
    let inputPath = Path.Combine(AppDomain.CurrentDomain.BaseDirectory, "input.txt")
    printfn "InputPath: %s" inputPath
    File.ReadLines inputPath
    |> determineFrequency
    |> printfn "Frequency: %d"

    0
