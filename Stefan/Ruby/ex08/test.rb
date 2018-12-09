require 'test/unit'
require './tree_parser.rb'

class TreeTest < Test::Unit::TestCase
    def test_empty_node
        node = Node.new
        assert_equal([], node.children)
        assert_equal([], node.metadata)
        assert_equal("Node with 0 direct children, 0 accumulated children, metadata = []", node.to_s)
        assert_equal(0, node.value)
    end

    def test_node_with_metadata
        node = Node.new([], [1, 2 ,3])
        assert_equal([], node.children)
        assert_equal([1, 2, 3], node.metadata)
        assert_equal("Node with 0 direct children, 0 accumulated children, metadata = [1, 2, 3]", node.to_s)
        assert_equal(6, node.value)
    end

    def test_node_with_children
        child1 = Node.new([], [1])
        child2 = Node.new([], [2])
        node = Node.new([child1, child2], [3])
        assert_equal([child1, child2], node.children)
        assert_equal([3], node.metadata)
        assert_equal([3, 1, 2], node.accumulated_metadata)
        assert_equal(2, node.accumulated_nr_children)
        assert_equal(6, node.sum_of_metadata)
        assert_equal("Node with 2 direct children, 2 accumulated children, metadata = [3]", node.to_s)
        assert_equal(0, node.value)
    end

    def test_node_with_children_and_grandchildren
        grandchild1 = Node.new([], [1, 2])
        grandchild2 = Node.new([], [3, 4])
        grandchild3 = Node.new([], [5])
        child1 = Node.new([grandchild1], [6])
        child2 = Node.new([grandchild2, grandchild3], [7])
        node = Node.new([child1, child2], [8])
        assert_equal([8], node.metadata)
        assert_equal([8, 6, 1, 2, 7, 3, 4, 5], node.accumulated_metadata)
        assert_equal(5, node.accumulated_nr_children)
        assert_equal(36, node.sum_of_metadata)
        assert_equal("Node with 2 direct children, 5 accumulated children, metadata = [8]", node.to_s)
    end

    def test_node_values_with_indexed_children
        child1 = Node.new([], [10])
        child2 = Node.new([], [20])
        child3 = Node.new([], [30])
        # A metadata entry of 1 refers to the first child node
        node = Node.new([child1, child2, child3], [1])
        assert_equal(10, node.value)

        # If a referenced child node does not exist, that reference is skipped
        node = Node.new([child1, child2, child3], [4])
        assert_equal(0, node.value)

        # A child node can be referenced multiple time and counts each time it is referenced
        node = Node.new([child1, child2, child3], [1, 1])
        assert_equal(20, node.value)

        # A metadata entry of 0 does not refer to any child node
        node = Node.new([child1, child2, child3], [1, 0])
        assert_equal(10, node.value)
    end

    def test_illegal_inputs
        assert_raises(RuntimeError) { TreeParser.new.parse_single_node("") }
        assert_raises(RuntimeError) { TreeParser.new.parse_single_node("0") }
        assert_raises(RuntimeError) { TreeParser.new.parse_single_node("00") }
    end

    def test_tree_with_single_node_with_single_metadata
        tree = TreeParser.new.parse_single_node("0 1 1")
        assert_equal([1], tree.metadata)
        assert_equal([], tree.children)
    end

    def test_tree_with_single_node_with_multiple_metadata
        tree = TreeParser.new.parse_single_node("0 3 1 2 3")
        assert_equal([1, 2, 3], tree.metadata)
        assert_equal([], tree.children)
    end

    def test_tree_with_parent_and_child_with_single_metadata
        tree = TreeParser.new.parse_single_node("1 1 0 1 3 2")
        #                            A----------
        #                                B----
        assert_equal([2], tree.metadata)
        assert_equal(1, tree.children.length)
        assert_equal([3], tree.children[0].metadata)
        assert_equal([], tree.children[0].children)
    end

    def test_tree_with_parent_and_child_with_multiple_metadata
        tree = TreeParser.new.parse_single_node("1 3 0 2 5 6 2 3 4")
        #                            A----------------
        #                                B------
        assert_equal([2, 3, 4], tree.metadata)
        assert_equal(1, tree.children.length)
        assert_equal([5, 6], tree.children[0].metadata)
        assert_equal([], tree.children[0].children)
    end

    def test_tree_with_parent_and_child_and_grandparent_with_multiple_metadata
        tree = TreeParser.new.parse_single_node("1 3 1 2 0 1 7 5 6 2 3 4")
        #                            A----------------------
        #                                B------------
        #                                    C----
        assert_equal([2, 3, 4], tree.metadata)
        assert_equal(1, tree.children.length)
        child = tree.children[0]
        assert_equal([5, 6], child.metadata)
        assert_equal(1, child.children.length)
        grandchild = child.children[0]
        assert_equal([7], grandchild.metadata)
        assert_equal(0, grandchild.children.length)
    end

    def test_tree_with_parent_and_two_children
        tree = TreeParser.new.parse_single_node("2 1 0 1 2 0 1 3 4")
        #                            A----------------
        #                                B---- C----
        assert_equal([4], tree.metadata)
        assert_equal(2, tree.children.length)
        child1 = tree.children[0]
        assert_equal([2], child1.metadata)
        assert_equal([], child1.children)
        child2 = tree.children[1]
        assert_equal([3], child2.metadata)
        assert_equal([], child2.children)
    end

    def test_example_data
        tree = TreeParser.new.parse_single_node("2 3 0 3 10 11 12 1 1 0 1 99 2 1 1 2")
        #                            A----------------------------------
        #                                B----------- C-----------
        #                                                 D-----
        assert_equal(2, tree.children.length)
        assert_equal(3, tree.accumulated_nr_children)
        assert_equal(138, tree.sum_of_metadata)
        assert_equal(66, tree.value)
    end

    def test_many_siblings
        tree = TreeParser.new.parse_single_node("4 3 0 2 4 5 0 1 6 0 2 7 8 0 3 9 10 11 1 2 3")
        #                            A------------------------------------------
        #                                B------ C---- D------ E----------
        assert_equal(4, tree.children.length)
        assert_equal(4, tree.accumulated_nr_children)
        assert_equal(66, tree.sum_of_metadata)
    end

    def test_complex_example
        tree = TreeParser.new.parse_single_node("4 3 1 2 1 1 0 2 14 15 12 13 16 0 1 6 0 2 7 8 2 3 0 1 17 0 2 18 19 9 10 11 1 2 3")
        #                            A------------------------------------------------------------------------------
        #                                B------------------------- C---- D------ E---------------------------
        #                                    F---------------                         H----- I--------
        #                                        G--------
        assert_equal(4, tree.children.length)
        assert_equal(8, tree.accumulated_nr_children)
        assert_equal(1 + 2 + 3 + 13 + 16 + 12 + 14 + 15 + 6 + 7 + 8 + 17 + 18 + 19 + 9 + 10 + 11, tree.sum_of_metadata)
    end
end