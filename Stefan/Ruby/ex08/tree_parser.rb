require './node.rb'

class TreeParser
    def parse_single_node(input)
        parse_multiple_nodes(input, 1)[0]
    end

    def parse_multiple_nodes(input, nr_of_nodes)
        node = Node.new
        nodes = [node]
        
        tokens, nr_of_children, nr_of_metadata = split(input)
        
        if nr_of_children > 0
            remaining_tokens = tokens.drop(2)
            node.children = parse_multiple_nodes(join(remaining_tokens), nr_of_children)
        end
        
        metadata_start_index = nr_of_children == 0 ? 2 : nr_tokens_for_node_and_children(node)
        node.metadata = tokens[metadata_start_index, nr_of_metadata].map(&:to_i)
        
        if nr_of_nodes > 1
            remaining_tokens = tokens.drop(nr_tokens_for_node_and_children(node))
            nodes += parse_multiple_nodes(join(remaining_tokens), nr_of_nodes - 1)
        end
        nodes
    end

    def split(input)
        tokens = input.split(" ")
        raise "At least two tokens expected: #{input}" if tokens.length < 2
        nr_of_children = tokens[0].to_i
        nr_of_metadata = tokens[1].to_i
        raise "At least one metadata expected: #{input}" if nr_of_metadata < 1
        [tokens, nr_of_children, nr_of_metadata]
    end

    def join(tokens)
        tokens.join(" ")
    end

    def nr_tokens_for_node_and_children(node)
        (1 + node.accumulated_nr_children) * 2 + node.accumulated_metadata.length
    end
end