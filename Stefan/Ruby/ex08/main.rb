require './tree_parser.rb'

input = IO.read("Input.txt")
tree = TreeParser.new.parse(input)
puts tree.sum_of_metadata
puts tree.value