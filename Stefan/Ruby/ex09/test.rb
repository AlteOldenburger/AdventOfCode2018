require 'test/unit'
require './marble_game.rb'

class MarbleGameTest < Test::Unit::TestCase
    def game_in_round(round, nr_players = 9)
        game = MarbleGame.new(nr_players)
        1.upto(round) { |marble| game.place(marble) }
        game
    end
    
    def test_setup
        game = MarbleGame.new(9)
        assert_equal([0], game.circle)
        assert_equal(0, game.current_marble)
    end

    def test_first_round
        game = game = game_in_round(1)
        assert_equal([0, 1], game.circle)
        assert_equal(1, game.current_marble)
        assert_equal(1, game.current_player)
    end

    def test_second_round
        game = game_in_round(2)
        assert_equal([0, 2, 1], game.circle)
        assert_equal(2, game.current_marble)
        assert_equal(2, game.current_player)
    end

    def test_third_round
        game = game_in_round(3)
        assert_equal([0, 2, 1, 3], game.circle)
        assert_equal(3, game.current_marble)
        assert_equal(3, game.current_player)
    end

    def test_tenth_round
        game = game_in_round(10)
        assert_equal([0, 8, 4, 9, 2, 10, 5, 1, 6, 3, 7], game.circle)
        assert_equal(10, game.current_marble)
        assert_equal(1, game.current_player)
    end
    
    def test_twentysecond_round
        game = game_in_round(22)
        assert_equal([0, 16, 8, 17, 4, 18, 9, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15], game.circle)
        assert_equal(22, game.current_marble)
        assert_equal(4, game.current_player)
    end

    def test_twentythird_round
        game = game_in_round(23)
        assert_equal([0, 16, 8, 17, 4, 18, 19, 2, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15], game.circle)
        assert_equal(19, game.current_marble)
        assert_equal(5, game.current_player)
        assert_equal(32, game.score(5))
    end

    def test_twentyfourth_round
        game = game_in_round(24)
        assert_equal([0, 16, 8, 17, 4, 18, 19, 2, 24, 20, 10, 21, 5, 22, 11, 1, 12, 6, 13, 3, 14, 7, 15], game.circle)
        assert_equal(24, game.current_marble)
        assert_equal(6, game.current_player)
        assert_equal(5, game.winner)
        assert_equal(32, game.score(5))
    end

    def test_example_games
        #10 players; last marble is worth 1618 points: high score is 8317
        game = game_in_round(1618, 10)
        assert_equal(8317, game.score(game.winner))
        
        # 30 players; last marble is worth 5807 points: high score is 37305
        game = game_in_round(5807, 30)
        assert_equal(37305, game.score(game.winner))
    end

    def test_algorithm
        game = MarbleGame.new(9)
        assert_equal([], game.winning_rounds_for(4, 5))
        
        assert_equal([], game.winning_rounds_for(25, 4))
        assert_equal([23], game.winning_rounds_for(25, 5))

        assert_equal([23], game.winning_rounds_for(50, 5))
        assert_equal([46], game.winning_rounds_for(50, 1))

        assert_equal([23], game.winning_rounds_for(70, 5))
        assert_equal([46], game.winning_rounds_for(70, 1))
        assert_equal([69], game.winning_rounds_for(70, 6))
    end
end