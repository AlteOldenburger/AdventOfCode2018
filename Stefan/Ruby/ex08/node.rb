class Node
    attr_accessor :children, :metadata

    def initialize(children = [], metadata = [])
        @children = children
        @metadata = metadata
    end

    def accumulated_metadata
        metadata + children.collect { |c| c.accumulated_metadata}.flatten
    end

    def accumulated_nr_children
        children.length + children.collect { |c| c.accumulated_nr_children}.sum
    end

    def sum_of_metadata
        metadata.sum + children.collect { |c| c.sum_of_metadata}.sum
    end

    def to_s
        return "Node with #{children.length} direct children, #{accumulated_nr_children} accumulated children, metadata = #{metadata}"
    end

    def print_tree(level = 0)
        puts "  " * level + to_s
        children.each { |c| c.print_tree(level + 1)}
    end
end