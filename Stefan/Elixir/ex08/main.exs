ExUnit.start()

defmodule AoC do
  def sum([]), do: 0
  def sum([head]), do: head
  def sum([head|tail]), do: head + sum(tail)

  def print([]), do: ""
  def print([head]), do: head
  def print([head|tail]), do: head <> " " <> print(tail)

  def get_children(_, _), do: []
  def get_metadata(nr, list), do: Enum.take(list, -nr)

  def solve([]), do: :error
  def solve([_]), do: :error
  def solve([_, _]), do: :error
  def solve([0, _ | metadata]), do: [children: [], metadata: metadata]
  def solve([nr_children, nr_metadata | tail]), do: [children: get_children(nr_children, tail), metadata: get_metadata(nr_metadata, tail)]
end

defmodule AoCTest do
  use ExUnit.Case

  test "summing numbers" do
    assert AoC.sum([1, 2, 3]) == 6
  end

  test "not solve invalid lists" do
    assert AoC.solve([]) == :error
    assert AoC.solve([1]) == :error
    assert AoC.solve([1, 2]) == :error
  end

  test "solve simple node" do
    assert AoC.solve([0, 1, 1]) == [children: [], metadata: [1]]
  end

  test "solve simple node with multiple metadata" do
    assert AoC.solve([0, 3, 1, 2, 3]) == [children: [], metadata: [1, 2, 3]]
  end

  test "solve node with 1 child and 1 metadata" do
    assert AoC.solve([1, 1, 0, 1, 1, 2]) == [children: [children: [], metadata: [1]], metadata: [2]]
  end
end


#File.read!("Input.txt")
"0 1 1"
  |> String.split
  |> Enum.map(&String.to_integer/1)
  |> AoC.solve
  |> IO.inspect