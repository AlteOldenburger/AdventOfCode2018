require './tree_parser.rb'

input = IO.read("Input.txt")
tree = TreeParser.new.parse(input)
puts tree.sum_of_metadata # 40036
puts tree.value # 21677