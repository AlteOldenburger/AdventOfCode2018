require './node.rb'

class TreeParser
    def parse(str)
        parse2(str, 1)[0]
    end

    def parse2(str, nr_of_nodes)
        nodes = []
        tokens = str.split(" ")
        raise "At least two tokens expected: #{str}" if tokens.length < 2
        node = Node.new
        nr_of_children = tokens[0].to_i
        nr_of_metadata = tokens[1].to_i
        raise "At least one metadata expected: #{str}" if nr_of_metadata < 1
        #puts "Parsing #{str} with #{nr_of_nodes} nodes, #{nr_of_children} children, and #{nr_of_metadata} metadata"
        
        if nr_of_children > 0
            remaining_tokens = tokens[2, tokens.length]
            node.children = parse2(remaining_tokens.join(" "), nr_of_children)
        end
        
        if nr_of_children == 0
            node.metadata = tokens[2, nr_of_metadata].collect {|i| i.to_i }
        else
            nr_tokens_for_this_node_and_children = (1 + node.accumulated_nr_children) * 2 + node.accumulated_metadata.length + nr_of_metadata
            node.metadata = tokens[nr_tokens_for_this_node_and_children - nr_of_metadata, nr_of_metadata].collect {|i| i.to_i}
        end
        
        nodes << node

        if nr_of_nodes > 1
            tokens_for_this_node_and_children = (1 + node.accumulated_nr_children) * 2 + node.accumulated_metadata.length
            remaining_tokens = tokens[tokens_for_this_node_and_children, tokens.length - tokens_for_this_node_and_children]
            nodes += parse2(remaining_tokens.join(" "), nr_of_nodes - 1)
        end
        nodes
    end
end